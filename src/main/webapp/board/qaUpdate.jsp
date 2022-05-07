<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../common/header.jsp"%>

	<caption>
		<h2 align="center">Q&A 수정 폼</h2>
	</caption>

	<div class="col-md-7 col-lg-8" style="float: none; margin: 0 auto;">
		<div class="container">
			<form name="updateForm" method="post" action="${path}/front">
				<div class="row mb-5">
					<div class="col">
						<div class="row m-5">
							<label for="inputTitle" class="col-sm-2 col-form-label">카테고리</label>
							<div class="col-sm-10">
								<textarea readonly class="form-control-plaintext"
									id="inputTitle">${param.qaTitle}</textarea>
							</div>
						</div>

						<div class="row m-5">
							<label for="inputContent" class="col-sm-2 col-form-label">문의
								내용</label>
							<div class="col-sm-10">
								<textarea class="form-control" name="qaContent"
									id="inputContent" rows="10">${param.qaContent}</textarea>
							</div>
						</div>


						<p>
						<div class="row m-5" align="right">
							<div class="col-sm-10">
								<input type=hidden name="key" value="qa"> 
								<input type=hidden name="methodName" value="update"> 
								<input type=hidden name='qaNumber' value="${param.qaNumber}">
								 
								<button type="submit" class="btn btn-dark">수정하기</button>
							</div>

							<div class="col-sm-2">
								<button type="button" class="btn btn-dark"
									onclick="location.href='${path}/front?key=qa&methodName=select'">목록</button>
							</div>

						</div>
						<p>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>