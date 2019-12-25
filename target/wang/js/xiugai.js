$("#cptype").change(
		function() {
			var yuanliaolb = $("#cptype").val();
			$("#cptypess").find("option").remove();
			// alert(yuanliaolb)
			$.ajax({
				url : "cxpz",
				data : {
					cropCategoryId : yuanliaolb,
				},
				type : "post",
				dataType : "json",
				success : function(result) {
					// 控制台输出
					// console.log(result.cro.length)
					for (var i = 0; i < result.cro.length; i++) {
						$("#cptypess").append('<option class="cpzl" value=' + result.cro[i].id + '>' + result.cro[i].cropSpecies + '</option>')
					}
				}
			});
		});
$(function() {
	// 回显农作物加工原料
	var ncpid = $("#ncpyl").val();
	// galert(ncpid);
	if (ncpid != "" && ncpid != null) {
		var cptype = document.getElementById('cptype');
		cptype[(ncpid) - 1].selected = true;
	}
	// 回显农作物加工种类
	var yuanliaolb = $("#cptype").val();
	$("#cptypess").find("option").remove();
	// alert(yuanliaolb)
	$.ajax({
		url : "cxpz",
		data : {
			cropCategoryId : yuanliaolb,
		},
		type : "post",
		dataType : "json",
		success : function(result) {
			// 控制台输出
			// console.log(result.cro.length)
			var cptypess1 = $("#cptypess1").val();
			// alert(cptypess1);
			for (var i = 0; i < result.cro.length; i++) {
				if (cptypess1 == (result.cro[i].id)) {
					$("#cptypess").append('<option class="cpzl" value=' + result.cro[i].id + ' selected>' + result.cro[i].cropSpecies + '</option>')
				} else {
					$("#cptypess").append('<option class="cpzl" value=' + result.cro[i].id + '>' + result.cro[i].cropSpecies + '</option>')
				}
			}
		}
	});
});
// 显示省市县
$(function() {
	$.ajax({
		url : "cxs",
		type : "post",
		dataType : "json",
		success : function(result) {
			var province = $("#province").val();
			for (var i = 0; i < result.pro.length; i++) {
				if (province == (result.pro[i].code)) {
					$("#shen").append('<option class="shende" value=' + result.pro[i].code + ' selected>' + result.pro[i].name + '</option>')
				} else {
					$("#shen").append('<option class="shende" value=' + result.pro[i].code + '>' + result.pro[i].name + '</option>')
				}
			}
			if (province != 0) {
				var sheng = $("#shen").val();
				$("#shi").find("option").remove();
				$("#xian").find("option").remove();
				$.ajax({
					url : "cxsys",
					data : {
						provincecode : sheng,
					},
					type : "post",
					dataType : "json",
					success : function(result) {
						var city = $("#city").val();
						if (result.city != "null") {
							$("#shi").append('<option class="shide" value="0">' + "请选择" + '</option>')
							$("#xian").append('<option class="xiande" value="0">' + "请选择" + '</option>')
							for (var i = 0; i < result.city.length; i++) {
								if (city == (result.city[i].code)) {
									$("#shi").append('<option class="shide" value=' + result.city[i].code + ' selected>' + result.city[i].name + '</option>')
								} else {
									$("#shi").append('<option class="shide" value=' + result.city[i].code + '>' + result.city[i].name + '</option>')
								}
							}
						} else {
							$("#shi").append('<option class="shide" value="0">' + "请选择" + '</option>')
						}
						if (city != 0) {
							var shi = $("#shi").val();
							$("#xian").find("option").remove();
							$.ajax({
								url : "cxx",
								data : {
									citycode : shi,
								},
								type : "post",
								dataType : "json",
								success : function(result) {
									var county = $("#county").val();
									if (result.town != "null") {
										$("#xian").append('<option class="xiande" value="0">' + "请选择" + '</option>')
										for (var i = 0; i < result.town.length; i++) {
											if (county == (result.town[i].code)) {
												$("#xian").append('<option class="xiande" value=' + result.town[i].code + ' selected>' + result.town[i].name + '</option>')
											} else {
												$("#xian").append('<option class="xiande" value=' + result.town[i].code + '>' + result.town[i].name + '</option>')
											}
										}
									} else {
										$("#xian").append('<option class="xiande" value="0">' + "请选择" + '</option>')
									}
								}
							});
						}
					}
				});
			}
		}
	});
});
// 省改变
$("#shen").change(
		function() {
			var sheng = $("#shen").val();
			$("#shi").find("option").remove();
			$("#xian").find("option").remove();
			$.ajax({
				url : "cxsys",
				data : {
					provincecode : sheng,
				},
				type : "post",
				dataType : "json",
				success : function(result) {
					if (result.city != "null") {
						$("#shi").append(
								'<option class="shide" value="0">' + "请选择"
										+ '</option>')
						$("#xian").append(
								'<option class="xiande" value="0">' + "请选择"
										+ '</option>')
						for (var i = 0; i < result.city.length; i++) {
							$("#shi")
									.append(
											'<option class="shide" value='
													+ result.city[i].code + '>'
													+ result.city[i].name
													+ '</option>')
						}
					} else {
						$("#shi").append(
								'<option class="shide" value="0">' + "请选择"
										+ '</option>')
					}
				}
			});
		});
// 市改变
$("#shi").change(
		function() {
			var shi = $("#shi").val();
			$("#xian").find("option").remove();
			$.ajax({
				url : "cxx",
				data : {
					citycode : shi,
				},
				type : "post",
				dataType : "json",
				success : function(result) {
					if (result.town != "null") {
						$("#xian").append(
								'<option class="xiande" value="0">' + "请选择"
										+ '</option>')
						for (var i = 0; i < result.town.length; i++) {
							$("#xian")
									.append(
											'<option class="xiande" value='
													+ result.town[i].code + '>'
													+ result.town[i].name
													+ '</option>')
						}
					} else {
						$("#xian").append(
								'<option class="xiande" value="0">' + "请选择"
										+ '</option>')
					}
				}
			});
		});