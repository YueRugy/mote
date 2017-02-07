package com.yue.util;


import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
    /**
     * 手机号校验
     */
    public static boolean isMobile(String phoneNumber) {
        String reg = "^(((13[0-9])|(15[0-9])|(17[0-9])|(18[0-9])|(14[0-9]))+\\d{8})$";
        return Pattern.compile(reg).matcher(phoneNumber).matches();
    }

    /**
     * 身份证号校验
     */
    public static boolean isIDCard(String idNumber) {
        String reg = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$";
        return Pattern.compile(reg).matcher(idNumber).matches();
    }

    /**
     * 中文校验
     */
    public static boolean isChinese(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }

        String reg = "[\u4e00-\u9fa5]";
        Pattern p = Pattern.compile(reg);
        for (int i = 0; i < str.length(); i++) {
            String c = str.substring(i, i + 1);
            Matcher m = p.matcher(c);
            if (!m.matches()) {
                return false;
            }
        }
        return true;
    }

  /*  public static boolean equals(final Object object1, final Object object2) {
        if (object1 == object2) {
            return true;
        }
        if (object1 == null) {
            if (object2 == null) {
                return true;
            } else {
                return false;
            }
        } else {
            return object1.equals(object2);
        }
    }*/

}
