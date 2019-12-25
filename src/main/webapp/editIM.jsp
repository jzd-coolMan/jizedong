<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑信息</title>
<link rel="stylesheet" type="text/css" href="/wang/css/reset.css" />
<link rel="stylesheet" type="text/css" href="/wang/css/editIM.css" />
<link rel="stylesheet" href="/wang/css/calendar.css" />
<script src="/wang/js/jquery.js"></script>
<script type="text/javascript" src="/wang/js/calendar.js"></script>
<script src="/wang/js/editIM-add.js"></script>
<script type="text/javascript" src="/wang/js/checkUserUpdateForm.js"
	charset="utf-8"></script>
<style>
html, body {
	height: 100%
}
</style>
</head>
<body>
	<div class="contaner">
		<div class="im-content">
			<div class="im-heade">
				<div class="imhead-title">
					当前页面：<a>修改信息</a>
				</div>
			</div>
			<form action="updateThe.action" id="search_form" name="upd"
				enctype="multipart/form-data" method="post" accept-charset="utf-8">
				<div class="editim-table">
					<ul class="table-con">
						<li class="edittable-top">
							<div class="edittable-left">采样信息</div>
							<div class="edittable-right">
								<ul>
									<li><lable>样品编号</lable> <input name="id" type="hidden"
										value="${s.id }"> <input name="sampleId"
										placeholder="首字母为英文，长度为5-15位" id="" class="ypbh"
										value="${s.sampleId }"> <span id="sample_id"></span></li>
									<li><input name="" id="ncpyl" value="${c.id }"
										type="hidden"> <lable>农产品加工原料类别</lable> <select
										class="sel" onchange="" onblur="checkcrop_category_id()"
										name="cropCategoryId" id="cptype">
											<option value="1">水果类</option>
											<option value="2">谷物类</option>
											<option value="3">油料类</option>
											<option value="4">坚果类</option>
											<option value="5">香辛类</option>
											<option value="6">饲料类</option>
									</select> <span id="crop_category_id"></span></li>
									<li><input name="" id="cptypess1" value="${s.breed }"
										type="hidden"> <lable>品种</lable> <select name="breed"
										class="sel" id="cptypess">
											<option class="cpzl" value="">请选择</option>
									</select> <span id="breed"></span></li>
									<li>
										<div class="width">
											<lable>地点</lable>
											<input value="北京" id="shengs" type="hidden"> <input
												value="北京市" id="shisss" type="hidden"> <input
												value="东城区" id="xiansss" type="hidden"> <input
												value="${s.province }" name="" id="province" type="hidden">
											<input value="${s.city }" name="" id="city" type="hidden">
											<input value="${s.county }" name="" id="county" type="hidden">
											<input value="123" id="wsx" type="hidden"> <select
												class="province" id="shen" name="province">
											</select><span>省</span> <select class="city" name="city" id="shi"></select><span>市</span>
											<select class="county" id="xian" name="county">
											</select><span>县</span>
										</div> <span class="xc"> <input placeholder="可为空" id="xiang"
											name="township" value="" type="text">乡 <input
											placeholder="可为空" id="cun" name="village" value=""
											type="text">村 <input placeholder="可为空" id="hu"
											name="household" value="" type="text"><span>户</span>
									</span> <span id="province"></span>
									</li>
									<li><lable>收获时间</lable> <input name="" value="${har }"
										id="" placeholder="选择日期" readonly="readonly" type="text">
									<li><lable>取样时间</lable> <input name="" value="${ctt }"
										id="" placeholder="选择日期" readonly="readonly" type="text">
									<li><lable>取样人</lable> <input placeholder="请输入取样人姓名"
										name="samplingPeople" id="" value="${s.samplingPeople }"
										onblur="checksampling_people()"> <span
										id="sampling_people"></span></li>
									<li class="jijie"><lable>采集季节及气候特征</lable> <textarea
											placeholder="${s.seasonal }" name="seasonal" id="seasonal1"
											rows="" cols="" onblur="checkseasonal()"></textarea> <span
										id="seasonal"></span></li>
									<li class="huanjing"><lable>采集地、环境信息描述</lable> <textarea
											placeholder="${s.description }" name="description"
											id="description1" rows="" cols="" onblur="checkdescription()"></textarea>
										<span id="description"></span></li>
									<li><lable>真菌污染率</lable> <input name="pollutionRate" id=""
										value="${s.pollutionRate }"> <span id="pollution_rate"></span></li>
								</ul>
							</div>
						</li>
						<div class="addds">
							<c:forEach items="${lis }" var="lis">
								<li class="edittable-middle">
									<div class="editmiddle-left">毒素信息</div>
									<div class="editmiddle-right">
										<ul>
											<li><lable>毒素种类</lable> <select class="dszl"
												name="toxinId">
													<option value="${lis.toxinId }">${lis.sampletoxininfo.toxinType }</option>
											</select> <span class="toxin_id"></span></li>
											<li><lable>毒素含量</lable> <input name="toxinCount"
												class="toxin_id1" maxlength="10" placeholder="毒素含量最大可输入十位"
												type="text" value="${lis.toxinCount }"> <span
												class="toxin_count"></span></li>
											<li><a class="del">删除</a></li>
										</ul>
									</div>
								</li>
							</c:forEach>
						</div>
						<div class="add-dsxx">+添加毒素信息</div>
						<div class="add-con">
							<c:forEach items="${bas }" var="bas">
								<li class="edittable-bottom">
									<div class="editbottom-left">产毒菌株信息</div>
									<div class="editbottom-right">
										<ul>
											<li><lable>样品编号</lable> <input name="sample_num"
												value="${bas.sampleNum }" class="sample" type="text"
												readonly="readonly"></li>
											<li><lable>菌株原始编号</lable> <input name="originalNum"
												value="${bas.originalNum }" class="num" type="text"></li>
											<li class="form-a"><lable>文献信息</lable> <a
												class="xz-btn-a">选择文件</a> <input placeholder="仅支持doc/docx格式"
												name="wordvalues" id="" value="" class="file-name-a"
												readonly="readonly" type="text"> <input
												name="word_addr" class="file-info-a" type="file"></li>
											<li class="form-b"><lable>文本信息</lable> <a
												class="xz-btn-b">选择文件</a> <input placeholder="仅支持txt格式"
												value="" name="txtvalues" id="" class="file-name-b"
												readonly="readonly" type="text"> <input
												name="txt_addr" value="0" class="file-info-b" type="file">
											</li>
											<li class="form-c"><lable>图片信息</lable> <a
												class="xz-btn-c">选择文件</a> <input placeholder="仅支持jpg/png格式"
												value="" name="imgvalues" id="" class="file-name-c"
												readonly="readonly" type="text"> <input
												name="picture_addr" value="0" class="file-info-c"
												type="file"></li>
											<li><a onclick="qwe(6);" class="del">删除</a></li>
										</ul>
									</div>
								</li>
							</c:forEach>
						</div>
						<div class="add-ds">+添加产品毒菌株信息</div>
						<div class="footer">
							<a class="baocun" onclick="xiugai()">修改</a> <a
								onclick="history.go(-1)" class="marginl"
								href="javascript:if(confirm('确实要放弃操作吗?返回之后，所添加数据不会保存！')){location='xxgl'}">返回</a>
						</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript" src="/wang/js/xiugai.js"></script>
