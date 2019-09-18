<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<form action="customer/customersignup">
<div style="background-color:#08A5F9; border:3px solid blue">
<h2>Fill All The Details Correctly</h2>
&nbsp;&nbsp;Customer Name:<input type="text" name="customerName" style="margin:20px"><br/><br/>
&nbsp;&nbsp;Username:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="customerUserName" style="margin:20px"><br/><br/>
&nbsp;&nbsp;Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="customerPassword" style="margin:20px"><br/><br/>
&nbsp;&nbsp;PhoneNumber:&nbsp;<input type="text" name="customerPhoneNumber" style="margin:20px"><br/><br/>
&nbsp;&nbsp;Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="customerAddress" style="margin:20px"><br/>
<input type="submit" value="Submit" style="width:80px;margin:20px">
</center>

</form>
</body>
</html>