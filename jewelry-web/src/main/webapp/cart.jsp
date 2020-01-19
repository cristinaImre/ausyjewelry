<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/commons/header.jsp" />


<div class="container main-container">
	<h3>${userName}, your shopping cart:</h3>
	<div class="row">
		<div class="col-md-4">
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
				<c:forEach items="${cart}" var="product">
					<tr>
						<td>${product.productDTOId }</td>
						<td>${product.productName }</td>
						<td>1</td>
						<td>55$</td>
				</c:forEach>
			</table>
			<br> <a href="${pageContext.request.contextPath }/products.jsp">Continue
				Shopping</a>
			<form action="logout" method="post">
				<button type="submit" class="btn btn-primary" value="logout">Logout</button>
			</form>	
		</div>
</div>
</div>
<jsp:include page="/WEB-INF/views/commons/footer.jsp" />