<script src="/wang/js/editIMupdate.js"></script>
<script type="text/javascript">
	function xiugai() {
		//  		alert(1);
		document.getElementById("search_form").submit();
	}
</script>
<!--	<script>
	function getPhotoSize(obj){
    photoExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
    console.log(photoExt);
     if(photoExt!='.png' && photoExt!='.jpg'){
        alert("请上传正确的照片格式!");
         obj.value = "";
        console.log(obj.value);
        return false;
    }
    var fileSize = 0;
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
    if (isIE && !obj.files) {
         var filePath = obj.value;
         var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
         var file = fileSystem.GetFile (filePath);
         fileSize = file.Size;
    }else {
         fileSize = obj.files[0].size;
    }
    fileSize=Math.round(fileSize/1024*100)/100; //单位为KB
}
function getPhotoSizes(obj){
    photoExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
     if(photoExt!='.doc' && photoExt!='.docx'){
        alert("请上传正确的文档格式!");
         obj.value = "";
        console.log(obj.value);
        return false;
    }
    var fileSize = 0;
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
    if (isIE && !obj.files) {
         var filePath = obj.value;
         var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
         var file = fileSystem.GetFile (filePath);
         fileSize = file.Size;
    }else {
         fileSize = obj.files[0].size;
    }
    fileSize=Math.round(fileSize/1024*100)/100; //单位为KB
}
function getTextSize(obj){
// 	alert("校验txt");
    photoExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
     if(photoExt!='.txt'){
        alert("请上传正确的文档格式!");
         obj.value = "";
        console.log(obj.value);
        return false;
    }
    var fileSize = 0;
    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
    if (isIE && !obj.files) {
         var filePath = obj.value;
         var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
         var file = fileSystem.GetFile (filePath);
         fileSize = file.Size;
    }else {
         fileSize = obj.files[0].size;
    }
    fileSize=Math.round(fileSize/1024*100)/100; //单位为KB
}
	</script>-->
</html>