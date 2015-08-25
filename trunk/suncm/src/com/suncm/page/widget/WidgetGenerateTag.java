package com.suncm.page.widget;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.suncm.pojo.SuncmProcatePageset;
import com.suncm.util.SpringUtil;

public class WidgetGenerateTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		try{
		SuncmProcatePageset spp = (SuncmProcatePageset) pageContext
				.getAttribute("item");
		AbstractWidgetFacade awf = (AbstractWidgetFacade) SpringUtil
				.getApplicationContext().getBean(
						"WidgetFacade" + spp.getPagetype());
		awf.setCore(spp);
		
		
		pageContext.getOut().write(awf.getInputCode());

		return super.doStartTag();
		}catch(Exception e){
			e.printStackTrace();
			return EVAL_PAGE;
		}
	}

}
