package com.suncm.step.common;

import com.ifw.base.AbstractStep;
import com.ifw.base.IFWConstants;
import com.ifw.exception.EXTException;
import com.suncm.util.SystemConfig;
/**
 * 根据跳转的来源进行跳转
 * 
 * @author xiezc
 *
 */
public class SwitchStep extends WebCommonStep {

	public String execute() throws EXTException {
		
		try{
			
			String switchSource = this.getSetting("switchSource");
			
			
			
			return getStringParam(switchSource);
			
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
