<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 수정</title>
<script type="text/javascript">
$(function(){
	$("[name=noContent]").val($("#inputContent").val());
	$("[name=noTitle]").val($("#inputTitle").val());
	$("[name=noDate]").val($("#date").val());
	
})

</script>
<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.updateForm;
		
	if ( f.no_title.value == "") {
	    alert( "제목을 입력해 주세요." );
	    f.no_title.focus();
		return false;
    }
	if ( f.no_content.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.no_content.focus();
		return false;
	}

	
    return true;
}
</SCRIPT>
</head>
<body>
<%@include file="../common/header.jsp"%>

<caption><h2 align="center">공지사항 수정 폼</h2></caption>

	<div class="col-md-7 col-lg-8" style="float: none; margin:0 auto;">
		<div class="container">
			<form name="updateForm" method="post" action="${path}/front">
			<div class="row mb-5">
				<div class="col">
				
				<div class="row m-5">
				    <label for="inputTitle" class="col-sm-2 col-form-label">제목</label>
				    <div class="col-sm-10">
				    
				      <input type="text" name="noTitle" class="form-control" id="inputTitle" value="${param.noTitle}" placeholder="제목을 입력해주세요.">
				    </div>
				</div>
				 
				<div class="row m-5">
				    <label for="inputContent" class="col-sm-2 col-form-label">내용</label>
				    <div class="col-sm-10">
				      <textarea class="form-control" name="noContent" id="inputContent" rows="10">${param.noContent}</textarea>
				    </div>
				</div>
		<!--  	 
				<div class="row m-5">
				    <div class="col-sm-2"></div>
				    <div class="col-sm-10">
					  <label for="formFileMultiple" class="form-label"></label>
					  <input class="form-control" type="file" id="formFileMultiple" multiple>
					</div>
				</div>
			-->		 
				 <div class="row m-5">
				    <label for="date" class="col-sm-2 col-form-label">날짜</label>
				    <div class="col-sm-10">
				      <input type="date" name="noDate" class="form-control" id="date" value="${param.noDate}">
				    </div>
				 </div>
				 
			
					<p>

					<div class="row m-5" align="right">
						 <div class="col-sm-10">
						 
						 	
   								 <input type="hidden" name="key" value="notice" >
   								 <input type="hidden" name="methodName" value="update" >
   								 <input type='hidden' name='noNumber' value="${param.noNumber}">
   								 <button type="submit" class="btn btn-dark" >수정하기</button>
						 	
						 
						 
						
						</div>
						
						<div class="col-sm-2">
						
							<button type="button" class="btn btn-dark"   onclick= "location.href='${path}/front?key=notice&methodName=select'">목록</button>
						</div>
					
					</div><p>
				
				</div>
			</div>
			</form>	
		</div>
	</div>

</body>
</html>