<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안다미로_회원가입</title>
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

input[type="text"], input[type="email"], input[type="password"] {
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

input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus
	{
	-webkit-box-shadow: none;
	box-shadow: none;
	outline: none;
}

input:focus::-webkit-input-placeholder {
	color: transparent;
}
</style>

<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	// 도로명주소 찾기 
	function findAddr() {
		new daum.Postcode({
			oncomplete : function(data) {

				console.log(data);

				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var jibunAddr = data.jibunAddress; // 지번 주소 변수
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('member_post').value = data.zonecode;
				if (roadAddr !== '') {
					document.getElementById("member_addr").value = roadAddr;
				} else if (jibunAddr !== '') {
					document.getElementById("member_addr").value = jibunAddr;
				}
			}
		}).open();
	}
	
	
	// 회원가입 후 뒤로갔을때 로그인창 안뜨게하기
 	function noBack() {
		window.history.forward();
	} 


	// 유효성 검사! 
	$(function(){
		
		// 아이디 - 영문+숫자만 가능 
		
		
		// 비밀번호 확인 - 영문+숫자포함 8글자 이상 
	    $('#pwd').keyup(function(){
	    	 $('#checkPwd').html('');
	      if($(this).val().length < 8) { // 글자수 
	          $('#pwdInput').html('비밀번호는 영문+숫자를 조합해 8자리 이상 입력해주세요.<br><br>');
	          $('#pwdInput').attr('color', '#f82a2aa3');
	      } else {
	    	  $('#pwdInput').html('사용가능한 비밀번호입니다.');
	    	  $('#pwdInput').attr('color', '#199894b3');
	      }
	    });

	    $('#pwdCheck').keyup(function(){
	        if($('#pwd').val() != $('#pwdCheck').val()){
	          $('#checkPwd').html('비밀번호가 일치하지 않습니다.<br><br>');
	          $('#checkPwd').attr('color', '#f82a2aa3');
	        } else{
	          $('#checkPwd').html('비밀번호가 일치합니다.<br><br>');
	          $('#checkPwd').attr('color', '#199894b3');
	        }
	    });
	    
	    // 주민등록번호 확인 - 숫자만 입력가능하게해야함
	    $('#jumin').keyup(function() {
	    	$('#checkJumin').html('');
	    	
	    	// 글자수 확인 
	    	if($(this).val().length != 14) {
		          $('#checkJumin').html('주민등록번호는 하이픈(-)을 포함해 14자리를 입력해주세요.<br><br>');
		          $('#checkJumin').attr('color', '#f82a2aa3');
	    	} else {
		          $('#checkJumin').html('주민등록번호가 일치합니다.<br><br>');
		          $('#checkJumin').attr('color', '#199894b3');
	    	}
	    });
	    
	    // 연락처 - 숫자+(-)만 가능 
	    
	    
	    // 이메일 확인 - 영문+숫자만 입력가능하게 해야함 
	    $('#email').keyup(function() {
	    	$('#checkEmail').html('');
	    	
	    	// @ 포함 
	    	if($(this).val().indexOf('@') == -1) {
	    		  $('#checkEmail').html('이메일은 @를 포함하여 입력해주세요.<br><br>');
		          $('#checkEmail').attr('color', '#f82a2aa3');
	    	}
	    })
	    
	    
	});

</script>
</head>
<body onload="noBack()" onpageshow="if(event.persisted) noBack();" onunload="">
	<%@include file="../common/header.jsp"%>
	<h1>회원가입</h1>
	<p>
	<p>
	<div class="col-sm-6, container">
		<form name="inForm" id="inForm" method="post" action="${path}/front">

			<div class="m-3">
				<h6>아이디</h6>
				<input type="text" name="id" placeholder="아이디를 입력해주세요." onclick="idCheck()"
					required="required">
				<p>

				<h6>비밀번호</h6>
				<input type="password" name="pwd" id="pwd" placeholder="8자 이상 영문/숫자를 조합해주세요."
					required="required">
				<div><font id="pwdInput" size="2"></font></div>

				<p>
				<h6>비밀번호 확인</h6>
				<input type="password" name="pwdCheck" id="pwdCheck"
					placeholder="비밀번호를 한번 더 입력해주세요." required="required">
				<div><font id="checkPwd" size="2"></font></div>

				<p>
				<h6>이름</h6>
				<input type="text" name="name" placeholder="이름을 입력해주세요."
					required="required">
				<p>
				<h6>주민등록번호</h6>
				<input type="text" name="jumin" id="jumin" placeholder="주민등록번호를 입력해주세요."
					required="required">
				<div><font id="checkJumin" size="2"></font></div>
				<p>
				<h6>연락처</h6>
				<input type="text" name="tel" placeholder="연락처를 입력해주세요."
					required="required">
				<p>
				<h6>이메일</h6>
				<input type="text" name="email" id="email" placeholder="이메일을 입력해주세요."
					required="required">
				<div><font id="checkEmail" size="2"></font></div>	
				<p>
				<h6>주소</h6>
				<input type="text" name="addr" id="member_post"
					placeholder="Zip Code" readonly onclick="findAddr()"><br>
				<input type="text" name="addr2" id="member_addr"
					placeholder="Address"><br> <input type="text"
					name="addr3" placeholder="Detailed Address">
				<p>
				<p>
			</div>
			<div class="m-5">
				<input type="hidden" name="key" value="user" />
				<!-- Controller를 찾는 정보 -->
				<input type="hidden" name="methodName" value="join" />
				<!-- 메소드이름 -->
				<input class="w-25 btn btn-dark" type="submit" value="가입완료" id="btn">
			</div>
			<p>
		</form>
	</div>
	<p>
		<%@include file="../common/footer.jsp"%>
</body>
</html>