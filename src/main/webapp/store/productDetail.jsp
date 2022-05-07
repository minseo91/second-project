<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<style type="text/css">
	.card-img-top{
		height: 15rem;
		object-fit : cover;
	}
button{
	background-color: #F2D58F;
}

</style>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>


<script type="text/javascript">
$(function(){
	
	/* $(".plus").click(function(){
		   var num = $(".numBox").val();
		   var plusNum = Number(num) + 1;
		   var price = `${param.price}`;
		    if(plusNum >= 99) {
		    $(".numBox").val(num);
		    $(".priceBox").val((price*num)+"원");
		    
		    
		   } else {
		    $(".numBox").val(plusNum);     
		    $(".priceBox").val((price*plusNum)+"원");
		   }
		  });
		  
		  $(".minus").click(function(){
		   var num = $(".numBox").val();
		   var minusNum = Number(num) - 1;
		   var price = `${param.price}`;
		   if(minusNum <= 0) {
		    $(".numBox").val(num);
		    $(".priceBox").val((price)+"원");
		   } else {
		    $(".numBox").val(minusNum);    
		    $(".priceBox").val((price*minusNum)+"원");
		   }
		  }); */
		  
		  function selectAll(){	
				$.ajax({
		   			url :"${pageContext.request.contextPath}/ajax" , //서버요청주소
		   			type:"post", //요청방식(method방식 : get | post | put | delete )
		   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
		   			data: {key :"product", methodName:"searchBy", name : "${param.pName}"},
		   			success :function(result){
						let pCode="";
		   				let content ="";
		   				let price = "";
		   				let pAlcohol = "";
		   				let price2 = 0;
		   				let review = "";
		   				$.each(result, function(index, item) {
		   					content += `<h5>${"${item.pDetail}"}</h5>`;
		   					price +=`가격 : ${'${item.pPrice}'}원`;
		   					pAlcohol +=`<b>도수 : ${'${item.pAlcohol}'}%</b>`;
		   					price2 = `${'${item.pPrice}'}`;
		   					pCode=`${'${item.pCode}'}`;
		   					
		   				});
		   				
		   				$(".plus").click(function(){
		   				   var num = $(".numBox").val();
		   				   var plusNum = Number(num) + 1;
						   var price = price2;
		   				    if(plusNum >= 99) {
		   				    $(".numBox").val(num);
		   				    $(".priceBox").val((price2*num)+"원");
		   				    
		   				    
		   				   } else {
		   				    $(".numBox").val(plusNum);     
		   				    $(".priceBox").val((price2*plusNum)+"원");
		   				   }
		   				  });
		   				  
		   				  $(".minus").click(function(){
		   				   var num = $(".numBox").val();
		   				   var minusNum = Number(num) - 1;
		   				   var price = price2;
		   				   if(minusNum <= 0) {
		   				    $(".numBox").val(num);
		   				    $(".priceBox").val((price2)+"원");
		   				   } else {
		   				    $(".numBox").val(minusNum);    
		   				    $(".priceBox").val((price2*minusNum)+"원");
		   				   }
		   				  });

		   				$(".pCode").val(pCode);
		   				$(".priceBox").val(price2+"원");
						$(".content").html(content);
						$("#price").html(price);
						$("#pAlcohol").html(pAlcohol);	
		   			},error : function(err){  
		   				alert(err+"에러 발생했어요.");
		   			}  //실팽했을때 실행할 함수 
		   		});
				
			}
			

		  selectAll()
		  
	
 	 
			 
});


</script>

