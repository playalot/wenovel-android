package szu.whale.wenote.util;

import android.text.TextUtils;
import android.util.Base64;

public class StringUtils extends Base {

    /**
     * 空检测 空返true
     *
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:33
     */
    public static boolean isEmpty(String s) {
        /*
		 * if(s==null||"".equals(s.trim())){ return true; } return false;
		 */
        return TextUtils.isEmpty(s);
    }

    /**
     * 是否包含当前字符串
     *
     * @param curProcessName 包含字符
     * @param s              包含字节
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:35
     */
    public static boolean contains(String curProcessName, String s) {
        if (TextUtils.isEmpty(curProcessName)) {
            return false;
        }
        try {


            if (curProcessName.contains(s)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

        }
        return false;
    }


    /**
     * 两个字符串是否相等
     *
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:36
     */
    public static boolean equal(String firstString, String secondString) {
        if (TextUtils.isEmpty(firstString) || TextUtils.isEmpty(secondString)) {
            return false;
        }
        try {

            if (firstString.equals(secondString)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

        }
        return false;
    }

     /**
      * BASE64Decoder Base64编码
      * @author statham
      * @date 2017/2/10 0010 10:40
      * @param
      * @return byte[]
      * @throws Exception
      */
    public static byte[] BASE64Decoder(String base64) throws Exception {
        return Base64.decode(base64,Base64.DEFAULT);
    }

    /**
     * 二进制数据编码为BASE64字符串
     * @param bytes
     * @return String
     * @throws Exception
     */
    public static String BASE64Encoder(byte[] bytes) throws Exception {
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    /**
     * 加密解密算法 执行一次为加密，两次为解密
     */
    public static String convertMD5(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    /**
     * 输入是否满足11位并且以1开头
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        if (isEmpty(str)) {
            return false;
        } else {
            return str.length() == 11 && str.startsWith("1");
        }
    }
}
