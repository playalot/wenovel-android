package szu.whale.wenote.util.encryption;


import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class AESCrypt {

	// /** 算法/模式/填充 **/
	private static final String AES_CipherMode = "AES/ECB/PKCS7Padding";//AES/ECB/PKCS5Padding

	// /** 创建密钥 **/
	private static SecretKeySpec createKey(String password) {
		byte[] data = null;
		if (password == null) {
			password = "";
		}
		StringBuffer sb = new StringBuffer(32);
		sb.append(password);
		while (sb.length() < 32) {
			sb.append("0");
		}
		if (sb.length() > 32) {
			sb.setLength(32);
		}

		try {
			data = sb.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new SecretKeySpec(data, "AES");
	}

	
	
	/**
	 * <p>
	 * 加密
	 * </p>
	 * 
	 * @param data
	 *            源数据
	 * @param privateKey
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] content, String password) {
		try {
			SecretKeySpec key = createKey(password);
			Cipher cipher = Cipher.getInstance(AES_CipherMode);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(content);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <p>
	 * 加密
	 * </p>
	 * 
	 * @param data
	 *            源数据
	 * @param privateKey
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String content, String password) {
		byte[] data = null;
		try {
			data = content.getBytes("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = encrypt(data, password);
		String result = null;
		try {
			result = RSACrypt.encode(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//byte2hex(data);
		return result;
	}

	/**
	 * <p>
	 * 解密
	 * </p>
	 * 
	 * @param data
	 *            源数据
	 * @param privateKey
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] content, String password) {
		try {
			SecretKeySpec key = createKey(password);
			Cipher cipher = Cipher.getInstance(AES_CipherMode);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] result = cipher.doFinal(content);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <p>
	 * 解密
	 * </p>
	 * 
	 * @param data
	 *            源数据
	 * @param privateKey
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String content, String password) {
		byte[] data = null;
		try {
			data = RSACrypt.decode(content);//hex2byte(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = decrypt(data, password);
		if (data == null)
			return null;
		String result = null;
		try {
			result = new String(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	// /** 字节数组转成16进制字符串 **/
	public static String byte2hex(byte[] b) { // 一个字节的数，
		StringBuffer sb = new StringBuffer(b.length * 2);
		String tmp = "";
		for (int n = 0; n < b.length; n++) {
			// 整数转成十六进制表示
			tmp = (Integer.toHexString(b[n] & 0XFF));
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);
		}
		return sb.toString().toUpperCase(); // 转成大写
	}

	// /** 将hex字符串转换成字节数组 **/
	public static byte[] hex2byte(String inputString) {
		if (inputString == null || inputString.length() < 2) {
			return new byte[0];
		}
		inputString = inputString.toLowerCase();
		int l = inputString.length() / 2;
		byte[] result = new byte[l];
		for (int i = 0; i < l; ++i) {
			String tmp = inputString.substring(2 * i, 2 * i + 2);
			result[i] = (byte) (Integer.parseInt(tmp, 16) & 0xFF);
		}
		return result;
	}

}
