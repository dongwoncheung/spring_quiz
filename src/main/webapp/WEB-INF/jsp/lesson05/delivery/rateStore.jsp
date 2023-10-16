<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<title>배탈의 민족</title>
</head>
<body>
	<div class="container">
		<header>
			<div class="logo d-flex justify-content-left mt-3 text-white text-bold bg-secondary">
				<h3>배탈의 민족</h3>
			</div>
		</header>
		<section>
			<c:forEach items="${store}" var="store1">
				<div>
					<h1>배달삼겹-리뷰</h1>
				<div id='no1'>
  					${store1.name}
  					${store1.phoneNumber }
  					${store1.address }
				</div>
				<div id='no1'>
  					${store1.name}
  					${store1.phoneNumber }
  					${store1.address }
				</div>
				<div id='no1'>
  					${store1.name}
  					${store1.phoneNumber }
  					${store1.address }
				</div>
				<div id='no1'>
  					${store1.name}
  					${store1.phoneNumber }
  					${store1.address }
				</div>
				<div id='no1'>
  					${store1.name}
  					${store1.phoneNumber }
  					${store1.address }
				</div>
				<div id='no1'>
  					${store1.name}
  					${store1.phoneNumber }
  					${store1.address }
				</div>
				<div id='no1'>
  					${store1.name}
  					${store1.phoneNumber }
  					${store1.address }
				</div>
				<div id='no1'>
  					${store1.name}
  					${store1.phoneNumber }
  					${store1.address }
				</div>
			</c:forEach>	
			
			</div>
		</section>
		<footer>
			(주)우와한 형제
			고객센터 : 1500-1500
		</footer>
	</div>
</body>
</html>