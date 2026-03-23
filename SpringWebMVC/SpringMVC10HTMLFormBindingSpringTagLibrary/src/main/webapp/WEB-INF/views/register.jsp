<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Implementors App</title>
</head>
<body>

<form:form method="post" modelAttribute="impl2"> <!-- bean id is impl2 -->
UserID: <form:input path="uid" /><br>
Username: <form:input  path="uname" /><br>
UserCity: <form:input path="ucity" /><br>
Phone Number: <form:input  path="unumber" /><br>
<input type="submit" value="Register" />
</form:form>


</body>
</html>