</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">

	
	<div class="row">	
			<div class="col-lg-8">
				<div class="card mb-3 h-100 w-100" >
				  <div class="row g-0 h-100 w-100">
				  	
					    <div class="col-lg-7">
					      <img src="${path }/img/${param.type}/${param.pName}.jpg" class="img-fluid img-thumbnail rounded-start" style="width:100%;height: 100%;">
	
					    </div>
					    <div class="col-lg-5">
					      <div class="card-body">
					     	 <br>
					        <h4 class="card-title" style="font-weight:bold;">${param.pName}</h4>
					        <br>
					        <p class="card-text">
					        	<div class="content"></div>
					        	
					        	<p> <br> <b>별점 : 

					        		<c:choose>
					        			<c:when test="${star==0}">
					        				<i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i>
					        			</c:when>
					        			<c:when test="${star<=0.5}">
					        				<i class="bi bi-star-half"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i>
					        			</c:when>
					        			<c:when test="${star<=1}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i>
					        			</c:when>
					        			<c:when test="${star<=1.5}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star-half"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i>
					        			</c:when>
					        			<c:when test="${star<=2}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i>
					        			</c:when>
					        			<c:when test="${star<=2.5}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-half"></i><i class="bi bi-star"></i><i class="bi bi-star"></i>
					        			</c:when>
					        			<c:when test="${star<=3}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star"></i><i class="bi bi-star"></i>
					        			</c:when>
					        			<c:when test="${star<=3.5}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-half"></i><i class="bi bi-star"></i>
					        			</c:when>
					        			<c:when test="${star<=4}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star"></i>
					        			</c:when>
					        			<c:when test="${star<=4.5}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-half"></i><i class="bi bi-star-half"></i>
					        			</c:when>
					        			<c:when test="${star<5}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-half"></i>
					        			</c:when>
					        			<c:when test="${star==5}">
					        				<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i>
					        			</c:when>
					        		</c:choose>
					        		</b>   
					        	<a href="#a" style="color:#A381BD; font-weight: bold;">[리뷰]</a>
					        	<p> <div><b>주종 : ${param.title} </b></div>
					        	<h5>${item.pDetail}</h5><p>

								<p> <div id="pAlcohol"></div>
								<p><br><h4 class="text-center" id = "price" style="font-weight:bold;"></h4>	
							</p>
					        <p class="card-text"><small class="text-muted"></small></p>
					      </div>
					    </div>
				  </div>
				</div>
			</div>
			<div class="col-lg-4">
				
					<div class="col">
						<div class="card rounded-3 shadow-sm text-center">
				          <div class="card-body mx-auto">
				          	<span style="text-align: right">수량</span>
				          	<form action="${path}/front">	
					          	<div class="card rounded-3 shadow-sm">     		
					          		<div class="card-main ">
					          		
					          			<button type="button" class="minus" style="border: none; background: none;">-</button>
					          			<input type="number" name="count" class="numBox" min="1" max="99" value="1" readonly="readonly" style="border: none; background: none; text-align: center;"/>
					          			<button type="button" class="plus" style="border: none; background: none;">+</button>
					          		</div>       	
					          	</div>
					            
					            
					            <div class="card rounded-3 shadow-sm mt-5">
					          		<div class="card-header text-center bg-white">총가격</div>
					          		<div class="card-main text-center">
					          			<input type="text" class="priceBox" name="totalPrice" value=${param.price}원 readonly="readonly" style="border: none; text-align: center;" />          			
					          		</div>       	
					          	</div>
					          	
			            		<input type="hidden" name="key" value = "cart" /> <!-- Controller를 찾는 정보 -->
								<input type="hidden" name="methodName" value = "insert" /><!-- 메소드이름 -->
								<input type="hidden" name="userId" value = "${loginUser.userId}" /> <!-- userID --> 
								<input type="hidden" name="pName" value="${param.pName}"/>								            
					            <button type="submit" class="btn-lg mt-5 , btn btn-dark">장바구니 담기</button><br>
					            
							</form>
							<form action="${path}/store/order.jsp">
								<input type="hidden" name="pName" value = "${param.pName}" />
					            <input type="hidden" name="count" class="numBox" min="1" max="99" value="1" readonly="readonly" style="border: none; background: none; text-align: center;"/>
								<input type="hidden" class="priceBox" name="totalPrice" value=${param.price}원 readonly="readonly" style="border: none; text-align: center;" />
					            <button type="submit" class="btn-lg mt-3 , btn btn-dark">바로 구매하기</button>
					        </form>
				          </div>
				        </div>
						
					</div>
				
			</div>
	</div>
	<div class="row mt-5">
		<div class="col" id = "content">
			<img src="${path}/img/${param.type}/${param.pName}2.jpg" class="rounded img-thumbnail" width="100%" height="100%">

			<img src="${path}/img/${param.type}/${param.pName}3.jpg" class="rounded img-thumbnail" width="100%" height="100%">		
		</div>
	</div>
	
	<div class="row mt-5">
		<div class="col"><div style="position:absolute; top:2500px;"><a name="a" id="a"></a></div>
				<table id="listTable" class="table table-hover">
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">글쓴이</th>
				      <th scope="col">내용</th>
				      <th scope="col">별점</th>
				      <th scope="col">등록일</th>
				      <th scope="col">사진</th>
				    </tr> 
				    <c:forEach items="${reviewList}" var="list">
						<tr id="review">
	   					<th scope="row">${list.viewNumber}</th>
	   					<td>${list.userId}</td>
	   					<td>${list.viewContent}</td>
	   					<td>${list.viewScore}</td>
	   					<td>2022-04-05</td>
	   					<td><img id=reviewImg src="${path}/img/${param.type}/${param.pName}2.jpg"  class='rounded float-end' style='width: 50px; height: 50px'></td>
	   					</tr>
				    </c:forEach>     
				</table>	
		</div>	
	</div>	
	

