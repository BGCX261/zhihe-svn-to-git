package com.ifwum.step;

import com.ifw.base.AbstractStep;
import com.ifw.base.IFWConstants;
import com.ifw.exception.EXTException;
/**
 * 根据跳转的来源进行跳转
 * 
 * @author xiezc
 *
 */
public class SwitchStep extends AbstractStep {

	public String execute() throws EXTException {
		
		try{
			
			String switchSource = this.getSetting("switchSource");
			
			
			
			return getStringParam(switchSource);
			
		}catch(Throwable t){
			
			t.printStackTrace();
			
			return "-1";
		}
		
	}

}
