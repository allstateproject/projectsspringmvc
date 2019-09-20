<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form>
Customer Id:<br>
<form:input type="text" name="customerId" path="customerId" required/><br>
Customer User Name:<br>
<form:input type="text" name="customerUserName" path="customerUserName" required/><br>
Customer Name:<br>
<form:input type="text" name="customerName" path="customerName" required/><br>
Customer Password:<br>
<form:input type="password" name="customerPassword" required path="customerPassword" maxlength="8" placeholder="less than 9 char"/><br>
Customer Address:<br>
<form:textarea rows="4" cols="50" path="customerAddress" required/><br>
Customer Phone No:<br>
<form:input type="number" name="customerPhoneNumber" required path="customerPhoneNumber" placeholder="only integers"/>
<form:input type="submit" value="Submit" path="submit" />
</form:form> 
</body>
</html>