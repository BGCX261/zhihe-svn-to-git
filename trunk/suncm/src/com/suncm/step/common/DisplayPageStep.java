package com.suncm.step.common;

import com.ifw.exception.EXTException;
import com.suncm.util.SystemConfig;
/**
 * ����Ŀǰflow������Ҫ��һ��step�����Դ˴�����һ����step��ֹ����
 * 
 * @author xiezc
 *
 */
public class DisplayPageStep extends WebCommonStep {

	public String execute() throws EXTException {
		
		try{
			
			return "0";
			
		}catch(Throwable t){


			this.setSessionParam("tranErrorCode", "C000002");
			this.setSessionParam("tranErrorDispMsg", SystemConfig
					.getErrorDisp("C000002"));
			this.setSessionParam("tranErrorMsg", t.getMessage());
			this.setSessionParam("tranErrorLocation", this.getStepID());
			t.printStackTrace();
			
			return "-1";
		}
		
	}

}
