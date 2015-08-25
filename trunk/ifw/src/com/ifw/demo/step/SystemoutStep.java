package com.ifw.demo.step;

import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;

public class SystemoutStep extends AbstractStep {

	public String execute() throws EXTException {
		
		System.out.println("successful first step!");
		
		return "0";
	}

}
