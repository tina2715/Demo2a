package com.udgs123.demo2a;

import android.content.Intent;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPass {
    public static final  String md5(String s) {
        final String md5="MD5";
        try {
            MessageDigest digest = MessageDigest.getInstance(md5);
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();
            //chuyển mảng byte thành hex string
            StringBuilder sb = new StringBuilder();
            for(byte b: messageDigest) {
              //  String b = Integer.toHexString(0xFF & aMessageDigest);
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  "";
    }
}
