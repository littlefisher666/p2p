<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ page import="entity.Product" %>
<%@ page import="entity.Apply" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>onlineApplyDetail</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css"
			type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css"
			type="text/css"></link>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/flat-ui.js"></script>
	</head>

	<body style="padding: 5px 10px">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">在线申请详情</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>产品名称</th>
							<th>申请人</th>
							<th>申请数额</th>
							<th>申请日期</th>
							<th>身份证号</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applies }" var="apply">
							<tr>
								<td>${apply.product.productName }</td>
								<td>${apply.applyPerson }</td>
								<td>${apply.applyNum }</td>
								<td>
									<fmt:formatDate value="${apply.applyDate }" type="date" pattern="yyyy/MM/dd"/>
								</td>
								<td>${apply.applyPersonIdcard }</td>
								<td>
									<c:if test="${apply.status == 'P'}">通过审核</c:if>
									<c:if test="${apply.status == 'R'}">未通过审核</c:if>
									<c:if test="${apply.status == 'W'}">等待审核</c:if>
								</td>
								<td>
									<c:if test="${apply.status == 'W'}">
										<a class="btn btn-primary btn-xs btn-danger"
											href="${pageContext.request.contextPath }/apply/modApplyStatus.action?applyId=${apply.applyId}&status=R">
											拒绝 
											<span class="glyphicon glyphicon-remove"></span> 
										</a>
										<a class="btn btn-primary btn-xs btn-success"
											href="${pageContext.request.contextPath }/apply/modApplyStatus.action?applyId=${apply.applyId}&status=P">
											通过 
											<span class="glyphicon glyphicon-ok"></span> 
										</a>
									</c:if>
									<c:if test="${apply.status != 'W'}">
										<a class="btn btn-primary btn-xs btn-success"
											href="${pageContext.request.contextPath }/apply/modApplyStatus.action?applyId=${apply.applyId}&status=W">
											待定
											<span class="glyphicon glyphicon-ok"></span> 
										</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
