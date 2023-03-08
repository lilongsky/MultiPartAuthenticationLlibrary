<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script type="module" src="script/login.js"></script>
</head>
<body>

<div id="login">
    <form id="login_form">
        <b>username: </b><label for="username"></label><input type="text" placeholder="username" id="username" name="username" required>
        <b>password: </b><label for="password"></label><input type="password" placeholder="password" id="password" required>
        <input type="hidden" id="md5-password" name="password">
        <label for="PAP"></label><input type="radio" id="PAP" name="devOption" value="PAP">PAP
        <label for="CHAP"></label><input type="radio" id="CHAP" name="devOption" value="CHAP" checked>CHAP
        <input type="button" id="submitButton" value="login in">
    </form>
</div>
</body>
</html>