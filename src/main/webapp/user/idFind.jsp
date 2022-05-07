<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

h6 {
	color: #9D8FFA;
}

div {
	text-align: center;
}

input[type="text"]{
	background: transparent;
	border: none;
	border-bottom: 1px solid #000000;
	-webkit-box-shadow: none;
	box-shadow: none;
	border-radius: 0;
	text-align: center;
	color: gray;
	width: 250px;
	padding: 10px;
}

input[type="text"]:focus {
	-webkit-box-shadow: none;
	box-shadow: none;
	outline: none;
}

input:focus::-webkit-input-placeholder {
	color: transparent;
}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<h1>아이디 찾기 </h1>
	<p>
	<p>
	<p>
	<p>
	<div class="col-sm-6, container">
		<form method="post" action="${path}/front" name="idFind">

			<div class="m-3">
				<h6>이름</h6>
				<input type="text" name="name" placeholder="이름을 입력해주세요.">
				<p>
				<h6>전화번호</h6>
				<input type="text" name="phone" placeholder="전화번호를 입력해주세요.">
				<p>
				<h6>이메일</h6>
				<input type="text" name="email" placeholder="이메일을 입력해주세요.">
			</div>

			<p>
			<p>
			<p>
			<p>
			<p>
			<div class="m-5">
					<input type="hidden" name="key" value="user">
					<input type="hidden" name="methodName" value="idFind">
					<input class="w-25 btn btn-dark" type="submit" value="아이디 찾기">
				<p>
			</div>
		</form>
		<div class="m-5">
			<input class="w-25 btn btn-dark" type="button" value="로그인 페이지로 이동" onclick="location.href='login.jsp'">
		</div>
		<p>
	</div>
	<p>
	

<jsp:include page="../common/footer.jsp" />
</body>
</html>