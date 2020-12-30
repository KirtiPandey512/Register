<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
</head>
<body>
<sql:setDataSource
        var="myDS"
        url="jdbc:mysql://localhost:3306/Student"
        user="root" password=""
    />
     <sql:query var="students"   dataSource="${myDS}">
        SELECT * FROM register;
    </sql:query>
    <table border="2">
    <caption>Students</caption>
    <tr>
    <th>Name
    </th>
    <th>Mail
    </th>
    </tr>
    <c:forEach var="stu" items="${students.rows}">
     
   <tr>
   <td>
   <c:out value="${stu.name}"></c:out> </td>
    <td>
   <c:out value="${stu.mail}"></c:out> </td>
   </tr>
         </c:forEach>
    </table>
</body>
</html>