$(function() {
	// 污染率
	var wrl = $("#wrl").val();
	var options = wuranluv.options;
	for (i = 0; i < options.length; i++) {
		if (wrl == options[i].value) {
			options[i].selected = true;
		}
	}
	// 毒素
	$(".mainSpecies")
			.append('<option value=' + "0" + '>' + "请选择" + '</option>')
	$.ajax({
		url : "cxsyds",
		type : "post",
		dataType : "json",
		success : function(result) {
			var toxinType = $("#wrjzl").val();
			for (var i = 0; i < result.dsxx.length; i++) {
				if (toxinType == (result.dsxx[i].id)) {
					$(".mainSpecies").append(
							'<option value=' + result.dsxx[i].id + ' selected>'
									+ result.dsxx[i].toxinType + '</option>')
				} else {
					$(".mainSpecies").append(
							'<option value=' + result.dsxx[i].id + '>'
									+ result.dsxx[i].toxinType + '</option>')
				}
			}
		}
	});
	$(".nzw_spacies")
			.append('<option value=' + "0" + '>' + "请选择" + '</option>')
	// 农作物
	$.ajax({
		url : "cxsynzw",
		type : "post",
		dataType : "json",
		success : function(result) {
			var nzw = $("#nzwzl").val();
			for (var i = 0; i < result.nzw.length; i++) {
				if (nzw == (result.nzw[i].id)) {
					$(".nzw_spacies")
							.append(
									'<option value=' + result.nzw[i].id
											+ ' selected>'
											+ result.nzw[i].cropSpecies
											+ '  </option>')
				} else {
					$(".nzw_spacies").append(
							'<option value=' + result.nzw[i].id + '>'
									+ result.nzw[i].cropSpecies + '</option>')
				}
			}
		}
	});
})
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
					$("#shen").append(
							'<option class="shende" value='
									+ result.pro[i].code + ' selected>'
									+ result.pro[i].name + '</option>')
				} else {
					$("#shen").append(
							'<option class="shende" value='
									+ result.pro[i].code + '>'
									+ result.pro[i].name + '</option>')
				}
			}
			if(province != 0){
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
							$("#shi").append(
									'<option class="shide" value="0">' + "请选择"
											+ '</option>')
							$("#xian").append(
									'<option class="xiande" value="0">' + "请选择"
											+ '</option>')
							for (var i = 0; i < result.city.length; i++) {
								if(city == (result.city[i].code)){
									$("#shi")
									.append(
											'<option class="shide" value=' + result.city[i].code + ' selected>' + result.city[i].name
													+ '</option>')
								}else{
									$("#shi")
									.append(
											'<option class="shide" value='
													+ result.city[i].code + '>'
													+ result.city[i].name
													+ '</option>')
								}
							}
						}else{
							$("#shi").append(
									'<option class="shide" value="0">' + "请选择"
											+ '</option>')
						}
						if(city != 0){
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
										$("#xian").append(
												'<option class="xiande" value="0">' + "请选择"
														+ '</option>')
										for (var i = 0; i < result.town.length; i++) {
											if(county == (result.town[i].code)){
												$("#xian")
												.append(
														'<option class="xiande" value='
																+ result.town[i].code + ' selected>'
																+ result.town[i].name
																+ '</option>')
											}else{
												$("#xian")
												.append(
														'<option class="xiande" value='
																+ result.town[i].code + '>'
																+ result.town[i].name
																+ '</option>')
											}
										}
									}else{
										$("#xian").append(
												'<option class="xiande" value="0">' + "请选择"
														+ '</option>')
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
					}else{
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
					}else{
						$("#xian").append(
								'<option class="xiande" value="0">' + "请选择"
										+ '</option>')
					}
				}
			});
		});