package szu.whale.wenote.api.basic;

/**
 * funtion :服务器错误码基类
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class NetworkException extends Exception {

    private String code;

    public NetworkException(String code , String errorMessage){
        super(errorMessage);
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
}
