package com.example.upload702.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.HashMap;
import java.util.Map;

/**
 *加密工具类
 */
public class EncryptionUtil {
    public Map<String,String> encryption(String pwd){
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String password = new Md5Hash(pwd,salt,2).toString();
        Map<String,String> map = new HashMap<>();
        map.put("salt",salt);
        map.put("password",password);
        return map;
    }
}
