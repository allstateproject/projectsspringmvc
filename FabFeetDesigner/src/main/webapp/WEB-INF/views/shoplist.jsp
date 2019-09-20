<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoplist</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	${message}
	<table border="1">
		<tr>
			<th>ShopId</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${shops}" var="s">
			<tr>
				<td>${s.shopId}</td>
				<td>${s.address}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>