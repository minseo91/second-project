<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 눌렀을때</title>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">



$(function(){

	function selectAll(fi){	
		$.ajax({
   			url :"../ajax" , //서버요청주소
   			type:"post", //요청방식(method방식 : get | post | put | delete )
   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
   			data: {key :"product", methodName:"productSelectAll", cate :"${param.type}" , filter : fi},
   			success :function(result){

   				let str ="";
   				$.each(result, function(index, item) {
   					str+="<div class='col-lg-3 col-md-6'>";
   					str+="<div class='card mb-3 h-100'>";
   					str+=`<a href = '${path}/front?key=review&methodName=reviewSelect&pName=${"${item.pName}"}&type=${param.type}&title=${param.title}'>`						
   					str+=`<img src='${path}/img/${"${item.cateCode}"}/${"${item.pName}"}.jpg' class=card-img-top alt='모르겠다'></a>`; 
   					str+="<div class='card-body'>";
   					str+="<p class='card-text'>";
   					str+=`<b>${'${item.pName}'}</b><p><p>`;
   					str+=`<b>가격 : ${'${item.pPrice}'} 원</b><p>`;
   					str+="<hr>";
   					str+="<b>상품 설명</b><p>";    
   					str+=`${'${item.pDetail}'}`;
   					str+="</p></div></div></div>";
   				});
   				//$("rrr").remove();

   				$("#rrr").empty();
				$("#rrr").html(str);
					
   			},error : function(err){  
   				alert(err+"에러 발생했어요.");
   			}  //실팽했을때 실행할 함수 
   		});
		
	}

	function alcoFilter(v,fi){		
		$.ajax({
   			url :"../ajax" , //서버요청주소
   			type:"post", //요청방식(method방식 : get | post | put | delete )
   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
   			data: {key :"product", methodName:"alcoFilter", cate :"${param.type}" ,alcohol : v , filter : fi},
   			success :function(result){

   				let strr ="";
   				$.each(result, function(index, item) {	
   					strr+="<div class='col-lg-3 col-md-6'>";
   					strr+="<div class='card mb-3 h-100'>";			
   					strr+=`<a href = '${path}/store/productDetail.jsp?pName=${"${item.pName}"}&title=${param.title}'>`
   					strr+=`<img src='${path}/img/${"${item.cateCode}"}/${"${item.pImage}"}.jpg' class=card-img-top alt='모르겠다'></a>`;
   					strr+="<div class='card-body'>";
   					strr+="<p class='card-text'>";
   					strr+=`<h4 style='font-weight:bold;'>${'${item.pName}'}</h4><p><p>`;
   					strr+=`<b>가격 : ${'${item.pPrice}'} 원</b><p>`;
   					strr+="<hr>";
   					strr+="<b>상품 설명</b><p><p>";    
   					strr+=`${'${item.pDetail}'}`;
   					strr+="</p></div></div></div>";
   				});

   			    $("#rrr").empty();
				$("#rrr").html(strr);
   			}
		})
		
	}

	$("[name=btn]").click(function(){
		alcoFilter($(this).val());
	})

	
	$("#se").change(function(){
		var s = $(this).val();
		selectAll(s);
		
		
		$("[name=btn]").click(function(s){
			alcoFilter($(this).val(),s);
		})
	})	

	selectAll();
});

 /* doucmengetElementById("a").click = function (){
	  
  }
  
  $("#a").click(function(){
	  
  })*/

</script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container">
<h4 style="text-align: center; font-weight:bolder">${param.title}</h4>
</div>



<nav class="navbar navbar-expand-lg navbar-light bg-white container">
  <div class="container-fluid">
  
    <a class="navbar-brand" ><h5>도수</h5></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"  ></span>
    </button>
    
    
    <div class="collapse navbar-collapse " id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">

          	<button type="button"  class="btn btn-link-light" style="text-decoration: none;" value="10" name=btn>저도수(0~10)%</button>
        </li>
        <li class="nav-item">    
          	<button type="button" class="btn btn-link-light" style="text-decoration: none;" value="20" name=btn>낮은 중도수(10~20)%</button>
        </li>
        <li class="nav-item">
          	<button type="button" class="btn btn-link-light" style="text-decoration: none;" value="30" name=btn>높은 중도수(20~30)%</button>
        </li>
        <li class="nav-item">
          	<button type="button" class="btn btn-link-light" style="text-decoration: none;" value="40" name=btn>고도수(30~40)%</button>
        </li>
      </ul>
		
		
	</div>
	<!-- <form class="d-flex"> -->
		<div class="row">
			<div class="col-9"></div>
			<div class="col">
		      	<select id="se" class="form-select form-select-sm " aria-label=".form-select-sm example" style="width:100px;height:38px;">
				  <option selected value="0">기본순</option>
				  <option value="1">판매순</option>
				  <option value="2">인기순</option>
				</select>  
			</div>
		</div>
		<!-- </form> -->
  </div>
</nav>







<form action="/front">
<div class='container mb-4'>
	<div id='rrr' class='row row-cols-1 row-cols-md-4 g-4'>
	</div>
</div>
<input type ="hidden" name="key" value="product"/>
<input type ="hidden" name="methodName" value="methodName"/>
</form>

<%-- <jsp:include page="../store/productMain.jsp"/> --%>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>