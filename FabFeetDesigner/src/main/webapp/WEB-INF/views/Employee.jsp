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
<div style="background-color:#0000; border:">
<h2>All the Details of an Employee</h2>
    
      <table border="1">
      <tr>
      <th>Employee Id</th>
      <th>DOJ</th>
      <th>DOL</th>
      <th>Shop Name</th>
      <th>Age</th>
      <th>Designation</th>
      <th>Salary</th>
      <th>Leaves</th>
      <th>Leaves Avail.</th>
      <th>Manager</th>
      
     
     
      </tr>
      <tr>
          <c:forEach items="${listemployee}" var="e">
            <tr>
                  <td>${e.empId} </td>
                  <td>${e.doj} </td>
                  <td>${e.dol} </td>
                  <td>${e.shop} </td>
                   <td>${e.age} </td>
                    <td>${e.desgination} </td>
                     <td>${e.salary} </td>
                      <td>${e.leaves} </td>
                       <td>${e.leaveAvailable} </td>
                       <td>${e.manager} </td>
                       
                  <td>edit</td>
                  <td>delete</td>
      </tr>
    
      </c:forEach>
      </table>
</center>

</form>

</body>
</html>