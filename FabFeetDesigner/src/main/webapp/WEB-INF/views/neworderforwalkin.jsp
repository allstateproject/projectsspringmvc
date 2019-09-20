<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BillingForWalkin" method="POST">
Order Date : <input type="text" name="orderDate" ><br/>
Payment Type : <input type="text" name="paymentType" ><br/>
Total Qty : <input type="number" name="totalqty" ><br/>
Total Cost : <input type="number" name="totalcost" ><br/>
<input type="submit" value="Submit" >
<form>
</body>
</html>