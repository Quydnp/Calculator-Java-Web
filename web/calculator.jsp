<%-- 
    Document   : calculator
    Created on : Jan 9, 2024, 3:37:45 AM
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
        <form method="get" action="CalServlet">
            <label for="first">First:</label>
            <input type="text" id="first" name="first" ><br>

            <label for="text">Second:</label>
            <input type="number" id="second" name="second" ><br>

            <label for="operator">Operator</label>
            <select id="operator" name="operator">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
                <option value="^">^</option>
            </select><br><br>

            <input type="submit" value="Compute"><br><br>

            <label for="result">Result:</label>
            <input type="number" name="result" value=''>
        </form>
    </body>
</html>
