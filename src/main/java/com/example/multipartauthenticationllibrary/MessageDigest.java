package com.example.multipartauthenticationllibrary;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.NoSuchAlgorithmException;

public class MessageDigest {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String SHA256(String message) throws NoSuchAlgorithmException {
        java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(message.getBytes(StandardCharsets.UTF_8));
        return new String (Hex.encode(hash));
    }



}
