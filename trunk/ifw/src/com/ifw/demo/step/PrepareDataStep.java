package com.ifw.demo.step;

import com.ifw.base.AbstractStep;
import com.ifw.exception.EXTException;

public class PrepareDataStep extends AbstractStep {

	public String execute() throws EXTException {
		
		System.out.println("successful second step!");
		
		return "0";
	}

}
