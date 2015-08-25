<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<div class="awrapper" align="center">
<c:if test="${dispFirst==1}">
<a class="aaction" href="${basePath}ifw.do?ifw_flowname=QueryProjectCateListFlow&pageActType=3&pageNumReq=${pageNum} ">【首页】</a>
</c:if>
<c:if test="${dispPre==1}">
<a class="aaction" href="${basePath}ifw.do?ifw_flowname=QueryProjectCateListFlow&pageActType=1&pageNumReq=${pageNum}">【上一页】</a>
</c:if>
<c:if test="${dispNext==1}">
<a class="aaction" href="${basePath}ifw.do?ifw_flowname=QueryProjectCateListFlow&pageActType=2&pageNumReq=${pageNum}">【下一页】</a>
</c:if>
<c:if test="${dispLast==1}">
<a class="aaction" href="${basePath}ifw.do?ifw_flowname=QueryProjectCateListFlow&pageActType=4&pageNumReq=${pageNum}">【尾页】</a>
</c:if>
第${pageNum}页/共${totalPageNum}页
</div>