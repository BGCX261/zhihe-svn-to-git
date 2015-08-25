package com.ifwum.step;

import java.util.StringTokenizer;

import com.css.security.SecurityConfiguration;
import com.css.security.org.Department;
import com.css.security.org.Organization;
import com.css.security.result.Result;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ����ĳ���������һ��������λ
 * 
 * @author xiezc
 *
 */
public class DmAddPosToDptStep extends AbstractStep {

	public String execute() throws EXTException {
		String dptId=getStringParam("deptid");
		String posIds=getStringParam("posIds");
		
		try{
			Organization org = SecurityConfiguration.getSecurityFactory().getDefaultOrganization();
			
			Department nowDpt = (Department)org.getDepartment(Long.parseLong(dptId));
			StringTokenizer st = new StringTokenizer(posIds,",");
			while(st.hasMoreTokens()){
				Result r = nowDpt.addPosition(Long.parseLong(st.nextToken()));
				if (r.equals(Result.SUCCESS)){//�����ɹ�����������
					//User user = um.getUser(username);
					//setObjectParam("createdUser", user);
					setStringParam("result", "true");
				}else{//����ʧ�ܣ���ʾ������Ϣ
					setStringParam("result", r.getFullMessage());
					break;
				}
			}
		    
		    return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		setStringParam("result", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "0";
	}

}
}
