package com.suncm.step.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;

import com.ifw.exception.EXTException;
import com.suncm.pojo.SuncmProjectCate;
import com.suncm.step.common.WebCommonStep;
import com.suncm.util.HibernateUtil;
import com.suncm.util.JbpmUtil;
import com.suncm.util.SystemConfig;

/**
 * 获得项目种类工作流图信息
 * 
 * @author xiezc
 * 
 */
public class PCateGetWflPicStep extends WebCommonStep {

	public String execute() throws EXTException {
		InputStream imageStream = null;
		FileOutputStream f = null;
		try{
			HttpSession hs = (HttpSession)getObjectParam("ifw_session");
			String basePath = hs.getServletContext().getRealPath("/");
			
			String pCateId = getStringParam("pCateId");
			Session hsession = HibernateUtil.getSessionFactory().getCurrentSession();

			hsession.beginTransaction();   
			
			SuncmProjectCate sp = (SuncmProjectCate)hsession.createQuery("from SuncmProjectCate where projectCateId='"+pCateId+"'").uniqueResult();
			
			hsession.getTransaction().commit();
		
			setObjectParam("pCate", sp);
			
			ProcessDefinitionQuery pdq = JbpmUtil.getRepositoryService().createProcessDefinitionQuery();
			pdq.deploymentId(sp.getWflid());
			ProcessDefinition pd = pdq.uniqueResult();
			String imageName = pd.getImageResourceName();
			//只上传了xml的工作流定义，无工作流图
			if(imageName == null || imageName.trim().length() == 0){
				return "0";
			}
			
			imageStream = JbpmUtil.getRepositoryService().getResourceAsStream(sp.getWflid(), imageName);
			
			File tempImg = new File(basePath+"/tempImg");
			if(!tempImg.exists()){
				tempImg.mkdir();
			}
			imageName = pd.getId()+".png";
			File imgFile = new File(tempImg.getPath()+"/"+imageName);
			if(imgFile.exists()){
				setStringParam("picFileName", "tempImg/"+imageName);
				return "0";
			}
			f = new FileOutputStream(imgFile);
			byte[] buffer = new byte[1024];
			int readSize = imageStream.read(buffer);
			while(readSize != -1){
				f.write(buffer);
				readSize = imageStream.read(buffer);
			}
			setStringParam("picFileName", "tempImg/"+imageName);
			return "0";
			
		}catch(Throwable t){


			this.setSessionParam("tranErrorCode", "C000002");
			this.setSessionParam("tranErrorDispMsg", SystemConfig
					.getErrorDisp("C000002"));
			this.setSessionParam("tranErrorMsg", t.getMessage());
			this.setSessionParam("tranErrorLocation", this.getStepID());
			t.printStackTrace();
			
			return "-1";
		}finally{
			try{
				if(imageStream != null){
					imageStream.close();
				}
				if(f!=null){
					f.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
