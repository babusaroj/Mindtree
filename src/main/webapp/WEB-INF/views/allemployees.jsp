<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
    <h2>List of Employees</h2>  
    <table border="1">
        <tr>
            <td>ID</td><td>NAME</td><td>Salary</td><td>Department ID</td><td>Department Name</td>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
            <td><a href="<c:url value='/edit-${employee.employeeId}-employee' />">${employee.employeeId}</a></td>
            <td>${employee.name}</td>
            <td>${employee.salary}</td>
            <td>${employee.department.departmentId}</td>
            <td>${employee.department.departmentName}</td>
            <td><a href="<c:url value='/delete-${employee.employeeId}-employee' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
	<a href="<c:url value='/addEmploye' />">Add New Employee</a>
	<br/>
    <br/>
	  Go back to <a href="<c:url value='/' />">Home Page </a>
</body>
</html>