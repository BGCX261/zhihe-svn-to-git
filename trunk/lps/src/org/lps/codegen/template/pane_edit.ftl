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
id="editPanel" autosized="true" width="450" rendered="${'#'}{s:hasPermission('entity','${entityName}:edit')}" >
		<f:facet name="header">
			<h:outputText value="${'#'}{messages.common_edit_instance}${'#'}{messages.entity_${entityName}}"/>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<h:graphicImage value="../img/ico_close.gif" id="hidelinkedit"
					styleClass="hidelink" />
				<rich:componentControl for="editPanel" attachTo="hidelinkedit"
					operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<div class="modalPanelForm">
		<h:form>
			
			<h:panelGrid columns="1">
				
					<h:panelGrid columns="1">
					<#foreach property in pojo.allPropertiesIterator>
					
<#if !c2h.isCollection(property) && !isToOne(property) && property != pojo.versionProperty!>
<#assign propertyIsId = property.equals(pojo.identifierProperty)>
<#if !propertyIsId || property.value.identifierGeneratorStrategy == "assigned">
<#if pojo.isComponent(property)>
<#foreach componentProperty in property.value.propertyIterator>
<#assign column = componentProperty.columnIterator.next()>

            <s:decorate id="${componentProperty.name}Field" template="../layout/edit.xhtml" rendered="${'#'}{s:hasPermission(${homeName}.instance,'${entityName}.${property.name}:edit')}">
                <ui:define name="label">${'#'}{messages.entity_${entityName}_${property.name}}</ui:define>
<#if isDate(componentProperty)>
                <rich:calendar id="${componentProperty.name}"
<#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
</#if>
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}" datePattern="MM/dd/yyyy" />
<#elseif isTime(componentProperty)>
                <h:inputText id="${componentProperty.name}"
                           size="5"
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                    <s:convertDateTime type="time"/>
                    <a:support event="onblur" reRender="${componentProperty.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
<#elseif isTimestamp(componentProperty)>
                <rich:calendar id="${componentProperty.name}"
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}" datePattern="MM/dd/yyyy hh:mm a" />
<#elseif isBigDecimal(componentProperty)>
                <h:inputText id="${componentProperty.name}"
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"
                           size="${column.precision+7}">
                    <a:support event="onblur" reRender="${componentProperty.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
<#elseif isBigInteger(componentProperty)>
                <h:inputText id="${componentProperty.name}"
<#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
</#if>
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"
                           size="${column.precision+6}">
                    <a:support event="onblur" reRender="${componentProperty.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
<#elseif isBoolean(componentProperty)>
                 <h:selectBooleanCheckbox id="${componentProperty.name}"
<#if !column.nullable>
                                    required="true"
</#if>
<#if propertyIsId>
                                    disabled="${'#'}{${homeName}.managed}"
</#if>
                                       value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"/>
<#elseif isString(componentProperty)>
<#if column.length gt 1000>
<#if column.length gt 800>
<#assign rows = 10>
<#else>
<#assign rows = (column.length/60)?int>
</#if>
                <h:inputTextarea id="${componentProperty.name}"
                               cols="60"
                               rows="${rows}"
<#if propertyIsId>
                           disabled="${'#'}{${homeName}.managed}"
</#if>
<#if !column.nullable>
                           required="true"
</#if>
                              value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}"/>
<#else>
<#if column.length gt 60>
<#assign size = 60>
<#else>
<#assign size = column.length>
</#if>
                <h:inputText id="${componentProperty.name}"
<#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
</#if>
<#if !column.nullable>
                      required="true"
</#if>
                          size="${size}"
                     maxlength="${column.length}"
                         value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                    <a:support event="onblur" reRender="${componentProperty.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
</#if>
<#else>
                <h:inputText id="${componentProperty.name}"
<#if !column.nullable>
                       required="true"
</#if>
<#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}">
                    <a4j:support event="onblur" reRender="${componentProperty.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
</#if>
            </s:decorate>
</#foreach>
<#else>
<#assign column = property.columnIterator.next()>
<#assign property = property.value.typeName>

            <s:decorate id="${property.name}Field" template="../layout/edit.xhtml" rendered="${'#'}{s:hasPermission(${homeName}.instance,'${entityName}.${property.name}:edit')}">
                <ui:define name="label">${'#'}{messages.entity_${entityName}_${property.name}}</ui:define>
<#if isDate(property)>
                <rich:calendar id="${property.name}"
<#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
</#if>
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}}" datePattern="MM/dd/yyyy" />
<#elseif isTime(property)>
                <h:inputText id="${property.name}"
                           size="5"
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}}">
                    <s:convertDateTime type="time"/>
                    <a4j:support event="onblur" reRender="${property.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
