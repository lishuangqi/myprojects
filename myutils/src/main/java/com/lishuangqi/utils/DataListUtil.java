/**
 * 
 */
package com.lishuangqi.utils;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author lishuangqi
 *
 */
public class DataListUtil {
	
	public static final int SORTTYPE_INT=1;
	public static final int SORTTYPE_LONG=2;
	/**
	 * mapList关联查询list，将对应fieldid映射为fieldname
	 * @param src 源map
	 * @param listT 关联List,需要过滤则传入validList
	 * @param listIndex 关联List的index列,null则取数据库id
	 * @param clz 关联类
	 * @param idField 关联id字段 
	 * @param nameField 关联名称显示字段
	 * @param shouldRemove 是否移除id字段
	 * @param filterInvalid 是否过滤无匹配的行 
	 * @throws Exception
	 */
	public static <T> void joinReplaceId(List<Map<String,Object>> src,List<T> listT,String listIndex
			,String idField,String[] nameFields,boolean shouldRemove,boolean filterInvalid) throws Exception{
		if(listT.size()==0||src.size()==0){
			return;
		}
		Method[] getNames=new Method[nameFields.length];
		List<Map<String,Object>> removeList=new ArrayList<Map<String,Object>>();
		//空取得list的id,用于建立映射
		if(listIndex==null){
			//
		}
		Map<Integer,T> mapIndex=DataListUtil.getTMapFromList(listT, listIndex);
		for(int i=0;i<nameFields.length;i++){
			getNames[i]=listT.get(0).getClass().getMethod("get"+StringUtils.capitalize(nameFields[i]));
		}
		for(int i=0;i<src.size();i++){
			//取得map中id的值
			Map<String,Object> map = src.get(i);
			//缺字段跳过
			if(!map.containsKey(idField)||map.get(idField)==null){
				continue;
			}
			int replaceId=(int)map.get(idField);
			//是否移除id列
			if(shouldRemove){
				map.remove(idField);
			}
			//缺少index跳过
			if(!mapIndex.containsKey(replaceId)){
				//需要过滤非法字段则加入移除列表
				if(filterInvalid){
					removeList.add(map);
				}else{
					//不过滤则填入空串
					for(int j=0;j<nameFields.length;j++){
						map.put(nameFields[j], "");
					}
					
				}
				continue;
			}
			//取得在关联list中的值
			T obj=mapIndex.get(replaceId);
			//添加name列及值
			for(int j=0;j<nameFields.length;j++){
				map.put(nameFields[j], getNames[j].invoke(obj));
			}
			src.set(i, map);
		}
		//移除
		if(filterInvalid&&!removeList.isEmpty()){
			src.removeAll(removeList);
		}
	}
	
	/**
	 * 从list得到索引map
	 * @param listT
	 * @param fieldId 小写 userComId
	 * @param cla
	 * @return
	 * @throws Exception
	 */
	public static <T> Map<Integer,Integer> getMapFromList(List<T> listT,String fieldId,Class<T> cla) throws Exception{
		Map<Integer,Integer> mapIndex= new HashMap<Integer,Integer>();
		if(listT.isEmpty()){
			return mapIndex;
		}
		Method getId=listT.get(0).getClass().getMethod("get"+StringUtils.capitalize(fieldId));
		for(int i=0;i<listT.size();i++){
			mapIndex.put((int)getId.invoke(listT.get(i)), i);
		}
		return mapIndex;
	}
	
