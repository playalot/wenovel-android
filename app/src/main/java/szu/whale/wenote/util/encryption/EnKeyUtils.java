package szu.whale.wenote.util.encryption;


import szu.whale.wenote.util.StringUtils;

/**
 * @author statham
 * @Email statham@maizuo.com
 * @date 2017/1/18 0018 16:15
 * @Description:
 */
public class EnKeyUtils implements NoProguard{

    static {
        System.loadLibrary("libconfig");
    }


    private static EnKeyUtils instance;
    public static EnKeyUtils getInstance(){
        if (instance==null){
            instance = new EnKeyUtils();
        }
        return instance;
    }


    private String RSAUN_KEY,RSAEN_key,AES_Key,RSA_MALL_Public_key = null;

    public String getRSAUN_KEY(){
        if (StringUtils.isEmpty(RSAUN_KEY)){
            RSAUN_KEY = getRSAUNkey();
        }
        return RSAUN_KEY;
    }

    public String getRSAEN_key(){
        if (StringUtils.isEmpty(RSAEN_key)){
            RSAEN_key = getRSAENkey();
        }
        return RSAEN_key;
    }

    public String getAES_Key(){
        if (StringUtils.isEmpty(AES_Key)){
            AES_Key = getAESKey();
        }
        return AES_Key;
    }

    public String getRSAMall_Public_key(){
        if (StringUtils.isEmpty(RSA_MALL_Public_key)){
            RSA_MALL_Public_key = getMallRsaPub();
        }
        return RSA_MALL_Public_key;
    }



    //RSA_PRILICKEY_UN
    public native String getRSAUNkey();

    //RSA_PRILICKEY
    public native String getRSAENkey();

    //RSA_MALL_Public_key
    public native String getMallRsaPub();

    //AES_KEY
    public native String getAESKey();

}
