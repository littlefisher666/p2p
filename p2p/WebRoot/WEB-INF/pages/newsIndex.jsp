<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="entity.News" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>ITing金融-每日新闻</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/jPaginate.css" rel="stylesheet" type="text/css" media="screen"/>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/dateFormat.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.paginate.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/clock.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/newsIndex.js"></script>
	</head>

	<body>
		<div class="wrap header oauto clear">
			<div class="clear" style="float: left"><a href="${pageContext.request.contextPath }/index.jsp?method=login.jsp">管理员登录</a></div>
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
		        <li><a href="${pageContext.request.contextPath }/product/index.action">融资产品</a></li>
		        <li><a href="${pageContext.request.contextPath }/news/newsIndex.action" target="_blank"  class="cur">每日新闻</a></li>
		    </ul>
		</div>
		
		
		<div class="wrap font16">首页 >> 每日新闻</div>
		<div class="wrap">
		<div class="title clear"><h1 class="fl">今日头条</h1></div>
			<div class="salon_top clear">
		    	<div class="fl">
		        	<ul id="foo1">
		            	<li><img src="${pageContext.request.contextPath }/images/news/${firstNews.image }" width="613" height="459" /></li>
		            </ul>
		            <div id="pager1" class="pager"></div>
		        </div>
		        <div class="fr">
		        	<div class="bt"><h1><a href="" title="${firstNews.newsTitle }">${firstNews.newsTitle }</a></h1>
		            	<div class="hudongsalon_success">
		            		<span class="fe4800">(成功举办)</span>
		                </div>
		            </div>
		            <div class="in clear">
		                <div class="time">时间：<fmt:formatDate value="${firstNews.createAt}" type="date" pattern="yyyy/MM/dd"/></div>
		            </div>
		            <div class="txt">
		            	${firstNews.content }
		            </div>
		        </div>
		    </div>
		</div>
		<div class="wrap">
			<div class="title clear"><h1 class="fl">其他新闻</h1></div>
		    <div class="salon">
		    	<ul id="ul">
		    		<c:forEach items="${allNews}" var="news">
		    			<li class="clear">
			            	<div class="fl"><img src="${pageContext.request.contextPath }/images/news/${news.image }" /></div>
			                <div class="fl">
			                	<div class="salon_title clear">
			                		<div class="fl">
			                			<a href="" title="${news.newsTitle }">${news.newsTitle }</a>
			                			<span class="fe4800">
			                				<c:if test="${news.status}=='C'">(成功举办)</c:if>
			                				<c:if test="${news.status}=='F'">(已结束)</c:if>
			                			</span>
			                		</div>
			                		<div class="fr">日期：<fmt:formatDate value="${news.createAt}" type="date" pattern="yyyy/MM/dd"/></div>
			                	</div>
			                    <div class="salon_in">${news.content }</div>
			                </div>
			            </li>
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
