<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 	<%@ page import="org.codehaus.jettison.json.JSONArray" %> 
<%@ page import="org.codehaus.jettison.json.JSONObject" %>
<%@ page import="java.util.List" %>
<%@ page import="ro.ausy.jewelry.commons.dto.ProductDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
		String username = (String) session.getAttribute("userName");
		List<ProductDTO> products = (List<ProductDTO>) session.getAttribute("product");
	%>
	<p>
		Welcome
		<%=username%></p>
	
	<br><br>
	<form action="product" method="post">
		Jewelry: <input type="text" name="new jewelry"><br>
		Products: <select productName="productName">
					<tr>
    					<td><input type="ring" name="list" value="DiamondRing">DiamondRing <button>delete</button></td>
					</tr>
					<tr>
    					<td><input type="ring" name="list" value="AmethistRing">AmethistRing <button>delete</button></td>
					</tr>
					<tr>
    					<td><input type="ring" name="list" value="PearlRing">PearlRing <button>delete</button></td>
					</tr>
		</select>
		<br><input type="submit" name="add" value="add">
	</form>

</body>
</html>