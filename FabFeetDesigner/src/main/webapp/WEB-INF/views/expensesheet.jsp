<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        
      <table border="1">
      <tr>
      <th>ExpenseId</th>
      <th>Expense Type</th>
      <th>Expense Amount</th>
      <th>Expense Date</th>
      
     
     
      </tr>
      <tr>
          <c:forEach items="${listexpense}" var="e">
            <tr>
                  <td>${e.expenseId} </td>
                  <td>${e.expenseType} </td>
                  <td>${e.expenseAmount} </td>
                  <td>${e.expenseDate} </td>
                  
                  <td>edit</td>
                  <td>delete</td>
      </tr>
    
      </c:forEach>
      </table>
</body>
</html>