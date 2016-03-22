/**
 * 是否含税价标志（通用类型）
 */
function formatKplx(value,row,index){
	if (value=="004"){
		return "增值税纸质专用发票";
	}else if (value=="007"){
		return "增值税纸质普通发票";
	}
}
/**
 * 格式化发票地区
 */
function formatfpdq(value,row,index){
	if (value=="00"){
		return "北京";
	}else if (value=="01"){
		return "上海";
	}
}
/*
 * 格式化发票客户类型
 */
function formatfpkhlx(value,row,index){
	if (value=="00"){
		return "B2B";
	}else if (value=="01"){
		return "B2C";
	}
}
/*
 * 格式化申请入口
 */
function formatsqrk(value,row,index){
	if (value=="00"){
		return "前台";
	}else if (value=="01"){
		return "后台";
	}
}

function formatArray(value,row,index){
	var arr = value.split(",");
	var result ="";
	if(arr.length>1){
		for(var i= 0;i<arr.length;i++){
			result += arr[i]+"</br>"
		}
		return result;
	}else{
		return value;
	}
}

function formatArrayTime(value,row,index){
	var arr = value.split(",");
	var result ="";
	if(arr.length>1){
		for(var i= 0;i<arr.length;i++){
			result = result + formatKprq(arr[i]) + "</br>";
		}
		return result;
	}else{
		return formatKprq(value);
	}
}



function formatKprq(value,row,index){
	return value.substr(0,10);
}


