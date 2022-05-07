<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Batang&display=swap" rel="stylesheet">
<style type="text/css">
 	* {
 		font-family: 'Gowun Batang', serif;
 	}
 	
 	button{style="background-color: pink;border: none;"}
 	.bi-cart4{
 		font-size: 30px;
   		line-height: 30px;
	}
	 img{
 	height: 285.05px;

 	}
	
	.btn:hover{
		color: #EBF04D;
	}
	
	
  	.bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">


<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/navbars/">
<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">

<link href="${pageContext.request.contextPath}/css/headers.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/navbar.css" rel="stylesheet">



</head>
<body>
<!-- 
	*****유효성검사*****
	
	1. 로그인 후 뒤로갔을때 로그인창 안뜨게하기 -- 완료 
	2. 비로그인 상태에서 구독누르면 로그인 페이지로 이동 
	3. 비로그인 상태에서 상품 장바구니에 담으면 로그인 페이지로 이동 
	4. 회원가입시 비밀번호 영문+숫자 8자 이상, 비밀번호 확인 
	5. 공지사항 
 -->
<c:choose>
	<c:when test="${not empty loginUser}"> 
	
		<c:choose>
			<c:when test="${loginGrade == 0}">
				<div class="container">
				    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
				      <a href="${path}/index.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				        <span class="fs-4">안다미로</span>
				      </a>
					<div class="col-md-6 text-end">
						<form action="${path}/store/cart.jsp" method="post">
						<%-- <input type="hidden" name="key" value="cart" /> 
 						<input type="hidden" name="methodName" value="select" />
						<input type="hidden" name="userId" value="${loginUser.userId}"/> --%>
						<button type="submit" style="border: none; background: none;"><i class="bi bi-cart4 me-2"></i></button>
						</form>
					</div>
						<div>
							<b>${loginName}님   </b>
							<button type="button" class="btn btn btn-dark me-2" onclick= "location.href='${path}/myPage/myPage.jsp'">마이페이지</button>
					        <button type="button" class="btn btn btn-dark me-2" onclick= "location.href='${path}/store/subscription.jsp'">구 독</button>
					        <button type="button" class="btn btn btn-dark me-2" onclick= "location.href='${path}/store/category.jsp'">스토어</button>
					        <button type="button" class="btn btn btn-dark me-2" onclick= "location.href='${path}/front?key=user&methodName=logout'">로그아웃</button>
						</div>
				    
				    </header>
				</div>
				<div class="container">
				    <nav class="navbar navbar-expand-lg navbar-light bg-light rounded" aria-label="Eleventh navbar example">
				      <div class="container-fluid">
				        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
				          <span class="navbar-toggler-icon"></span>
				        </button>
				
				        <div class="collapse navbar-collapse" id="navbarsExample09">
				          <ul class="navbar-nav me-auto mb-2 mb-lg-0"> 
				            <li class="nav-item">
				              <a class="nav-link active" aria-current="page" href="${path}/store/product.jsp?type=Gift&title=선물 세트">선물 세트</a>
				            </li>
				            <li class="nav-item">
				              <a class="nav-link active" aria-current="page" href="${path}/front?key=factory&methodName=select">양조장</a>
				            </li>
				          </ul>
				        </div>
				      </div>
				    </nav>
				</div> 		
			</c:when>
			<c:otherwise>
				<div class="container">
				    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
				      <a href="${path}/index.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				        <span class="fs-4">안다미로</span>
				      </a>
					<div class="col-md-6 text-end">
						
						
						<form action="${path}/front" method="get">	
							<b>${loginName}님   </b>
							<button type="button" class="btn btn-dark me-2" onclick= "location.href='${path}/admin/member.jsp'">회원관리</button>		
				        	<button type="submit" class="btn btn-dark me-2" >상품관리</button>
				        	<input type="hidden" name="key" value = "product" /> <!-- Controller를 찾는 정보 -->
							<input type="hidden" name="methodName" value = "select" />  <!-- 메소드이름 -->
							<button type="button" class="btn btn-dark me-2" onclick= "location.href='${path}/admin/orders.jsp'">배송관리</button>
				        	<button type="button" class="btn btn-dark me-2" onclick= "location.href='${path}/admin/boards.jsp'">게시판관리</button>
				        	<button type="button" class="btn btn-dark me-2" onclick= "location.href='${path}/front?key=user&methodName=logout'">로그아웃</button>
				        </form>
				        
				        
				    </div>
				    </header>
				</div>
				<div class="container">
				    <nav class="navbar navbar-expand-lg navbar-light bg-light rounded" aria-label="Eleventh navbar example">
				      <div class="container-fluid">
				        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
				          <span class="navbar-toggler-icon"></span>
				        </button>
				
				        <div class="collapse navbar-collapse" id="navbarsExample09">
				          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				            <li class="nav-item">
				              <a class="nav-link active" aria-current="page" href="${path}/store/product.jsp?type=Gift&title=선물 세트">선물 세트</a>
				            </li>
				            <li class="nav-item">
				              <a class="nav-link active" aria-current="page" href="${path}/front?key=factory&methodName=select">양조장</a>
				            </li>
				          </ul>
				        </div>
				      </div>
				    </nav>
				</div>				
			</c:otherwise>
		</c:choose>
	
	</c:when>
	<c:otherwise>
		<div class="container">
		    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
		      <a href="${path}/index.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
		        <span class="fs-4">안다미로</span>
		      </a>
			<div class="col-md-5 text-end">
		        <button type="button" class="btn btn-dark me-2" onclick= "location.href='${path}/store/subscription.jsp'">구독</button>
		        <button type="button" class="btn btn-dark  me-2" onclick= "location.href='${path}/store/category.jsp'">스토어</button>
		        <button type="button" class="btn btn-dark me-2" onclick= "location.href='${path}/user/login.jsp'">로그인</button>
		    </div>
		    </header>
		</div>
		<div class="container">
		    <nav class="navbar navbar-expand-lg navbar-light bg-light rounded" aria-label="Eleventh navbar example">
		      <div class="container-fluid">
		        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
		          <span class="navbar-toggler-icon"></span>
		        </button>
		
		        <div class="collapse navbar-collapse" id="navbarsExample09">
		          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		            <li class="nav-item">
		              <a class="nav-link active" aria-current="page" href="${path}/store/product.jsp?type=Gift&title=선물 세트">선물 세트</a>
		            </li>
		            <li class="nav-item">
		              <a class="nav-link active" aria-current="page" href="${path}/front?key=factory&methodName=select">양조장</a>
		            </li>
		          </ul>
		        </div>
		      </div>
		    </nav>
		</div> 		
	</c:otherwise>
</c:choose>

</body>


