<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String basePath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专用发票作废</title>
<script type="text/javascript" src="<%=basePath %>/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui.css"/>
<script type="text/javascript" src="<%=basePath %>/js/jquery/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/easyui_global.css"/>
<OBJECT ID=sk CLASSID="clsid:003BD8F2-A6C3-48EF-9B72-ECFD8FC4D49F"
	codebase="NISEC_SKSCX.ocx#version=1,0,0,1"> </OBJECT>
<script type="text/javascript">
function concelFp(){
	var row = datagrid.datagrid('getSelected');
	if(row ==null || row == ''){
		alert('请选择一条记录进行操作!');
		return;
	}
	$.ajax({
		type:"GET",
        url: "<%=basePath %>/einvoice/ptfpzf",
        data: {'lsh':row.fpqqlsh},
        async: false,
        success: function (data) {
        	var kpxx = data.kpxx;
        	var skconfig = data.skconfig;
        	var setResult = SetParameter(skconfig.aqm,skconfig.keypwd,skconfig.url,skconfig.port);
        	if(setResult){
	        	var sInvoiceVoidInfo = 
	        		"<?xml version=\"1.0\" encoding=\"gbk\"?>\r\n<business id=\"10009\" comment=\"发票作废\">\r\n<body yylxdm=\"1\">\r\n<kpzdbs>0601</kpzdbs>\r\n<fplxdm>"+kpxx.fplx+"</fplxdm>\r\n<zflx>1</zflx>\r\n<fpdm>"+kpxx.fpdm+"</fpdm>\r\n<fphm>"+kpxx.fphm+"</fphm>\r\n<hjje>"+kpxx.hjje+"</hjje>\r\n<zfr>"+kpxx.kpr+"</zfr>\r\n</body>\r\n</business>";		
	        	try {
	        		invoiceVoidRet = sk.Operate(sInvoiceVoidInfo);
	        		/* var pos=ret.indexOf("<returncode>"); */
	        		var invoiceVoidRetReturncode = getTotalMidValue(invoiceVoidRet, "<returncode>","</returncode>");
	        		var invoiceVoidRetReturnmsg = getTotalMidValue(invoiceVoidRet, "<returnmsg>","</returnmsg>");	
	        		if(invoiceVoidRetReturncode==0&&invoiceVoidRetReturnmsg=="成功"){
	        			$.post('<%=basePath %>/einvoice/updateFpzt2zf',{'lsh':lsh},function(text,status){
	        				if(text == 0){
	        					alert('操作成功！');
	        					$("#searchForm").submit();
	        				}else{
	        					alert('发票作废操作成功，但更新发票状态时发生异常！');
	        				}
	        				
	        			})
	        		}else{
	        			alert("发票领购信息核对失败，失败原因："+invoiceVoidRetReturnmsg);
	        		}
	        	} catch (e) {
	        		alert(e.message + ",errno:" + e.number);
	        	}
        	}
        	
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {
        	if(XMLHttpRequest.responseText=="timeOut"){
        		location.reload();
        	}else{
        		alert("Error");
        	}
        }
	});
}

function SetParameter(aqm,keypwd,ip,port) {
	
	//01设置初始化参数
	var sInputInfo = "<?xml version=\"1.0\" encoding=\"gbk\"?>\r\n<business id=\"20001\" comment=\"参数设置\">\r\n<body yylxdm=\"1\">\r\n<servletip>"+ip+"</servletip>\r\n<servletport>"+port+"</servletport>\r\n<keypwd>"+keypwd+"</keypwd>\r\n<aqm>"+aqm+"</aqm>\r\n</body>\r\n</business>";
	try {
		ret = sk.Operate(sInputInfo);
		/* var pos=ret.indexOf("<returncode>"); */
		var returncode = getTotalMidValue(ret, "<returncode>","</returncode>");
		var returnmsg = getTotalMidValue(ret, "<returnmsg>","</returnmsg>");	
		if(returncode==0&&returnmsg=="成功"){
			return true	;
		}else{
			alert("参数设置失败，失败原因："+returnmsg);
			return false ;
		}
	} catch (e) {
		alert(e.message + ",errno:" + e.number);
		return false;
	}
}

//获取指定的字符串
function getTotalMidValue(source, priStr, suxStr) {
	if (source == null)
		return null;
	var iFirst = source.indexOf(priStr);		
	var iLast = source.lastIndexOf(suxStr);		
	if (iFirst < 0 || iLast < 0)
		return null;	
	var beginIndex = iFirst + priStr.length;	
	return source.substring(beginIndex, iLast);
}
</script>


</head>
<body>
<div id="toolbar_div" class="toolbar_div" >
   <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-filesave" onclick="concelFp();" plain="true">作废</a>
   <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="hideOrShow();" plain="true">查询条件</a>
   
   <div id="div_search" class="div_search">
		<form id='searchForm' action="">
			<div class="" style="line-height: 30px;">
				<label>开票起止日期:</label>
				<input type="text" class="form-control" id="beginDate" name="beginDate" placeholder="开始时间" value=""
	         	onfocus="var endDate=$dp.$('endDate');WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,onpicked:function(){endDate.focus();},maxDate:'#F{$dp.$D(\'endDate\')}'})">
	         	<label>-</label>
	         	<input type="text" class="form-control" id="endDate" name="endDate" placeholder="结束时间" value=""
	         	onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true,minDate:'#F{$dp.$D(\'beginDate\')}'})">
				<label>会员ID：</label>
				<input type="text" id="hyid4q" name="hyid4q" placeholder="会员ID">
				<label>发票号码：</label>
				<input type="text" id="fphm4q" name="fphm4q" placeholder="发票号码">
				<label>订单号：</label>
				<input type="text" id="ddh4q" name="ddh4q" placeholder="订单号">
				<label>手机号：</label>
				<input type="text" id="sjh4q" name="sjh4q" placeholder="手机号">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchfpList();" plain="true">查找</a>
			</div>
		</form>
   </div>
