<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A</title>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<style type="text/css">
h1 {
	text-align: center;
}

div {margin 100px;
	
}

.pagination-container {
	margin: 100px auto;
	text-align: center;
}

.pagination {
	position: relative;
}

.pagination a {
	position: relative;
	display: inline-block;
	color: #2c3e50;
	text-decoration: none;
	font-size: 1.2rem;
	padding: 8px 16px 10px;
}

.pagination a:before {
	z-index: -1;
	position: absolute;
	height: 100%;
	width: 100%;
	content: "";
	top: 0;
	left: 0;
	background-color: #2c3e50;
	border-radius: 24px;
	-webkit-transform: scale(0);
	transform: scale(0);
	transition: all 0.2s;
}

.pagination a:hover, .pagination a .pagination-active {
	color: #fff;
}

.pagination a:hover:before, .pagination a .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination .pagination-active {
	color: #fff;
}

.pagination .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination-newer {
	margin-right: 50px;
}

.pagination-older {
	margin-left: 50px;
}

a {
	text-decoration: none
}
</style>
<script type="text/javascript">
	$(function() {
		
		function qaFilter(v , pn){	//pn=pageNo
			
		 if(pn=="" || pn==null){
			 pn=1;
		 }

		alert("pn = " + pn)
			$.ajax({
	   			url :"${pageContext.request.contextPath}/ajax" , //서버요청주소
	   			type:"post", //요청방식(method방식 : get | post | put | delete )
	   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
	   			data: {key :"qa", methodName:"selectFilter", cate:v, pageNo:pn},
	   			success :function(result){//map이나옴
                       /* alert(result) */
	   			    $.each(result, function(i, map){ //2개 
	   			       let str = "";
	   			        $.each(map.qaList , function(index, item){
	   			        	str += "<tr>";
							str += `<th scope="row">${'${item.qaNumber}'}</th>`;
							str += `<td>${'${item.userId}'}</td>`;
							str += `<td>${'${item.qaTitle}'}</td>`;
							str += `<td><a href='${path}/front?key=qa&methodName=selectByQANum&qaNumber=${"${item.qaNumber}"}' style='text-decoration:none'>${'${item.qaContent}'}</a></td>`;
							str += `<td>${'${item.qaDate}'}</td>`;
							str += "</tr>"
	   			        })   
	   			        
	   			        $("a").css("textDecoration","none");
	   			        
						$("#qaTable tr:gt(0)").remove();
					    $("#qaTable tr:eq(0)").after(str);
					    
					    
					    //페이지 번호 생성...
					   /*  alert(map.blockcount)
	   			    	alert(map.pageNo)
	   			    	alert(map.pageCnt) */
		   			     
		   			    let pageQA = "";
	   					// 페이징처리 일단 보류
		   				
		   				let temp = (map.pageNo - 1) % map.blockcount;
		   				let startPage = map.pageNo - temp; 
					   			    
	   			   		//pageQA += `<li class='page-item'>`;
	   			   		
	   					if(startPage - map.blockcount > 0) {
	   						pageQA += `<a class='page-link' style='color: black' href='${path}/front?key=qa&methodName=select&pageNo=${startPage-1}' aria-label='Previous'><span aria-hidden='true'>PREV</span>`
	   					}
	   			   	
	   				//	pageQA += `</li>`
			           /* alert(startPage)
			           alert( (startPage-1)+map.blockcount) */
		                    for( let i =startPage ; i <=  (startPage-1)+map.blockcount ; i++  ){
		                    	 if(i>map.pageCnt){
		                    		 break;
		                    	 }
		                    	// pageQA += `<li class='page-item'>`
		                    	pageQA +="<a style='color: black' class=${i==map.pageNo?"pagination-active":page} page-link' id='page' href='#' name="+map.categoryNum+">"+i+`</a>`
		                    	//pageQA +=  `</li>`
		                    }
                         
	   					
	   					//pageQA += `<li class='page-item'>`	   		
	   			    
	   			       if((startPage + map.blockcount)<=map.pageCnt){
	   			    	pageQA += ` <a class='page-link' style='color: black' href='front?key=qa&methodName=select&pageNo=${startPage+p.blockcount}' aria-label='Next'>
			        			<span aria-hidden='true'>NEXT</span>
				      		</a>`
	   			       }
	   					
	   			   // pageQA += `</li>`
	   			    
	   			    
	   			       
	   			 		$("#pagingQA").html(pageQA);
	   				});
	   			
	   			   
	   			  

				}, // 성공했을 때 실행할 함수 
				error : function(err) {
					alert(err + " 에러가 발생했어요.");
				}// 실패했을 때 실행할 함수  
	   			
			})
		}
	
	  ///////////////////////////////
	  
	    $(document).on("click","#page", function(){
	    	/* alert($(this).attr("name") +", "+ $(this).text()) */
	    	
	    	qaFilter($(this).attr("name") , $(this).text())	  
	    	
	    })
	    
	  
	  ////////////////////////
		
		function selectAll(){
			/* alert(22) */
		/*	$.ajax({
	   			url :"${pageContext.request.contextPath}/ajax" , //서버요청주소
	   			type:"post", //요청방식(method방식 : get | post | put | delete )
	   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
	   			data: {key :"qa", methodName:"select"},
	   			success :function(result){//map이나옴

					let pageQA = "";
	   			
	   			    $.each(result, function(i, map){ //2개 

	   			    
	   					
	   			        $.each(map.qaList , function(index, item){
	   			        	str += "<tr>";
							str += `<th scope="row">${'${item.qaNumber}'}</th>`;
							str += `<td>${'${item.userId}'}</td>`;
							str += `<td>${'${item.qaTitle}'}</td>`;
							str += `<td><a href='${path}/front?key=qa&methodName=selectByQANum&qaNumber=${"${item.qaNumber}"}'>${'${item.qaContent}'}</a></td>`;
							str += `<td>${'${item.qaDate}'}</td>`;
							str += "</tr>"
	   			        })   
	   			          
						$("#qaTable tr:gt(0)").remove();
					    $("#qaTable tr:eq(0)").after(str);
	   			    
					
				}, // 성공했을 때 실행할 함수 
				error : function(err) {
					alert(err + " 에러가 발생했어요.");
				}// 실패했을 때 실행할 함수  
	   			
			})*/
		}
		
		
		selectAll();
		
		$("[name=btn]").click(function(){
			qaFilter($(this).val());
		})

	});

	
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<h1>Q&A</h1>
	<nav class="navbar navbar-expand-lg navbar-light bg-white container">
		<div class="container-fluid">
			<div class="collapse navbar-collapse " id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item">

						<button type="button" class="btn btn-link-light"
							style="text-decoration: none;" value="1" name=btn>1.상품문의</button>
					</li>
					<li class="nav-item">
						<button type="button" class="btn btn-link-light"
							style="text-decoration: none;" value="2" name=btn>2.결제/환불/교환
							문의</button>
					</li>
					<li class="nav-item">
						<button type="button" class="btn btn-link-light"
							style="text-decoration: none;" value="3" name=btn>3.쿠폰/포인트
							문의</button>
					</li>
					<li class="nav-item">
						<button type="button" class="btn btn-link-light"
							style="text-decoration: none;" value="4" name=btn>4.기타문의</button>
					</li>
				</ul>


			</div>
		</div>
	</nav>

	<div class="col-sm-6, container">
		<div class="d-grid gap-2 d-md-block">
			<a class="btn btn-primary , btn btn-dark"
				href="${path}/board/qaWrite.jsp" role="button">등록하기</a>
		</div>
		<p>
		<table class="table table-hover" id="qaTable">
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">작성자</th>
				<th scope="col">카테고리</th>
				<th scope="col">제목</th>
				<th scope="col">작성일</th>
			</tr>
		</table>
	</div>

	<!-- 페이징처리 -->

	<nav aria-label="Page navigation example" id="pagingQA"
		style="text-align: center;"></nav>
	<%@include file="../common/footer.jsp"%>
</body>
</html>