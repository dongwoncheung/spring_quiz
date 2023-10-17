<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기</title>
<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- AJAX를 사용하려면 반드시 jquery 원본 필요 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기</h1>
		
		<%--<form method="post" action="/lesson06/ex01/add-user"> --%>
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" id="title" name="title" class="form-control col-3">
			</div>
			<div class="form-group">
				<label for="address">주소</label>
				<input type="text" id="address" name="address" class="form-control col-3">
			</div>
			
			
			<!-- <input type="submit" class="btn btn-success" value="추가"> -->
			<%-- ★★★ AJAX 통신일 때는 반드시 button 타입으로 지정한다!!! --%>
			<input type="button" id="joinBtn" class="btn btn-success" value="추가">
		<%--</form>  --%>
	</div>
	
<script>
$('#joinBtn').on('click', function() {
	//alert("버튼 클릭");
	
	// validation check
	let name = $("#title").val().trim();
	if (name == "") {
		//alert("이름을 입력하세요");
		return; 
	}
	
	let yyyymmdd = $('#address').val().trim();
	if (yyyymmdd.length < 1) {
		//alert("생년월일을 입력하세요");
		return; 
	}
	
	
	
	console.log(name);
	console.log(address);
	
	// AJAX: 서버 요청
	$.ajax({
		// request
		type:"POST"
		, url:"/lesson06/ex01/add-user"
		, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce} // JSON String
		
		// response
		// call back 함수
		, success:function(data) { // data: response 결과 응답
			// 서버 처리 후 에러가 없을 때 수행됨
			//alert(data);
			if (data == "성공") {
				location.href = "/lesson06/quiz01/url-list-view";
			}
		}
		, complete:function(data) {
			// 성공이든 실패든 무조건 불려짐 => 안 씀!!
			alert(data);
		}
		, error:function(request, status, error) {
			// 에러일 때 수행됨 (400, 500...)
			alert(request);
			alert(status);
			alert(error);
		}
	});
</script>
</body>
</html>