<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<base>
<title>信息管理</title>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>信息管理</title>
<link rel="stylesheet" type="text/css" href="/wang/css/reset.css" />
<script src="/wang/js/jquery.js"></script>
<script src="/wang/js/IM-index.js"></script>
<link rel="stylesheet" type="text/css" href="/wang/css/IM-index.css" />
<script src="/wang/js/super.js"></script>
<style>
html, body {
	height: 100%;
}
</style>
</head>
<body>
	<a name="top"></a>
	<div class="contaner">
		<div class="im-content">
			<div class="im-heade">
				<div class="imhead-title">
					当前页面：<a>信息管理</a>
				</div>
				<div class="imhead-select">
					<form name="sub" action="mhcx.action" method="post">
						<ul>
							<li class="bh"><lable>样品编号</lable> <input maxlength="15"
								onkeyup="this.value=this.value.replace(/\s+/g,'')"
								id="sample_id" value="${sampleId }" type="text" name="sampleId"></li>
							<li class="wrl mright"><lable>污染率</lable> <select
								id="wuranluv" name="pollutionRate">
									<option value="">请选择</option>
									<option value="0-20">0~20%</option>
									<option value="20-40">20%~40%</option>
									<option value="40-60">40%~60%</option>
									<option value="60-80">60%~80%</option>
									<option value="80-100">80%~100%</option>
							</select><input type="hidden" value="${pollutionRate }" id="wrl"></li>
							<li class="time"><lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间</lable>
								<input id="qaz" value="23" type="hidden"> <select
								name="year" id="year" class="year">
							</select><span> &nbsp;年</span> <select name="month" id="month1"
								class="month">
							</select> <span> &nbsp;月 </span> <select name="day" id="day1" class="day">
							</select> <span>&nbsp; 日</span></li>
							<li class="w mright yu"><lable>主要污染菌种类</lable> <select
								name="toxinType" class="mainSpecies" id="toxin_type">
							</select> <input type="hidden" value="${toxinType }" id="wrjzl"></li>
							<li class="w mright yu"><lable>农作物种类</lable> <select
								name="cropSpecies" class="nzw_spacies" id="crop_species">
							</select> <input type="hidden" value="${cropSpecies }" id="nzwzl">
							</li>
							<li class="place w"><lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地点</lable>
								<input type="hidden" value="" id="shengs"> <input
								type="hidden" value="" id="shisss"> <input type="hidden"
								value="" id="xiansss"> <input type="hidden" value="123"
								id="wsx"> <select name="province" class="province"
								id="shen">
									<option value="0">请选择</option>
							</select> <input type="hidden" value="${province }" id="province">
								<span> &nbsp;省</span> <select name="city" class="city" id="shi">
									<option value="0">请选择</option>
							</select> <input type="hidden" value="${city }" id="city"> <span>
									&nbsp;市</span> <select name="county" class="county" id="xian">
									<option value="0">请选择</option>
							</select> <input type="hidden" value="${county }" id="county"> <span>
									&nbsp;县</span></li>
						</ul>
						<div class="soso">
							<a href="javascript:if(confirm('确实要搜索吗?'))find()">搜索</a>
						</div>
					</form>
				</div>
				<div class="oper">
					<ul>
						<li class="btn-top"><a href="editIM-add.html" class="dt">新增单条</a>
							<form class="form-b" action="rest/excel/updateExcel"
								method="post" enctype="multipart/form-data" id="excelForm">
								<input type="file" name="file"
									class="file-info-b  file-info-b-1" accept=".xlsx"> <a
									class="xz-btn-b xz-btn-b-1">选择文件</a> <input type="text" name=""
									id="" value="" class="vall vall-1" readonly> <input
									class="submit-b" type="button" value="导入样品信息">
							</form> <a class="mb">下载模板</a> <br> <a class="pl">批量删除</a> <!-- 产毒菌株信息的导入 -->
							<form class="form-b" action="rest/excel/updateBacterialExcel"
								method="post" enctype="multipart/form-data" id="excelForm1">
								<input type="file" name="file" class="file-info-b junzhu-a"
									accept=".xlsx"> <a class="xz-btn-b junzhu-b">选择文件</a> <input
									type="text" name="" id="flag" value="" class="vall vall-c"
									readonly> <input class="submit-b submit-c"
									type="button" value="导入菌株信息">
							</form> <a href="javascript:void(0)" class="dc">信息导出</a></li>
					</ul>
				</div>
			</div>
			<div class="im-table">
				<table>
					<thead>
						<tr>
							<th class="w1"><input type="checkbox" id="checkbox1"
								value=""> 全选</th>
							<th class="w2">样品编号</th>
							<th class="w3">地点</th>
							<th class="w4">农产品加工类型</th>
							<th class="w5">取样时间</th>
							<th class="w6">录入时间</th>
							<th class="w7">真菌污染率</th>
							<th class="w8">主要毒素</th>
							<th class="w9">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${r }" var="r">
							<tr>
								<td><input class="testyangpin" value="${r.id }"
									type="checkbox"></td>
								<td class="ybbh">${r.sampleId }</td>
								<td>${r.county }</td>
								<td>${r.cropspecies.cropSpecies }</td>
								<td><fmt:formatDate value="${r.harvestTime }"
										pattern="yyyy-MM-dd" /></td>
								<td><fmt:formatDate value="${r.samplingTime }"
										pattern="yyyy-MM-dd" /></td>
								<td>${r.pollutionRate }%</td>
								<td>${r.dsm }</td>
								<td><a href="updatexx?id=${r.id }">编辑</a> |<a
									href=" javascript:if(confirm('确实要删除吗?'))location='scxx?id=${r.id }'">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="page"></div>
		</div>
	</div>
	<!-- <link rel="stylesheet" type="text/css" href="../css/style.css"> -->
	<link type="text/css" rel="stylesheet" href="/wang/css/paging.css">
	<style type="text/css">
