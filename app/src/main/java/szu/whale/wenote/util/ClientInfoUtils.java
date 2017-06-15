package szu.whale.wenote.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;


/**
 * 客户端信息Utils
 *
 * @author statham
 * @date 2017/2/9 0009 18:08
 */
public class ClientInfoUtils {
    private static final String MAIZUO_CLIENTID = "APP_CLIENTID";
    private static final String MAIZUO_CHANNELID = "APP_CHANNELID";//内部渠道
    private static final String UMENG_CHANNEL = "UMENG_CHANNEL";//外部渠道


    public String UM_Value = null;
    public String ClientId = null;
    public String ChannelId = null;
    public String EquipmentId = null;
    public String versionName = null;
    private int versionCode = 0;

    private static ClientInfoUtils instance;

    public static ClientInfoUtils getInstance() {
        if (instance == null) {
            instance = new ClientInfoUtils();
        }
        return instance;
    }


    /**
     * 得到友盟的渠道号
     *
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:11
     */
    public String getUmMetaInfo(Context context) {
        if (!StringUtils.isEmpty(UM_Value)) {
            return UM_Value;
        }
        if (context == null) {
            return UM_Value;
        }
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(),
                    PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            UM_Value = bundle.getString(UMENG_CHANNEL);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            UM_Value = "";
        }
        return UM_Value;
    }

    /**
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:11
     */
    public String getClientID(Context context) {
        if (!StringUtils.isEmpty(ClientId)) {
            return ClientId;
        }
        if (context == null) {
            return ClientId;
        }
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            ClientId = bundle.getString(MAIZUO_CLIENTID);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            ClientId = "";
        }
        return ClientId;
    }

    /**
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:11
     */
    public String getChannelID(Context context) {
        if (context == null) {
            return ChannelId;
        }
        if (!StringUtils.isEmpty(ChannelId)) {
            return ChannelId;
        }
        if (context == null) {
            return ChannelId;
        }

        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(),
                    PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            ChannelId = bundle.getString(MAIZUO_CHANNELID);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            ChannelId = "";
        }
        return ChannelId;
    }

    /**
     * 当前程序的版本号 130
     *
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:11
     */
    public int getVersionCode(Context context) {
        if (versionCode > 0) {
            return versionCode;
        }
        if (context == null) {
            return versionCode;
        }
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionCode = packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            versionCode = 0;
        }
        return versionCode;
    }

    /**
     * 当前程序的版本名称4.9.5
     *
     * @param
     * @return
     * @author statham
     * @date 2017/2/9 0009 18:11
     */
    public String getVersionName(Context context) {
        if (!StringUtils.isEmpty(versionName)) {
            return versionName;
        }
        if (context == null) {
            return versionName;
        }
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            versionName = "";
        }
        return versionName;
    }


    /**
     * 获取当前进程名
     *
     * @autuor statham
     * @date 2017/4/11 下午6:45
     * @param
     * @return
     */
    public static String getCurrentProcessName(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo processInfo : activityManager.getRunningAppProcesses()) {
            if (processInfo.pid == android.os.Process.myPid()) {
                return processInfo.processName;
            }
        }
        return null;
    }
}
