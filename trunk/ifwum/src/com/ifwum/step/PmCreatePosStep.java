package com.ifwum.step;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.org.PositionManager;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * 访问权限管理系统，根据请求数据新建一个岗位
 * 
 * @author xiezc
 *
 */
public class PmCreatePosStep extends AbstractStep {

	public String execute() throws EXTException {
		String posname=getStringParam("posname");
		String posdesc=getStringParam("posdesc");
		String typecode=getStringParam("typecode");
		String infocode=getStringParam("infocode");
		
		try{
			PositionManager pm = SecurityConfiguration.getSecurityFactory().getPositionManager();

			Result r = pm.createPosition(posname, typecode, infocode, posdesc);
			if (r.equals(Result.SUCCESS)){//创建成功，返回结果页面
				//User user = um.getUser(username);
				//setObjectParam("createdUser", user);
				return "0";
			}else{
				setStringParam("errorMsg", r.getFullMessage());
				return "1";
			}
			
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "出现错误，错误信息："+e.getMessage());
		return "1";
	}

}
}
