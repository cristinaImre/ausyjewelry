<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/commons/header.jsp" />

<div class="container main-container">
	<h3>Welcome, ${userName}</h3>
	<div class="row">
		<div class="col-md-6">
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Buy</th>
				</tr>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.productDTOId}</td>
						<td>${product.productName}</td>
						<td><a href="${pageContext.request.contextPath }/cart?&action=buy&productId=${product.productDTOId}">Buy</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-md-6" id="imgProducts">
			<img src="${pageContext.request.contextPath}/resources/img/audrey.png" style="width: 100%"> 
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/commons/footer.jsp" />