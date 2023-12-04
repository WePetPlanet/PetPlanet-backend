package top.zynorl.petplanet.common.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/12/04
 **/

/**
 * AES加密工具类
 */
public class AESUtil {
    /**
     * 加密
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 加密后的内容（Base64 编码字符串）
     */
    public static String encrypt(String content, String password) {
        if (StrUtil.isBlank(content) || StrUtil.isBlank(password)) {
            return null;
        }
        try {
            // 将密码转换为 16 位密钥
            byte[] key = SecureUtil.sha256(password).substring(0, 16).getBytes();

            // AES 加密
            byte[] encryptBytes = SecureUtil.aes(key).encrypt(content.getBytes());
            return Base64.encode(encryptBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密
     *
     * @param content 待解密内容（Base64 编码字符串）
     * @param password 解密密码
     * @return 解密后的内容
     */
    public static String decrypt(String content, String password) {
        if (StrUtil.isBlank(content) || StrUtil.isBlank(password)) {
            return null;
        }
        try {
            // 将密码转换为 16 位密钥
            byte[] key = SecureUtil.sha256(password).substring(0, 16).getBytes();

            // AES 解密
            byte[] decryptBytes = SecureUtil.aes(key).decrypt(Base64.decode(content));
            return new String(decryptBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(encrypt("1234567","123456"));
    }
}
