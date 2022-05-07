<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>


	
	<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/footers/">
	<%-- <link rel="StyleSheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"> --%>
	<link href="${pageContext.request.contextPath}/css/footers.css" rel="stylesheet">
</head>
<body>

<div class="b-example-divider"></div>

<div class="container">
  <footer class="py-3 my-4">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
      <li class="nav-item"><a href="${path}/index.jsp" class="nav-link px-2 text-muted">Home</a></li>
      <li class="nav-item"><a href="${path}/front?key=notice&methodName=select" class="nav-link px-2 text-muted">Notice</a></li>
      <li class="nav-item"><a href="${path}/board/qa.jsp" class="nav-link px-2 text-muted">QA</a></li>
      <li class="nav-item"><a href="" class="nav-link px-2 text-muted">About</a></li>
    </ul>
    <p class="text-center text-muted">&copy; 2022 Kosta Team2</p>
  </footer>
</div>	
	
	
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>

</body>
</html>