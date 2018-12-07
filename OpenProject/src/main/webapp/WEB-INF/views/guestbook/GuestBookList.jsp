<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#Messageblock>ul {
	border: 1px solid black;
	width: 200px;
	margin : 1px;
}</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/Header.jsp"%>
	<c:if test="${!viewData.isEmpty()}">
		<c:forEach var="message" items="${viewData.messageList }">
			<div id="Messageblock">
				<ul>
					<li>${message.id }</li>
					<br>
					<li>${message.guestName }</li>
					<br>
					<li>${message.message }</li>
					<br>
					<a href="GuestBookView/${message.id }">[상세보기]</a>
					<a href="GuestBookDelete?id=${message.id }">[삭제하기]</a>
				</ul>
			</div>
		</c:forEach>
	</c:if>

	<c:forEach var="num" begin="1" end="${viewData.pageTotalCount }">
		<a href="GuestBookList?page=${num }">[${num }]</a>

	</c:forEach>
</body>
</html>