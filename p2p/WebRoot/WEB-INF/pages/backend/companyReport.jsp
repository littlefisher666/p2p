<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Company" %>
<%@ page import="entity.Report" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>companyReport</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css"
			type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css"
			type="text/css"></link>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/datetimepicker/bootstrap-datetimepicker.css" type="text/css"></link>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/flat-ui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/bootstrap/js/messager.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/datetimepicker/bootstrap-datetimepicker.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
		<script type="text/javascript">
			function submit(){
				var year = $(".(year active)");
				alert("year:"+year);
				var form = $("form").attr("action","/p2p/company/qryCompanyReportByYear.action?year="+year);
				$("#submit").submit();
			}
			
		</script>
	</head>

	<body style="padding: 5px 10px">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">企业报表</h3>
			</div>

			<div class="panel-body">

				<table class="table table-hover">
					<thead>
						<tr>
							<th>企业名称</th>
							<th>融资产品总数</th>
							<th>总融资目标</th>
							<th>实际融资数</th>
							<th>佣金</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reports }" var="report">
							<tr>
								<td>${report.company.companyName }</td>
								<td>${report.productNum }</td>
								<td>${report.financingTarget }万</td>
								<td>${report.financingActualTotal }万</td>
								<td>${report.financingInReturnNumTotal }万</td>
								<td>
									<a class="btn btn-primary btn-xs btn-success"
										href="${pageContext.request.contextPath}/company/qryCompanyReportDetailByCompanyId.action?companyId=${report.company.companyId}">
										详情 
										<span class="glyphicon glyphicon-list-alt"></span> 
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<script type="text/javascript">
			$('#datetimepicker').datetimepicker( {
				language : 'zh-CN',
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 4,
				minView : 4,
				forceParse : 0
			});
		</script>
	</body>
</html>