	public static <T> Map<Integer,T> getTMapFromList(List<T> listT,String fieldId) throws Exception{
		Map<Integer,T> mapT= new HashMap<Integer,T>();
		if(listT.isEmpty()){
			return mapT;
		}
		Method getId=listT.get(0).getClass().getMethod("get"+StringUtils.capitalize(fieldId));
		for(int i=0;i<listT.size();i++){
			mapT.put((int)getId.invoke(listT.get(i)), listT.get(i));
		}
		return mapT;
	}
	/**
	 * 根据list返回map
	 * @param listT
	 * @param fieldKey 需要作为key的字段
	 * @return
	 * @throws Exception
	 */
	public static <T> Map<String,T> getKeyTMapFromList(List<T> listT,String fieldKey) throws Exception{
		Map<String,T> mapT= new HashMap<String,T>();
		if(listT.isEmpty()){
			return mapT;
		}
		Method getId=listT.get(0).getClass().getMethod("get"+StringUtils.capitalize(fieldKey));
		for(int i=0;i<listT.size();i++){
			mapT.put(getId.invoke(listT.get(i)).toString(), listT.get(i));
		}
		return mapT;
	}
	/**
	 * 从list得到索引map
	 * @param listT
	 * @param fieldId 小写 userComId
	 * @param cla
	 * @return
	 * @throws Exception
	 */
	public static <T> Map<Object,Integer> getMapFromListObjKey(List<T> listT,String fieldObj,Class<T> cla) throws Exception{
		Map<Object,Integer> mapIndex= new HashMap<Object,Integer>();
		if(listT.isEmpty()){
			return mapIndex;
		}
		Method getId=listT.get(0).getClass().getMethod("get"+StringUtils.capitalize(fieldObj));
		for(int i=0;i<listT.size();i++){
			mapIndex.put(getId.invoke(listT.get(i)), i);
		}
		return mapIndex;
	}
	/**
	 * 从map的一列得到索引map
	 * @param listT
	 * @param fieldId
	 * @return
	 * @throws Exception
	 */
	public static Map<Integer,Integer> getIndexMapFromMap(List<Map<String, Object>> listT,String fieldId) throws Exception{
		Map<Integer,Integer> mapIndex= new HashMap<Integer,Integer>();
		if(listT.isEmpty()){
			return mapIndex;
		}
		for(int i=0;i<listT.size();i++){
			mapIndex.put(Integer.parseInt(listT.get(i).get(fieldId).toString()),i);
		}
		return mapIndex;
	}
	/**
	 * 增加mapValue
	 * @param map
	 * @param key
	 * @param value
	 */
	public static void incMapValue(Map<String,Integer> map,String key,Integer value){
		if(map.containsKey(key)){
			map.put(key, value+map.get(key));
		}else{
			map.put(key,value);
		}
	}
	public static void incMapLong(Map<String,Long> map,String key,Long value){
		if(map.containsKey(key)){
			map.put(key, value+map.get(key));
		}else{
			map.put(key,value);
		}
	}
	/**
	 * 增加mapValue,用,分隔
	 * @param map
	 * @param key
	 * @param value 重复的不会填入
	 */
	public static void putMapValue(Map<String,String> map,String key,String value){
		if(map.containsKey(key)){
			String oldVale=map.get(key);
			if(!oldVale.contains(value)){
				//重复的value不填入
				map.put(key, oldVale+","+value);
			}
		}else{
			map.put(key,value);
		}
	}
	/**
	 * listMap排序
	 * @param listMap 比较的list
	 * @param key 比较字段
	 * @param type 1int2Long
	 * @param isAsc 是否升序	
	 */
	public static void sortListMapByKey(List<Map<String, Object>> listMap,String key,int type,boolean isAsc){
		ComparatorMap comparatorMap=new ComparatorMap(key,type,isAsc);
		Collections.sort(listMap,comparatorMap);
	}
	/**
	 * 将list封装为map
	 * @param listT
	 * @param fields需要封装的字段
	 * @return
	 * @throws Exception
	 */
	public static <T> List<Map<String,Object>> packMapFromList(List<T> listT,String[] fields)throws Exception{
		List<Map<String,Object>> listMap= new ArrayList<Map<String,Object>>();
		if(listT.isEmpty()){
			return listMap;
		}
		List<Method> methods=new ArrayList<Method>();
		//获取方法
		for(String field:fields){
			Method met=listT.get(0).getClass().getMethod("get"+StringUtils.capitalize(field));
			methods.add(met);
		}
		//封装map
		for(T obj:listT){
			Map<String,Object> map =new HashMap<String,Object>();
			int i=0;
			for(String field:fields){
				Object value=methods.get(i).invoke(obj);
				map.put(field, value);
				i++;
			}
			listMap.add(map);
		}
		return listMap;
	}

}
