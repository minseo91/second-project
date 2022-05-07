<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<jsp:include page="../common/header.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매하기</title>

<script src="../js/jquery-3.6.0.js"></script>

<style type="text/css">
 
 .card{text-align: center;}
 .form-check{text-align: left;}
 
</style>

<script type="text/javascript">
$(function(){ 
	

	


	function selectAll(){

		$.ajax({
	   			url :"${pageContext.request.contextPath}/ajax" , //서버요청주소
	   			type:"post", //요청방식(method방식 : get | post | put | delete )
	   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
	   			data: {key :"order", methodName:"CartorderSelect", id:'${loginId}'},
	   			success :function(result){

	   				let str ="";
	   				var toPrice =0;
	   				let cou ="";
	   				$.each(result, function(index, item) {
	   					str+=`<div class='col-md-9 col-lg-9' style='float: none; margin:0 auto;'><p>`;
	   					str+=`<div class='row'><div class='col align-self-center'>`;
	   					str+=`<div class='row text-start'>${'${item.pName}'}</div>`	;
	   					str+=`</div><div class='col'>`;
	   					str+=`<img src='${path}/img/${"${item.cateCode}"}/${"${item.pName}"}.jpg' class='rounded float-end' style='width:180px; height:250px;'>`;   
	   					str+=`</div></div><div class='row'><div class='col'><div class='text-start'>상품 금액</div><p><div class='text-start'>수량</div></div>` ;
	   					str+=`<div class='col'>`;
	   					str+=`<div class='text-center'>${'${item.cartTotal}'}원</div><p>`;
	   					str+=`<div class="text-center">${'${item.cartNo}'}개</div>`;
	   					str+=`</div></div><hr></div>`;
	   					toPrice +=item.cartTotal;

	   					str+=`<input type='hidden' name='pCode' value='${"${item.pCode}"}'>`
	   					str+=`<input type='hidden' name='orderQty' value='${"${item.cartNo}"}'>` 
	   					
	   					
	   					
	   				});

	   				$("#productList").empty();
					$("#productList").html(str);

					$("[name=finfinPrice]").val(toPrice);
					
					
	   				$("#totalPrice").html(toPrice+"원");
	   				$("#finPrice").html(toPrice+"원");
					//$("#couponList").html(cou);
					$("[name=disco]").val()
	   			},error : function(err){  
	   				alert(err+"에러 발생했어요.");
	   			}  //실팽했을때 실행할 함수 
	   		});
	 }
	
	function couponAll(){

		$.ajax({
	   			url :"${pageContext.request.contextPath}/ajax" , //서버요청주소
	   			type:"post", //요청방식(method방식 : get | post | put | delete )
	   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
	   			data: {key :"order", methodName:"couponSelect", id : '${loginId}' },
	   			success :function(result){
	   				let cou ="";
	   				let fin = "";
	   				$.each(result, function(index, item) { 					
	   					cou +=`<option value="${'${item.cRate}'}">${'${item.cName}'}${'${item.cRate}'}</option>`;
	
	   				});;
					$("#couponList").append(cou);
	   			},error : function(err){  
	   				alert(err+"에러 발생했어요.");
	   			}  //실팽했을때 실행할 함수 
	   		});
	 }
	
	
		$("#couponList").change(function(){
			$("#finCoupon").html("-"+$(this).val()+"원");

			test();
			
		})
		
		function test(){
			res = parseInt($("#couponList").val()) + parseInt( $("#pointText").val());
	 		$("#finDiscount").html("-"+res+"원");		
	 		$("#finfinfinPrice").val((parseInt($("[name=finfinPrice]").val())-parseInt(res))+3000+"원")
		}

		$("#pointText").keyup(function(){
		  const name = $('#pointText').val();
		  if(${loginUser.userPoint}==0 || name =="" ||name ==null){
			 	 $("#finPoint").html(0+"P");
			 	 return;
		  }else if(${loginUser.userPoint}>=name){
			  	$("#point").html((${loginUser.userPoint}-name)+"P");
				$("#finPoint").html("-"+name+"P");
		  }else if(${loginUser.userPoint}<name){
			  $("#point").html("0P");
			  $("#finPoint").html("-"+3000+"P");
 
		  }

		  test();
		});

	couponAll();
	selectAll();
 })      
  
</script>
</head>
<body>
<form action="${path}/front">
<h2 align="center">구매하기</h2><p>
<div class="container" >
<div class="container row" style="float: none; margin:100 auto;">
<div id="productList"></div>
<div class="col-md-9 col-lg-9" style="float: none; margin:0 auto;"><p>
	<div class="row">  
		<div class="col">
			<div class="text-start"><b>총 상품 금액</b></div> 
		</div> 
		<div class="col">
			<div class="text-center"><b id="totalPrice"></b></div><p> 
		</div> 
	</div> 
