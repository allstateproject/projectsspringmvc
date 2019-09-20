<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1 style="padding-top:50px">Expense Entries</h1></center>

	
<center>

<form style="margin-top:20px;width:400px;border:4px solid white;background-color:red;" action="Expense">
		 &nbsp; &nbsp;Expense Type: <input type="text" name="expenseType" style="margin: 30px; width: 200px;"><br/>
	 	 &nbsp; &nbsp;Expense Amt:  <input type="text" name="expenseAmount" style="margin:30px; width:200px"><br/>
	 	  &nbsp; &nbsp;Expense Date :  <input type="text" name="expenseDate" style="margin:30px; width:200px"><br/>
	 	 <input type="submit" value="Enter Data" style="border:2px solid blue;margin-bottom:20px;width:100px;height:30px">
</form>
</body>
</html>