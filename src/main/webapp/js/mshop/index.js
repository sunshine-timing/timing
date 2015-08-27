//var progressData = 0;
/*
 * 加载模块，并绑定切换样式和事件
 */
function moduleChange(obj, moduleId) {
	// $('[role=progressbar]').css('width', progressData + '%');
	$("#index_Dycontent").load(
			"leftMenu.action",
			{
				moduleId : moduleId
			},
			function(response, status, xhr) {
				// 进度40，并清除调度任务
				// progressData = 60;
				// $('[role=progressbar]').css('width', progressData + '%');

				// 加载完成后，绑定样式和事件
				$(".nav_class1>li").bind(
						'click',
						function() {
							$(this).addClass('active_nav1').siblings()
									.removeClass('active_nav1');

							// 加载第一个子菜单
							$("div[name=index_menu_url]").load(
									$(this).attr("id"),
									function(response, status, xhrb) {
										// 进度30，并清除调度任务
										// progressData = 100;
										// $('[role=progressbar]').css('width',
										// progressData + '%');

									});

						});

				// 顶部导航栏 样式切换
				$(obj).addClass("active").siblings().removeClass("active");

			});

}

/**
 * 返回主页
 */
function home_index() {
	$("#index_Dycontent").load("user_index.jsp");
}
function chageMenuUrl(url) {
	if(url==""||url==null)
	{
		return false;
	}
	else
	{
		$("iframe[name=contentframe]").attr("src",url);
	}
}