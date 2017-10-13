package com.lishuangqi.utils;

import org.apache.commons.lang.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

/**
 * Created by michael on 2017/10/13.
 */
public class StringUtil extends StringUtils {
    public StringUtil() {
    }

    public static boolean hasText(String string) {
        if(!isEmpty(string) && !isBlank(string)) {
            int strLen = string.length();

            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(string.charAt(i))) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static String round(String string) {
        if(!isEmpty(string) && string.indexOf(".") != -1) {
            string = string.substring(0, string.indexOf("."));
        }

        return isDigit(string)?String.valueOf(Long.parseLong(string)):(!isEmpty(string)?(string.indexOf(".") != -1?string.substring(0, string.indexOf(".")):string):null);
    }

    public static int toInteger(String string) throws ParseException {
        NumberFormat format = NumberFormat.getNumberInstance();
        return format.parse(string).intValue();
    }

    public static String toFirstUpperCase(String string) {
        if(!isEmpty(string) && !isBlank(string)) {
            StringBuffer buf = new StringBuffer();
            buf.append(Character.toUpperCase(string.charAt(0)));
            buf.append(string.substring(1));
            return buf.toString();
        } else {
            return null;
        }
    }

    public static String splitWords(String string, char delimiter) {
        if(!isEmpty(string) && !isBlank(string)) {
            StringBuffer buf = new StringBuffer();

            for(int i = 0; i < string.length(); ++i) {
                if(Character.isUpperCase(string.charAt(i))) {
                    buf.append(delimiter);
                }

                buf.append(Character.toLowerCase(string.charAt(i)));
            }

            if(buf.charAt(0) == delimiter) {
                buf.delete(0, 1);
            }

            return buf.toString();
        } else {
            return null;
        }
    }

    public static boolean isChineseChar(char c) {
        return c >= 19968 && c <= '龥';
    }

    public static boolean isDigit(String string) {
        if(!isEmpty(string) && !isBlank(string)) {
            string = trim(string);

            for(int i = 0; i < string.length(); ++i) {
                char c = string.charAt(i);
                if(!Character.isDigit(c) && c != 46 && c != 45) {
                    return false;
                }
            }

            if(string.indexOf(".") != string.lastIndexOf(".")) {
                return false;
            } else if(string.indexOf("-") != string.lastIndexOf("-")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static String trimLeadingWhitespace(String string) {
        if(!isEmpty(string) && !isBlank(string)) {
            StringBuffer buf = new StringBuffer(string);

            while(buf.length() > 0 && Character.isWhitespace(buf.charAt(0))) {
                buf.deleteCharAt(0);
            }

            return buf.toString();
        } else {
            return string;
        }
    }

    public static String trimTrailingWhitespace(String string) {
        if(!isEmpty(string) && !isBlank(string)) {
            StringBuffer buf = new StringBuffer(string);

            while(buf.length() > 0 && Character.isWhitespace(buf.charAt(buf.length() - 1))) {
                buf.deleteCharAt(buf.length() - 1);
            }

            return buf.toString();
        } else {
            return string;
        }
    }

    public static int countOccurrencesOf(String source, String sub) {
        if(source != null && sub != null && source.length() != 0 && sub.length() != 0) {
            int count = 0;
            int pos = 0;

            int var5;
            for(boolean idx = false; (var5 = source.indexOf(sub, pos)) != -1; pos = var5 + sub.length()) {
                ++count;
            }

            return count;
        } else {
            return 0;
        }
    }

    public static String delete(String inString, String pattern) {
        return replace(inString, pattern, "");
    }

    public static String unqualify(String qualifiedName) {
        return unqualify(qualifiedName, '.');
    }

    public static String unqualify(String qualifiedName, char pattern) {
        return qualifiedName.substring(qualifiedName.lastIndexOf(pattern) + 1);
    }

    public static String[] addStringToArray(String[] array, String str) {
        if(CollectionUtil.isEmpty(array)) {
            return new String[]{str};
        } else {
            String[] newArr = new String[array.length + 1];
            System.arraycopy(array, 0, newArr, 0, array.length);
            newArr[array.length] = str;
            return newArr;
        }
    }

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if(CollectionUtil.isEmpty(array1)) {
            return array2;
        } else if(CollectionUtil.isEmpty(array2)) {
            return array1;
        } else {
            String[] newArr = new String[array1.length + array2.length];
            System.arraycopy(array1, 0, newArr, 0, array1.length);
            System.arraycopy(array2, 0, newArr, array1.length, array2.length);
            return newArr;
        }
    }

    public static String[] mergeStringArrays(String[] array1, String[] array2) {
        if(CollectionUtil.isEmpty(array1)) {
            return array2;
        } else if(CollectionUtil.isEmpty(array2)) {
            return array1;
        } else {
            ArrayList result = new ArrayList();
            result.addAll(Arrays.asList(array1));

            for(int i = 0; i < array2.length; ++i) {
                String str = array2[i];
                if(!result.contains(str)) {
                    result.add(str);
                }
            }

            return toStringArray(result);
        }
    }

    public static String[] reversalStringArray(String[] array) {
        if(CollectionUtil.isEmpty(array)) {
            return new String[0];
        } else {
            Arrays.sort(array);
            return array;
        }
    }

    public static String[] toStringArray(Collection<String> collection) {
        return collection == null?null:(String[])((String[])collection.toArray(new String[collection.size()]));
    }

    public static String[] removeDuplicateStrings(String[] array) {
        if(CollectionUtil.isEmpty(array)) {
            return array;
        } else {
            TreeSet set = new TreeSet();

            for(int i = 0; i < array.length; ++i) {
                set.add(array[i]);
            }

            return toStringArray(set);
        }
    }

    public static String[] split(String source, String pattern) {
        return hasText(source) && hasText(pattern)?source.split(pattern):null;
    }

    public static List<String> split(String source, int step) {
        ArrayList list = new ArrayList();
        if(isEmpty(source)) {
            return list;
        } else {
            for(int i = 0; i < source.length(); ++i) {
                list.add(source.substring(i * step, (i + 1) * step > source.length()?source.length():(i + 1) * step));
                if((i + 1) * step >= source.length()) {
                    break;
                }
            }

            return list;
        }
    }

    public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {
        if(str == null) {
            return null;
        } else {
            StringTokenizer st = new StringTokenizer(str, delimiters);
            ArrayList tokens = new ArrayList();

            while(true) {
                String token;
                do {
                    if(!st.hasMoreTokens()) {
                        return toStringArray(tokens);
                    }

                    token = st.nextToken();
                    if(trimTokens) {
                        token = token.trim();
                    }
                } while(ignoreEmptyTokens && token.length() <= 0);

                tokens.add(token);
            }
        }
    }

    public static String[] delimitedListToStringArray(String str, String delimiter) {
        if(str == null) {
            return new String[0];
        } else if(delimiter == null) {
            return new String[]{str};
        } else {
            ArrayList result = new ArrayList();
            int pos;
            if("".equals(delimiter)) {
                for(pos = 0; pos < str.length(); ++pos) {
                    result.add(str.substring(pos, pos + 1));
                }
            } else {
                pos = 0;

                int var5;
                for(boolean delPos = false; (var5 = str.indexOf(delimiter, pos)) != -1; pos = var5 + delimiter.length()) {
                    result.add(str.substring(pos, var5));
                }

                if(str.length() > 0 && pos <= str.length()) {
                    result.add(str.substring(pos));
                }
            }

            return toStringArray(result);
        }
    }

    public static Set<String> commaDelimitedListToSet(String source, String pattern) {
        TreeSet set = new TreeSet();
        String[] tokens = split(source, pattern);

        for(int i = 0; i < tokens.length; ++i) {
            set.add(tokens[i]);
        }

        return set;
    }

    public static String collectionToDelimitedString(Collection<String> coll, String delim, String prefix, String suffix) {
        if(CollectionUtil.isEmpty(coll)) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();
            Iterator it = coll.iterator();

            while(it.hasNext()) {
                sb.append(prefix).append((String)it.next()).append(suffix);
                if(it.hasNext()) {
                    sb.append(delim);
                }
            }

            return sb.toString();
        }
    }

    public static String collectionToDelimitedString(Collection<String> coll, String delim) {
        return collectionToDelimitedString(coll, delim, "", "");
    }

    public static String arrayToDelimitedString(Object[] arr, String delim) {
        if(CollectionUtil.isEmpty(arr)) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();

            for(int i = 0; i < arr.length; ++i) {
                if(i > 0) {
                    sb.append(delim);
                }

                sb.append(arr[i]);
            }

            return sb.toString();
        }
    }

    public static int parseInt(String source) {
        return parseInt(source, 0);
    }

    public static int parseInt(Object object) {
        return parseInt(object == null?null:object.toString(), 0);
    }

    public static int parseInt(String source, int defaultValue) {
        if(isEmpty(source)) {
            return defaultValue;
        } else {
            try {
                source = source.replaceAll(",", "");
                int e = source.indexOf(".");
                if(e > 0) {
                    source = source.substring(0, e);
                }

                return Integer.parseInt(source);
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    public static long parseLong(String source) {
        return parseLong(source, 0L);
    }

    public static long parseLong(String source, long defaultValue) {
        if(source != null && !source.equals("")) {
            try {
                source = source.replaceAll(",", "");
                int e = source.indexOf(".");
                if(e > 0) {
                    source = source.substring(0, e);
                }

                return Long.parseLong(source);
            } catch (Exception var4) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static String surround(String[] sourceArray, String subString) {
        return surround(sourceArray, subString, "", "");
    }

    public static String surround(String[] sourceArray, String subString, String start, String end) {
        StringBuffer ret = new StringBuffer();

        for(int i = 0; i < sourceArray.length; ++i) {
            String s = sourceArray[i];
            ret.append(i == 0?"":subString).append(start).append(s).append(end);
        }

        return ret.toString();
    }

    public static String defaultString(String source, String defaultValue) {
        return !isEmpty(source) && !isBlank(source)?source:defaultValue;
    }

    public static String defaultString(Object source, String defaultValue) {
        return source != null?(source instanceof String?(String)source:String.valueOf(source)):defaultValue;
    }

    public static List<String> splitSimpleStringToList(String source, String split, String except) {
        ArrayList list = new ArrayList();
        if(!isEmpty(source) && !isBlank(source) && !isEmpty(split) && !isBlank(split)) {
            String[] strs = source.split(split);
            if(CollectionUtil.isEmpty(strs)) {
                return list;
            } else {
                for(int i = 0; i < strs.length; ++i) {
                    String s = strs[i];
                    if(!isEmpty(s) && (isEmpty(except) || !except.equals(s))) {
                        list.add(s);
                    }
                }

                return list;
            }
        } else {
            return list;
        }
    }

    public static List<String> splitSimpleStringToList(String source, String split) {
        return splitSimpleStringToList(source, split, (String)null);
    }

    public static double parseDouble(String str) {
        if(isEmpty(str)) {
            return 0.0D;
        } else {
            str = str.trim();
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder("");
            boolean started = false;
            boolean hasDot = false;

            for(int i = 0; i < chars.length; ++i) {
                if(!started) {
                    if(chars[i] >= 48 && chars[i] <= 57) {
                        sb.append(chars[i]);
                        started = true;
                    } else if(chars[i] == 46) {
                        sb.append(0);
                        sb.append(chars[i]);
                        started = true;
                        hasDot = true;
                    }
                } else if(chars[i] >= 48 && chars[i] <= 57) {
                    sb.append(chars[i]);
                } else {
                    if(chars[i] != 46 || hasDot) {
                        break;
                    }

                    sb.append(chars[i]);
                    hasDot = true;
                }
            }

            return Double.parseDouble(sb.toString());
        }
    }

    public static String trimSlash(String src) {
        return trim(src, "\\\\|\\/");
    }

    public static String trim(String src, String replaced) {
        return trim(src, replaced, "");
    }

    public static String trim(String src, String replaced, String replacement) {
        return src.replaceAll("^(" + replaced + ")|(" + replaced + ")$", replacement);
    }

    public static String signConvert(String s) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch(c) {
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\"':
                    sb.append("\\\"");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                default:
                    sb.append(c);
            }
        }

        return sb.toString();
    }
}

