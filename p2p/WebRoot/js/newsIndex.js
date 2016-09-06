//=====分页ajax begin========================================
function validatePage(page){
	$.ajax({
		type    :"POST",
		dataType:"json",
		url     :"/p2p/ajax/selectNewsByPage.action",
		data    :"page="+page,
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
function refreshPage(allNews) {
//	alert(JSON.stringify(allNews));
	var ul = $("#ul");
	var content="";
	for (var i = 0;i < allNews.length;i++) {
		var date = new Date(allNews[i].createAt);
		var flag = "";
		if(allNews[i].status == 'C'){
				flag = "(成功举办)";
			} else if(allNews[i].status == 'F') {
				flag = "(已结束)";
			}
		if (allNews[i].status != 'D') {
			var icontent = '<li class="clear">\n'+
								'<div class="fl"><img src="/p2p/images/news/'+allNews[i].image+'" /></div>\n'+
									'<div class="fl">\n'+
										'<div class="salon_title clear">\n'+
											'<div class="fl">\n'+
												'<a href="" title="'+allNews[i].newsTitle+'">'+allNews[i].newsTitle+'</a>\n'+
												'<span class="fe4800">\n'+
													flag+							
												'</span>\n'+
											'</div>\n'+
											'<div class="fr">日期：'+date.format("yyyy/MM/dd")+'</div>\n'+
										'</div>\n'+
									'<div class="salon_in">'+allNews[i].content+'</div>\n'+
								'</div>\n'+
							'</li>\n';
			content += icontent;
		}
	}
	ul.html(content);
}
//=====js写循环页面 end=======================================