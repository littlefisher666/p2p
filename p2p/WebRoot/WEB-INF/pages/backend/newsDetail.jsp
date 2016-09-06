<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.News" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>newsModify</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css" type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"> </script>
		<script src="${pageContext.request.contextPath }/plugins/bootstrap/js/bootstrap.min.js"> </script>
	</head>

	<body style="padding: 5px 10px">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">新闻详情</h3>
			</div>
			<div class="panel-body">
				<h1>${news.newsTitle }</h1>
				<img alt="" src="${pageContext.request.contextPath }/images/news/${news.image }" class="img-thumbnail">
				<p class="lead">${news.content }</p>
			</div>
		</div>

	</body>
</html>
