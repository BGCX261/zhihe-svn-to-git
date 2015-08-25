package com.ifw.spring.ext;

import java.io.IOException;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.ifw.base.BaseFlow;
import com.ifw.base.IFWConfigWraper;
import com.ifw.base.StepInterface;
import com.ifw.base.FlowWraperManager;
import com.ifw.base.StepWraper;
import com.ifw.exception.EXTException;
/**
 * 重写baseflow，获得step部分改为使用spring的bean管理功能实现，其他不变
 * 
 * @author kfzx-xiezc
 *
 */
public class SpringFlow extends BaseFlow {
	
	public SpringFlow(Map model,String flowName) throws IOException, EXTException{
		
		super(model,flowName);
		
	}
	
	public StepInterface getStepInstance(StepWraper sw) throws EXTException {
		
		ApplicationContext appContext = SpringUtil.getApplicationContext();

		StepInterface os = (StepInterface)appContext.getBean(sw.getId());
		os.setStepID(sw.getStepDistId());
		os.setFlow(this);
		return os;
	}
}
