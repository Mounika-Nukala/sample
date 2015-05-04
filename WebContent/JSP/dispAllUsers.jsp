<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table>
    <tr>
        <th width="80">First Name</th>
        <th width="120">Last Name</th>
        <th width="120">Email Id</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${model.userList}" var="user">
        <tr>
            <td>${user.fname}</td>
            <td>${user.lname}</td>
            <td>${user.email}</td>
            <td><a href="<c:url value='get?id=${user.uid}'/>">Edit</a></td>
            <td><a href="<c:url value='delete?id=${user.uid}'/>">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
<a href="index.jsp">Back to Home page</a>
</body>
</html>