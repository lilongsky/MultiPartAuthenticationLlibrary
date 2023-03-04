package com.example.multipartauthenticationllibrary;

import java.io.*;
import java.security.NoSuchAlgorithmException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "LoginServlet", value = "/login-first")
public class LoginServlet extends HttpServlet {

    String testPSW = "tt";
    String testSHA256Psw;

    {
        try {
            testSHA256Psw = MessageDigest.SHA256("tt");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    String testUsrName = "tt";



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        String devOpt = request.getParameter("devOpt");
        if (devOpt.equals("CHAP")){

        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String sha256psw = request.getParameter("sha256psw");
        String devOpt = request.getParameter("devOpt");
        PrintWriter writer = response.getWriter();
        sha256psw = sha256psw.toUpperCase();
        if (devOpt.equals("PAP")){
            if ((username.equals(testUsrName)) && sha256psw.equals(testSHA256Psw)){
                writer.write("success");
            }
            else {
                writer.write("fail");
            }
        } else if (devOpt.equals("CHAP")) {


        }
        writer.flush();
    }

    public void destroy() {
    }
}