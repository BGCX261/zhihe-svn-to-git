<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<div class="awrapper" align="center">
<c:if test="${dispFirst==1}">
<a class="aaction" href="${basePath}ifw.do?ifw_flowname=QueryProjectCateListFlow&pageActType=3&pageNumReq=${pageNum} ">����ҳ��</a>
</c:if>
<c:if test="${dispPre==1}">
<a class="aaction" href="${basePath}ifw.do?ifw_flowname=QueryProjectCateListFlow&pageActType=1&pageNumReq=${pageNum}">����һҳ��</a>
</c:if>
<c:if test="${dispNext==1}">
<a class="aaction" href="${basePath}ifw.do?ifw_flowname=QueryProjectCateListFlow&pageActType=2&pageNumReq=${pageNum}">����һҳ��</a>
</c:if>
<c:if test="${dispLast==1}">
<a class="aaction" href="${basePath}ifw.do?ifw_flowname=QueryProjectCateListFlow&pageActType=4&pageNumReq=${pageNum}">��βҳ��</a>
</c:if>
��${pageNum}ҳ/��${totalPageNum}ҳ
</div>