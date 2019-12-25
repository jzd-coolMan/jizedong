/*全选*/
$(function() {
	//全选
	$("#checkbox1").click(function() {
		var iffalse = $(this).get(0).checked;
		$('tbody input[type = "checkbox"]').each(function() {
			$(this).prop("checked", iffalse);
		});
	});
	$('tbody input[type = "checkbox"]').click(function() {
		var ele = $('tbody input[type = "checkbox"]');
		for(var i = 0; i < ele.length; i++) {
			if(ele.eq(i).is(':checked')) {
				$("#checkbox1").prop("checked", true);
			}
			if(ele.eq(i).is(':checked') === false) {
				$("#checkbox1").prop("checked", false);
				break;
			}
		}
	});
	//删除提示
	$(".del").click(function(){
		if(confirm("确认删除？")){
				alert('删除成功')
			}else{
				alert("取消删除")
			}
	});
	//信息导入
	$(".xz-btn-b-1").click(function(){
		$(".file-info-b-1").trigger('click');
	});
	$(".file-info-b-1").change(function() {
		$(".vall-1").val($(".file-info-b-1").val());
	});
	
	$(".junzhu-b").click(function(){
		$(".junzhu-a").trigger('click');
	});
	$(".junzhu-a").change(function() {
		$(".vall-c").val($(".junzhu-a").val());
	});
	$(".sc").click(function(){
		$(".vall").html("");
		$(".file-info-b").val("")
		$(".vall").css("display","none");
		$(".sc").css("display","none");
	})
});

