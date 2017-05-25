<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <h2>List of Department</h2>  
    <table border="1">
        <tr>
            <td>Department ID</td><td>Department Name</td><td></td>
        </tr>
        <c:forEach items="${department}" var="department">
            <tr>
            <td><a href="<c:url value='/edit-${department.departmentId}-department' />">${department.departmentId}</a></td>
            <td>${department.departmentName}</td>
            <td><a href="<c:url value='/delete-${department.departmentId}-department' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
	<a href="<c:url value='/addDepartment' />">Add New Department</a>
	<br/>
    <br/>
    Go back to <a href="<c:url value='/' />">Home Page </a>
</body>
</html>