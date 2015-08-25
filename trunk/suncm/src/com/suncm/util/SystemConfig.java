package com.suncm.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.ifw.exception.EXTException;

/**
 * 
 * @author time
 * 
 * ��ȡ����ϵͳ������Ϣ����systemconfig.xml
 *
 */
public class SystemConfig {
	private static HashMap<String, String> configInfo = new HashMap();
	private static HashMap<String, String> errorInfo = new HashMap();

    static {
        try {
            // ��ȡ�����ļ���ø�������
            
            SAXBuilder saxB = new SAXBuilder();
    		Document doc = null;
    		try{
    			doc = saxB.build(SystemConfig.class.getResourceAsStream("/systemconfig.xml"));
    		}catch(JDOMException e){
    			e.printStackTrace();
    			throw new EXTException(e);
    		}
    		List<Element> list = doc.getRootElement().getChild("settings").getChildren();
    		List<Element> errorlist = doc.getRootElement().getChild("errorcodes").getChildren();
    		for(Element item:list){
    			configInfo.put((String)item.getAttribute("name").getValue(), (String)item.getAttribute("value").getValue());
    		}
    		for(Element item:errorlist){
    			errorInfo.put((String)item.getAttribute("id").getValue(), (String)item.getAttribute("disMsg").getValue());
    		}
    		
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
/**
 * ���ĳ��ϵͳ����ֵ
 * @param key ��������
 * @return
 */
    public static String getConfig(String key) {
        return configInfo.get(key);
    }
    public static String getErrorDisp(String key) {
        return errorInfo.get(key);
    }

}
