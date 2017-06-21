package szu.whale.wenote.api.basic;

/**
 * funtion :实体类,后台返回的数据实体
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class ResponseInfo<T> {

    private String status;
    private String msg;
    private String errorMsg;
    private T data;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
