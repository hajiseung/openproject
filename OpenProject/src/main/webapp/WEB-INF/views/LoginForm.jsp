<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
<div id="contents">
	<h2>로그인</h2>
	<hr>
	<form method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userID"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPW"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
</div>