<#elseif isTimestamp(property)>
                <rich:calendar id="${property.name}"
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}}" datePattern="MM/dd/yyyy hh:mm a"/>
<#elseif isBigDecimal(property)>
                <h:inputText id="${property.name}"
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}}"
                           size="${column.precision+7}">
                    <a4j:support event="onblur" reRender="${property.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
<#elseif isBigInteger(property)>
                <h:inputText id="${property.name}"
<#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
</#if>
<#if !column.nullable>
                       required="true"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}}"
                           size="${column.precision+6}">
                    <a4j:support event="onblur" reRender="${property.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
<#elseif isBoolean(property)>
                <h:selectBooleanCheckbox id="${property.name}"
<#if !column.nullable>
                                   required="true"
</#if>
<#if propertyIsId>
                                   disabled="${'#'}{${homeName}.managed}"
</#if>
                                      value="${'#'}{${homeName}.instance.${property.name}}"/>
<#elseif isString(property)>
<#if column.length gt 160>
<#if column.length gt 800>
<#assign rows = 10>
<#else>
<#assign rows = (column.length/80)?int>
</#if>
                <h:inputTextarea id="${property.name}"
                               cols="80"
                               rows="${rows}"
<#if propertyIsId>
                           disabled="${'#'}{${homeName}.managed}"
</#if>
<#if !column.nullable>
                           required="true"
</#if>
                              value="${'#'}{${homeName}.instance.${property.name}}"/>
<#else>
<#if column.length gt 100>
<#assign size = 100>
<#else>
<#assign size = column.length>
</#if>
                <h:inputText id="${property.name}"
<#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
</#if>
<#if !column.nullable>
                       required="true"
</#if>
                           size="${size}"
                      maxlength="${column.length}"
                          value="${'#'}{${homeName}.instance.${property.name}}">
                    <a4j:support event="onblur" reRender="${property.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
</#if>
<#else>
                <h:inputText id="${property.name}"
<#if !column.nullable>
                       required="true"
</#if>
<#if propertyIsId>
                       disabled="${'#'}{${homeName}.managed}"
</#if>
                          value="${'#'}{${homeName}.instance.${property.name}}">
                    <a4j:support event="onblur" reRender="${property.name}Field" bypassUpdates="true" ajaxSingle="true"/>
                </h:inputText>
</#if>
            </s:decorate>
</#if>
</#if>
</#if>

<#if !c2h.isCollection(property) && !isToOne(property) && property != pojo.versionProperty!>
<#if !property.equals(pojo.identifierProperty) || property.value.identifierGeneratorStrategy == "assigned">
<#if c2j.isComponent(property)>
<#foreach componentProperty in property.value.propertyIterator>
        <s:decorate id="${componentProperty.name}" template="../layout/display.xhtml" rendered="${'#'}{!s:hasPermission(${homeName}.instance,'${entityName}.${property.name}:edit') and s:hasPermission(${homeName}.instance,'${entityName}.${property.name}:read')}">
            <ui:define name="label">${'#'}{messages.entity_${entityName}_${property.name}</ui:define>
            <@outputValue property=componentProperty expression="${'#'}{${homeName}.instance.${property.name}.${componentProperty.name}}" indent=12/>
        </s:decorate>
</#foreach>
<#else>
        <s:decorate id="${property.name}" template="../layout/display.xhtml"  rendered="${'#'}{!s:hasPermission(${homeName}.instance,'${entityName}.${property.name}:edit') and s:hasPermission(${homeName}.instance,'${entityName}.${property.name}:read')}">
            <ui:define name="label">${'#'}{messages.entity_${entityName}_${property.name}}</ui:define>
            <@outputValue property=property expression="${'#'}{${homeName}.instance.${property.name}}" indent=12/>
        </s:decorate>
</#if>
</#if>
</#if>

</#foreach>
							<h:panelGrid columns="2">
						<a4j:commandButton value="${'#'}{messages.common_save_instance}"
					action="${'#'}{${componentName}Home.update}"
					reRender="${componentName}List,messagePanel"
					oncomplete="if (!${'#'}{facesContext.maximumSeverity.ordinal == 2})${'#'}{rich:component('editPanel')}.hide();" 
					status="commonstatus"/>
					<a4j:commandButton value="${'#'}{messages.common_back}"
					oncomplete="${'#'}{rich:component('editPanel')}.hide();" status="commonstatus"/>
					</h:panelGrid>
					</h:panelGrid>
				
				
			</h:panelGrid>
		</h:form>
		</div>
	</rich:modalPanel>