.color a {
	padding: 5px;
	color: #4c4743;
	/* font-size: 20px; */
}

.color a:hover {
	color: #ed6c44;
}
/* .color2 {
	float: right;
	color: #4c4743;
	font-size: 20px;
	border: 1px black hidden;
} */
.color {
	/* 	float: right; */
	border: 1px black hidden;
	width: 100%;
	text-align: center;
}

#checkOne {
	color: #000;
	font-size: 20px;
}

#checkOnediv {
	color: #ed6c44;
}
/* #h1 {
	color: #4c4743;
} */
</style>
	<div class="im-page">
		<ul>
			<li class="im-indexpage"><a data-id="" href="xxgl?pageNum=1">首页</a></li>
			<c:if test="${pageInfo.getPageNum() >1 }">
				<li class="im-nextpage"><a data-id=""
					href="xxgl?pageNum=${pageNum-1 }">上一页</a></li>
			</c:if>
			<li class="im-pagenum"><a data-id="1" href="xxgl?pageNum=1">1</a></li>
			<li class="im-pagenum"><a data-id="2" href="xxgl?pageNum=2">2</a></li>
			<li class="im-pagenum"><a data-id="3" href="xxgl?pageNum=3">3</a></li>
			<li class="im-pagenum"><a data-id="4" href="xxgl?pageNum=4">4</a></li>
			<li class="im-pagenum"><a data-id="5" href="xxgl?pageNum=5">5</a></li>
			<c:if test="${pageInfo.getPageNum()<pageInfo.getPages()}">
				<li class="im-nextpage"><a data-id=""
					href="xxgl?pageNum=${pageNum+1 }">下一页</a></li>
			</c:if>
			<li class="im-indexpage"><a data-id=""
				href="xxgl?pageNum=${pageInfo.getPages() }">尾页</a></li>
		</ul>
	</div>
	<script type="text/javascript"
		src="/wang/js/jquery1.11.3-jquery.min.js"></script>
	<script type="text/javascript" src="/wang/js/browsing.js"></script>
	<!-- 	<script type="text/javascript" src="/wang/js/linkage4.js"></script> -->
	<script type="text/javascript" src="/wang/js/IM.js"></script>
	<script type="text/javascript">
		function find() {
// 			var sampleId = $("#sample_id").val();
			document.sub.submit();
		}
	</script>
	<script type="text/javascript">
