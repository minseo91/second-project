<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<caption>
		<h2 align="center">배송관리</h2>
	</caption>

	<div class="container ">
		<form  method="post" action="${path}/admin/shipping.jsp">
			<div class="row mb-3">
				<div class="col">
					<table class="table text-center">
						<thead>
							<tr>
								<th scope="col">주문번호</th>
								<th scope="col">아이디</th>
								<th scope="col">결제방식</th>
								<th scope="col">주문날짜</th>
								<th scope="col">주문상태</th>
								<th scope="col">배송상태</th>
								<th scope="col">주소</th> <!-- deli_addr + deli_addr2 어떻게? -->
								<th scope="col">상세주소</th>
								<th scope="col">연락처</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${orderList}" var="order">
								<tr>
									<th scope="row">${order.orderCode}</th>
									<td>${order.uId}</td>
									<td>${order.payCode}</td>
									<td>${order.orderDate}</td>
									<td>${order.orderStatus}</td>
									<td>${order.deliStatus}</td>
									<td>${order.deliAddr}</td> 
									<td>${order.deliAddr2}</td> 
									<td>${order.orderPhone}</td>								
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</form>
	</div>
		
<jsp:useBean class="alcohol.mvc.paging.PageCnt" id="p"/> 
	<nav aria-label="Page navigation example">
	
			<c:set var="doneLoop" value="false"/>
			<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2   , (2-1)%2    1 , (3-1)%2  0 -->
			<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 1 -->
			
		<ul class="pagination  justify-content-center">
	
			<li class="page-item">
				<c:if test="${(startPage-p.blockcount) > 0}"> <!-- (-2) > 0  -->
					<a class="page-link" style="color: black" href="${path}/front?key=order&methodName=orderAll&pageNo=${startPage-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					</a>   
				</c:if>
			</li>	
	 
			<c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
				<c:if test="${(i-1)>=p.pageCnt}">
					<c:set var="doneLoop" value="true"/>
				</c:if> 
				<c:if test="${not doneLoop}" >
				<li class="page-item"><a style="color: black" class="${i==pageNo?'pagination-active':page} page-link" id="page" href="${path}/front?key=order&methodName=orderAll&pageNo=${i}">${i}</a></li> 
				</c:if>			  
			</c:forEach>
	
		    <li class="page-item">
			    <c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
			      <a class="page-link" style="color: black" href="${path}/front?key=order&methodName=orderAll&pageNo=${startPage+p.blockcount}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </c:if>
		    </li>
	  </ul>
	
	</nav>
</body>
</html>