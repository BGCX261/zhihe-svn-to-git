package com.suncm.page.widget;

import java.util.StringTokenizer;

import com.suncm.util.SystemConfig;

/**
 * 普通下拉框包装对象
 * 
 * @author kfzx-xiezc
 *
 */
public class PlainComboWidgetFacade extends AbstractWidgetFacade {

	public String getDispCode() {
		
		return null;
	}

	public String getInputCode() {
		
		String name = "input" + getCore().getId().getPageNo();
		StringBuffer result = new StringBuffer("<li><label for=\"");
		result.append(name)
		.append("\">").append(getCore().getPropertyName()).append("</label><select  name='").append(name).append("' id='")
		.append(name).append("'/>");
		StringTokenizer st = new StringTokenizer(getCore().getOptions(),SystemConfig.getConfig("delim"));
		while(st.hasMoreTokens()){
			String temp = st.nextToken();
			result.append("<option value=\"").append(temp)
			.append("\">").append(temp).append("</option>");
		}
		
		result.append("<span>").append(getCore().getItemdesc())
		.append("</span><img src='${basePath}img/check_right.gif'/></li>");
		result.append("</select><span>").append(getCore().getItemdesc())
		.append("</span><img src='${basePath}img/check_right.gif'/></li>");
		return result.toString();
	}

}
