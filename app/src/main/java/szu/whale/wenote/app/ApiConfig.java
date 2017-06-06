package szu.whale.wenote.app;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class ApiConfig {
    private static boolean isDebug = true;

    public static boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    public static final String baseUrl = "";


    public static String getBaseUrl() {
        return baseUrl;
    }
}
