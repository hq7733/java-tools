package com.htools.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author hq
 * @date 2023/8/10
 */
public class EncryptionUtils {

    private String algorithm;

    /**
     * 加密编码
     */
    private static final String SECRET_KEY_ENCODING = "UTF-8";

    public EncryptionUtils(String algorithm) {
        this.algorithm = algorithm;
    }

    public String encrypt(String content, String password) throws Exception {
        byte[] raw = password.getBytes(EncryptionUtils.SECRET_KEY_ENCODING);
        SecretKeySpec sKeySpec = new SecretKeySpec(raw, this.algorithm);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
        byte[] byteResult = cipher.doFinal(content.getBytes(EncryptionUtils.SECRET_KEY_ENCODING));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteResult.length; i++) {
            String hex = Integer.toHexString(byteResult[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    private static byte[] decrypt(byte[] content, String password) throws Exception {
        byte[] raw = password.getBytes(EncryptionUtils.SECRET_KEY_ENCODING);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        return cipher.doFinal(content);
    }
}
