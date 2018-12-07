<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Title</title>
<style>
#memberPhoto {
	background-image:
		url('<%=request.getContextPath()%>/uploadfile/userphoto/${logininfo.userPhoto}');
	background-size: 100%;
	width: 150px;
	height: 150px;
	border: 1px solid #000000;
	border-radius: 75px;
	margin: 20px 0;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/Header.jsp"%>
	<div class="content">
		<h2>회원정보</h2>
		<div id="memberPhoto"></div>
		<hr>

		<table>
			<tr>
				<%--session에 저장된 member객체 user를 통해 id값, name값 가져옴--%>
				<td>id : ${logininfo.userID}</td>
			</tr>
			<tr>
				<td>이름 : ${logininfo.userName}</td>
			</tr>
			<tr>
				<td>사진 : ${logininfo.userPhoto}</td>
			</tr>

		</table>

	</div>
</body>
</html>