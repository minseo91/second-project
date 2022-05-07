<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안다미로_로그인</title>
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

input[type="text"], input[type="password"] {
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

input[type="text"]:focus, input[type="password"]:focus {
	-webkit-box-shadow: none;
	box-shadow: none;
	outline: none;
}

input:focus::-webkit-input-placeholder {
	color: transparent;
}
</style>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
	function saveToDos(token) { // item을 localStorage에 저장 
		typeof (Storage) !== 'undefined'
				&& sessionStorage.setItem('AccessKEY', JSON.stringify(token));
	}

	// SDK 초기화, 사용할 앱의 JavaScript 키 입력 
	Kakao.init('09849bf089720853454c142511d3ca09');

	// 로그인 
	function loginWithKakao() {
		Kakao.Auth.login({
			scope: 'profile_nickname, account_email, age_range, birthday',
			success : function(response) {
				saveToDos(resposne.access_token) // 로그인 성공시 사용자 엑세스 토큰을 sessionStorage에 저장
				window.Kakao.API.request({ // 사용자 정보 가져오기 
					url: '/v2/user/me',
					success: (res) => {
						const kakao_account = res.kakao.account;
						window.location.href('index.jsp')
					}
				})
			},
			fail : function(err) {
				alert(JSON.stringify(err))
			},
		})
	}

	Kakao.Auth.createLoginButton({
				container : '#kakao-login-btn',
				success : function(authObj) {
					Kakao.API
							.request({
								url : '/v2/user/me',
								success : function(res) {
									alert(JSON.stringify(res))
								},
								fail : function(error) {
									alert('login success, but failed to request user information: '
											+ JSON.stringify(error))
								},
							})
				},
				fail : function(err) {
					alert('failed to login: ' + JSON.stringify(err))
				},
			})

	// 로그아웃 
	function kakaoLogout() {
		if (!Kakao.Auth.getAccessToken()) {
			alert('Not logged in.')
			return

		}
		Kakao.Auth.logout(function() {
			alert('logout ok\naccess token -> ' + Kakao.Auth.getAccessToken())
		})
	}
	
	// 로그인 후 뒤로갔을때 로그인창 안뜨게하기
 	function noBack() {
		window.history.forward();
	} 

</script>
</head>
<body onload="noBack()" onpageshow="if(event.persisted) noBack();" onunload="">
	<jsp:include page="../common/header.jsp" />
	<h1>로그인</h1>
	<p>
	<p>
	<p>
	<p>
	<div class="col-sm-6, container">
		<form method="post" action="${path}/front">

			<div class="m-3">
				<h6>아이디</h6>
				<input type="text" name="id" placeholder="아이디를 입력해주세요." required="required">
				<p>
				<h6>비밀번호</h6>
				<input type="password" name="pwd" placeholder="비밀번호를 입력해주세요." required="required">
			</div>

			<p>
			<p>
			<p>
			<p>
			<p>
			<div class="m-5">
		<!-- 		<a id="custom-login-btn" href="javascript:loginWithKakao()"> <img
					src="../img/kakao_login_medium_wide.png" width="300"
					alt="카카오 로그인 버튼" />
				</a> -->
				<p>
				<p>
					<input class="w-25 btn btn-dark" type="submit" value="로그인">
					<input type="hidden" name="key" value="user" />
					<!-- Controller를 찾는 정보 -->
					<input type="hidden" name="methodName" value="login" />
					<!-- 메소드이름 -->
				<p>
			</div>
		</form>
		<div class="m-5">
			<input class="w-25 btn btn-dark" type="button" value="회원가입"
				onclick="location.href='join.jsp'">
		</div>
		<p>

			<!-- <button class="api-btn" onclick="kakaoLogout()">로그아웃</button> -->
		<p>
		<div class="m-5">
			<a href="idFind.jsp" style="text-decoration: none;">아이디 찾기</a>
			<p>
			<p>
				<a href="pwdFind.jsp" style="text-decoration: none;">비밀번호 찾기</a>
			<p>
		</div>

	</div>
	<p>





		<%-- 	<div class="jumbotron">
		<h1>Login</h1>
		<p>Login, AOP/HttpSession</p>
		<p>
			<a class="btn btn-primary btn-lg">Learn more</a>
		</p>
	</div>

	<c:choose>
	<c:when test="${empty loginUser}">
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/front">
			<input type="hidden" name="key" value = "user" /> <!-- Controller를 찾는 정보 -->
			<input type="hidden" name="methodName" value = "login" />  <!-- 메소드이름 -->
			<fieldset>
				<legend>Login</legend>
				<div class="form-group">
					<label for="userId" class="col-lg-2 control-label">User Id</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="userId" name="userId"
							placeholder="userId">
					</div>
				</div>
				<div class="form-group">
					<label for="pwd" class="col-lg-2 control-label">Password</label>
					.<div class="col-lg-10">
						<input type="password" class="form-control" id="pwd" name="pwd"
							placeholder="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button class="btn btn-default">Cancel</button>
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>
			</fieldset>
		</form>
	</c:when>
	<c:otherwise>
			<legend>Login</legend>
			<blockquote>
				<p>My Shopping Mall!</p>

				<div class="alert alert-dismissible alert-warning">
					<button type="button" class="close" data-dismiss="alert">Ã</button>
					<h4>Welcome!</h4>
					<p>
						<a href="#" class="alert-link">${loginUser} / ${loginName}</a>.
					</p>
				</div>
			</blockquote>
	</c:otherwise>
</c:choose> --%>

		<jsp:include page="../common/footer.jsp" />
</body>