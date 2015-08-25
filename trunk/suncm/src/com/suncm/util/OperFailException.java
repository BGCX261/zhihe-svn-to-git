package com.suncm.util;
/**
 * 用于封装一个可用于记录日志和页面展示的执行信息对象
 * 
 * @author kfzx-xiezc
 *
 */
public class OperFailException extends Exception {
	
	String tranErrorCode = "0";
	String tranErrorDispMsg;
	String tranErrorMsg;
	String tranErrorLocation;
	
	public String getTranErrorCode() {
		return tranErrorCode;
	}
	public void setTranErrorCode(String tranErrorCode) {
		this.tranErrorCode = tranErrorCode;
	}
	public String getTranErrorDispMsg() {
		return tranErrorDispMsg;
	}
	public void setTranErrorDispMsg(String tranErrorDispMsg) {
		this.tranErrorDispMsg = tranErrorDispMsg;
	}
	public String getTranErrorMsg() {
		return tranErrorMsg;
	}
	public void setTranErrorMsg(String tranErrorMsg) {
		this.tranErrorMsg = tranErrorMsg;
	}
	public String getTranErrorLocation() {
		return tranErrorLocation;
	}
	public void setTranErrorLocation(String tranErrorLocation) {
		this.tranErrorLocation = tranErrorLocation;
	}

}
