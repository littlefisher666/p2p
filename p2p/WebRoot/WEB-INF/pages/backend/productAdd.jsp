<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Product" %>
<%@ page import="entity.Company" %>
<%@ page import="entity.ProductType" %>
<%@ page import="entity.LendingPeriod" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>productAdd</title>
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
		
		<script type="text/javascript">
			function inputSubmit(){
				$("#contentInput").val($("#content").wysiwyg('getContent').html());
			};
		</script>
	</head>

	<body style="padding: 5px 10px">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">融资产品添加</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/product/addProduct.action"
					method="post">
					<div class="form-group">
						<label for="productName" class="col-lg-2 control-label">产品名称</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="productName" name="product.productName" placeholder="产品名称">
						</div>
					</div>

					<div class="form-group">
						<label for="productRate" class="col-lg-2 control-label">贷款利率</label>
						<div class="col-lg-10">
							<div class="input-group col-lg-3" style="float: left;">
								<input type="text" class="form-control" name="product.primeLendingRateFrom" placeholder="最低利率,不填默认为0">
								<span class="input-group-addon">%</span>
							</div>
							<div class="input-group col-lg-4">
								<input type="text" class="form-control" name="product.primeLendingRateTo" placeholder="最高利率,可不填,不填认为利率为固定值">
								<span class="input-group-addon">%</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="company" class="col-lg-2 control-label">发行单位</label>
						<div class="col-lg-10">
							<select data-toggle="select" class="form-control select select-default" id="company" name="product.company.companyId ">
								<c:forEach items="${companies }" var="company">
									<option value="${company.companyId }">
										${company.companyName }
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="loansize" class="col-lg-2 control-label">贷款规模</label>
						<div class="col-lg-10">
							<div class="input-group col-lg-3" style="float: left;">
								<input type="text" class="form-control" name="product.financingAmountFrom" placeholder="最低贷款规模,不填默认为0">
								<span class="input-group-addon">万</span>
							</div>
							<div class="input-group col-lg-5">
								<input type="text" class="form-control" name="product.financingAmountTo" placeholder="最高贷款规模,可不填,不填认为贷款规模为固定值">
								<span class="input-group-addon">万</span>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="productType" class="col-lg-2 control-label">产品类型</label>
						<div class="col-lg-10">
							<select data-toggle="select" class="form-control select select-default" id="productType" name="product.productType.productTypeId">
								<c:forEach items="${productTypes }" var="productType">
									<option value="${productType.productTypeId }">
										${productType.productTypeName }
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="productDuration" class="col-lg-2 control-label">贷款周期</label>
						<div class="col-lg-10">
							<select data-toggle="select" class="form-control select select-default" id="lendingPeriod" name="product.lendingPeriod.lendingPeriodId">
								<c:forEach items="${lendingPeriods }" var="lendingPeriod">
									<option value="${lendingPeriod.lendingPeriodId }">
										${lendingPeriod.period }个月
									</option>
								</c:forEach>
							</select>
						</div>
					</div>


					<div class="form-group">
						<label for="linkman" class="col-lg-2 control-label">联系人</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="linkman" name="product.linkMan" placeholder="联系人">
						</div>
					</div>

					<div class="form-group">
						<label for="bank" class="col-lg-2 control-label">联系银行</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="bank" name="product.ownedBank" placeholder="联系银行">
						</div>
					</div>


					<div class="form-group">
						<label for="content" class="col-lg-2 control-label">内容</label>
						<div class="col-lg-10">

							<div class="btn-toolbar" data-role="editor-toolbar" data-target="#content">
								<div class="btn-group">
									<a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)">
										<b>加粗</b> 
									</a>
									<a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)">
										<i>倾斜</i> 
									</a>
								</div>
								<div class="btn-group">
									<a class="btn" data-edit="insertunorderedlist" title="Bullet list">列表 </a>
									<a class="btn" data-edit="insertorderedlist" title="Number list">有序列表 </a>
									<a class="btn" data-edit="indent" title="Indent (Tab)">Tab缩进</a>
								</div>
								<div class="btn-group">
									<a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"> 左对齐 </a>
									<a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"> 居中 </a>
									<a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"> 右对齐 </a>
									<a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"> 自动调整 </a>
								</div>

								<div class="btn-group">
									<a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"> 撤销 </a>
									<a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"> 恢复 </a>
								</div>
							</div>
							<div id="content" style="overflow: scroll; max-height: 300px; border: 1px solid; height: 200px;"></div>
							<input type="hidden" name="company.companyDetail" id="contentInput" />
							<br />
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button type="submit" class="btn btn-lg btn-success" style="padding: 15px 60px; border-radius: 0px;" onclick="inputSubmit();">
								添加
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
