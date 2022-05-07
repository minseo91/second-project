<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 등록</title>

<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.writeForm;
		
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

<caption><h2 align="center">공지사항 등록 폼</h2></caption>

<form name="writeForm" method="post" action="${path}/front?key=notice&methodName=insert" 
  onSubmit='return checkValid()' enctype="multipart/form-data">
<!-- 
     아래 문장으로 전송하면 post방식으로 전송이되고 현재 파일업로드때문에 enctype="multipart/form-data" 설정되어 있기때문에 
     request로 값을 받을수가 없다. ( MulitpartRequest로 받아야한다.) 그런데 Controller로 가기전에 Controller를 찾기위해서 
     DispatherServlet에서 request로 두개의 값을 받고 있기때문에 key, methodName은 get방식으로 별도로 전송해야한다.
     
	<input type="hidden" name="key" value = "user" />
	<input type="hidden" name="methodName" value = "login" />  

 -->

<div class="col-md-7 col-lg-8" style="float: none; margin:0 auto;">
	<div class="container">
	
		<div class="row mb-5">
			<div class="col">
			
			<div class="row m-5">
			    <label for="inputTitle" class="col-sm-2 col-form-label">제목</label>
			    <div class="col-sm-10">
			      <input type="text" name="no_title" class="form-control" id="inputTitle" placeholder="제목을 입력해주세요.">
			    </div>
			 </div>
			 
			 <div class="row m-5">
			    <label for="inputContent" class="col-sm-2 col-form-label">내용</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" name="no_content" id="inputContent" rows="10">내용에 이미지 추가는 어떻게</textarea>
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
			      <input type="date" class="form-control" id="date">
			    </div>
			 </div>
			 
		
				<p>
				
				<div class="row m-5" align="right">
					 <div class="col-sm-10">
						<button type="submit" class="btn btn-dark" >등록하기</button>
					</div>
					
					<div class="col-sm-2">
						<button type="button" class="btn btn-dark"   onclick= "location.href='${path}/front?key=notice&methodName=select'">목록</button>
					</div>
				
				</div><p>
				
			</div>
		</div>
	</div>
</div>
</form>




<%@include file="../common/footer.jsp"%>
</body>
</html>