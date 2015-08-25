package com.ifw.base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.ifw.exception.EXTException;
/**
 * 从xml文件初始化一个Flow
 * 
 * @author xiezc
 *
 */
public class FlowWraper {
	
	private String operationName = null;
	
	private HashMap opSteps = null;
	
	private String firstOpStep = null;
	
	public FlowWraper(String operationName) throws IOException,EXTException{
		
		this.operationName = operationName;
		
		readOpfile(operationName);
		
	}
	
	private void readOpfile(String operationName) throws IOException,EXTException{
		
		//HashMap cache = IFWConfigWraper.getSettings();
		
		//String opPath = (String)cache.get(IFWConstants.OPERATIONFILEPATH);
		String opPath = null;
		
		StringBuffer sb = null;
		
		if(opPath==null||opPath.trim().equals("")){
			
			//String WEBINFOCLASSPATH = new File(".").getCanonicalPath()+File.separator+"WEB-INFO"+File.separator+"classes";
			//System.out.println(OperationWraper.class.getResource("/"));
			
			
			sb = new StringBuffer(IFWConstants.CLASSPATH).append(IFWConstants.CONFOPPATH).append(operationName).append(".xml");
			
			//sb = new StringBuffer(WEBINFOCLASSPATH).append(File.separator).append("configfiles"+File.separator+"operations"+File.separator).append(operationName);
		
		}else{
			
			sb = new StringBuffer(opPath).append(File.separator).append(operationName).append(".xml");
			
		}
		
		opPath = sb.toString();
		
		SAXBuilder saxB = new SAXBuilder();
		Document doc = null;
		try{
			doc = saxB.build(new File(opPath));
		}catch(JDOMException e){
			e.printStackTrace();
			throw new EXTException(e);
		}
		//一个流程分为多个部分，目前只有step部分，后续扩展用
		List parts = doc.getRootElement().getChildren();
		
		/*SimpleDOMParser sdp = new SimpleDOMParser();
		
		SimpleDOMObject sdo = sdp.parse(opPath);
		
		Object []objs = sdo.getChildElements();
		
		Object []objs1;
		
		int size = objs.length;
		int size1 = -1;
		
		SimpleDOMObject tmpObj = null;
		
		SimpleDOMObject tmpObj1 = null;
		
		HashMap tmpMap = null;
		
		Iterator it = null;*/
		String tmpRV = null;
		String tmpParam = null;
		String tmpVal = null;
		int opStepCount = 0;
		
		StepWraper sw = null;
		String stepDistId = null;
		
		for(int i=0;i<parts.size();i++){
			
			Element part = (Element)parts.get(i);
			
			//解析交易步骤,目前只有这一部分
			if(part.getName().equals(IFWConstants.FLOW)){
				
				List steps = part.getChildren();
				
				opSteps = new HashMap(steps.size());

				for(int j=0;j<steps.size();j++){//处理每个交易步骤
					
					Element step = (Element)steps.get(j);
					List stepProp = (List)step.getAttributes();
					
					//处理每个交易步骤
					if(step.getName().equals(IFWConstants.OPSTEPTAG)){
						
						//首先初始化osw对象
						String osId = step.getAttributeValue(IFWConstants.ID);
						String alias = step.getAttributeValue(IFWConstants.STEPALIAS);
						
						if(osId != null){
							if(alias != null){
								sw = new StepWraper(osId,alias);
							}else{
								sw = new StepWraper(osId,osId);
							}
							
							if(opStepCount==0)
								
								this.firstOpStep = sw.getStepDistId();
						}else{
							throw new EXTException("Op Step must have an attribute named " +  IFWConstants.ID);
						}
						
						//处理交易步骤的每个参数
						for(int k = 0;k < stepProp.size();k++){
							
							tmpParam = ((Attribute)stepProp.get(k)).getName();
							tmpVal = ((Attribute)stepProp.get(k)).getValue();

							//交易步骤ID
							//由于osw对象在初始化opstep过程中必须不为空，所以率先初始化此对象 
							if(tmpParam.equals(IFWConstants.ID)){
								
								/*osw = new OpStepWraper(tmpVal);
								
								if(opStepCount==0)
									
									this.firstOpStep = tmpParam;*/
								continue;//id已经处理过，可以处理下一条
								
							}else if(tmpParam.startsWith(IFWConstants.IJUMP)){
								//设置switch
								tmpRV = tmpParam.substring(5).toString();
								
								sw.setSwitch(tmpRV, tmpVal);
								
							}else{//其它属性
								
								sw.setAttribute(tmpParam, tmpVal);
								
							}						
						}	
						//别名作为opstep的唯一跳转标志，避免bean的重复定义问题
						opSteps.put(sw.getStepDistId(), sw);
						//opSteps.put(osw.getId(), osw);
						opStepCount++;
					}else{
						throw new EXTException("Op Step tag name must be " + IFWConstants.OPSTEPTAG + ",not be " +step.getName());
					}
				}
			}
		}
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public HashMap getOpSteps() {
		return opSteps;
	}

	public void setOpSteps(HashMap opSteps) {
		this.opSteps = opSteps;
	}
	
	public String getFirstOpStep(){
		return this.firstOpStep;
	}
	//增加服务部分时扩展用
	public ServiceBean getServiceTable(String serviceId){
		return null;
	}
}
