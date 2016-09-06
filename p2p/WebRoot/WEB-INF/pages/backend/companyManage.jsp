<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="entity.Company" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>conpanyManage</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css"
			type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css"
			type="text/css"></link>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/flat-ui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/bootstrap/js/messager.js"></script>
		<script type="text/javascript">
			function deleteCompany()
			{
				 return confirm("确认删除", "确认要删除吗?删除后不能恢复");
			}
		</script>
	</head>

	<body style="padding: 5px 10px">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					企业管理
				</h3>
			</div>
			<div class="panel-body">
				<a href="${pageContext.request.contextPath}/index.jsp?method=companyAdd.jsp" class="btn btn-primary btn-default">
					添加
					<span class="glyphicon glyphicon-plus"></span> 
				</a>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>企业名称</th>
							<th>佣金比例</th>
							<th>企业详情</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${companies}" var="company">
							<c:if test="${company.status != 'D'}">
								<tr>
									<td>${company.companyName }</td>
									<td>${company.financingInReturn }%</td>
	<%--			${fn:substring(str,first,last)}用来截取字符串的jstl					--%>
									<td>${fn:substring(company.companyDetail,0,20 )}...</td>
									<td>
										<a class="btn btn-primary  btn-xs btn-warning"
											href="${pageContext.request.contextPath }/company/ToCompanyModify.action?companyId=${company.companyId}">
											修改
											<span class="glyphicon glyphicon-pencil"></span> 
										</a>
										<a class="btn btn-primary btn-xs btn-success"
											href="${pageContext.request.contextPath }/company/companyDetail.action?companyId=${company.companyId}">
											详情 
											<span class="glyphicon glyphicon-list-alt"></span> 
										</a>
										<a class="btn btn-primary btn-xs btn-danger"
											href="${pageContext.request.contextPath }/sysuser/delCompanyByCompanyId.action?companyId=${company.companyId}"
											onclick="return deleteCompany();"> 
											删除 
											<span class="glyphicon glyphicon-remove"></span> 
										</a>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
