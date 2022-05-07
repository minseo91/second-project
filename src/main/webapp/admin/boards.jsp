<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판관리</title>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<style type="text/css">
h1 {
	text-align: center;
}

div {
	margin 100px;
	
}
</style>
<script type="text/javascript">
	$(function() {
		
		function qaFilter(v){	

			$.ajax({
	   			url :"${pageContext.request.contextPath}/ajax" , //서버요청주소
	   			type:"post", //요청방식(method방식 : get | post | put | delete )
	   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
	   			data: {key :"qa", methodName:"selectFilter", cate:v},
	   			success :function(result){//map이나옴

	   			    $.each(result, function(i, map){ //2개 
	   			       let str = "";
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
	   			    
	   			    })

				}, // 성공했을 때 실행할 함수 
				error : function(err) {
					alert(err + " 에러가 발생했어요.");
				}// 실패했을 때 실행할 함수  
	   			
			})
		}
	
	
		
		function selectAll(){
			$.ajax({
	   			url :"${pageContext.request.contextPath}/ajax" , //서버요청주소
	   			type:"post", //요청방식(method방식 : get | post | put | delete )
	   			dataType:"json"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
	   			data: {key :"qa", methodName:"select"},
	   			success :function(result){//map이나옴

					let pageQA = "";
	   			
	   			    $.each(result, function(i, map){ //2개 
	   			       let str = "";
	   			    
	   					// 페이징처리 일단 보류
/* 		   				let doneLoop = false;
		   				let temp = (data.map.pageNo - 1) % data.map.blockCount;
		   				let startPage = data.map.pageNo - temp; 
					   			    
	   			   		pageQA += `<li class='page-item'>`
	   			   		
	   					if('startPage - data.map.blockCount > 0') {
	   						pageQA += `<a class='page-link' style='color: black' href='${path}/front?key=qa&methodName=select&pageNo=${startPage-1}' aria-label='Previous'>
	   						<span aria-hidden='true'>&laquo;</span>`
	   					}
	   			   	
	   					pageQA += `</li>`
	   					
	   					$.each(result.qaList, function(index, item) {
	   						if('(i-1) >= data.map.pageCnt}') {
	   							doneLoop = true;
	   						}	
	   						if('not doneLoop') {
	   							pageQA += `<li class='page-item'>
	   											<a style='color: black' class='${i==pageNo?"pagination-active":page} page-link' id='page' href='${path}/front?key=qa&methodName=select&pageNo=${i}'>${i}</a>
	   									   </li>`
	   						}
	   					})
	   					
	   					
	   					pageQA += `<li class='page-item'>`
	   					if('${(startPage+p.blockcount)<=p.pageCnt}') {
	   						pageQA += ` <a class='page-link' style='color: black' href='front?key=qa&methodName=select&pageNo=${startPage+p.blockcount}' aria-label='Next'>
	   					        			<span aria-hidden='true'>&raquo;</span>
	   						      		</a>`
	   					}
	   					pageQA += `</li>` */
	   			    
	   				 });
	   			    $("#pagingQA").html(pageQA);
	   			    
	   					
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
	   			
			})
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
	<h1>게시판관리</h1>
	<nav class="navbar navbar-expand-lg navbar-light bg-white container">
		<div class="container-fluid">
			<div class="collapse navbar-collapse " id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item">

						<button type="button" class="btn btn-link-light"
							style="text-decoration: none;" value="1" name=btn>1.notice</button>
					</li>
					<li class="nav-item">
						<button type="button" class="btn btn-link-light"
							style="text-decoration: none;" value="2" name=btn>2.Q&A</button>
					</li>
					<li class="nav-item">
						<button type="button" class="btn btn-link-light"
							style="text-decoration: none;" value="3" name=btn>3.review</button>
					</li>
					<!-- <li class="nav-item">
						<button type="button" class="btn btn-link-light"
							style="text-decoration: none;" value="4" name=btn>4.기타문의</button>
					</li> -->
				</ul>


			</div>
		</div>
	</nav>


	<div class="col-sm-6, container">
		<%-- <div class="d-grid gap-2 d-md-block">
			<a class="btn btn-primary" href="${path}/board/qaWrite.jsp"
				role="button">등록하기</a>
		</div>
		<p> --%>
	
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
<jsp:useBean class="alcohol.mvc.paging.PageCnt" id="p"/> 
<nav aria-label="Page navigation example">

		<c:set var="doneLoop" value="false"/>
		<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2   , (2-1)%2    1 , (3-1)%2  0 -->
		<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 1 -->
	<ul class="pagination  justify-content-center">

		<li class="page-item">
			<c:if test="${(startPage-p.blockcount) > 0}"> <!-- (-2) > 0  -->
				<a class="page-link" style="color: black" href="${path}/front?key=qa&methodName=select&pageNo=${startPage-1}" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
				</a>   
			</c:if>
		</li>	
 
		<c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
			<c:if test="${(i-1)>=p.pageCnt}">
				<c:set var="doneLoop" value="true"/>
			</c:if> 
			<c:if test="${not doneLoop}" >
			<li class="page-item"><a style="color: black" class="${i==pageNo?'pagination-active':page} page-link" id="page" href="${path}/front?key=qa&methodName=select&pageNo=${i}">${i}</a></li> 
			</c:if>			  
		</c:forEach>

    <li class="page-item">
	    <c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
	      <a class="page-link" style="color: black" href="front?key=qa&methodName=select&pageNo=${startPage+p.blockcount}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </c:if>
    </li>
    

    	
  </ul>

</nav>
<%@include file="../common/footer.jsp"%>
</body>
</html>