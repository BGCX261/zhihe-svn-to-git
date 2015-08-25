package com.ifw.base;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import com.ifw.exception.EXTException;

public class IFWConfigWraper {
	
	private static Properties transmapping = null;
	
	private static boolean isCacheClass = true;
	
	//private static HashMap settings = DefaultCacheFactory.getCacheFactory().getCache("ifwconfig.xml").getParams();
	
	private static HashMap opStepsMap = new HashMap();
	
	public static Class getOpStep(String id) throws EXTException{
		
		if(isCacheClass){
			
			return (Class)opStepsMap.get(id);
	
		}else{
			
			String opStepImplCls = (String)opStepsMap.get(id);
			
			Class cls = null;
			try {
				
				cls = Class.forName(opStepImplCls);
				
			} catch (ClassNotFoundException e) {
				
				throw new EXTException("加载" + "失败。",e);
				
			}
			
			return cls;
			
		}
	}
	
	public static void setOpStep(String id,String opStepImplCls) throws EXTException {
		
		if(isCacheClass){
			
			Class cls = null;
			try {
				
				cls = Class.forName(opStepImplCls);
				
			} catch (ClassNotFoundException e) {
				
				throw new EXTException("加载" + "失败。",e);
				
			}
			
			opStepsMap.put(id, cls);
			
		}else{
			
			opStepsMap.put(id, opStepImplCls);
			
		}
	}
	
	public static void initialize() throws IOException, EXTException{
		
		//Cache cache = IFWCacheFactory.getIFWCache();
		
		//String confPath = (String)settings.get(IFWConstants.IFWCFGFILEPATH);
		//不想与cache框架耦合，这里 使用默认的报名，去掉配置路径部分
		String confPath = null;
		
		StringBuffer sb = null;
		
		/*if(confPath==null||confPath.trim().equals("")){
			
			sb = new StringBuffer(IFWConstants.WEBINFOCLASSPATH).append(File.separator)
			.append(IFWConstants.CONFPATH).append("opstepmapping.xml");
		
		}else{
			
			sb = new StringBuffer(confPath).append(File.separator)
			.append("opstepmapping.xml");
			
		}
		
		confPath = sb.toString();
		
		SimpleDOMParser sdp = new SimpleDOMParser();
		SimpleDOMObject sdo = sdp.parse(confPath);
		
		SimpleDOMObject settingsSDO = sdo.nextElement(IFWConstants.SETTINGS);
		
		
		//使用临时变量定义
		SimpleDOMObject tmpSDO = null;
		String tmpTag = null;
		String tmpStr = null;
		Object [] tmpArray = null;
		
		tmpArray = settingsSDO.getChildElements();
//		
		int size = tmpArray.length;
//		
		for(int j=0;j<size;j++){
			
			tmpSDO = (SimpleDOMObject)tmpArray[j];
			tmpTag = tmpSDO.getTagName();
			tmpStr = tmpSDO.getText();
			settings.put(tmpTag, tmpStr);	
		}
		
		SimpleDOMObject allOpSteps = sdo.nextElement(IFWConstants.OPSTEPS);
		tmpStr = allOpSteps.getAttribute(IFWConstants.ISCACHECLASS);
//		
		try{
			
			isCacheClass = Boolean.parseBoolean((String)settings.get(IFWConstants.ISCACHECLASS));
			
		}catch(Exception e){
			
			isCacheClass = false;
			
		}

		tmpArray = sdo.getChildElements();
		size = tmpArray.length;
		
		
		for(int i=0;i<size;i++){
			
			tmpSDO = (SimpleDOMObject)tmpArray[i];
			
			tmpTag = tmpSDO.getAttribute(IFWConstants.ID);
			
			tmpStr = tmpSDO.getText();
			
			setOpStep(tmpTag, tmpStr);
			
		}*/
		
		//加载transmapping.properties
		
		if(confPath==null||confPath.trim().equals("")){
			
			sb = new StringBuffer(IFWConstants.CLASSPATH).append(File.separator).append(IFWConstants.CONFPATH).append("transmapping.properties");
		
		}else{
			
			sb = new StringBuffer(confPath).append(File.separator).append("transmapping.properties");
			
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sb.toString()));
		transmapping = new Properties();
		transmapping.load(bis);
		if(bis!=null)
			bis.close();
		
	}

	/*public static HashMap getSettings() {
		return settings;
	}

	public static void setSettings(HashMap settings) {
		IFWConfigWraper.settings = settings;
	}*/

	public static Properties getTransmapping() {
		return transmapping;
	}

	public static void setTransmapping(Properties transmapping) {
		IFWConfigWraper.transmapping = transmapping;
	}
	
	
	
}
