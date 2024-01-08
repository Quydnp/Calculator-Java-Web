<%-- 
    Document   : login
    Created on : Jan 6, 2024, 3:23:00 PM
    Author     : HI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form style="display: block;" method="POST" action="loginServlet1">
            <input style="display: block;" placeholder="Username" type="text" name="User" value="" />
            <input style="display: block; margin-top:8px;" placeholder="Password" type="password" name="Password" value="" />
            <input style="display: block; margin-top:8px" type="submit" value="Login" name="Login" />
        </form>
        
    </body>
</html>