// 			function doExport(){
// 				var ex = "";
// 				$.each($('input:checkbox:checked'),function(){
// 					if($(this).val()!=''){
// 	                	ex = ex+($(this).val()+",");
// 	                }
// 	            });
// 	            if(ex!=''){
// 	          		window.location="rest/excel/message_export?ex="+ex;
// 	          	}else{
// 	          		alert("请先勾选数据!");
// 	          	}
// 			}
// 			function nameCheck(){
// 				var img1 = $("input:file").val();
// 				if(img1==''){
// 					alert("请选择文件！");
// 					return false;
// 				}
// 				var img = $("input:file").val().split("\\");
// 				var imgName = img[img.length-1];
// 				var imgshuzu = imgName.split(".");
// 				var imgleixing = imgshuzu[imgshuzu.length-1];
// 				if(imgleixing=="xlsx"){
// 					$("#excelForm").submit();
// 				}else{
// 					alert("上传文件格式不正确，请上传2007版本的excel文档");
// 					return false;
// 				}
// 			}
// 			function nameCheck1(){
// 				var img1 = $("#flag").val();
// 				if(img1==''){
// 					alert("请选择文件！");
// 					return false;
// 				}
// 				var img = $("#flag").val().split("\\");
// 				var imgName = img[img.length-1];
// 				var imgshuzu = imgName.split(".");
// 				var imgleixing = imgshuzu[imgshuzu.length-1];
// 				if(imgleixing=="xlsx"){
// 					$("#excelForm1").submit();
// 				}else{
// 					alert("上传文件格式不正确，请上传2007版本的excel文档");
// 					return false;
// 				}
// 			}
// 		function testyangpin(){
// 		var msg = "您真的确定要删除吗？";
// 			if (confirm(msg)==true){
// 				var urlss = "";
// 				var ss = $(".testyangpin");
// 				for(var i=0 ; i<ss.length;i++){
// 					if(ss[i].checked){
// 					  urlss =urlss+ss[i].value+",";
// 					}
// 				}
// 				if(urlss == ""){
// 						alert("请选择要删除的信息");
// 						return false;
// 				}else{
<%--  					location.href = "<%=path%>/rest/deletelists?urlss="+urlss+"";  --%>
// 					return true;
// 				}
// 			}else{
// 		    	return false;
// 			}
// 		}
// 		function searchAll(){
// 			var sample_id = $("#sample_id").val();
// 			var pollution_rate=$("#wuranluv").val();
// 			var toxin_type = $("#toxin_type").val();
// 			var crop_species = $("#crop_species").val()
// 			;
// 			var year = $("#year").val();
// 			var month = $("#month").val();
// 			if(month<10){
// 				month = "0"+month;
// 			}else if(month=="请选择"){
// 				month="";
// 			}
// 			var day = $("#day").val();
// 			if(day<10){
// 				day = "0"+day;
// 			}else if(day=="请选择"){
// 				day="";
// 			}
// 			var sampling_time = year.replace(/\s/g,"")+"-"+month.replace(/\s/g,"")+"-"+day.replace(/\s/g,"");
// 			var province = $("#shen option:selected").text();
// 			if(province=="请选择"){
// 				province="";
// 			}
// 			var city = $("#shi option:selected").text();
// 			if(city=="请选择"){
// 				city="";
// 			}
// 			var county = $("#xian option:selected").text();
// 			if(county=="请选择"){
// 				county="";
// 			}
// 			console.log(sample_id,pollution_rate,toxin_type,crop_species,sampling_time,province,city,county)
<%-- 			location.href = "<%=path%>/rest/tolistim?param1="+sample_id+"&param2="+pollution_rate+"&param3="+toxin_type+"&param4="+crop_species+"&param5="+sampling_time+"&param6="+province+"&param7="+city+"&param8="+county; --%>
// 		}
		</script>
</body>
</html>