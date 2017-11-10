/**
 * 
 */
package com.lishuangqi.resolver;

import com.alibaba.fastjson.JSONObject;
import com.lishuangqi.common.RawMessage;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author whsav
 *
 */
public class ProcessTask implements Runnable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7881564340234460359L;
	private RawMessage rm;
	ProcessTask(RawMessage rm){
		this.rm=rm;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		String path=rm.getPath();
		String method=rm.getMethod();
		JSONObject serviceRet=new JSONObject();
		try {			
			//取得接口信息
//			InterfaceInfoVO ifi=ServerInterfaceInfo.getMethodMap(path,method);
//			if(ifi==null){
//				LogUtil.appLog.info("无效的访问路径");
//				return;
//			}else{
//				LogUtil.appLog.info("path:"+path+",method:"+method+",接口:"+ifi.getName());
//			}
//			//取得入库Po类
//			Class<?> clz = null;
//			try {
//			  	clz = Class.forName(ifi.getPoClass());
//			}catch (Exception e){
//				LogUtil.appLog.debug("PoClass not set:",e);
//			}
//			Map<String,Object> mapWithPo=new HashMap<String,Object>();
//			if(StringUtils.isEmpty(ifi.getResolveClass())){
//				//无解析配置，则默认按json处理
//				GeneralResolver generalResolver= (GeneralResolver) WebUtil.getBean("generalResolver");
//				mapWithPo=generalResolver.RawJsonToPO(rm.getData(), clz);
//			}else{
//				//有解析配置，则用解析类解析
//				Object rs= WebUtil.getBean(ifi.getResolveClass());
//				Method rsmeth=rs.getClass().getMethod(ifi.getResolveMethod(), String.class, InterfaceInfoVO.class, Class.class);
//				mapWithPo= (Map<String,Object>)rsmeth.invoke(rs,rm.getData(), ifi, clz);
//			}
//			if(StringUtils.isEmpty(ifi.getServiceClass())){
//				//无解析配置，则调用直接入库
//				GeneralService generalService=(GeneralService) WebUtil.getBean("generalService");
//				generalService.saveList(mapWithPo);
//			}else{
//				//业务调用,将多参数Map<String,Object>传入
//				Object service=WebUtil.getBean(ifi.getServiceClass());
//				Method methReceive=service.getClass().getMethod(ifi.getServiceMethod(), Map.class, InterfaceInfoVO.class);
//
//				serviceRet= (JSONObject)methReceive.invoke(service,mapWithPo, ifi);
//				LogUtil.appLog.info("处理service:"+service.getClass().getName()+",方法:"+methReceive.getName()+",返回:");
//			}
		}catch(Exception e){
			e.printStackTrace();
//			LogUtil.appLog.error("处理错误:",e);
		}
	}

}