<jsp:useBean class="alcohol.mvc.paging.PageCnt" id="p"/> 
<nav aria-label="Page navigation example">

		<c:set var="doneLoop" value="false"/>
		<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2   , (2-1)%2    1 , (3-1)%2  0 -->
		<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 1 -->
	<ul class="pagination  justify-content-center">

		<li class="page-item">
			<c:if test="${(startPage-p.blockcount) > 0}"> <!-- (-2) > 0  -->
				<a class="page-link" style="color: black" href="${path}/front?key=review&methodName=reviewSelect&pName=${param.pName}&type=${param.type}&title=${param.title}&price=${param.price}&pageNo=${startPage-1}" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
				</a>   
			</c:if>
		</li>	
 
		<c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
			<c:if test="${(i-1)>=p.pageCnt}">
				<c:set var="doneLoop" value="true"/>
			</c:if> 
			<c:if test="${not doneLoop}" >
			<li class="page-item"><a style="color: black" class="${i==pageNo?'pagination-active':page} page-link" id="page" href="${path}/front?key=review&methodName=reviewSelect&pName=${param.pName}&type=${param.type}&title=${param.title}&price=${param.price}&pageNo=${i}">${i}</a></li> 
			</c:if>			  
		</c:forEach>

    <li class="page-item">
	    <c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
	      <a class="page-link" style="color: black" href="front?key=review&methodName=reviewSelect&pName=${param.pName}&type=${param.type}&title=${param.title}&price=${param.price}&pageNo=${startPage+p.blockcount}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </c:if>
    </li>
    

    	
  </ul>

</nav>

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	<div class="row mt-5 mb-5">
		<div class="col">
				<div class="accordion accordion-flush" id="accordionFlushExample">
				<span><b>자주하는 질문</b></span>
				  <div class="accordion-item">
				    <h2 class="accordion-header" id="flush-headingOne">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
				        배송/기간 관련 질문
				      </button>
				    </h2>
				    <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
				      <div class="accordion-body">사실 <code>나도 몰라</code>허허</div>
				    </div>
				  </div>
				  <div class="accordion-item">
				    <h2 class="accordion-header" id="flush-headingTwo">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
				        맛 문의합니다
				      </button>
				    </h2>
				    <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
				      <div class="accordion-body">맛이  <code>좋은지는</code>몰라요</div>
				    </div>
				  </div>
				  <div class="accordion-item">
				    <h2 class="accordion-header" id="flush-headingThree">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
				        양이 얼마나 되나요
				      </button>
				    </h2>
				    <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
				      <div class="accordion-body">엄청 많은 <code>500ml</code>에요</div>
				    </div>
				  </div>
				</div>
		</div>
	</div>
</div>





<jsp:include page="../common/footer.jsp"/>
</body>
</html>