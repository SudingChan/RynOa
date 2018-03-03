package com.ken.rynoa.utils;

import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author joseph
 * @create 2018-02-27 下午 12:08
 * @desc MD5加密类
 **/

public class MD5Util {
    /**
     * MD5加密
     * @param str
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public String EncoderByMD5(String str)throws IOException,NoSuchAlgorithmException{
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //加密后的字符串
        str = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return str;
    }
}
