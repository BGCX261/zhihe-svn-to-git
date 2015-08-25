package com.ifw.demo.step;

import com.ifw.base.AbstractStep;
import com.ifw.base.IFWConstants;
import com.ifw.exception.EXTException;

public class ReplyPageStep extends AbstractStep {

	public String execute() throws EXTException {
		
		try{
			
			String replayPage = this.getSetting(IFWConstants.REPLY);
			
			this.setStringParam(IFWConstants.REPLY, replayPage);
			
			return "0";
			
		}catch(Throwable t){
			
			t.printStackTrace();
			
			return "-1";
		}
		
	}

}
