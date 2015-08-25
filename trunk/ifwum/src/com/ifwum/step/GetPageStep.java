package com.ifwum.step;

import com.ifw.base.AbstractStep;
import com.ifw.base.IFWConstants;
import com.ifw.exception.EXTException;
/**
 * ���ݿͻ������͵�ҳ�����ֻ�ö�Ӧ��jsp
 * 
 * @author kfzx-xiezc
 *
 */
public class GetPageStep extends AbstractStep {

	public String execute() throws EXTException {
		
		try{
			
			String replayPage = this.getStringParam("page");
			
			this.setStringParam(IFWConstants.REPLY, replayPage);
			
			return "0";
			
		}catch(Throwable t){
			
			t.printStackTrace();
			
			return "-1";
		}
		
	}

}
