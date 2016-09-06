<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Product" %>
<%@ page import="entity.Company" %>
<%@ page import="entity.ProductType" %>
<%@ page import="entity.LendingPeriod" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>productManage</title>
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
<%--	删除function写不出来	--%>
			function deleteProduct()
			{
				return confirm("确认删除", "确认要删除吗?删除后不能恢复") ;
			}
		</script>
	</head>

	<body style="padding: 5px 10px">
		
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">融资产品管理</h3>
			</div>
			<div class="panel-body">
				<a href="${pageContext.request.contextPath}/product/productAdd.action" class="btn btn-primary btn-default">
					添加 <span class="glyphicon glyphicon-plus"></span> 
				</a>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>产品名称</th>
							<th>发行单位</th>
							<th>产品类型</th>
							<th>贷款周期</th>
							<th>贷款利率</th>
							<th>贷款规模</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products }" var="product">
							<c:if test="${product.status != 'D' }">
								<tr>
									<td>${product.productName }</td>
									<td>${product.company.companyName }</td>
									<td>${product.productType.productTypeName }</td>
									<td>${product.lendingPeriod.period }个月</td>
									<td>${product.primeLendingRateFrom }%-${product.primeLendingRateTo }%</td>
									<td>${product.financingAmountFrom }万-${product.financingAmountTo }万</td>
									<td>
										<c:if test="${product.status == 'E' }">有效产品</c:if>
										<c:if test="${product.status == 'T' }">失效产品</c:if>
									</td>
									<td>
										<a class="btn btn-primary  btn-xs btn-warning"
											href="${pageContext.request.contextPath}/product/toProductModify.action?productId=${product.productId }"> 
											修改 
											<span class="glyphicon glyphicon-pencil"></span> 
										</a>
										<a class="btn btn-primary btn-xs btn-success"
											href="${pageContext.request.contextPath}/product/productDetail.action?productId=${product.productId }">
											 详情
											<span class="glyphicon glyphicon-list-alt"></span> 
										</a>
										<a class="btn btn-primary btn-xs btn-danger" href="${pageContext.request.contextPath }/sysuser/delProductByProductId.action?productId=${product.productId }"
											onclick="return deleteProduct();"> 
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
