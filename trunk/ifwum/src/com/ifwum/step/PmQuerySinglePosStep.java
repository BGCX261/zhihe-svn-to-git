package com.ifwum.step;

import com.css.security.SecurityConfiguration;
import com.css.security.org.Position;
import com.css.security.org.PositionManager;
import com.css.security.result.Result;
import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;
/**
 * ����Ȩ�޹���ϵͳ�����ݸ�λid��ѯһ����λ����Ϣ
 * 
 * @author xiezc
 *
 */
public class PmQuerySinglePosStep extends AbstractStep {

	public String execute() throws EXTException {
		String posId=getStringParam("posId");
		
		try{
			PositionManager pm = SecurityConfiguration.getSecurityFactory().getPositionManager();

			Position pos = pm.getPosition(Long.parseLong(posId));
			
			setObjectParam("posObject", pos);
			
			return "0";
			
		}catch(Exception e){
		e.printStackTrace();
		setStringParam("errorMsg", "���ִ��󣬴�����Ϣ��"+e.getMessage());
		return "1";
	}

}
}
