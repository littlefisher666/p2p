<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ page import="entity.News" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>NewsManage</title>
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
			function deleteNews()
			{
				 return confirm("确认删除", "确认要删除吗?删除后不能恢复");
			}
			
			function desmethod()
			{
				alert(1);
			}
		</script>
	</head>

	<body style="padding: 5px 10px">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">新闻管理</h3>
			</div>
			<div class="panel-body">
				<a href="${pageContext.request.contextPath }/index.jsp?method=newsAdd.jsp"
					class="btn btn-primary btn-default"> 
					添加 
					<span class="glyphicon glyphicon-plus"></span> 
				</a>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>新闻标题</th>
							<th>新闻正文</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allNews}" var="news">
							<c:if test="${news.status != 'D'}">
								<tr>
									<td>${fn:substring(news.newsTitle,0,9) }...</td>
									<td>${fn:substring(news.content,0,20) }...</td>
									<td>
										<fmt:formatDate value="${news.createAt}" type="date" pattern="yyyy/MM/dd"/>
									</td>
									<td>
										<a class="btn btn-primary  btn-xs btn-warning"
											href="${pageContext.request.contextPath }/news/toNewsModify.action?newsId=${news.newsId}">
											修改
											<span class="glyphicon glyphicon-pencil"></span> 
										</a>
										<a class="btn btn-primary btn-xs btn-success"
											href="${pageContext.request.contextPath }/news/newsDetail.action?newsId=${news.newsId}">
											详情 
											<span class="glyphicon glyphicon-list-alt"></span> 
										</a>
										<a class="btn btn-primary btn-xs btn-danger"
											href="${pageContext.request.contextPath }/sysuser/delNewsByNewsId.action?newsId=${news.newsId}"
											onclick="return deleteNews();"> 
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
