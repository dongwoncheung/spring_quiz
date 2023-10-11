<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
    <style>
        .vip { color: red; }
        .gold { color: yellow; }
        .high-points { color: blue; }
    </style>
    <title>멤버쉽</title>
</head>
<body>
<div class="container">
    <h1>멤버쉽</h1>
    <table class="table">
        <thead>
        <tr>
            <th>이름</th>
            <th>전화번호</th>
            <th>등급</th>
            <th>포인트</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${membership}" var="membership">
                <tr>
                    <td>${membership.name}</td>
                    <td>${membership.phoneNumber}</td>
                    <td>
                    	<c:choose>
                    		<c:when test="${membership.grade == 'VIP'}">vip</c:when>
                    		<c:when test="${member.grade == 'GOLD'}">gold</c:when>
                    	</c:choose>
                    	${member.grade}
                    
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${membership.point >= 5000}">high-points</c:when>
                    	</c:choose>
                    	${member.point}
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


