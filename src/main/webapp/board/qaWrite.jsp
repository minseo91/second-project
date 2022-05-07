<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
<script type="text/javascript">
	$(function() {
		/*if(document.getElementById("input_check").checked) {
		    document.getElementById("input_check_hidden").disabled = true;
		}*/
		
		
		
		/*if($("[name=qaTitle]").val() == "상품문의"){
			$("[name=category]").val("1");
		}else if($("[name=qaTitle]").val() == "결제/환불/교환 문의"){
			$("[name=category]").val("2");
		}else if($("[name=qaTitle]").val() == "쿠폰/포인트 문의"){
			$("[name=category]").val("3");
		}else if($("[name=qaTitle]").val() == "기타 문의"){
			$("[name=category]").val("4");
		}*/
		
		
		$("select[name=qaTitle]").change(function(){
			$("#qa_category").val(this.selectedIndex);
		})
		
		
	})
</script>
	<caption>
		<h2 align="center">Q&A</h2>
	</caption>


	<form name="writeForm" method="post" action="${path}/front">
		<div class="col-md-7 col-lg-8" style="float: none; margin: 0 auto;">
			<div class="container">

				<div class="row mb-5">
					<div class="col">

						<div class="row m-5">
							<label for="inputCategory" class="col-sm-2 col-form-label">카테고리</label>
							<div class="col-sm-10">
								<select id="inputCateSelect" class="form-select" aria-label="Default select example"
									style="width: 300px; height: 38px;" name="qaTitle">
									<option selected value="0">-----문의 유형을 선택해주세요.-----</option>
									<option value="상품문의">1. 상품문의</option>
									<option value="결제/환불/교환 문의">2. 결제/환불/교환 문의</option>
									<option value="쿠폰/포인트 문의">3. 쿠폰/포인트 문의</option>
									<option value="기타 문의">4. 기타 문의</option>
								</select> <br>
								<!-- <textarea id="inputCate"></textarea> -->
								
							</div>
						</div>

							
						</div>

						<div class="row m-5">
							<label for="inputContent" class="col-sm-2 col-form-label">문의
								내용</label>
							<div class="col-sm-10">
								<textarea class="form-control" name="qaContent"
									id="inputContent" rows="10">내용</textarea>
							</div>
						</div>

						<div class="row m-5">
							<label for="date" class="col-sm-2 col-form-label">작성일</label>
							<div class="col-sm-10">
								<input type="date" class="form-control" name="qaDate" id="date">
							</div>
						</div>

						<div class="row m-5">
							<label for="inputTitle" class="col-sm-2 col-form-label">비밀글
								설정</label>
							<div class="col-sm-10">
								<input type="checkbox" name="open" value="1" id="open">
								<input type="checkbox" name="secret" value="0" id="secret">
							</div>
						</div>


						<p>
						<div class="row m-5" align="right">
							<div class="col-sm-10">
								<input type=hidden name="key" value="qa"> 
								<input type=hidden name="methodName" value="insert">
								<input type=hidden name="category">
								<input type=hidden name="userId" value="${loginUser.userId}"><!-- 로그인 -->
								<input type=hidden name="qa_category" id="qa_category">
								
<%-- 								<input type=hidden name="qaTitle" value="${qa.qaTitle}">
								<input type=hidden name="qaContent" value="${qa.qaContent}">
								<input type=hidden name="qaSecret" value="${qa.qaSecret}">  --%>
								<button type="submit" class="btn btn-dark">등록하기</button>
							</div>

							<div class="col-sm-2">
								<button type="button" class="btn btn-dark"
									onclick="location.href='${path}/front?key=qa&methodName=select'">목록</button>
							</div>

						</div>
						<p>
					</div>
				</div>

			</div>
		</div>


	</form>


	<%@include file="../common/footer.jsp"%>
</body>
</html>