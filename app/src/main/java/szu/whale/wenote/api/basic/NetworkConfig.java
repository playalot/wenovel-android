package szu.whale.wenote.api.basic;

/**
 * funtion :配置log信息以及基本配置信息
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class NetworkConfig {
    private static boolean isDebug = false;
    public static final String baseUrl = "52.197.229.254:4400";

    public static boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }


    public static String getBaseUrl() {
        return baseUrl;
    }
}
