package com.suncm.step.common;

import java.util.HashMap;
import java.util.StringTokenizer;

import com.ifw.base.IFWConstants;
import com.ifw.exception.EXTException;
import com.suncm.util.SystemConfig;

/**
 * 在实体多页面创建向导中暂存前几页的创建信息
 * 
 * @author kfzx-xiezc
 *
 */

public class SaveDataStep extends WebCommonStep {

	public String execute() throws EXTException {
		
		try{
			String datatosave = this.getSetting("datatosave");
			StringTokenizer st = new StringTokenizer(datatosave,"|");
			String temp = null;
			HashMap dynamicData = (HashMap)getSessionObjParam("dynamicData");
			if(dynamicData == null){
				dynamicData = new HashMap();
			}
			while(st.hasMoreTokens()){
				temp = st.nextToken();
				dynamicData.put(temp, getStringParam(temp));
			}
			
			setSessionParam("dynamicData", dynamicData);
			
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
