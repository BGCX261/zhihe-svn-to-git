package com.ifwum.step;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ���������������½�һ���û�
 * 
 * @author xiezc
 *
 */
public class CreateUserStep extends AbstractStep {

	public String execute() throws EXTException {
		String username=getStringParam("username");
		String password=getStringParam("password");
		String realname=getStringParam("realname");
		String email=getStringParam("email");
		String type=getStringParam("usertype");
		String mobile=getStringParam("mobile");
		
		try{
			UserManager um = SecurityConfiguration.getSecurityFactory().getUserManager();
			AttrManager am = SecurityConfiguration.getSecurityFactory().getAttrManager();
			Hashtable attrValues = new Hashtable() ;
			attrValues.put(am.getAttr("mobile"), mobile) ;
			Result r = um.createUser(username , password , realname , email , Integer.parseInt(type) , attrValues) ;
			if (r.equals(Result.SUCCESS)){//�����ɹ������ؽ��ҳ��
				User user = um.getUser(username);
				setObjectParam("createdUser", user);
				return "0";
			}else{
				setStringParam("errorMsg", r.getFullMessage());
				return "1";
			}
			
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}
