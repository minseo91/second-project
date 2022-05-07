<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
	<div class="row mt-4">
		<div class="col-1"></div>
		<div class="col-10">
			<div class="card mb-4  text-center" >
			  <div class="card-body">
			  	<div class="row">
			  		<div class="col">
			  			<div class="input-group mb-3">
						  <span class="input-group-text" id="inputGroup-sizing-default">이름</span>
						  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" value="${loginName}" disabled>
						</div><p>
			  			<div class="input-group mb-3">
						  <span class="input-group-text" id="inputGroup-sizing-default">아이디</span>
						  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" value="${loginId}" disabled>
						</div><p>
						<div class="input-group mb-3">
						  <span class="input-group-text" id="inputGroup-sizing-default">비밀번호</span>
						  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" value=>
						</div><p>
						<div class="input-group mb-3">
						  <span class="input-group-text" id="inputGroup-sizing-default">이메일</span>
						  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" value="${loginUser.userEmail}">
						</div><p>
						<div class="input-group mb-3">
						  <span class="input-group-text" id="inputGroup-sizing-default">연락처</span>
						  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" value="${loginUser.userPhone}">
						</div>
						<p class="text-end" ><button type="button" class="btn btn-link , btn btn-dark" style="text-decoration: none; color:white;">수정</button></p>

			  		</div>		  		
			  	</div>
			  </div>
			</div>
		</div>	
		<div class="col-1"></div>
	</div>
	</form>




</body>
</html>