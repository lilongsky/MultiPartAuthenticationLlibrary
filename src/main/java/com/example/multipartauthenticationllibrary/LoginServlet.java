package com.example.multipartauthenticationllibrary;

import java.io.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.bouncycastle.util.encoders.Hex;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import com.google.gson.*;


@WebServlet(name = "LoginServlet", value = "/login-first")
public class LoginServlet extends  HttpServlet {

    String testPSW = "tt";
    String testSHA256Psw;

    {
        try {
            testSHA256Psw = MessageDigest.SHA256(testPSW);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    String testUsrName = "tt";
    String salt = "asfsgsfgsg";
    String randomValue;
    {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        randomValue = new String(Hex.encode(bytes));
    }
    String id;
    String randomValueWithId;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        String devOpt = request.getParameter("devOpt");
        if (devOpt.equals("CHAP")){
            id = request.getParameter("id");
            try {
                randomValueWithId = MessageDigest.SHA256(id+randomValue);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

            JsonObject obj = new JsonObject();
            obj.addProperty("id",id);
            obj.addProperty("randomValue",randomValueWithId);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            writer.write(gson.toJson(obj));
            writer.flush();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String sha256psw = request.getParameter("sha256psw");
        String devOpt = request.getParameter("devOpt");
        PrintWriter writer = response.getWriter();
        //sha256psw = sha256psw.toUpperCase();
        if (devOpt.equals("PAP")){
            if ((username.equals(testUsrName)) && sha256psw.equals(testSHA256Psw)){
                writer.write("success");
            }
            else {
                writer.write(testSHA256Psw);
            }
        } else if (devOpt.equals("CHAP")) {
            if (request.getParameter("id").equals(id)){
                String correctPsw;

                try {
                    correctPsw = MessageDigest.SHA256((testSHA256Psw+randomValueWithId));
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }

                if ((username.equals(testUsrName)) && sha256psw.equals(correctPsw)){
                    writer.write("success");
                }else {
                    writer.write(correctPsw);
                }
            }
            else {writer.write("id mismatch");}
        }
        writer.flush();
    }

    public void destroy() {
    }
}