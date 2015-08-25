package com.ifwum.step;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import com.css.security.SecurityConfiguration;
import com.css.security.org.PositionManager;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ���������������½�һ���û�
 * 
 * @author xiezc
 *
 */
public class PmQueryPosListStep extends AbstractStep {

	public String execute() throws EXTException {
		
		try{
			PositionManager pm = SecurityConfiguration.getSecurityFactory().getPositionManager();
			Iterator it = pm.getPositions();
			HttpSession session = (HttpSession)getObjectParam("ifw_session");
			//��������
			session.setAttribute("pos", it);
			session.setAttribute("poscount", String.valueOf(pm.getPositionCount()));
			return "0";
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}
