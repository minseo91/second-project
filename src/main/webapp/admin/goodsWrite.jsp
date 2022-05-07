<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
	
<jsp:include page="../common/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datepicker.css">

<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.ko.min.js"></script>


<script type="text/javascript">

/* $(function() {	
		
   $('#datePicker').datepicker({
	    format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
	    startDate: '-10y',	//달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
	    endDate: '+10y',	//달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
	    autoclose : true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
	    immediateUpdates: false,	//사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
	    showWeekDays : true ,// 위에 요일 보여주는 옵션 기본값 : true
	    title: "Date",	//캘린더 상단에 보여주는 타이틀
	    todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
	    weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일  */
	    language : "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
  	    
	});//datepicker end
	

	
});//ready end */


</script>


</head>
<body>

	<caption><h2 align="center">상품등록</h2></caption><p>

	<div class="container">

		<form action="${path}/front" method="post">
		
			<div class="col-12">
				<label for="inputAddress" class="form-label">category</label> 
				<select class="form-select form-select-sm" aria-label=".form-select-sm example" name="category">
					<option selected>select</option>
					<option value="A">탁주</option>
					<option value="B">청주</option>
					<option value="C">과실주</option>
					<option value="D">증류주</option>
					<option value="GIFT">선물세트</option>
					<option value="Monthly">이달의 술</option>
				</select>
			</div>
			<p>
			
			<div class="row">
				<div class="col">
					<label for="inputAddress" class="form-label">상품코드</label> 
					<input type="text" class="form-control" placeholder="상품코드" aria-label="First name" name="pCode">
				</div>
				<div class="col">
					<label for="inputAddress" class="form-label">상품이름</label> 
					<input type="text" class="form-control" placeholder="상품이름" aria-label="Last name" name="pName">
				</div>
			</div>
			<p>
			
			<div class="col-12">
				<label for="inputAddress" class="form-label">상품설명</label> 
				<input type="text" class="form-control" id="inputAddress" placeholder="상품설명" name="pDetail">
			</div>
			<p>
			
			<div class="row">
				<div class="col">
					<label for="inputAddress" class="form-label">도수</label> 
					<input type="text" class="form-control" placeholder="도수" aria-label="First name" name="pAlcohol">
				</div>
				<div class="col">
					<label for="inputAddress" class="form-label">상품가격</label> 
					<input type="text" class="form-control" placeholder="상품가격" aria-label="Last name" name="pPrice">
				</div>
			</div>
			<p>
			
			<div class="row">
				<div class="col">
					<label for="inputAddress" class="form-label">재고량</label> 
					<input type="text" class="form-control" placeholder="재고량" aria-label="First name" name="pStuck">
				</div>
				<div class="col">
					<label for="inputAddress" class="form-label">등록일</label>
					<input type="date" class="form-control"	placeholder="0000-00-00" name="pDate"/> 
					<!-- <input class="form-control"	id="datePicker" value="0000-00-00" "name="pDate"/>  -->
				</div>
                <p>

				<div align="right">
					<input type="hidden" name="key" value="product" /> 
					<input type="hidden" name="methodName" value="insertwrite" />
					<button type="submit" class="btn btn-dark" >등록하기</button>
				</div>
				<p>
		    
		    </div>
     
          	</form>
          	
     </div><!--컨테이너-->

	
</body>
</html>

<jsp:include page="../common/footer.jsp" />