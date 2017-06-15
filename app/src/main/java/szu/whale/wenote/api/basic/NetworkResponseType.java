package szu.whale.wenote.api.basic;

public class NetworkResponseType {
    public static final String STATUS_OK = "0";
    public static final String STATUS_Error = "-1";

    public static final String STATUS_600211 = "600211";//token已过期
    public static final String STATUS_600203 = "600203";//用户未绑定支付手机号
    public static final String STATUS_600205 = "600205";//账号已冻结
    public static final String STATUS_6103 = "6103";//短信验证码错误次数达到上限
    public static final String STATUS_2004 = "4";//输入手机格式不对
    public static final String STATUS_900006 = "900006";//验证码已经发送
    public static final String STATUS_6007 = "6007";//请输入图形验证码
    public static final String STATUS_1014 = "1014";//发送次数超限
    public static final String STATUS_1100021 = "1100021";//账号已存在
    public static final String STATUS_6666 = "6666";//未登录或登录会话失效
    public static final String STATUS_1100030 = "1100030";//密码错误次数达到上限,请输入图形验证码
    public static final String STATUS_370010 = "370010";//图形验证码输入有误
    public static final String STATUS_1100006 = "1100006";//密码错误
    public static final String STATUS_1100020 = "1100020";//手机号不存在
    public static final String STATUS_6101 = "6101";//短信验证码错误
    public static final String STATUS_1100018 = "1100018";//用户的邮寄地址不存在
    public static final String STATUS_1100004 = "1100004";//手机号已存在
    public static final String STATUS_6102 = "6102";//短信验证码失效
    public static final String STATUS_500025 = "500025";//卡授权失效
    public static final String STATUS_6003 = "6003";//暂无数据
    public static final String STATUS_100002 = "STATUS_100002";//订单已支付
}
