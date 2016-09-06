<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Company" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>companyDetail</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css"
			type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css"
			type="text/css"></link>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/plugins/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/flat-ui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/fwb/bootstrap-wysiwyg.js"></script>
		<script src="${pageContext.request.contextPath }/plugins/fwb/external/jquery.hotkeys.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/productAdd.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/application.js"></script>
	
	</head>

	<body style="padding: 5px 10px">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">企业详情</h3>
			</div>
			<div class="panel-body">


				<div class="form-group">
					<label for="companyId" class="col-lg-2 control-label">企业编号</label>
					<div class="col-lg-10">
						${company.companyId }
					</div>
				</div>

				<div class="form-group">
					<label for="companyName" class="col-lg-2 control-label">企业名称</label>
					<div class="col-lg-10">
						${company.companyName }
					</div>
				</div>

				<div class="form-group">
					<label for="productRate" class="col-lg-2 control-label">融资佣金</label>
					<div class="col-lg-10">
						${company.financingInReturn }%
					</div>
				</div>

				<div class="form-group">
					<label for="content" class="col-lg-2 control-label">内容</label>
					<div class="col-lg-10">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						${company.companyDetail }
					</div>
				</div>
			</div>
		</div>

	</body>
</html>
