package com.lishuangqi.utils;

/**
 * Created by michael on 2017/10/20.
 */

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public RegexUtil() {
    }

    public static void main(String[] args) {
        System.out.println("匹配汉字: " + isChinese("中国！"));
        System.out.println("验证字符: " + stringCheck("中文aabc001_-"));
    }

    public static final boolean isUrl(String str) {
        return match(str, "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$");
    }

    public static final boolean isPwd(String str) {
        return match(str, "^[a-zA-Z]\\w{6,12}$");
    }

    public static final boolean stringCheck(String str) {
        return match(str, "^[a-zA-Z0-9一-龥-_]+$");
    }

    public static final boolean isEmail(String str) {
        return match(str, "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }

    public static final boolean isInteger(String str) {
        return match(str, "^[+]?\\d+$");
    }

    public static final boolean isNumeric(String str) {
        return isFloat(str) || isInteger(str);
    }

    public static final boolean isDigits(String str) {
        return match(str, "^[0-9]*$");
    }

    public static final boolean isFloat(String str) {
        return match(str, "^[-\\+]?\\d+(\\.\\d+)?$");
    }

    public static final boolean isTel(String text) {
        return isMobile(text) || isPhone(text);
    }

    public static final boolean isPhone(String text) {
        return match(text, "^(\\d{3,4}-?)?\\d{7,9}$");
    }

    public static final boolean isMobile(String text) {
        return text.length() != 11?false:match(text, "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
    }

    public static final boolean isIdCardNo(String text) {
        return match(text, "^(\\d{6})()?(\\d{4})(\\d{2})(\\d{2})(\\d{3})(\\w)$");
    }

    public static final boolean isZipCode(String text) {
        return match(text, "^[0-9]{6}$");
    }

    public static final boolean isRightfulString(String text) {
        return match(text, "^[A-Za-z0-9_-]+$");
    }

    public static final boolean isEnglish(String text) {
        return match(text, "^[A-Za-z]+$");
    }

    public static final boolean isChineseChar(String text) {
        return match(text, "^[Α-￥]+$");
    }

    public static final boolean isChinese(String text) {
        return match(text, "^[一-龥]+$");
    }

    public static boolean isContainsSpecialChar(String text) {
        if(StringUtils.isBlank(text)) {
            return false;
        } else {
            String[] chars = new String[]{"[", "`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "=", "|", "{", "}", "\'", ":", ";", "\'", ",", "[", "]", ".", "<", ">", "/", "?", "~", "！", "@", "#", "￥", "%", "…", "&", "*", "（", "）", "—", "+", "|", "{", "}", "【", "】", "‘", "；", "：", "”", "“", "’", "。", "，", "、", "？", "]"};
            String[] arr$ = chars;
            int len$ = chars.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String ch = arr$[i$];
                if(text.contains(ch)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static String stringFilter(String text) {
        String regExpr = "[`~!@#$%^&*()+=|{}\':;\',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regExpr);
        Matcher m = p.matcher(text);
        return m.replaceAll("").trim();
    }

    public static String htmlFilter(String inputString) {
        String htmlStr = inputString;
        String textStr = "";

        try {
            String e = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            String regEx_html = "<[^>]+>";
            String patternStr = "\\s+";
            Pattern p_script = Pattern.compile(e, 2);
            Matcher m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll("");
            Pattern p_style = Pattern.compile(regEx_style, 2);
            Matcher m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll("");
            Pattern p_html = Pattern.compile(regEx_html, 2);
            Matcher m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll("");
            Pattern p_ba = Pattern.compile(patternStr, 2);
            Matcher m_ba = p_ba.matcher(htmlStr);
            htmlStr = m_ba.replaceAll("");
            textStr = htmlStr;
        } catch (Exception var15) {
            System.err.println("Html2Text: " + var15.getMessage());
        }

        return textStr;
    }

    private static final boolean match(String text, String reg) {
        return !StringUtil.isBlank(text) && !StringUtil.isBlank(reg)?Pattern.compile(reg).matcher(text).matches():false;
    }
}
