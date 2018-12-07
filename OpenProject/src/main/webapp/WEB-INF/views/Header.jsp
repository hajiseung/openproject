<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bitcamp.OpenProject.member.model.*"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/OpenProjectCss.css">
<h1 class="title">Open Project</h1>
<ul id="gnb">
	<li><a href="<%=request.getContextPath()%>/">Home</a></li>
	<li><a href="<%=request.getContextPath()%>/MemberRegForm">회원가입</a></li>
	<%
		MemberInfo lid = (MemberInfo) request.getSession(false).getAttribute("logininfo");
		if (lid == null) {
	%>
	<li><a href="<%=request.getContextPath()%>/LoginForm">로그인</a></li>
	<%
		} else {
	%>
	<li><a href="<%=request.getContextPath()%>/Logout">로그아웃</a></li>
	<%
		}
	%>
	<li><a href="<%=request.getContextPath()%>/mypage">마이페이지</a></li>
	<li><a href="<%=request.getContextPath()%>/MemberList">회원리스트</a></li>
	<li><a href="<%=request.getContextPath()%>/guestbook/GuestBookList">방명록보기</a></li>
	<li><a href="<%=request.getContextPath()%>/guestbook/GuestBookWrite">방명록쓰기</a></li>
</ul>
