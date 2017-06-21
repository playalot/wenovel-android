package szu.whale.wenote.util.encryption;


import java.io.UnsupportedEncodingException;

import szu.whale.wenote.util.StringUtils;


public class RSAEncryption implements NoProguard {

	//=======================加密==========================
	/**
	 * RSA算法加密(公钥钥加密)
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String rsaSignPublic(String source) throws Exception {
		if (StringUtils.isEmpty(source)) {
			return "";
		}
		try {
			byte[] data = source.getBytes("utf-8");
			byte[] encodedData = RSACrypt.encryptByPublicKey(data, getPublicKey());
			return RSACrypt.encode(encodedData);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	/**
	 * RSA算法加密(公钥钥加密)
	 *
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String rsaSignPublicMall(String source) throws Exception {
		if (StringUtils.isEmpty(source)) {
			return "";
		}
		try {
			byte[] data = source.getBytes("utf-8");
			byte[] encodedData = RSACrypt.encryptByPublicKey(data, getMallPublicSignKey());
			return RSACrypt.encode(encodedData);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	 

	/**
	 * RSA算法加密(私钥加密)
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String rsaSign(String source) throws Exception {
		if (StringUtils.isEmpty(source)) {
			return "";
		}
		try {
			byte[] data = source.getBytes("utf-8");
			byte[] encodedData = RSACrypt.encryptByPrivateKey(data, getPrivateSignKey());
			return RSACrypt.encode(encodedData);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	 
	
	//=======================解密==========================
	/**
	 * @author statham
	 * @version 2015-3-31 下午04:47:29
	 * @description RSA算法解密(公钥解密)
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String rsaUnSignPublic(String source) throws Exception {
		if (StringUtils.isEmpty(source)) {
			return "";
		}
		try {
			byte[] data = RSACrypt.decode(source);
			byte[] dencodedData = RSACrypt.decryptByPublicKey(data, getPublicKey());
			return new String(dencodedData);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	 
	
	/**
	 * @author statham
	 * @version 2015-3-31 下午04:47:29
	 * @description RSA算法解密(私钥解密)
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String rsaUnSign(String source) throws Exception {
		if (StringUtils.isEmpty(source)) {
			return "";
		}
		try {
			byte[] data = RSACrypt.decode(source);
			byte[] dencodedData = RSACrypt.decryptByPrivateKey(data, getPrivateUnSignKey());
			return new String(dencodedData);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// ===========================================
	private static String getMallPublicSignKey() {
		return EnKeyUtils.getInstance().getRSAMall_Public_key();
	}

	private static String getPrivateSignKey() {
		try{
			return unsign(EnKeyUtils.getInstance().getRSAEN_key());
		}catch (Exception e) {
			// TODO: handle exception
			return EnKeyUtils.getInstance().getRSAEN_key();
		}
	}

	private static String getPrivateUnSignKey() {
		try{
			return unsign(EnKeyUtils.getInstance().getRSAUN_KEY());
		}catch (Exception e) {
			// TODO: handle exception
			return EnKeyUtils.getInstance().getRSAUN_KEY();
		}
	}
	
	private static String getPublicKey(){
		return "";
	}
	
	public static String unsign(String inStr) {
		try {
			byte[] a = RSACrypt.decode(inStr);
			for (int i = 0; i < a.length; i++) {
				if(i%2==0){
					a[i] = (byte) (a[i] ^ 'd');
				}else{
					a[i] = (byte) (a[i] ^ 't');
				}
			}
			String k = new String(a);
			return k;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inStr;
	 }
}
