<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/commons/header.jsp" />

<div class="container main-container">
	<h3>Welcome, ${userName}</h3>
	<div class="row">
		<div class="col-md-4">
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Name</th>
				</tr>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.productDTOId}</td>
						<td>${product.productName}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div class="col-md-6">
		<p>Add product</p>
		<form action="insert" method="post">
			<p>
				<input type="text" name="productName">
				<button type="submit" class="btn btn-primary" value="insert">Add product</button>
			</p>
		</form>
		</div>

		<div class="col-md-6">
		<p>Delete product</p>
		<form action="delete" method="post">
			<select name="productId">
				<c:forEach items="${products}" var="product">
					<option value="${product.productDTOId}">${product.productName}</option>
				</c:forEach>
			</select> 
			<button type="submit" class="btn btn-primary" value="delete">Delete product</button>
		</form>
		</div>
</div>
</div>

<jsp:include page="/WEB-INF/views/commons/footer.jsp" />