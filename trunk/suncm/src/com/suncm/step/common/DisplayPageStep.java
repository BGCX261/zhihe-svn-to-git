package com.suncm.step.common;

import com.ifw.exception.EXTException;
import com.suncm.util.SystemConfig;
/**
 * 由于目前flow中至少要有一个step，所以此处放置一个空step防止报错
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
