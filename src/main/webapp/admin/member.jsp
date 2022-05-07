<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<style type="text/css">
	li.open > a > span {
  	border-top: 0px !important;
  	border-bottom: 4px dashed !important;
}

</style>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
$(function(){
	function seletAll(){	

		$.ajax({
   			url :"${pageContext.request.contextPath}/ajax" , //서버요청주소
   			type:"post", //요청방식(method방식 : get | post | put | delete )
   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
   			data: {key :"user", methodName:"memberAll"},
   			success :function(result){//map이나옴
   			       let str = "";
   			        $.each(result , function(index, item){
   			        	str += "<tr>";
   			        	str +=  `<th scope='row'>${'${item.joinDate}'}</th>`
 						str +=  `<td>${'${item.userId}'}</td>`
   						str +=  `<td>${'${item.userName}'}</td>`
   						str +=  `<td>${'${item.userPhone}'}</td>`
   						str +=  `<td>${'${item.price}'}</td>`
   						str += 	`<td>회원</td>`
   						str +=  `<td><button type='button' name="bbbb" value='${"${item.userId}"}' class='btn btn-secondary btn-sm' id='coupon' data-bs-toggle='modal' data-bs-target='#exampleModal'>쿠폰 지급</button></td>`
   						str += "</tr>"							
   			        })   	          
					$("#qaTable tr:gt(0)").remove();
				    $("#qaTable tr:eq(0)").after(str);	   

			},
			error : function(err) {
				alert(err + " 에러가 발생했어요.");
			}
		})
	}
	$(document).on("click","#coupon",function(){
		$("[name=bbbb]").empty();
		$("[name=bbbb]").val($(this).val());
	})
	seletAll();
})


</script>

</head>
<body>
<jsp:include page="../common/header.jsp"/>
	<caption><h2 align="center">회원관리</h2></caption>
	
<div class="container ">
	<div class="row">
	</div>
	<div class="row mb-3">
		<div class="col">
			<table class="table text-center" id="qaTable">
			    <tr>
			      <th scope="col">등록일</th>
			      <th scope="col">아이디</th>
			      <th scope="col">이름</th>
			      <th scope="col">연락처</th>
			      <th scope="col">총 주문 금액</th>
			      <th scope="col">등급</th>
			      <th scope="col">쿠폰</th>
			      <th scope="col">
			      
				  <!-- Modal -->
				  
				  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				    <div class="modal-dialog modal-sm">
				      <div class="modal-content">
				        <div class="modal-header">
				          <h5 class="modal-title" id="exampleModalLabel">쿠폰지급</h5>
				          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				        </div>
				        
				        <div class="modal-body">
				       <form action="${path}/front">
					        <div class="col mt-3 text-center">
					        
					        <b>지급할 쿠폰 종류</b><br>
					      
					          <select name="coupon">
							     <option value="3000" >welcome coupon</option>
							     <option value="5000">birthday coupon</option>
							     <option value="4000">new product coupon</option>
							     
							  </select><br>
							</div> 
							<div class="col mt-3 text-center">
							<b>지급할 쿠폰 수</b> 
					
							<input name="items" type="number" class="datail-quantity form-control text-center input-sm" value="1" >
							
							</div>
				         <input type='hidden' name="bbbb">
				          <input type="hidden" name="key" value="user" >
   						  <input type="hidden" name="methodName" value="couponInsert" >
				          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
				          <button type="submit" class="btn btn-primary">Submit</button>
				           </form>

				       		
				       		 </div>
				       
				        
				         
				      </div>
				    </div>
				  </div>
				  
		        </th>
			    </tr>
			</table>
		</div>
		
	</div>

</div>



<jsp:include page="../common/footer.jsp"/>

</body>
</html>