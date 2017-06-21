package szu.whale.wenote.api.basic;

public class NetworkResponseType {
    public static final String STATUS_OK = "0";
    public static final String STATUS_6011 = "6011";// 验证码已失效
    public static final String STATUS_6012 = "6012";// 验证码错误次数达到上限，请稍后验证
    public static final String STATUS_6013 = "6013";// 验证码错误请重试
    public static final String STATUS_6014 = "6014";// 账号被占用
    public static final String STATUS_600211 = "600211";// 验证码token已失效
    public static final String STATUS_LOGIN_SURPASS = "6006";// 登录次数过多 图形验证码
    public static final String STATUS_LOGIN_AGAIN = "6001";// 需要重新登录
    public static final String STATUS_PREFERENTAIL_FAIL = "1"; // 小卖品优惠价格校验失败
    public static final String STATUS_01 = "-1";// 系统故障
    public static final String STATUS_6002 = "6002";// 参数有误
    public static final String STATUS_6003 = "6003";// 返回数据为空
    public static final String STATUS_6004 = "6004";// 6004
    public static final String STATUS_6005 = "6005";// 需要重新请求
    public static final String STATUS_6006 = "6006";// 超过频率限制
    public static final String STATUS_6007 = "6007";// 下单校验优惠不通过
    public static final String STATUS_6009 = "6009";// 标识订单已经支付
    public static final String STATUS_2002 = "2002";// 标识订单金额第三方校验不过
    public static final String STATUS_6021 = "6021";// 座位无效
    public static final String STATUS_6022 = "6022";// 场次无效
    public static final String STATUS_6023 = "6023";// 其他原因
    public static final String STATUS_6024 = "6024";// 和影院网络连接异常
    public static final String STATUS_6031 = "6031";// 该订单已过期,如有疑问请联系客服电话4001808400,谢谢
    public static final String STATUS_6032 = "6032";// 该订单的票券已部分消费暂不支持自助退费，请填写您的手机号码，我们的客服将联系您处理退费事宜，期间请勿消费该订单的票券，谢谢
    public static final String STATUS_6033 = "6033";// 该订单已经退费过了，如有疑问请联系客服电话&QQ
    public static final String STATUS_6042 = "6042";// 已有待支付订单
    // 4001808400
    public static final String STATUS_6034 = "6034";// 该订单的支付方式暂不支持自助退费，请填写您的手机号码，我们的客服将联系您处理退费事宜，期间请勿消费该订单的票券，谢谢
    public static final String STATUS_6035 = "6035";// 您今天的退费次数已超限，请填写您的手机号码，我们的客服将联系您处理退费事宜，期间请勿消费该订单的票券，谢谢
    //安全密码
    public static final String STATUS_600201 = "600201"; //手机号已被其他账号绑定
    public static final String STATUS_600202 = "600202"; // 该账户已经绑定了支付手机号
    public static final String STATUS_600203 = "600203"; //用户未绑定支付手机号
    public static final String STATUS_600204 = "600204"; //安全密码和上次安全密码一样
    public static final String STATUS_600205 = "600205"; //账户已冻结
    public static final String STATUS_600206 = "600206"; //安全密码为空
    public static final String STATUS_600207 = "600207"; //未设置安全密码
    public static final String STATUS_600208 = "600208"; //安全密码错误
    public static final String STATUS_600209 = "600209"; //安全密码不能和登录密码一样
    public static final String STATUS_600210 = "600210"; //手机用户无需绑定
    public static final String STATUS_1100018 = "1100018";//个人资料邮寄地址为空
    public static final String STATUS_1005 = "1005";    //客户端匹配失败
}
