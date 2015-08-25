package com.suncm.page.widget;

/**
 * 普通文本框包装对象
 * 
 * @author kfzx-xiezc
 *
 */
public class DateInputWidgetFacade extends AbstractWidgetFacade {

	public String getDispCode() {
		
		return null;
	}

	public String getInputCode() {
		
		String name = "input" + getCore().getId().getPageNo();
		StringBuffer result = new StringBuffer("<li><label for=\"");
		result.append(name)
		.append("\">").append(getCore().getPropertyName());
		if(getCore().getIsforced() == 1){
			result.append("*");
		}
		result.append("</label><input class=\"");
		if(getCore().getMinlength() != 0){
		result.append("upper ");
		}
		if(getCore().getMaxlength() != 1000){
			result.append("limitlen ");
		}
		if(getCore().getIsforced() == 1){
			result.append("required ");
		}
		result.append("\" ");
		if(getCore().getMaxlength() != 1000){
			result.append("maxlength=\"");
		}
		result.append(getCore().getMaxlength()).append("\" type='text' name='").append(name).append("' id='")
		.append(name).append("'/>").append("<span>").append(getCore().getItemdesc())
		.append("</span><img src='${basePath}img/check_right.gif'/></li>");
		return result.toString();
	}

}
