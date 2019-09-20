<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h4>List Of Employees</h4>
${listemployee}
<table>
<tr>
	<th>EmpId </th>
	<th>Name </th>
	<th>DOJ </th>
	<th> DOL </th>
</tr>
<c:if test="${llistemployee}">
	 <c:forEach items="${listemployee}" var="p">
<tr>
	<td> ${p.empId }</td>
	<td> ${p.username }</td>
	<td> ${p.doj }</td>
	<td> ${p.dol }</td>
</tr>
</c:forEach>
	 </c:if>
	 
</table>

</body>
</html>