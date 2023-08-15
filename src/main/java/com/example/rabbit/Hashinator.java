package com.example.rabbit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashinator {
    public static String md5(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(msg.getBytes());

        return bytesToHex(md.digest());
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

}
