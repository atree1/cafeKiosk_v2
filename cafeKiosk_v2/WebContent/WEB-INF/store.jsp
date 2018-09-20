<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<span>${store.sno}</span>
	</div>
	<div>
		<span>${store.sname}</span>
	</div>
	<div>
		<span>위도: ${store.lng}, 경도: ${store.lng}</span>
	</div>
	<div>
		<span>${store.addr}</span>
	</div>
<c:forEach var="orderdetail" items="${detail}">
	<div>
		<span>주문번호: ${orderdetail.ono}</span>
	</div>
	<div>
		<span>가격: ${orderdetail.price}</span>
	</div>
	<div>
		<span>수량: ${orderdetail.qty}</span>
	</div>
</c:forEach>
</body>
</html>