
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" isELIgnored="false" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="margin-left:20px;width:900px;background-color:#08A5F9">
<p style="color:white" align="right">${customer.customerUserName}&nbsp; ${customer.customerId }</p>
<a href="#" style="height:20px;width:130px;padding-left:10px;background-color:white;text-decoration:none;color:black">Products</a>

<a href="#" style="height:20px;width:130px;padding-left:10px;background-color:white;text-decoration:none;color:black">My Orders</a>
<a href="#" style="height:20px;width:130px;padding-left:10px;background-color:white;text-decoration:none;color:black">Change Address</a>
<a href="#" style="height:20px;width:130px;padding-left:10px;background-color:white;text-decoration:none;color:black">Change Password</a>
<a href="#" style="height:20px;width:130px;padding-left:10px;background-color:white;text-decoration:none;color:black">Change Ph No</a>
</br><br/>

<table align="center" style="background-color:white;width:500px">
<tr style="height:60px">
<th>Hi ${customer.customerName}</th>
</tr>
<tr style="height:60px" align="center"><td>PhoneNumber: ${customer.customerPhoneNumber}</td></tr>
<tr style="height:60px" align="center"><td>Address: ${customer.customerAddress}</td></tr>
</table>


</body>
</html>