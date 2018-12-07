<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../Header.jsp"%>
<div>
	<table>
		<tr>
			<td>글 번호</td>
			<td>글쓴이</td>
			<td>글 내용</td>
		</tr>
		<tr>
			<td>${message.id }</td>
			<td>${message.guestName }</td>
			<td>${message.message }</td>
		</tr>
	</table>
</div>
