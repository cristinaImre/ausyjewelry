<!-- jsp:include page="/WEB-INF/views/commons/header.jsp" -->

<div class="container main-container">
<div>
	<form action="login" method="POST">
	
		Please enter your username
		<input type="text" name="username" placeholder="Username"/><br>
		
		Please enter your password
		<input type="text" name="password" placeholder="Password"/> 
		
		<input type="submit" name="submit" value="Login">
	</form>
</div>

<jsp:include page="/WEB-INF/views/commons/footer.jsp" />