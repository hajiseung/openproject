<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#list {
	border: 1px solid black;
}

#tr {
	border-bottom: 1px solid black;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/Header.jsp"%>

	<table id="list">
		<tr id="tr">
			<td>회원 ID</td>
			<td>회원 이름</td>
			<td>회원 사진</td>
		</tr>
		<c:if test="${!memberList.isEmpty() }">
			<c:forEach var="memberlist" items="${memberList }">
				<tr>
					<td>${memberlist.userID }</td>
					<td>${memberlist.userName}</td>
					<td>${memberlist.userPhoto}</td>
					<td><img src="<%=request.getContextPath()%>/uploadfile/userphoto/${memberlist.userPhoto}"/></td>
					<td><a href="MemberModify/${memberlist.userID }">[수정하기]</a></td>
					<td><a href="MemberDelete?id=${memberlist.userID }">[삭제하기]</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>