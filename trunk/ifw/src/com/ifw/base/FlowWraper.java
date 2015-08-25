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
 * ��xml�ļ���ʼ��һ��Flow
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
		//һ�����̷�Ϊ������֣�Ŀǰֻ��step���֣�������չ��
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
			
			//�������ײ���,Ŀǰֻ����һ����
			if(part.getName().equals(IFWConstants.FLOW)){
				
				List steps = part.getChildren();
				
				opSteps = new HashMap(steps.size());

				for(int j=0;j<steps.size();j++){//����ÿ�����ײ���
					
					Element step = (Element)steps.get(j);
					List stepProp = (List)step.getAttributes();
					
					//����ÿ�����ײ���
					if(step.getName().equals(IFWConstants.OPSTEPTAG)){
						
						//���ȳ�ʼ��osw����
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
						
						//�����ײ����ÿ������
						for(int k = 0;k < stepProp.size();k++){
							
							tmpParam = ((Attribute)stepProp.get(k)).getName();
							tmpVal = ((Attribute)stepProp.get(k)).getValue();

							//���ײ���ID
							//����osw�����ڳ�ʼ��opstep�����б��벻Ϊ�գ��������ȳ�ʼ���˶��� 
							if(tmpParam.equals(IFWConstants.ID)){
								
								/*osw = new OpStepWraper(tmpVal);
								
								if(opStepCount==0)
									
									this.firstOpStep = tmpParam;*/
								continue;//id�Ѿ�����������Դ�����һ��
								
							}else if(tmpParam.startsWith(IFWConstants.IJUMP)){
								//����switch
								tmpRV = tmpParam.substring(5).toString();
								
								sw.setSwitch(tmpRV, tmpVal);
								
							}else{//��������
								
								sw.setAttribute(tmpParam, tmpVal);
								
							}						
						}	
						//������Ϊopstep��Ψһ��ת��־������bean���ظ���������
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
	//���ӷ��񲿷�ʱ��չ��
	public ServiceBean getServiceTable(String serviceId){
		return null;
	}
}
