package com.ifw.exception;

/**
 * 扩展异常，供工具类开始时使用。
 * 
 * @author YaoDeZhi
 * 
 * */
public class EXTException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2730048490804266L;

	public EXTException() {
		super();
	}

	public EXTException(String arg0) {
		super(arg0);
		
	}

	public EXTException(Throwable arg0) {
		super(arg0);
		
	}

	public EXTException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

}
