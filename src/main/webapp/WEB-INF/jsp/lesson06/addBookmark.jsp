<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- jquery는 원본으로 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control">
		</div>
		<div class="form-group">
			<label for="url">URL</label>
			<div class="d-flex"><!-- class="form-inline" -->
				<input type="text" id="url" class="form-control col-11">
				<button type="button" id="urlCheckBtn" class="btn btn-info">중복확인</button>
			</div>
			<small id="duplicatedTest" class="text-danger d-none">중복된 url입니다</small>	
			<small id="availableTest" class="text-success d-none">저장가능한url입니다</small>	
			
		
		<button type="button" id="addBtn" class="btn btn-success btn-block"><!-- w-100을넣어도 크기가 늘어난다 -->추가</button>
	</div>
<script>
$(document).ready(function() {
	// Quiz2) 중복확인 버튼 클릭
	$('#urlCheckBtn').on('click', function() {
		// alert("클릭");
		//validation
		let url = $('#url').val().trim();// 변수 선언 !! + value확인 + 앞뒤.여백을 없앤다
		if (!url) {
			alert("검사할 url을 입력하세요.");
			return;
		}
		
		// DB에서 URL 중복확인 -AJAX 통신
		$.ajax({
			// request
			type:"POST" // url이 길 수 있어서
			, url:"/lesson06/quiz02/is-duplicated-url"
			, data:{"url":url}
			
			// response
			, success:function(data) { // data JSON=>dictionary
				// {"code":200, "is_duplication":true}   true:중복
				if (data.is_duplication) {
					// 중복
					$('#duplicatedText').removeClass('d-none');
					$('#availableText').addClass('d-none');
				} else {
					// 중복 아님
					$('#duplicatedText').addClass('d-none');
					$('#availableText').removeClass('d-none');
				}
			}
			, error:function(request, stutus, error) {
				alert("중복확인에 실패했습니다.");
			}
		});
	});
	
	// quiz01) 추가 버튼 클릭
	$('#addBtn').on('click', function() {
		//alert("클릭");
		
		// validation
		// 모든항목들을 가지고 validation check
		let name = $('#name').val().trim();
		let url = $('#url').val().trim();
		
		console.log(name);
		console.log(url);
		
		if (!name) {
			alert("제목을 입력하세요.");
			return;
		}
		
		if (!url) {
			alert("주소를 입력하세요.");
			return;	
		}
		
		if (url.startsWith("http://") == false && 
				url.startsWith("https://") == false) {
			alert("주소 형식이 잘못 되었습니다.");
			return;
		}
		// AJAX 통신  -> 브라우저가하는 처리를 내가 답하는것
		 $.ajax({
			// request
			type:"POST"
			, url:"/lesson06/quiz01/add-bookmark"
			, data:{"name":name, "url":url}
			
			// response
			, success:function(data) { // data: response 응답값(JSON String)/ => Dictionary Object
				// data는 JSON String => Object 변환된 형태로 사용할 수 있다.
				// jquery의 ajax 함수 기능
				//if(data == "성공"){
				//	location.href="/lesson06/quiz01/bookmark-list-view"
				//}
				
			    alert(data.code);
				alert(data.result); 
				
				 if (data.result == "success") {
					location.href = "/lesson06/quiz01/bookmark-list-view";
				}
			}
			, error:function(request, status, error) {
				alert("추가에 실패했습니다. 관리자에게 문의해주세요.");
			}  
		}); 
		// Quiz02) 저장 가능한 URL인지 체크
		if ($('#availableText').hasClass('d-none')) { // availableText d-none이 있으면 가입 불가
			alert("URL 중복확인을 다시 해주세요.");
			return;
		}
		
		
	});
});
</script>
</body>
</html>	



