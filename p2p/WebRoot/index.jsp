<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--<jsp:forward page="/WEB-INF/pages/index.jsp"></jsp:forward>--%>
<%--<jsp:forward page="WEB-INF/pages/backend/companyManager.jsp"></jsp:forward>--%>
<%--<jsp:forward page="/product/index.action"></jsp:forward>--%>
<%--<a href="${pageContext.request.contextPath }/product/index.action">a</a>--%>

<% 
	String method = request.getParameter("method"); 
	if(null == method) {
%>
<jsp:forward page="/product/index.action" />
<% 
	} else { 
		method = "/WEB-INF/pages/backend/" + method; 
%>
<jsp:forward page="<%=method%>" />
<% 
	} 
%>
