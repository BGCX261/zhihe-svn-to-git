package com.suncm.step.common;

import com.ifw.base.AbstractStep;
import com.ifw.base.IFWConstants;
import com.ifw.exception.EXTException;
import com.suncm.util.SystemConfig;

public class ReplyPageStep extends WebCommonStep {

	public String execute() throws EXTException {
		
		try{
			
			String replayPage = this.getSetting(IFWConstants.REPLY);
			
			this.setStringParam(IFWConstants.REPLY, replayPage);
			
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
