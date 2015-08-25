package com.suncm.page.widget;

/**
 * 文件选择框包装对象
 * 
 * @author kfzx-xiezc
 *
 */
public class FileWidgetFacade extends AbstractWidgetFacade {

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
		if(getCore().getIsforced() == 1){
			result.append("required ");
		}
		result.append("\" ");
		result.append(" type='file' name='").append(name).append("' id='")
		.append(name).append("'/>").append("<span>").append(getCore().getItemdesc())
		.append("</span><img src='${basePath}img/check_right.gif'/></li>");
		return result.toString();
	}

}
