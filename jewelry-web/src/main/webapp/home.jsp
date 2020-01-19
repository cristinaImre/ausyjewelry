<jsp:include page="/WEB-INF/views/commons/header.jsp" />
<body>
	<div class="container main-container">
		<div class="row">
			<div class="col-md-8" id="message">
				<p>We are all stars and we deserve to twinkle</p>
			</div>
			<div class="col-md-4" id="login"><%@ include file="login.jsp"%></div>
		</div>
		<br>
		<div class="row">
		 <%@ include file="homeSlider.jsp"%>
		</div>
	</div>
</body>

<jsp:include page="/WEB-INF/views/commons/footer.jsp" />