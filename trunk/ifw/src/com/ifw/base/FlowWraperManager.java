package com.ifw.base;

import java.io.IOException;
import java.util.HashMap;

import com.ifw.exception.EXTException;
//import com.ifw.system.Configuration;

public class FlowWraperManager {
	
	private static HashMap opWraperMap = new HashMap();
	
	private static boolean isCacheOp;
	
	static{
		try{
			
			//isCacheOp = Boolean.parseBoolean(Configuration.getProperty(IFWConstants.ISCACHEOP));
			isCacheOp = false;
			
		}catch(Exception e){
			isCacheOp = true;
		}
	}
	
	public static FlowWraper getFlowWraper(String flowName) throws IOException, EXTException{
		
		if(isCacheOp){
			
			Object obj = opWraperMap.get(flowName);
			
			if(obj==null){
				
				FlowWraper ow = new FlowWraper(flowName);
				
				opWraperMap.put(flowName, ow);
				
				return ow;
				
			}else{
				
				return (FlowWraper)obj;
				
			}
			
		}else{
			
			FlowWraper ow = new FlowWraper(flowName);
			
			return ow;
			
		}
		
	}
	
}
