package com.baiwang.einvoice.qz.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baiwang.einvoice.qz.beans.Business;
import com.baiwang.einvoice.qz.mq.EInvoceKjfpfhListener;
import com.baiwang.einvoice.qz.mq.EInvoiceSenders;
import com.baiwang.einvoice.qz.service.FpService;
import com.baiwang.einvoice.qz.utils.JAXBUtil;
import com.baiwang.einvoice.qz.utils.ValidateXML;

@RequestMapping("einvoice")
@Controller
public class FpController {
	
	private static final Log logger = LogFactory.getLog(FpController.class);
	@Resource
	private EInvoiceSenders sender;
	@Resource
	private FpService fpService;
	@RequestMapping("kjfp")
	@ResponseBody
	@POST
	public String kjfp(String xml){
		
		
		return "开具发票";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String SaveKpInfo(String xml, HttpServletRequest request) throws UnsupportedEncodingException, JMSException{
		
		if( !ValidateXML.validateXml("wyyy.xsd", xml.getBytes("utf-8")) ){
			return null;
		}
		
		Business business = JAXBUtil.unmarshallObject(xml.getBytes("utf-8"));
		
		UUID uuid = UUID.randomUUID();
		String correlationId = uuid.toString();
		sender.sendMessage(xml, correlationId);

		fpService.saveXmlInfo(business);
		
		Map<String, String> map = EInvoceKjfpfhListener.getMap();
		
		String requestURL = request.getRequestURL().toString();
		String url = requestURL.substring(0,requestURL.lastIndexOf("/")) + "/query?corre=" + correlationId;
		
		
		if(null != map.get(correlationId)){
			return map.get(correlationId);
		}else{
			return "正在处理中,请查询" + url;
		}
	}
	
	@RequestMapping(value="query",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String query(@RequestParam String corre) {
		if(null == corre || "".equals(corre)){
			return "查询失败";
		}
		Map<String, String> map = EInvoceKjfpfhListener.getMap();
		if(null != map.get(corre)){
			return map.get(corre);
		}else{
			return "正在处理中,请稍等...";
		}
		
	}
	
	
	
}