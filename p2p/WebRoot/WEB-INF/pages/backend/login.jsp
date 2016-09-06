<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Sysuser" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>登录到Iting</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">		
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css" type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css" type="text/css"></link>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/flat-ui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/base.js"></script>
		
		<style type="text/css">
    		$(function(){
    			$('#loginFrm');
    		})	
    	</style>
		<style type="text/css">
			body{
				background-color: #7784a0;
				padding-top: 40px;
			}
			.loginDiv{
				margin: auto;
				height: 300px;
				width: 600px;
				margin-top:1111pz;;
				background-color: #aaaaaa;
				color: white;
			}
			.loginFrm{
				margin: auto;
				height: 300px;
				width: 600px;
				height: 300px;
				background: #ffffff;
				margin-top:1111pz;;
			}
		</style>
		
		<script type="text/javascript">
			function loginsubmit(){
				document.getElementById("login-form").submit();
			}
		</script>
	</head>

	<body>
		<div class="loginDiv" style="height: 61px;">
			<h3 style="text-align: center; padding-top: 10px;">欢迎使用ITing融资系统</h3>
		</div>
		<div class="loginFrm">
			<form class="form-horizontal" role="form" method="post" id="login-form" action="${pageContext.request.contextPath }/sysuser/login.action">
				<div class="form-group" style="padding-top: 15px;">
					<label for="userName" class="col-lg-2 control-label">用户名</label>
					<div class="col-lg-9">
						<input type="text" class="form-control" id="loginName" name="sysuser.loginName" />
					</div>
				</div>
				<div class="form-group">
					<label for="pwd" class="col-lg-2 control-label">密码</label>
					<div class="col-lg-9">
						<input type="password" class="form-control" id="pwd" name="sysuser.loginPassword" />
					</div>
				</div>
				<div class="form-group" align="right">
					<div class="col-lg-10">
						<a style="border: none;" class="btn" href="javascript:;" onclick="loginsubmit();"> 
							<img alt="" src="${pageContext.request.contextPath }/images/login_btn.png">
						</a>
					</div>
				</div>
				<div class="form-group" align="right">
					<hr style="width: 80%" />
					<div class="footer">Copyright &copy; 2011届南京信息工程大学学生靳雅楠  版权所有   <a href="mailto:jin68716503@163.com">jin68716503@163.com</a></div>
				</div>
			</form>
		</div>
	</body>
</html>
