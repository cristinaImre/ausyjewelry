<jsp:include page="/WEB-INF/views/commons/header.jsp" />

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
		List<ProductDTO> products = (List<ProductDTO>) session.getAttribute("products");
	%>
	<p>
		Welcome
		<%=username%></p>
	
	<br><br>
<!-- 	<form action="product" method="post"> -->
	
	<table>
	
		<h1>Ausy Jewelry AJ</h1>

	
		<%
		int var = 0;
		for(ProductDTO productDTO : products) {
		%>
		<tr>
			<td><%=++var %></td> 
<%-- 			<td><%=productDTO.getProductDTOId() %></td>  --%>
			<td><%=productDTO.getProductName() %></td>
		</tr>
		<%
		}
		%>
	</table>
	
	<p>Add to shopping bag</p>
	<form action="select" method="post">
		<tr>
    		<td><input type="text" name="product"><button value="select">add</button></td> 
		</tr><br> 
	</form>
	
</body>
</html>

<jsp:include page="/WEB-INF/views/commons/footer.jsp" />