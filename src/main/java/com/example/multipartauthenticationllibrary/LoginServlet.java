package com.example.multipartauthenticationllibrary;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.net.URLEncoder;


@WebServlet(name = "LoginServlet", value = "/login-first")
public class LoginServlet extends HttpServlet {
    String testPSW = "tt";
    String testMD5Psw;

    {
        try {
            testMD5Psw = MD5Util.encode(URLEncoder.encode(testPSW,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    String testUsrName = "tt";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String md5psw = request.getParameter("md5psw");
        String devOpt = request.getParameter("devOpt");
        PrintWriter writer = response.getWriter();
        md5psw = md5psw.toUpperCase();
        if (devOpt.equals("PAP")){
            if ((username.equals(testUsrName)) && md5psw.equals(testMD5Psw)){
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