package szu.whale.wenote.api.basic;

/**
 * funtion :服务器错误码基类
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class NetworkException extends Exception {

    private int code;

    public NetworkException(int code , String errorMessage){
        super(errorMessage);
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
