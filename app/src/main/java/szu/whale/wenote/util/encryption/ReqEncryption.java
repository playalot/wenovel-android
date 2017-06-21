/**
 * 
 */
package szu.whale.wenote.util.encryption;

import java.io.Serializable;

/**
 * @author frankfang
 * @E-mail frankfang@hyx.com	
 * @version 2015年10月29日 下午10:33:05
 * @Description 加密的请求体
 */
public class ReqEncryption implements Serializable {

	private String encode;
	private String param;
	
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}

}
