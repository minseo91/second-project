<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="../common/header.jsp"%>
<title>양조장</title>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=67df1f7c9b283b2023123ffabe045899"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
a:link , a:visited{
	text-decoration: none;
}

</style>


</head>
<body>
<div class="container">
	<div class="py-5 text-center">
		<h1 style="font-weight:bold;">양조장</h1>
	</div>
		<div class="row">
			<div class="col-md-5">
				<%@include file="map.jsp"%>
			</div>
			
			<div class="col-md-7">
				<div class="row">
					<div class="col">
						<table>
							<!-- <h2>양조장 목록</h2>-->
							<tbody>
							<div class="accordion accordion-flush" id="accordionFlushExample">
							<c:forEach items="${facList}" var="factory">
								 <div class="accordion-item">
								    <h2 class="accordion-header" id="flush-headingOne">
								      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target=".${factory.fName} " aria-expanded="false" aria-controls="flush-collapseOne">
								        ${factory.fName}
								      </button>
								    </h2>
								    <div id="flush-collapseOne" class="${factory.fName} accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
								      <div class="accordion-body"><p>취급 종류 : ${factory.fType}<p>주소 : ${factory.fAddr}<p>연락처 : ${factory.fPhone}</div>
								    </div>
								  </div>
											
							<!--  
								    <tr>				
								    			    
				                        <th scope="row" id="title">${factory.fName}</a></td>	                
				                       <td>${factory.fType}</td>
				                        <td>${factory.fAddr}</td>
								    </tr>
							  -->
						    </c:forEach>
						    </div>
						    </tbody>
						    
					    </table>
				    </div>
				    <!--
				    <div class="col" name="detail">
				    	아작스로 양조장 당 내용 표시
					    	<div class="row mt-5 mb-5">
								<div class="col">
										<div class="accordion accordion-flush" id="accordionFlushExample">
										<span><b>양조장 목록</b></span>
										
										  <div class="box">
										  
										  </div>
										  
										 
										</div>
								</div>
							</div>
				    	
				    </div>
				    -->
				</div>
				
			</div>
			<footer class="my-5 pt-5 text-muted text-center text-small"></footer>
		</div>
	
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>