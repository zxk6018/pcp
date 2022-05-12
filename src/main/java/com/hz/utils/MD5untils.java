package com.hz.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5untils {
    public  String md5(String plainText){
        byte[] secretBytes=null;
        try {
            secretBytes=MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("没有md5这个算法");
        }
        String md5Code=new BigInteger(1, secretBytes).toString(16);
        for(int i=0;i<32-md5Code.length();i++){
            md5Code="0"+md5Code;
        }
        return md5Code;
    }

}