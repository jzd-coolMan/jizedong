var allshen = "";
var allshi = "";
var allxian = "";

function getSheng(sheng) {
	$.ajax({
		url : "rest/findAllShen",
		dataType : "JSON",
		success : function(lists) {
			var shengs = document.getElementById("shengs").value;
			for ( var shen in lists) {
				if(lists[shen].name == shengs ){
					allshen += "<option value=" + lists[shen].code + ">"
					+ lists[shen].name + "</option>";
				}else{
					allshen += "<option value=" + lists[shen].code + ">"
					+ lists[shen].name + "</option>";
				}
			
			
			}
			$("#" + sheng).append(allshen);
		}
	});
}
function changeShen(shenCode, sheng, shi, xian) {
	shi = '#' + shi;
	xian = '#' + xian;
	$.ajax({
		url : "rest/findShiByShen",
		data : "shenCode=" + shenCode,
		dataType : "JSON",
		success : function(lists) {
			console.log(lists);
			$(shi).empty(); // 清空市option
			$(xian).empty(); // 清空县option
			allshi = "<option>请选择</option>"; // 清空市变量
			allxian = "<option>请选择</option>"; // 清空县变量
			for ( var i in lists) {
				allshi += "<option value=" + lists[i].code + ">" // 给市变量赋值
						+ lists[i].name + "</option>";
			}
			$(shi).append(allshi); // 添加市option
			$(xian).append(allxian); // 添加县option
		}
	});
}
function changeShi(shiCode, sheng, shi, xian) {
	xian = '#' + xian;
	$.ajax({
		url : "rest/findXianByShi",
		data : "shiCode=" + shiCode,
		dataType : "JSON",
		success : function(lists) {
			$(xian).empty();
			allxian = "<option>请选择</option>";
			for ( var i in lists) {
				allxian += "<option value=" + lists[i].code + ">"
						+ lists[i].name + "</option>";
			}
			$(xian).append(allxian);
		}
	});
}
//------------------------------------------

//------------------------------------------
function getKind(){
	$.ajax({
		url:"/rest/getKind",
		dataType:"JSON",
		success:function(obj){
			$("#nzw_spacies").empty();
			var spacies='<option selected value="请选择">请选择</option>';
			for(var i in obj){
				spacies+='<option value='+obj[0].id+'>&nbsp;&nbsp;'+obj[i].crop_species+'</option>';
			}
			$("#nzw_spacies").append(spacies);
		}
	});
	
}