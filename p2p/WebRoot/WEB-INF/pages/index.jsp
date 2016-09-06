<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Product" %>
<%@ page import="entity.Company" %>
<%@ page import="entity.ProductType" %>
<%@ page import="entity.LendingPeriod" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>网络在线货币借贷及审核系统</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/jPaginate.css" rel="stylesheet" type="text/css" media="screen"/>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.paginate.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/index.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/clock.js"></script>
	</head>

	<body>
		
		<div class="wrap header oauto clear">
			<div class="clear" style="float: left"><a href="${pageContext.request.contextPath }/index.jsp?method=login.jsp">管理员登录</a></div>
			<div id="clock"  style="float: right;"></div>
		</div>
		<div class="logo-nav">
		    <div class="wrap oauto">
		        <div class="clear">
		            <div class="fl"><img src="${pageContext.request.contextPath }/images/logo.png" /></div>
		        </div>
		    </div>
		</div>
		<div class="menu">
		    <ul class="clear">
		        <li><a href="${pageContext.request.contextPath }/product/index.action" class="cur">融资产品</a></li>
		        <li><a href="${pageContext.request.contextPath }/news/newsIndex.action" target="_blank">每日新闻</a></li>
		    </ul>
		</div>


		<div class="wrap bank_list">
			<div class="title clear">
				<h1 class="fl">产品分类</h1>
			</div>
			<div class="bank_list_tp">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" id="choices">
					<tr class="bank_list_tp1">
						<td width="10%" align="right">产品类型：</td>

						<td width="12%" align="center" valign="top" class="qb">
							<a href="javascript:;" class="cur" productType="0">全部</a>
						</td>

						<td width="78%" class="txt clear">
							<a href="javascript:;" productType="1" >信用贷</a>
							<a href="javascript:;" productType="2">抵押贷</a>
							<a href="javascript:;" productType="3">质押贷</a>
							<a href="javascript:;" productType="4">担保贷</a>
							<a href="javascript:;" productType="5">票据贴现</a>
							<a href="javascript:;" productType="6">其他</a>
						</td>
					</tr>
					<tr class="bank_list_tp2">
						<td align="right">贷款周期：</td>
						<td align="center" valign="top" class="qb">
							<a href="javascript:;" class="cur" lendingPeriod="0">全部</a>
						</td>
						<td class="txt clear">
							<a href="javascript:;" lendingPeriod="1">1个月</a>
							<a href="javascript:;" lendingPeriod="2">3个月</a>
							<a href="javascript:;" lendingPeriod="3">6个月</a>
							<a href="javascript:;" lendingPeriod="4">12个月</a>
							<a href="javascript:;" lendingPeriod="5">其他</a>
						</td>
					</tr>
					<tr class="bank_list_tp3">
						<td align="right">贷款利率：</td>
						<td align="center" valign="top" class="qb">
							<a href="javascript:;" class="cur" primeLendingRateFrom="0" primeLendingRateTo="100">全部</a>
						</td>
						<td class="txt clear">
							<a href="javascript:;" primeLendingRateFrom="0" primeLendingRateTo="6">6%以下</a>
							<a href="javascript:;" primeLendingRateFrom="6" primeLendingRateTo="8">6%-8%</a>
							<a href="javascript:;" primeLendingRateFrom="8" primeLendingRateTo="10">8%-10%</a>
							<a href="javascript:;" primeLendingRateFrom="10" primeLendingRateTo="12">10%-12%</a>
							<a href="javascript:;" primeLendingRateFrom="12" primeLendingRateTo="14">12%-14%</a>
							<a href="javascript:;" primeLendingRateFrom="14" primeLendingRateTo="100">14%以上</a>
						</td>
					</tr>
					<tr class="bank_list_tp4">
						<td align="right">贷款规模：</td>
						<td align="center" valign="top" class="qb">
							<a href="javascript:;" class="cur" financingAmountFrom="0" financingAmountTo="100000">全部</a>
						</td>
						<td class="txt clear">
							<a href="javascript:;" financingAmountFrom="0" financingAmountTo="100">100万以下</a>
							<a href="javascript:;" financingAmountFrom="100" financingAmountTo="200">100万-200万</a>
							<a href="javascript:;" financingAmountFrom="200" financingAmountTo="300">200万-300万</a>
							<a href="javascript:;" financingAmountFrom="300" financingAmountTo="500">300万-500万</a>
							<a href="javascript:;" financingAmountFrom="500" financingAmountTo="1000">500万-1000万</a>
							<a href="javascript:;" financingAmountFrom="1000" financingAmountTo="100000">1000万以上</a>
						</td>
					</tr>
				</table>
			</div>
		</div>


		<div class="wrap project_release">
			<div class="project_release_tp">融资产品</div>
		    <div class="project_release_bt">
		    	<ul id="ul">
		    		<c:forEach items="${products }" var="product">
		    			<c:if test="${product.status != 'D'}">
			    			<li class="clear">
				                <div class="fl">
				                	<dl>
				                    	<dt>产品名称：<span class="king">${product.productName }</span></dt>
				                    	<dt>所属银行：${product.company.companyName }</dt>
				                      	<dt>产品类别：${product.productType.productTypeName }</dt>
				                    	<dt>放贷利率：${product.primeLendingRateFrom }%-${product.primeLendingRateTo }%（年化利率）</dt>
				                    	<dt>放贷金额：${product.financingAmountFrom }-${product.financingAmountTo }万</dt>
				                      	<dt>放贷期限：${product.lendingPeriod.period }个月</dt>
				                    </dl>
				                </div>
				                <div class="view_details"><a href="${pageContext.request.contextPath }/product/productIndex.action?productId=${product.productId }">查看详细</a></div>
				            </li>
		    			</c:if>
		    		</c:forEach>
		    	</ul>
		    </div>
			<input id="pageSum" type="hidden" value="${pageSum}"/>
			<script type="text/javascript">
				var pageSum = $("#pageSum").attr("value");
				$(function() {
					$("#demo4").paginate({
					count 					: pageSum,//页面总数
					start 					: 1,//打开页面选中的页面
					display     			: 12,//能够显示的页面数量 
					border					: false,
					text_color  			: '#79B5E3',
					background_color    	: 'none',	
					text_hover_color  		: '#2573AF',
					background_hover_color	: 'none', 
					images					: false,
					mouse					: 'press',
					onChange     			: function(page){
													validatePage(page);
											  }
					
					});
				});
		</script>
			<div class="demo">
				<div id="demo4"></div>
			</div>
		</div>
		
		<div class="footer">Copyright &copy; 2011届南京信息工程大学学生靳雅楠  版权所有   <a href="mailto:jin68716503@163.com">jin68716503@163.com</a></div>
		
	</body>
</html>
