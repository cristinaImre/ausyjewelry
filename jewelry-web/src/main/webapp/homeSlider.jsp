<div class="row">
<div class="col-md-12">
			<div class="slider-home">
				<img class="mySlides" src="${pageContext.request.contextPath}/resources/img/slider1.jpg" style="width: 100%"> 
				<img class="mySlides" src="${pageContext.request.contextPath}/resources/img/slider2.jpg" style="width: 100%"> 
				<img class="mySlides" src="${pageContext.request.contextPath}/resources/img/slider3.jpg" style="width: 100%">
				<img class="mySlides" src="${pageContext.request.contextPath}/resources/img/slider4.jpg" style="width: 100%">
			</div>

			<script>
				var myIndex = 0;
				carousel();
				function carousel() {
					var i;
					var x = document.getElementsByClassName("mySlides");
					for (i = 0; i < x.length; i++) {
						x[i].style.display = "none";
					}
					myIndex++;
					if (myIndex > x.length) {
						myIndex = 1
					}
					x[myIndex - 1].style.display = "block";
					setTimeout(carousel, 2000); // Change image every 2 seconds
				}
			</script>
			</div>

</div>