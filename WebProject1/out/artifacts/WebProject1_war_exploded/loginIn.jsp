<%--
  Created by IntelliJ IDEA.
  User: huangyue
  Date: 2020/6/5
  Time: 下午9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <h1>login in</h1>
    <form action="/loginIn" method="post">
        <label>
            username:<input type="text" name="username">
        </label>
        <label>
            password:<input type="password" name="password">
        </label>
        <input type="submit" value="submit">
    </form>
</body>
</html>
