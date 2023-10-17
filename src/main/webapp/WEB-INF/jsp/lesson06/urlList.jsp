<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과페이지</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>no</th>
			<td>${url.id}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${url.name}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${url.address}</td>
		</tr>

	</table>
</body>
</html>