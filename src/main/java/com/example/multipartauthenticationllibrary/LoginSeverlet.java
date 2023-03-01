package com.example.multipartauthenticationllibrary;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.sql.*;



@WebServlet(name = "loginfirstseverlet", value = "/login-first")
public class LoginSeverlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String md5psw = request.getParameter("md5psw");
        //todo: redo MD5 current is different with front
        String devOpt = request.getParameter("devOpt");
        PrintWriter writer = response.getWriter();
        md5psw = md5psw.toUpperCase();
        //if (devOpt.equals("PAP")){
            if ((username.equals("tt")) && md5psw.equals(MD5Util.encode("tt"))){
                writer.write("success");
            }
            else {
                writer.write(MD5Util.encode("tt"));
            }
        //}
        writer.flush();
    }

    public void destroy() {
    }
}