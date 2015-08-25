package com.ifwum.step;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.attr.AttrManager;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.result.Result;
import com.css.security.user.User;
import com.css.security.user.UserManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ��������͵�dptCode�Ƿ��Ѿ�ע���
 * 
 * @author xiezc
 *
 */
public class DmCheckDptCodeStep extends AbstractStep {

	public String execute() throws EXTException {
		String dptCode=getStringParam("deptcode");
		
		try{
			Organization org = SecurityConfiguration.getSecurityFactory().getDefaultOrganization();
			
			Department nowDpt = (Department)org.getDepartmentByCode(dptCode);
			if(nowDpt == null){
				setObjectParam("result", "true");
			}else{
				setObjectParam("result", "false");
			}
		    
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}
