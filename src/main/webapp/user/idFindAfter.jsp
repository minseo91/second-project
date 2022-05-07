<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1 {
	text-align: center;
	padding: 30px;
}

div {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<h1>아이디 찾기 결과</h1>
	<div></div>
	<div class="col-sm-6, container">
		<div class="m-5">
			<input class="w-25 btn btn-dark" type="button" value="로그인하러가기"
				onclick="location.href='user/login.jsp'">
		</div>
	</div>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>