<!-- jsp:include page="/WEB-INF/views/commons/header.jsp" -->
<div>
	<form action="login" method="POST">
	
		Please enter your username
		<input type="text" name="username" placeholder="Username"/><br>
		
		Please enter your password
		<input type="password" name="password" placeholder="Password"/> 
		
		<button type="submit" class="btn btn-primary" value="Login">Login</button>
	</form>
</div>

<jsp:include page="/WEB-INF/views/commons/footer.jsp" />