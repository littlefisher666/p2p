<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ page import="entity.Apply" %>
<%@ page import="entity.Product" %>
<%@ page import="entity.Company" %>
<%@ page import="entity.ProductType" %>
<%@ page import="entity.LendingPeriod" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>ITing金融-产品</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">		
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css" type="text/css"></link>
			<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css" type="text/css"></link>
			<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
			<link rel="stylesheet" href="${pageContext.request.contextPath }/css/css.css">
			<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/flat-ui.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath }/js/base.js"></script>
			
			<script language="javascript"> 
				function realSysTime(clock){ 
				var now=new Date(); //创建Date对象 
				var year=now.getFullYear(); //获取年份 
				var month=now.getMonth(); //获取月份 
				var date=now.getDate(); //获取日期 
				var day=now.getDay(); //获取星期 
				var hour=now.getHours(); //获取小时 
				var minu=now.getMinutes(); //获取分钟 
				var sec=now.getSeconds(); //获取秒钟 
				month=month+1; 
				var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六"); 
				var week=arr_week[day]; //获取中文的星期 
				var time="<a href='#'>"+year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec+"</a>"; //组合系统时间 
				clock.innerHTML=time; //显示系统时间 
				} 
				window.onload=function(){ 
				window.setInterval("realSysTime(clock)",1000); //实时获取并显示系统时间 
				} 
			</script> 
	</head>

	<body>
		<div class="wrap header oauto clear">
		    <div id="clock" class="fr"></div>
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
		
		
		
		<div class="wrap font16">首页 >> 融资产品 >> ${product.productName }</div>
		<div class="wrap clear">
			<div class="fl">
		    	<div class="detail_detail">
		        	<div class="success_tp clear">
		            	<div class="fl">${product.productName }</div>
		            </div>
		            <div class="detail_detail_bt">
		            	<div class="detail_detail_bt1">
		            	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		                    <tr>
		                      <td>产品名称：${product.productName }</td>
		                      <td>放贷利率：${product.primeLendingRateFrom }%-${product.primeLendingRateTo }%（年化利率）</td>
		                    </tr>
		                    <tr>
		                      <td>发行单位：${product.company.companyName }</td>
		                      <td>放贷金额：${product.financingAmountFrom }-${product.financingAmountTo }万</td>
		                    </tr>
		                    <tr>
		                      <td>产品类型：${product.productType.productTypeName }</td>
		                      <td>放贷期限：${product.lendingPeriod.period }个月</td>
		                    </tr>
		                  </table>
		            	</div>
		                <div class="detail_detail_bt3 clear">
		                	<div class="fl">经理：${product.linkMan }<br />${product.ownedBank }</div>
		                    <div class="fr">
		                    	<a href="javascript:;" data-toggle="modal" data-target="#applyModal" class="apply-btn" />
		                    		申请
		                    	</a>
		                    </div>
		                </div>
		            </div>
		        </div>
		        
		        
		        
		        <div class="detail_detail_title title clear"><h1 class="fl">产品详情</h1></div>
		        <div class="detail_detail_in">
		        	<h1><span class="logo1"></span>产品描述</h1>
		            <p>${product.productDescription }</p>
		            <h1><span class="logo1"></span>功能特点</h1>
		            <p>（1）利用创投机构对科技型中小企业经营状况以及发展潜力的专业判断，有效控制客户准入风险；
		           	          （2）股权融资和债权融资相结合，在不稀释股权的基础上有效解决企业流动资金需求；
		           	          （3）建立起银行、创投机构与科技型中小企业的合作平台。</p>
		            <h1><span class="logo1"></span>相关要求</h1>
		            <p>（1）贷款金额：根据借款人的实际资金需求、偿债能力及我行认可的授信方案综合确定银投联贷的贷款金额，该品种项下的最高金额不得超过创投公司实际投入到借款人的创投（风投）资金的80％。
		           	          （2）贷款期限：由贷款人根据借款人实际生产周期、借款用途、借款人风险承受能力、经营特点等情况具体确定，不得超过创投公司和借款人约定的退出投资期限。
		                                                  （3）贷款利率：贷款利率按照中国人民银行利率政策及我行的贷款定价政策执行。</p>
		        </div>
		    </div>
		    <div class="fr">
		    	<div class="success">
		        	<div class="success_tp">产品成功申请人<span class="fe4800">（${fn:length(product.applies)} ）</span>人</div>
		            <div class="success_bt">
		            	<ul>
		            		<c:forEach items="${product.applies }" var="apply" varStatus="status">
		            			<li><h1>${status.count }</h1><span>${apply.applyPerson }</span>成功申请（${apply.applyNum }万元）</li>
		            		</c:forEach>
		                </ul>
		            </div>
		        </div>
		    </div>
		</div>
		
		<!-- 申请 -->
		<div class="modal fade" style="margin-top: 200px;" id="applyModal"
			tabindex="-1" role="dialog" aria-labelledby="applyModal"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form class="form-horizontal" role="form" method="post"
						action="${pageContext.request.contextPath }/apply/applyProduct.action?productId=${product.productId }">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">申请</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="productId" class="col-lg-2 control-label">产品ID</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="productId" name="apply.applyId" readonly="readonly" value="${product.productId}" />
								</div>
							</div>
							<div class="form-group">
								<label for="productName" class="col-lg-2 control-label">产品名称</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="productName" name="apply.product.productName" readonly="readonly" value="${product.productName}" />
								</div>
							</div>
							<div class="form-group">
								<label for="applyPersonIDCard" class="col-lg-2 control-label">申请人身份证号</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="applyPersonIDCard" name="apply.applyPersonIdcard" placeholder="申请人身份证号" />
								</div>
							</div>
							<div class="form-group">
								<label for="applyPerson" class="col-lg-2 control-label">申请人</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="applyPerson" name="apply.applyPerson" placeholder="请使用上面身份证上的姓名" />
								</div>
							</div>




							<div class="form-group">
								<label for="applyNum" class="col-lg-2 control-label">申请金额</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="applyNum" name="apply.applyNum" placeholder="单位：万元" />
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							<input type="submit" class="btn btn-primary" value="申请" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 申请 -->

<!--end-->
		<div class="footer">Copyright &copy; 2011届南京信息工程大学学生靳雅楠  版权所有   <a href="mailto:jin68716503@163.com">jin68716503@163.com</a></div>
		
		
	</body>
</html>
