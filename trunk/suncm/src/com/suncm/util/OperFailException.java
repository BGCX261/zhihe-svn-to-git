package com.suncm.util;
/**
 * ���ڷ�װһ�������ڼ�¼��־��ҳ��չʾ��ִ����Ϣ����
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
