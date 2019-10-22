package com.hacking.util;

import java.util.UUID;

/**
 * 字符串处理工具类
 *
 * @author jintingying
 * Created on 2019/10/11
 * @version 1.0
 */
public class HackingStringUtils {

    public static final String SQL_FILED_CONDITION_ALL_FLAG = "*";

    private static final String emailRegx = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$";

    private static final String phoneRegx = "^(13[0-9]|15[01]|153|15[6-9]|180|18[23]|18[5-9])\\d{8}$";

    /**
     * 判断一个字符串不为null且不为空
     *
     * @param  str
     * @return boolean
     */
    public static boolean isNotEy(String str){
        return null != str && !"".equals(str);
    }
    /**
     * 判断一个字符串不为null, 且不为空, 且不全为空格
     *
     * @param  str
     * @return boolean
     */
    public static boolean isNotEyAndSp(String str){
        return null != str && !"".equals(str) && !"".equals(str.replace(" ", ""));
    }

    /**
     * 使用UUID生成8位唯一性字符串
     *
     * @return java.lang.String
     */
    public static String randomUUID_8() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    /**
     * 使用UUID生成32唯一性字符串(去除‘-’)
     *
     * @return String
     */
    public static String randomUUID_32(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 判断字符串是否为邮箱格式
     *
     * @param  str
     * @return boolean
     */
    public static boolean isEmail(String str){
       if(isNotEy(str)) return str.matches(emailRegx);
       else return false;
    }

    /**
     * 判断字符串是否为手机号格式
     *
     * @param  str
     * @return boolean
     */
    public static boolean isPhone(String str){
        if(isNotEy(str)) return str.matches(phoneRegx);
        else return false;
    }

    private static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };
}
