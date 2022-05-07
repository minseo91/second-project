<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<style type="text/css">
a:link , a:visited{
	text-decoration: none;
}
 a:hover {
	font-weight: bold;
}
</style>

</head>
<body>
<%@include file="../common/header.jsp"%>
<caption><h2 align="center">공지사항</h2></caption>


<div class="container" >
	
	<div class="d-grid gap-2 d-md-block">
		<c:if test="${loginGrade==1}">
			<a class="btn btn-dark" href="${path}/board/noticeWrite.jsp"  role="button" value="등록하기">등록하기</a>
		</c:if>
	</div>
	<p>
	
	<form  name="read" method="post" action="${path}/board/noticeRead.jsp" style="text-align: center;">
	<table class="table">
	
	  <thead class="table-light">
	    <tr>
	      <th scope="col">글번호</th>
	      <th scope="col">제목</th>
	      <th scope="col">작성일</th>
	      <th scope="col">조회수</th>
	    <!--   <th scope="col">
	      	<button type="button" class="btn btn-primary btn-sm" id="delete">
  					삭제
			</button>
	      </th> -->
	    </tr>
	  </thead>
	  <tbody>
	   <!--  
	    <tr>
	      <th scope="row">1</th>
	      <td><a href="#" onclick="document.write.submit()">공지사항 입니다.</a></td>
	      <td>2022/04/16</td>
	      <td><input type="checkbox"  name="delete" value=""></td>
	    </tr>
	    <tr>
	      <th scope="row">2</th>
	      <td><a href="#">로그인한게 관리자라면</a></td>
	      <td>2022.04.16</td>
	      <td><input type="checkbox"  name="delete" value=""></td>
	    </tr>
	    <tr>
	      <th scope="row">3</th>
	      <td><a href="#">등록, 수정, 삭제 가능</a></td>
	      <td>2022-04-16</td>
	      <td><input type="checkbox"  name="delete" value=""></td>
	    </tr>
	    -->
	    <c:forEach items="${noticeList}" var="notice">
             <tr>
                        <th scope="row">${notice.noNumber}</th>
                        <td><a href="${path}/front?key=notice&methodName=selectByNoticeNum&noNumber=${notice.noNumber}&pageNo=${pageNo}">${notice.noTitle}</a></td>
                
                        <td>${notice.noDate}</td>
                        <td>${notice.viewCount}</td>
                   <!--  <td><input type="checkbox"  name="delete" value=""></td> -->
             </tr>
      </c:forEach>
	    
	    
	    
	  </tbody>
	</table>
	</form>
</div>

<jsp:useBean class="alcohol.mvc.paging.PageCnt" id="p"/> 
    
  
 <!--  블럭당  -->
 <nav aria-label="Page navigation example">
		
		<c:set var="doneLoop" value="false"/>
		<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2  =0  , (2-1)%2    1 , (3-1)%2  0 -->
		<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 1 -->
		
	
	
		  <!-- 
     if( ( 시작페이지 - 한블록당뿌려질[]개수) > 0 ){ // if()
	       [이전]출력한다.	
     } 
     ex) if( ( startPage -blockcount) > 0 ){

          }
		-->
		
		<!-- 
		 시작페이지 구한다(몇번부터 출력할지를 정함 [번호] )
           방법 => int temp=(현재페이지번호-1)% 한블록당 보여질[]개수;
                   int startPage=현재페이지번호 -temp; => 시작번호[]
             
             
					   int temp = (pageNo-1) % p.blockcount ;         //시작 페이지 구하기
				      int startPage = pageNo - temp;
		 -->
	<ul class="pagination  justify-content-center">

		<li class="page-item">
		  <c:if test="${(startPage-p.blockcount) > 0}"> <!-- (-2) > 0  -->
		      <a class="page-link" style="color: black" href="${path}/front?key=notice&methodName=select&pageNo=${startPage-1}" aria-label="Previous">
		      <span aria-hidden="true">&laquo;</span></a>
		  </c:if>
		 </li>
		  
		
		  <c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
			  <c:if test="${(i-1)>=p.pageCnt}">
			       <c:set var="doneLoop" value="true"/>
			    </c:if> 
			    
			  <c:if test="${not doneLoop}" >
			         <li class="page-item"><a style="color: black" class="${i==pageNo?'pagination-active':page} page-link" id="page" href="${path}/front?key=notice&methodName=select&pageNo=${i}">${i}</a></li> 
		     </c:if>
		</c:forEach>
		
				<!-- 
				[다음]
 
					  if( (시작페이지+한블록당뿌려질[]개수)<= 총페이지수){
					      [다음]출력;
					  }  
					
					  ex)if( (startPage+blockCount) <= pageCount){
					
					      }
				 -->
		<li class="page-item">
			 <c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
			     <a class="page-link" style="color: black" href="${path}/front?key=notice&methodName=select&pageNo=${startPage+p.blockcount}" aria-label="Next">
			     <span aria-hidden="true">&raquo;</span>
			     </a>
			 </c:if>
		</li>
		</ul>
		
		
	</nav> 

<%@include file="../common/footer.jsp"%>
</body>
</html>