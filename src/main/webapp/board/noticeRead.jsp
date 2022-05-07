<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 보기</title>

<SCRIPT language=javascript>


</script>
<style type="text/css">

</style>
</head>
<body>
<%@include file="../common/header.jsp"%>
<caption><h2 align="center">공지사항</h2></caption>



<div class="col-md-7 col-lg-8" style="float: none; margin:0 auto;">
	<div class="container">
	
		<div class="row mb-5">
			<div class="col">
			
			<div class="row m-5">
			    <label for="inputTitle" class="col-sm-2 col-form-label">제목</label>
			    <div class="col-sm-10">
			      <textarea readonly class="form-control-plaintext" id="inputTitle" >${notice.noTitle}</textarea>
			    </div>
			 </div>
			 
			 <div class="row m-5">
			    <label for="inputReadNum" class="col-sm-2 col-form-label">조회수</label>
			    <div class="col-sm-10">
			      <textarea readonly class="form-control-plaintext" id="inputReadNum">${requestScope.notice.viewCount}</textarea>
			    </div>
			 </div>
			 
			 <div class="row m-5">
			    <label for="inputContent" class="col-sm-2 col-form-label">내용</label>
			    <div class="col-sm-10">
			      <textarea readonly class="form-control-plaintext" id="inputContent" rows="10">${notice.noContent}</textarea>
			    </div>
			 </div>
			 			 
	<!--  	 
			 <div class="row m-5">
			    <div class="col-sm-2"></div>
			    <div class="col-sm-10">
				  <label for="formFileDisabled" class="form-label"></label>
				  <input class="form-control" type="file" id="formFileDisabled" disabled>
				</div>
			 </div>
		-->		 
			 <div class="row m-5">
			    <label for="date" class="col-sm-2 col-form-label">작성일</label>
			    <div class="col-sm-10">
			      ${requestScope.notice.noDate}
			    </div>
			 </div>
 
		
				<p>
           			
				<div class="row m-5" >
					<div class="col-sm-2" align="left">
						<button type="button" class="btn btn-dark"  onclick= "location.href='${path}/front?key=notice&methodName=select'">목록</button>
					</div>
					<div class="col-sm-8" align="right">
					<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
					<form name="requestForm" method="get" action="${path}/board/noticeUpdate.jsp">	
							<input type=hidden name="noNumber" value="${notice.noNumber}">
							<input type=hidden name="noTitle" value="${notice.noTitle}">
							<input type=hidden name="noContent" value="${notice.noContent}">	
							<c:if test="${loginGrade==1}">			
								<input type=submit class="btn btn-light" value="수정하기">
							</c:if>
					</form>
					<!-- 	<button type="button" onclick="location.href='${path}/board/noticeUpdate.jsp'" class="btn btn-light" >수정하기</button> -->
					</div>
					 <div class="col-sm-2" align="right">
						 <c:if test="${loginGrade==1}">
							<button type="button" class="btn btn-light"  onclick= "location.href='${path}/front?key=notice&methodName=delete&noNumber=${notice.noNumber}'">삭제하기</button>
						</c:if>
					</div>
				</div>
	          			
			</div>
		</div>
	</div>
</div>




<%@include file="../common/footer.jsp"%>
</body>
</html>