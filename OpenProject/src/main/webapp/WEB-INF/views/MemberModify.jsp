<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
<h2>회원가입</h2>
<hr>
<form method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>아이디(이메일)</td>
			<td><input type="text" name="userID" value="${memberInfo.userID }"	readonly="readonly"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPW"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<td>사진</td>
			<td><input type="file" name="photoFile"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>
