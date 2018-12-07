<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/Header.jsp"%>
	<form method="post">
		이름: <input type="text" name="guestName" value="${logininfo.userID}" readonly/> <br /> 
		암호: <input	type="password" name="password" /> <br /> 
		메시지:<textarea name="message" cols="30"  rows="5"></textarea><br /> 
		<input type="submit" value="메시지 남기기" />
	</form>	
</body>
</html>