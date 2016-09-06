var productType = 0;
var lendingPeriod = 0;
var primeLendingRateFrom = 0;
var primeLendingRateTo = 100;
var financingAmountFrom = 0;
var financingAmountTo = 100000;

//=====异步选择类型  begin=====================================
$(document).ready(function(){
	$("#choices tr").each(function()
		{
			$(this).find('a').click(function(){
					$(this).parent().parent().find('a').removeClass('cur');
					$(this).addClass('cur');
					if($(this).parent().parent().attr("class") == "bank_list_tp1") {
						productType = $(this).attr("productType");
//						alert("productType:"+productType);
					} else if($(this).parent().parent().attr("class") == "bank_list_tp2") {
						lendingPeriod = $(this).attr("lendingPeriod");
//						alert("lendingPeriod:"+lendingPeriod);
					} else if($(this).parent().parent().attr("class") == "bank_list_tp3") {
						primeLendingRateFrom = $(this).attr("primeLendingRateFrom");
						primeLendingRateTo = $(this).attr("primeLendingRateTo");
//						alert("primeLendingRateFrom:"+primeLendingRateFrom);
//						alert("primeLendingRateTo:"+primeLendingRateTo);
					} else if($(this).parent().parent().attr("class") == "bank_list_tp4") {
						financingAmountFrom = $(this).attr("financingAmountFrom");
						financingAmountTo = $(this).attr("financingAmountTo");
//						alert("financingAmountFrom:"+financingAmountFrom);
//						alert("financingAmountTo:"+financingAmountTo);
					}
					$.ajax({
						type    :"POST",
						dataType:"json",
						url     :"/p2p/ajax/selectProductByType.action",
						data    :"productType="+productType+"&lendingPeriod="+lendingPeriod+"&primeLendingRateFrom="+primeLendingRateFrom+
								 "&primeLendingRateTo="+primeLendingRateTo+"&financingAmountFrom="+financingAmountFrom+"&financingAmountTo="+financingAmountTo,
						success :function(data){
									refreshPage(data[0]);
									
									$("#demo4").paginate({
										count 		: data[1],//页面总数
										start 		: 1,//打开页面选中的页面
										display     : 12,//能够显示的页面数量 
										border					: false,
										text_color  			: '#79B5E3',
										background_color    	: 'none',	
										text_hover_color  		: '#2573AF',
										background_hover_color	: 'none', 
										images		: false,
										mouse		: 'press',
										onChange     			: function(page){
																		validatePage(page);
														 		 }
									});
						},
					});							
			});
		}
	);
});
//=====异步选择类型 end=======================================

//=====分页ajax begin========================================
function validatePage(page){
//	alert(page);
	$.ajax({
		type    :"POST",
		dataType:"json",
		url     :"/p2p/ajax/selectProductByPage.action",
		data    :"page="+page+"&productType="+productType+"&lendingPeriod="+lendingPeriod+"&primeLendingRateFrom="+primeLendingRateFrom+
				 "&primeLendingRateTo="+primeLendingRateTo+"&financingAmountFrom="+financingAmountFrom+"&financingAmountTo="+financingAmountTo,
		success :function(data){
					refreshPage(data[0]);
					
					$("#demo4").paginate({
						count 		: data[1],//页面总数
						start 		: page,//打开页面选中的页面
						display     : 12,//能够显示的页面数量 
						border					: false,
						text_color  			: '#79B5E3',
						background_color    	: 'none',	
						text_hover_color  		: '#2573AF',
						background_hover_color	: 'none', 
						images		: false,
						mouse		: 'press',
						onChange     			: function(page){
														validatePage(page);
										 		 }
					});
		},
	});
}
//=====分页ajax end==========================================

//=====js写循环页面 begin=====================================
function refreshPage(products) {
	var ul = $("#ul");
	var content="";
	for (var i = 0;i < products.length;i++) {
		if (products[i].status != 'D') {
			var icontent = '<li class="clear">\n'+
						'<div class="fl">\n'+
							'<dl>\n'+
								'<dt>产品名称：<span class="king">'+products[i].productName+'</span></dt>\n'+
								'<dt>所属银行：'+products[i].company.companyName+'</dt>\n'+
								'<dt>产品类别：'+products[i].productType.productTypeName+'</dt>\n'+
								'<dt>放贷利率：'+products[i].primeLendingRateFrom+'%-'+products[i].primeLendingRateTo+'%（年化利率）</d\nt>'+
								'<dt>放贷金额：'+products[i].financingAmountFrom+'-'+products[i].financingAmountTo+'万</dt\n>'+
								'<dt>放贷期限：'+products[i].lendingPeriod.period+'个月</dt>\n'+
							'</dl>\n'+
						'</div>\n'+
						'<div class="view_details">'+
							'<a href="/p2p/product/productIndex.action?productId='+products[i].productId +'">'+
							'查看详细'+
							'</a>'+
						'</div>\n'+
					'</li>\n';
			content += icontent;
		}
	}
	ul.html(content);
}
//=====js写循环页面 end=======================================