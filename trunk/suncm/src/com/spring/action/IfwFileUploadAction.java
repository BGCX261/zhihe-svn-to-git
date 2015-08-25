package com.spring.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.FileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ifw.base.IFWConstants;
import com.ifw.spring.ext.SpringFlow;
import com.suncm.um.SuncmUser;
import com.suncm.util.SystemConfig;

/**
 * 这个action不会新建session,专门用于处理文件请求 文件请求处理使用apache fileupload类库实现
 * 
 * @author xiezc
 * 
 */
public class IfwFileUploadAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		Map model = new HashMap();

		// 1.将session带入flow中,由于之前已经做过登录,此处不再新建session，如果session为空表示没有登录或登录超时
		HttpSession session = req.getSession(false);
		// session超时返回超时页面
		if (session == null) {
			return new ModelAndView("suncm_sessionerror", model);
		} else {
			// 如果session中没有用户对象也返回超时页面，提示重新登录
			Object suncm_user = session.getAttribute("suncm_user");
			if (suncm_user == null) {
				return new ModelAndView("suncm_sessionerror", model);
			}
		}
		// 2.处理上传字段
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(Integer.parseInt(SystemConfig
				.getConfig("fileUploadThreshold")));
		// the location for saving data that is larger than getSizeThreshold()
		factory.setRepository(new File(dealPath(SystemConfig
				.getConfig("fileUploadTmpPath"))));
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum size before a FileUploadException will be thrown
		upload.setFileSizeMax(Integer.parseInt(SystemConfig
				.getConfig("fileUploadMaxSize")));
		String uploadDir = dealPath(SystemConfig.getConfig("fileUploadPath"));

		List<FileItem> fileItems = null;
		try {
			File fUploadDir = new File(uploadDir);
			if(!fUploadDir.exists()){
				if(!fUploadDir.mkdir()){
					throw new Exception("can't make system directory,please contact your system manager.");
				}
			}
			fileItems = upload.parseRequest(req);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("suncm_syserror", model);
		}
		for (FileItem fileItem : fileItems) {
			if (fileItem.isFormField()) {
				model.put(fileItem.getFieldName(), fileItem.getString("GBK"));
			} else {
				// 对于上传的文件先做保存
				String path = fileItem.getName();
				if (path.trim().length() == 0) {// 客户没有选择文件
					model.put(fileItem.getFieldName(), "");
				} else {
					try {
						int start = path.lastIndexOf('\\');
						String fileName = path.substring(start + 1);
						String userName = ((SuncmUser) session
								.getAttribute("suncm_user")).getUserId();
						SimpleDateFormat sd = new SimpleDateFormat(
								"yyyyMMddHHmmss");
						File pathDest = new File(uploadDir, userName + "$$"
								+ sd.format(new Date()) + "$$" + fileName);
						fileItem.write(pathDest);
						model.put(fileItem.getFieldName(), pathDest.toString());
					} catch (Exception e) {
						e.printStackTrace();
						return new ModelAndView("suncm_syserror", model);
					} finally {
						fileItem.delete();
					}
				}

			}
		}
		// 3.设置 默认字段，开始执行逻辑
		model.put("ifw_session", session);
		session.setAttribute("tranErrorCode", "0");
		session.setAttribute("actDesc", "");
		session.setAttribute("tranErrorMsg", "");
		session.setAttribute("tranErrorDispMsg", "");
		session.setAttribute("tranErrorLocation", "");

		SpringFlow sf = new SpringFlow(model, (String)model.get("ifw_flowname"));

		sf.execute();
		return new ModelAndView((String) model.get(IFWConstants.REPLY), model);
		// System.out.println("xiexie" + getHelloWorld());

	}

	/**
	 * 对于文件上传路径，支持相对webapp的路径和系统绝对路径，如果以.开头表示相对webapp的相对路径
	 * 
	 * @return 转换后的path
	 */
	private String dealPath(String oriPath) {
		if (oriPath.startsWith(".")) {// 相对路径
			String destPath = getClass().getResource("/").getPath();
			return destPath + oriPath.substring(2);
		} else {
			return oriPath;
		}
	}
}
