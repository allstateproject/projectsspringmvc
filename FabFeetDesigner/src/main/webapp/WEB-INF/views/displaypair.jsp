<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

${product}
<table border="1">
	<tr>	
		<th>Product Id</th>
		 <th>design number</th>
		 <th>ProductName</th>
		 <th>Product Category</th> 
		 <th>cost</th>
		 <th>Size</th>
		 <th>Quantity</th>
		 <
	</tr>
	<c:if test="${product}">
	 <c:forEach items="${product}" var="p">
	 <tr>
			 <td> ${p.productId}</td>
			 <td>${p.productDesignNumber}</td>
			 <td>${p.productName}</td>
			 <td>${p.productCategory}</td>
			 <td>${p.productCost}</td> 
			  <td>${p.productSize}</td> 
			 <td>${p.productQuantity}</td> 
			 <td>${p.productImage}</td> 
			  <td><a href="<c url='editProduct/${p.productId}'/>">edit</a></td> 
			  <td>delete</td> 
	 </tr>
	 </c:forEach>
	 </c:if>
	 
</table>
</body>
</html>