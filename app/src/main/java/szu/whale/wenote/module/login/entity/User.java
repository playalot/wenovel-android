package szu.whale.wenote.module.login.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class User implements Serializable {

	private String userId;
	private String userName;
	private String sessionKey; // 登录编号
	private String nickName;
	private int yinHuaCount; // 印花数
	private String mobile;//登录中的mobile
	private String email;
	private String headImgPath; // 头像
	private String  payPassFlag; //是否设置了安全密码0无1有
	private String cashCardCount;//现金券数量
	private String maizuoCardCount;//卖座卡数量
	private String preCardCounts;//预售卡数量
	private String userNickName;//用户自定义昵称
	private String date;
	private String bindMobile;//登录中的mobile
	private String userOrderCounts;//可用订单
	private String preOrderCounts;//待付订单
	private String isVip; //1 vip  0 no vip
	private boolean loginresult;
	private String displayMsg;
	private String type;// //登陆类别：1:普通登陆 2:注册后登陆  3第三方登录
	private String alipayAccessToken;
	private String codeUrl; // 验证码URL
	private String validCount;//可用卖座卡张数
	private String validPreCardCount;//可用预售卡张数
	private String isSetPayPassword;//是否设置过安全密码  0 否  1 是
	private String relevanceMobile;//支付绑定的手机号
	private String payPwdDes;//支付绑定的手机号

	// 绑定手机号用
	private String sign;//后台给出的待绑定的第三方帐号的识别码
	private String uniqueKey;//第三方帐号对应的唯一码或邮箱帐号
	private String isBindAccount;//是否绑定手机号码 0、未绑定

	public String getPayPwdDes() {
		return payPwdDes;
	}

	public void setPayPwdDes(String payPwdDes) {
		this.payPwdDes = payPwdDes;
	}
	public String getValidCount() {
		return validCount;
	}

	public void setValidCount(String validCount) {
		this.validCount = validCount;
	}

	public String getValidPreCardCount() {
		return validPreCardCount;
	}

	public void setValidPreCardCount(String validPreCardCount) {
		this.validPreCardCount = validPreCardCount;
	}

	
	public String getIsVip() {
		return isVip;
	}

	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}

	
	public String getIsSetPayPassword() {
		return isSetPayPassword;
	}

	public void setIsSetPayPassword(String isSetPayPassword) {
		this.isSetPayPassword = isSetPayPassword;
	}

	public String getRelevanceMobile() {
		return relevanceMobile;
	}

	public void setRelevanceMobile(String relevanceMobile) {
		this.relevanceMobile = relevanceMobile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isLoginresult() {
		return loginresult;
	}

	public void setLoginresult(boolean loginresult) {
		this.loginresult = loginresult;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public int getYinHuaCount() {
		return yinHuaCount;
	}

	public void setYinHuaCount(int yinHuaCount) {
		this.yinHuaCount = yinHuaCount;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDisplayMsg() {
		return displayMsg;
	}

	public void setDisplayMsg(String displayMsg) {
		this.displayMsg = displayMsg;
	}

	
	public String getAlipayAccessToken() {
		return alipayAccessToken;
	}

	public void setAlipayAccessToken(String alipayAccessToken) {
		this.alipayAccessToken = alipayAccessToken;
	}

	public String getPayPassFlag() {
		return payPassFlag;
	}

	public void setPayPassFlag(String payPassFlag) {
		this.payPassFlag = payPassFlag;
	}


	public String getCashCardCount() {
		return cashCardCount;
	}

	public void setCashCardCount(String cashCardCount) {
		this.cashCardCount = cashCardCount;
	}

	public String getMaizuoCardCount() {
		return maizuoCardCount;
	}

	public void setMaizuoCardCount(String maizuoCardCount) {
		this.maizuoCardCount = maizuoCardCount;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getBindMobile() {
		return bindMobile;
	}

	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}

	public String getUserOrderCounts() {
		return userOrderCounts;
	}

	public void setUserOrderCounts(String userOrderCounts) {
		this.userOrderCounts = userOrderCounts;
	}

	public String getPreOrderCounts() {
		return preOrderCounts;
	}

	public void setPreOrderCounts(String preOrderCounts) {
		this.preOrderCounts = preOrderCounts;
	}
	
	public String getPreCardCounts() {
		return preCardCounts;
	}

	public void setPreCardCounts(String preCardCounts) {
		this.preCardCounts = preCardCounts;
	}
	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", nickName=" + nickName + ", yinhua=" + yinHuaCount + ", sessionKey=" + sessionKey
				+ ", mobile=" + mobile + ", email=" + email + ", headImgPath=" + headImgPath +  ", date=" + date
				+ ", loginresult=" + loginresult +",displayMsg="+ displayMsg+",isVip="+isVip+"]";
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getIsBindAccount() {
		return isBindAccount;
	}

	public void setIsBindAccount(String isBindAccount) {
		this.isBindAccount = isBindAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
