<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#include "../util/TypeInfo.ftl">
<#assign entityName = pojo.shortName>
<#assign componentName = entityName?uncap_first>
<#assign homeName = componentName + "Home">
<#assign masterPageName = entityName + "List">
<#assign editPageName = entityName + "Edit">
<rich:modalPanel 
xmlns="http://www.w3.org/1999/xhtml"
    xmlns:s="http://jboss.com/products/seam/taglib"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:rich="http://richfaces.org/rich"
    xmlns:a4j="http://richfaces.org/a4j"
id="deletePanel" autosized="true" width="450" rendered="${'#'}{s:hasPermission('entity','${entityName}:delete')}">
		<f:facet name="header">
			<h:outputText value="${'#'}{messages.common_delete_instance}${'#'}{messages.entity_${entityName}}"
				style="padding-right:15px;" />
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="../img/ico_close.gif" 
					styleClass="hidelink" id="hidelinkdelete" />
				<rich:componentControl for="deletePanel" attachTo="hidelinkdelete"
					operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<h:form>
			<table width="100%">
				<tbody>
				
					<tr>
						<td align="center" width="50%">
						${'#'}{messages.common_delete_confirm}
						</td>
						</tr>
					<tr>
						<td align="center" width="50%">
						
						
						<a4j:commandButton value="${'#'}{messages.common_delete_instance}"
							ajaxSingle="true" action="${'#'}{${componentName}Home.remove}"
							oncomplete="${'#'}{rich:component('deletePanel')}.hide();"
							reRender="${componentName}ListTable,messagePanel" status="commonstatus"/></td>
						<td align="center" width="50%">
						<a4j:commandButton
							value="${'#'}{messages.common_cancle}"
							onclick="${'#'}{rich:component('deletePanel')}.hide();return false;" status="commonstatus"/>
						</td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</rich:modalPanel>