</div><!--그리드 가운데 정렬?-->

<p>

<div class="col-md-6 col-lg-7" style="float: none; margin:0 auto;">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">배송지</h5>
         <div class="input-group mb-3">

         <span class="input-group-text" id="basic-addon1">수령인</span>
         <input type="text" class="form-control" name="name" value="${loginName}" placeholder="${loginName}" aria-label="Username" aria-describedby="basic-addon1">
         </div><p>
         
         <div class="input-group mb-3">
         <span class="input-group-text" id="basic-addon1">주소</span>
         <input type="text" class="form-control" name="addr" value="${loginAddr}" placeholder="${loginAddr}"  aria-label="Username" aria-describedby="basic-addon1">
         </div><p>
                  
         <div class="input-group mb-3">
         <span class="input-group-text" id="basic-addon1">상세주소</span>
         <input type="text" class="form-control" name="addr2" value="" placeholder="상세주소" aria-label="Username" aria-describedby="basic-addon1">
         </div>
         
         <div class="input-group mb-3">
         <span class="input-group-text" id="basic-addon1">연락처</span>
         <input type="text" class="form-control" name="phone" value="${loginUser.userPhone}" placeholder="${loginUser.userPhone}" aria-label="Username" aria-describedby="basic-addon1">
         </div>              
      </div><p>
</div>
</div><!--배송지 카드--><p>
  
<div class="col-md-5 col-lg-5" style="float: none; margin:0 auto;">  
	<div class="card">
		<div class="card-body">
			<h5 class="card-title">사용 가능한 쿠폰</h5>
				<select class="form-select" id="couponList" name="couponList" aria-label="Default select example">
					<option selected value="0" >선택</option>
					
				</select>
		</div>
	</div>
</div><!--쿠폰--><p>
    
<div class="col-md-5 col-lg-5" style="float: none; margin:0 auto;">  
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">사용 가능한 적립금</h5>
        <h6 class="text-end"><b id="point">${loginUser.userPoint}P</b></h6>
        <input id="pointText" name="point" class="form-control form-control-sm" type="text" value="0" placeholder="사용할 적립금을 입력하세요" max="${loginUser.userPoint}" aria-label=".form-control-sm example">
      </div>
    </div>
</div><!--적립금--><p>

<div class="col-md-3 col-lg-3" style="float: none; margin:0 auto;">  
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">결제방법</h5>
        <div class="form-check">
       <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" value="1" checked>
       <label class="form-check-label" for="flexRadioDefault2">신용카드</label>
      </div>
      <div class="form-check">
       <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="0">
       <label class="form-check-label" for="flexRadioDefault1">무통장 입금</label>
      </div>
      </div>
    </div>
  </div><p><!--결제-->

<div class="col-md-9 col-lg-9" style="float: none; margin:0 auto;"><p>
<hr>


<div class="row">
 <div class="col">
  <div class="text-start"><b>계산서</b></div><p>
  <div class="text-start">총 상품 금액</div><p>
  <div class="text-start">총 할인 금액</div><p>
  <div class="text-start">&nbsp;&nbsp;포인트 사용</div><p>
  <div class="text-start">&nbsp;&nbsp;쿠폰</div><p>
  <div class="text-start">총 배송비</div><p>
  <div class="text-start"><b>총 결제 금액</b></div><p>
 </div>
<input type="hidden" name= "finfinPrice" value="0"/>
 <div class="col">
 <input type="hidden" name="disco"/>
 <input type="hidden" name="Poi"/>
  <div class="text-end">&nbsp;</div><p>
  <div class="text-end" id="finPrice"></div><p>
  <div class="text-end" id="finDiscount">0원</div><p>
  <div class="text-end" id="finPoint">0P</div><p>
  <div class="text-end" id="finCoupon">원</div><p>
  <div class="text-end" id="finDelivery">3000원</div><p>
  <div class="text-end"><b><input type="text" name="toPr" style="border: none; text-align: right;" id="finfinfinPrice" value="0"></b></div><p>
 
</div>



<div align="center">
<input type=hidden name="aftPoint" value="${loginUser.userPoint}">
<input type=hidden name="id" value="${loginId}"/>
<input type=hidden name="key" value="order"> 
<input type=hidden name="methodName" value="insert"> 

<button type="submit" class="btn btn-dark">결제하기</button>
</div><p> 
</div>

</div><!--계산서 전체를 위한....-->

</form>
</div><!--container row-->

</div><!--container--> 





</body>
</html>
<jsp:include page="../common/footer.jsp"/>
