package szu.whale.wenote.util.encryption;


import szu.whale.wenote.util.StringUtils;

public class AESEncryption implements NoProguard{

	/**
	 * @author statham
	 * @version 2015-4-17 下午04:14:14
	 * @description AES加密
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String AESencrypt(String source, String key) throws Exception {
		if (StringUtils.isEmpty(source)) {
			return "";
		}
		try{
			if(StringUtils.isEmpty(key)){
				key = getKey();
			}
			String encodedData = AESCrypt.encrypt(source, key);
			return encodedData;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * @author statham
	 * @version 2015-4-17 下午04:14:16
	 * @description AES解密
	 * @param source
	 * @return
	 * @throws Exception
	 */
	public static String AESdecrypt(String source, String key) throws Exception {
		if (StringUtils.isEmpty(source)) {
			return "";
		}
		try{
			if(StringUtils.isEmpty(key)){
				key = getKey();
			}
			String dencodedData = AESCrypt.decrypt(source, key);
			return dencodedData;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public static String getKey(){
		try{
			return RSAEncryption.unsign(EnKeyUtils.getInstance().getAES_Key());
		}catch (Exception e) {
			// TODO: handle exception
			return EnKeyUtils.getInstance().getAES_Key();
		}
	}
}