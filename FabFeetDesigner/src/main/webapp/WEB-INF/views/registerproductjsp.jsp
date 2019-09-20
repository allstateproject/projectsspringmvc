<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
Product ID:<br>
<input type="text" name="productId" id="a"><br>
Product Design Number:<br>
<input type="text" name="productDesignNumber" id="a"><br>
Product Name:<br>
<input type="text" name="productName" id="a"><br>
Product Category:<br>
<select name="products">
  <option value="shoes">Shoes</option>
  <option value="bags">Bags</option>
  <option value="apparels">Apparels</option>
</select><br>
Product Size:<br>
<select name="size" size="3">
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>

</select>
<h3>Product Quantity:</h3><br>
Quantity (between 1 and 50):
<input type="number" name="quantity" min="1" max="50"><br>
<input type="submit" value="Submit">
<br>
Shop No:<br>
<select name="shop">
	<option value="shop1">Shop1</option>
	
	<option value="shop2">Shop2</option>
	<option value="shop3">Shop3</option>
	
	<option value="shop4">Shop4</option>
	<option value="shop5">Shop5</option>
	<option value="shop6">Shop6</option>
</select><br>
Product Cost
<input type="text" name="cost"><br>
</form>

</body>
</html>