</div>
<table id="datagrid"></table>
</body>
<script type="text/javascript">
initDataGridComponent();
var datagrid;
function initDataGridComponent(){
	var qParams = form2Json('searchForm');
	datagrid = $("#datagrid").datagrid({
				title : "专用发票作废",
				singleSelect:true,
				rownumbers:true,
				idField:'fpqqlsh',
				url:"<%=basePath%>/einvoice/zyfpzf_q",
				pagination : true,
				pageSize : 50,
				pageNumber:1,
				pageList: [10,20,50,100],
				queryParams: qParams,
				columns:[[
					 {field:'fpqqlsh',title:'fpqqlsh',width:150,editor:'text',hidden:true},
				     {field:'zddh',title:'订单号',width:150,editor:'text'},
				     {field:'zddh',title:'订单号',width:150,editor:'text'},
		             {field:'hym',title:'会员名',width:100,editor:'text'},
		             {field:'hyid',title:'会员ID',width:100,editor:'text'},
			         {field:'shr',title:'收货人',width:100,editor:'text'}, 
		             {field:'shrdh',title:'收货人电话',width:100,editor:'text'},
		             {field:'sqsj',title:'申请时间',width:100,editor:'text',formatter:dateFormatter},
			         {field:'gmfmc',title:'发票抬头',width:100,editor:'text'},
		             {field:'spzl',title:'发票内容',width:100,editor:'text'},
			         {field:'hjje',title:'合计金额',width:100,editor:'text'},
		             {field:'hjse',title:'合计税额',width:100,editor:'text'},
			         {field:'jshj',title:'价税合计',width:100,editor:'text'},
			         {field:'kplx',title:'发票状态',width:100,editor:'text'},
		             {field:'kprq',title:'开票日期',width:100,editor:'text',formatter:dateFormatter},
		             {field:'fpdm',title:'发票代码',width:100,editor:'text'},
		             {field:'fphm',title:'发票号码',width:100,editor:'text'}
				]],
				onClickRow:function(index){	
					
				}
	});
	
}



/**
 * 开票类型
 */
function formatKplx(value,row,index){
	if (value=="1"){
		return "红字发票";
	} else {
		return "蓝字发票";
	}
}

/**
 * 显示或隐藏
 */
function hideOrShow(){
	$("#div_search").toggle();
}
function dateFormatter(value) {
	if(value==null || value =='undefined'){
		return '';
	}
	var dateValue = new Date(value);
	return dateValue.format("yyyy-mm-dd");
}
/**
 * 打印
 */
function print(){
	var row = datagrid_zp.datagrid('getSelected');
	
	if(row ==null || row == ''){
		alert('请选择一项进行打印!');
		return;
	}
	alert(row.zddh)
	
	if(confirm("确定要打印么？")){
	 	getParameter();
		if(!SetParameter()){
			return;
		}
		PrintInvoice(fpqqlsh,fpdm, fphm);
	}
}
/**
 * 查询
 */
function searchfpList(){
	var qParams = form2Json('searchForm');
	$("#datagrid").datagrid("load", qParams);
}

//将表单数据转为json
function form2Json(id) {

    var arr = $("#" + id).serializeArray()
    var jsonStr = "";

    jsonStr += '{';
    for (var i = 0; i < arr.length; i++) {
        jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
    }
    jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
    jsonStr += '}'

    var json = JSON.parse(jsonStr)
    return json
}
Date.prototype.format = function (fmt) { //author: meizz
    var o = {
        "m+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "M+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
</script>
</html>