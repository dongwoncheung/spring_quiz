<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- jquery는 원본으로 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		
		<table class="table text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bookmarkList}" var="bookmark">
				<tr>
					<td>${bookmark.id}</td>
					<td>${bookmark.name}</td>
					<!-- target="_blank => 새탭으로 사이트를 들어가게 해주는 문법 -->
					<td><a href="${bookmark.url}" target="_blank">${bookmark.url}</a></td><!--  선택시 원하는 주소로 이동 -->
					<td>
						<%-- 1) value 속성을 이용해서 값 세팅 --%>
						<%-- <button type="button" class="del-btn btn btn-danger" value="${bookmark.id}">삭제</button> --%>
						
						<%-- 2) data를 이용해서 태그에 값 세팅: 대문자 X --%>
						<button type="button" class="del-btn btn btn-danger" data-bookmark-id="${bookmark.id}">삭제</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
<script>
 $(document).ready(function() {
	// 삭제 버튼 클릭
	$(".del-btn").on('click', function(e) {
		//alert("삭제");
		
		//---- value---
		// 1)
		//let id = $(this).val();
	
		// 2)
		// let id = e.target.value;
		
		//---- data---
		// data-bookmark-id    => data("bookmark-id") 함수 사용
		let id = $(this).data('bookmark-id');
		//alert(id);
		
		$.ajax({
			// request
			type:"DELETE"
			, url:"/lesson06/quiz02/delete-bookmark"
			, data:{"id":id}
			
			// response
			, success:function(data) {
				// if (data.result == "성공") {
				if (data.code == 200) {
					location.reload(true); // 새로고침
				} else {
					alert("삭제를 하는데 실패했습니다. 다시 시도해주세요.");
				}
			}
			, error:function(request, status, error) {
				alert("삭제를 하는데 실패했습니다. 관리자에게 문의해주세요.");
			}
		});
	});
}); 
</script>
</body>
</html>
