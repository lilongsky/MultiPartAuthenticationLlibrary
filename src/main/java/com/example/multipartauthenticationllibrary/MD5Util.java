package com.example.multipartauthenticationllibrary;
import java.math.BigInteger;
import java.security.*;
public class MD5Util {
    public static String encode(String source) {

    String algorithm = "MD5";

    MessageDigest messageDigest = null;
    try {
     messageDigest = MessageDigest.getInstance(algorithm);
    } catch (NoSuchAlgorithmException e) {
     e.printStackTrace();
    }

    byte[] input = source.getBytes();

    byte[] output = new byte[0];
    if (messageDigest != null) {
        output = messageDigest.digest(input);
    }

    int signum = 1;
    BigInteger bigInteger = new BigInteger(signum, output);

    int radix = 16;

    return bigInteger.toString(radix).toUpperCase();

    }
}
