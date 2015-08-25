<!DOCTYPE composition PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#include "../util/TypeInfo.ftl">
<#assign entityName = pojo.shortName>
<#assign componentName = entityName?uncap_first>
<#assign homeName = componentName + "Home">
<#assign masterPageName = componentName + "List">
<#assign editPageName = entityName + "Edit">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:s="http://jboss.com/products/seam/taglib"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:rich="http://richfaces.org/rich"
    xmlns:a4j="http://richfaces.org/a4j"
    template="../layout/template.xhtml">

<ui:define name="body">
<a4j:queue requestDelay="100" />
		<rich:panel rendered="${'#'}{!s:hasPermission('entity','${entityName}:read')}">
		<h:outputText value="${'#'}{messages.common_search_noright}"  />
		</rich:panel>
		
<rich:panel rendered="${'#'}{s:hasPermission('entity','${entityName}:read')}">
		<f:facet name="header">${'#'}{messages.entity_${entityName}}${'#'}{messages.common_search_result}  </f:facet>
			<div class="results" id="${masterPageName}div">
			<h:outputText value="${'#'}{messages.common_search_noresult}" rendered="${'#'}{${homeName}.dataModel.rowCount ==0}" />
			<a4j:region> 
		<h:form>
			
				<rich:dataTable id="${masterPageName}Table" var="_${componentName}"
					value="${'#'}{${homeName}.dataModel}" rows="10" reRender="datascroller"
					rowKeyVar="row" 
					onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
					onRowMouseOut="this.style.backgroundColor='${'#'}{a4jSkin.tableBackgroundColor}'"
					columnClasses="datacolumn1,datacolumn2" rendered="${'#'}{${homeName}.dataModel.rowCount != 0}">

					<f:facet name="header">
						<h:outputText value="${'#'}{messages.entity_${entityName}}${'#'}{messages.common_table_header}" />
					</f:facet>


<#foreach property in pojo.allPropertiesIterator>
<#if !c2h.isCollection(property) && !isToOne(property) && property != pojo.versionProperty!>
<#if pojo.isComponent(property)>
<#foreach componentProperty in property.value.propertyIterator>
<#assign propertyPath = property.name + '.' + componentProperty.name>
<rich:column sortBy="${'#'}{'${propertyPath}'}" filterBy="${'#'}{'${propertyPath}'}" rendered="${'#'}{s:hasPermission('column','${entityName}.${property.name}.${componentProperty.name}:read')}">
	<f:facet name="header">${'#'}{messages.entity_${entityName}_${property.name}}</f:facet>
	<@outputValue1 property=componentProperty expression="${'#'}{_${componentName}.${property.name}.${componentProperty.name}}" indent=12 renderedstring="${'#'}{s:hasPermission(_${componentName},'${entityName}.${property.name}.${componentProperty.name}:read')}"/>
	</rich:column>
</#foreach>
<#else>
<rich:column sortBy="${'#'}{'${property.name}'}" filterBy="${'#'}{'${property.name}'}" rendered="${'#'}{s:hasPermission('column','${entityName}.${property.name}:read')}">
	<f:facet name="header">${'#'}{messages.entity_${entityName}_${property.name}}</f:facet>
<@outputValue1 property=property expression="${'#'}{_${componentName}.${property.name}}" indent=12 renderedstring="${'#'}{s:hasPermission(_${componentName},'${entityName}.${property.name}:read')}"/>
</rich:column>
</#if>
</#if>
<#if isToOne(property)>
<#assign parentPojo = c2j.getPOJOClass(cfg.getClassMapping(property.value.referencedEntityName))>
<#if parentPojo.isComponent(parentPojo.identifierProperty)>
<#foreach componentProperty in parentPojo.identifierProperty.value.propertyIterator>
<rich:column >
	<f:facet name="header">
	<#assign propertyPath = property.name + '.' + parentPojo.identifierProperty.name + '.' + componentProperty.name>
	${'#'}{messages.entity_${parentPojo.shortName}_${parentPojo.identifierProperty}}</f:facet>
	<@outputValue property=componentProperty expression="${'#'}{_${componentName}.${propertyPath}}" indent=12/>
</rich:column>

</#foreach>
<#else>
<rich:column >
	<f:facet name="header">
	<#assign propertyPath = property.name + '.' + parentPojo.identifierProperty.name>
	${'#'}{messages.entity_${parentPojo.shortName}_${parentPojo.identifierProperty}}</f:facet>
	<@outputValue property=parentPojo.identifierProperty expression="${'#'}{_${componentName}.${propertyPath}}" indent=12/>
</rich:column>
</#if>
</#if>
</#foreach>

<rich:column styleClass="action">
						<f:facet name="header">${'#'}{messages.common_action}</f:facet>
						
						<a4j:commandLink ajaxSingle="true" id="editlink" rendered="${'#'}{s:hasPermission(_${componentName},'${entityName}:edit')}">
						${'#'}{messages.common_edit_instance}
         					<a4j:support id="editsupport" event="onclick"
								oncomplete="${'#'}{rich:component('editPanel')}.show()">
								<f:setPropertyActionListener value="${'#'}{row}"
									target="${'#'}{${homeName}.instance}" />
							</a4j:support>
						</a4j:commandLink>
						${'#'}{' '}
						<a4j:commandLink ajaxSingle="true" id="deletelink" rendered="${'#'}{s:hasPermission(_${componentName},'${entityName}:delete')}">
						${'#'}{messages.common_delete_instance}
							<a4j:support id="deletesupport" event="onclick"
								oncomplete="${'#'}{rich:component('deletePanel')}.show()">
								<f:setPropertyActionListener value="${'#'}{row}"
									target="${'#'}{${homeName}.instance}" />
							</a4j:support>
						</a4j:commandLink>

					</rich:column>

					<f:facet name="footer">

						<rich:datascroller for="${componentName}ListTable" maxPages="20" align="left"
							ajaxSingle="true" id="datascroller" rendered="${homeName}.dataModel.rowCount >10">
						</rich:datascroller>

					</f:facet>
				</rich:dataTable>
				<a4j:status onstart="${'#'}{rich:component('wait')}.show()"
		onstop="${'#'}{rich:component('wait')}.hide()" />

				<a4j:commandLink ajaxSingle="true" id="addlink" action="${'#'}{${homeName}.clearInstance}"
					oncomplete="${'#'}{rich:component('addPanel')}.show()" rendered="${'#'}{s:hasPermission('entity','${entityName}:add')}">
						${'#'}{messages.common_add_instance}
					</a4j:commandLink>

			</h:form>
			</a4j:region>
			</div>
		</rich:panel>

		<ui:include src="${entityName}AddPane.xhtml" />
		<ui:include src="${entityName}EditPane.xhtml" />
		<ui:include src="${entityName}DeletePane.xhtml" />


	</ui:define>
</ui:composition>
