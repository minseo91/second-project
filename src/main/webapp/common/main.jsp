<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
<title>메인</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

	
	<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/carousel/">
	
	<%-- <link rel="StyleSheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"> --%>
	<link href="${pageContext.request.contextPath}/css/carousel.css" rel="stylesheet">
	<style>
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
</head>
<body>


<div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/>  
        <image href="${pageContext.request.contextPath}/img/꽃길을 여는 술들2.jpg" width="100%"/>
        </svg>
        <div class="container">
          <div class="carousel-caption text-start">
            <h1>특별한 날을 완성시키는 가장 쉬운 방법</h1>
            <p></p>
            <p><a class="btn btn-lg btn-dark" href="${path}/store/category.jsp">확인하러 가기</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/>
        <image href="${pageContext.request.contextPath}/img/4월의 술.jpg" width="100%"/>
        </svg>
        <div class="container">
          <div class="carousel-caption">
            <h1 style="color:black;">한 달에 한 번, 집 앞으로 찾아오는 인생 술</h1>
            <p style="color:black;">4월의 술</p>
            <p><a class="btn btn-lg btn-dark" href="${path}/store/subscription.jsp">구독하러 가기</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/>
        <image href="${pageContext.request.contextPath}/img/신애유자2.jpg" width="100%"/>
        </svg>
			
        <div class="container">
          <div class="carousel-caption text-end">
            <h1></h1>
            <p></p>
            <p><a class="btn btn-lg btn-dark" href="${path}/store/category.jsp">베스트셀러 보러 가기</a></p>
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
  <div class="container marketing" style="text-align: center;">
  <div class="row" >
      <div class="col-lg-6">
        <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text>
        <image href="${pageContext.request.contextPath}/img/B/기다림 흑미 약주3.jpg" height="100%" />
        </svg>
		
        <h2>술</h2>
        <p></p>
        <p><a class="btn btn-secondary" href="${path}/store/category.jsp">보러 가기 &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
      
      <div class="col-lg-6">
        <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text>
        <image href="${pageContext.request.contextPath}/img/Gift/문배술.jpg" height="100%" /></svg>
		
        <h2>세트</h2>
        <p></p>
        <p><a class="btn btn-secondary" href="${path}/store/product.jsp?type=Gitf&title=선물 세트">보러 가기 &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
    <!--  
      <div class="col-lg-4">
        <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
		
        <h2>굿즈</h2>
        <p>설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</p>
        <p><a class="btn btn-secondary" href="#">View details &raquo;</a></p>
      </div>--><!-- /.col-lg-4 -->
    </div><!-- /.row -->

    <hr class="featurette-divider">

</div>


	<%-- <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
 --%></body>
</html>

