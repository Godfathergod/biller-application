<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Назва сервісу</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <%
        Cookie[] cookies = request.getCookies();
        if(Arrays.stream(cookies).anyMatch(cookie -> cookie.getName().equals("username"))) {
            response.sendRedirect("home");
        }
    %>
    <h1 class="central element">Biller</h1>
</header>
<main>
    <h2 class="central element">Get Started</h2>
    <div class="button-group">
        <a class="signin-button" href="authorization.jsp">Sign In</a>
        <a class="signup-button" href="registration_page.jsp">Sign Up</a>
    </div>
</main>
</body>
</html>