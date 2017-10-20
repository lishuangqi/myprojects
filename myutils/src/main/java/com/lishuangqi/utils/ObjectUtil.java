package com.lishuangqi.utils;

/**
 * Created by michael on 2017/10/20.
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ObjectUtil {

    public ObjectUtil() {
    }

    public static boolean objectEqualsToBoolean(Object source, Object target) {
        if(source != null && target != null) {
            boolean rv = true;
            if(source instanceof Map) {
                rv = mapOfSrc(source, target, rv);
            } else {
                rv = classOfSrc(source, target, rv);
            }

            return rv;
        } else {
            return false;
        }
    }

    public static Map<String, String> objectEqualsToMap(Object source, Object target) {
        new StringBuffer();
        HashMap rvMap = new HashMap();
        if(source != null && target != null) {
            boolean rv = true;
            Map rvMap1;
            if(source instanceof Map) {
                rvMap1 = mapOfSrcToMap(source, target, rvMap);
            } else {
                rvMap1 = classOfSrcToMap(source, target, rvMap);
            }

            return rvMap1;
        } else {
            return null;
        }
    }

    public static String getObjectDiffFieldValueToString(Object source, Object target) {
        Map map = objectEqualsToMap(source, target);
        StringBuffer content = new StringBuffer();
        if(map != null) {
            Iterator i$ = map.keySet().iterator();

            while(i$.hasNext()) {
                String key = (String)i$.next();
                if(CollectionUtil.isNotEmpty(map.get(key))) {
                    content.append(key + "=" + (String)map.get(key) + ",");
                }
            }
        }

        return content.toString();
    }

    private static boolean mapOfSrc(Object source, Object target, boolean rv) {
        new HashMap();
        HashMap map = (HashMap)source;
        Iterator i$ = map.keySet().iterator();

        while(i$.hasNext()) {
            String key = (String)i$.next();
            if(target instanceof Map) {
                new HashMap();
                HashMap tarValue1 = (HashMap)target;
                if(tarValue1.get(key) == null) {
                    rv = false;
                    break;
                }

                if(!((String)map.get(key)).equals(tarValue1.get(key))) {
                    rv = false;
                    break;
                }
            } else {
                String tarValue = getClassValue(target, key) == null?"":getClassValue(target, key).toString();
                if(!tarValue.equals(map.get(key))) {
                    rv = false;
                    break;
                }
            }
        }

        return rv;
    }

    private static Map<String, String> mapOfSrcToMap(Object source, Object target, Map<String, String> rv) {
        new HashMap();
        HashMap map = (HashMap)source;
        Iterator i$ = map.keySet().iterator();

        while(i$.hasNext()) {
            String key = (String)i$.next();
            if(target instanceof Map) {
                new HashMap();
                HashMap tarValue = (HashMap)target;
                String srcValue = map.get(key) == null?"":map.get(key).toString();
                String tarValue1 = tarValue.get(key) == null?"":tarValue.get(key).toString();
                if(!getMapValueToString(srcValue).equals(getMapValueToString(tarValue1))) {
                    rv.put(key, "由" + srcValue + "更新为" + tarValue1);
                }
            } else {
                String tarValue2 = getClassValue(target, key) == null?"":getClassValue(target, key).toString();
                if(!tarValue2.equals(map.get(key))) {
                    rv.put(key, "由" + map.get(key) + "更新为" + tarValue2);
                }
            }
        }

        return rv;
    }

    private static boolean classOfSrc(Object source, Object target, boolean rv) {
        Class srcClass = source.getClass();
        Field[] fields = srcClass.getDeclaredFields();
        Field[] arr$ = fields;
        int len$ = fields.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Field field = arr$[i$];
            String nameKey = field.getName();
            String tarValue;
            if(target instanceof Map) {
                new HashMap();
                HashMap srcValue = (HashMap)target;
                tarValue = getClassValue(source, nameKey) == null?"":getClassValue(source, nameKey).toString();
                if(srcValue.get(nameKey) == null) {
                    rv = false;
                    break;
                }

                if(!((String)srcValue.get(nameKey)).equals(tarValue)) {
                    rv = false;
                    break;
                }
            } else {
                String var12 = getClassValue(source, nameKey) == null?"":getClassValue(source, nameKey).toString();
                tarValue = getClassValue(target, nameKey) == null?"":getClassValue(target, nameKey).toString();
                if(!var12.equals(tarValue)) {
                    rv = false;
                    break;
                }
            }
        }

        return rv;
    }

    private static Map<String, String> classOfSrcToMap(Object source, Object target, Map<String, String> rv) {
        Class srcClass = source.getClass();
        Field[] fields = srcClass.getDeclaredFields();
        Field[] arr$ = fields;
        int len$ = fields.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Field field = arr$[i$];
            String nameKey = field.getName();
            String tarValue;
            if(target instanceof Map) {
                new HashMap();
                HashMap srcValue = (HashMap)target;
                tarValue = getClassValue(source, nameKey) == null?"":getClassValue(source, nameKey).toString();
                String tarValue1 = srcValue.get(nameKey) == null?"":((String)srcValue.get(nameKey)).toString();
                if(!tarValue1.equals(tarValue)) {
                    rv.put(nameKey, "由" + tarValue + "更新为" + tarValue1);
                }
            } else {
                String var13 = getClassValue(source, nameKey) == null?"":getClassValue(source, nameKey).toString();
                tarValue = getClassValue(target, nameKey) == null?"":getClassValue(target, nameKey).toString();
                if(!var13.equals(tarValue)) {
                    rv.put(nameKey, "由" + var13 + "更新为" + tarValue);
                }
            }
        }

        return rv;
    }

    public static Object getClassValue(Object obj, String fieldName) {
        if(obj == null) {
            return null;
        } else {
            try {
                Class e = obj.getClass();
                Method[] ms = e.getMethods();

                for(int i = 0; i < ms.length; ++i) {
                    if(ms[i].getName().startsWith("get")) {
                        Object objValue = null;

                        try {
//                            log.debug("ObjectUtil method:" + ms[i].getName());
                            Class[] e1 = ms[i].getParameterTypes();
                            if(e1 != null && e1.length > 0) {
                                continue;
                            }

                            objValue = ms[i].invoke(obj, (Object[])null);
                        } catch (Exception var7) {
                            var7.printStackTrace();
                            continue;
                        }

                        if(objValue != null) {
                            if(ms[i].getName().toUpperCase().equals(fieldName.toUpperCase()) || ms[i].getName().substring(3).toUpperCase().equals(fieldName.toUpperCase())) {
                                return objValue;
                            }

                            if(fieldName.toUpperCase().equals("SID") && (ms[i].getName().toUpperCase().equals("ID") || ms[i].getName().substring(3).toUpperCase().equals("ID"))) {
                                return objValue;
                            }
                        }
                    }
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }

            return null;
        }
    }

    public static Map<String, Object> getClassAllValue(Object obj) {
        if(obj == null) {
            return null;
        } else {
            HashMap objectValMap = new HashMap();

            try {
                Class e = obj.getClass();
                Method[] ms = e.getMethods();

                for(int i = 0; i < ms.length; ++i) {
                    if(ms[i].getName().startsWith("get")) {
                        Object objValue = null;

                        try {
//                            log.debug("ObjectUtil method:" + ms[i].getName());
                            Class[] e1 = ms[i].getParameterTypes();
                            if(e1 == null || e1.length <= 0) {
                                objValue = ms[i].invoke(obj, (Object[])null);
                                String filedName = StringUtil.substring(ms[i].getName(), 1, ms[i].getName().indexOf("get"));
                                if(objValue != null) {
                                    objectValMap.put(filedName, objValue);
                                }
                            }
                        } catch (Exception var12) {
                            var12.printStackTrace();
                        }
                    }
                }

                return objectValMap;
            } catch (Exception var13) {
                var13.printStackTrace();
                return objectValMap;
            } finally {
                ;
            }
        }
    }

    public static String getClassAllValueToString(Object obj) {
        Map objValMap = getClassAllValue(obj);
        StringBuffer content = new StringBuffer();
        if(objValMap != null) {
            Set set = objValMap.entrySet();
            Iterator itor = set.iterator();

            while(itor.hasNext()) {
                Entry entry = (Entry)itor.next();
                content.append((String)entry.getKey() + "=" + entry.getValue() + ",");
            }
        }

        return content.toString();
    }

    public static String getClassAllValueToString(List<Object> objlist) {
        StringBuffer content = new StringBuffer();
        if(CollectionUtil.isNotEmpty(objlist)) {
            for(Iterator reVal = objlist.iterator(); reVal.hasNext(); content.append(";")) {
                Object object = reVal.next();
                Map objValMap = getClassAllValue(object);
                if(objValMap != null) {
                    Set set = objValMap.entrySet();
                    Iterator itor = set.iterator();

                    while(itor.hasNext()) {
                        Entry entry = (Entry)itor.next();
                        content.append((String)entry.getKey() + "=" + entry.getValue() + ",");
                    }
                }
            }
        }

        String reVal1 = StringUtil.replace(content.toString(), ",;", ";");
        return reVal1;
    }

    private static String getMapValueToString(Object value) {
        return value == null?"":(value instanceof Collection?"":String.valueOf(value));
    }
}
