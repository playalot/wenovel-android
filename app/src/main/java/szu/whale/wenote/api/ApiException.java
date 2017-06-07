package szu.whale.wenote.api;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class ApiException extends Exception {

    private int code;

    public ApiException(int code , String errorMessage){
        super(errorMessage);
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
