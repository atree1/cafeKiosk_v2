<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/user/order">

	<h1>음료</h1>

	<c:forEach var="drink" items="${drinkList}">
		<table style="width:30%; margin: 10px; display:inline;">
			<tr>
				<th><img
					src="http://10.10.10.93:8080/getFile?fname=s_${drink.img}" /></th>
			</tr>
			<tr>
				<td>${drink.menu}</td>
			</tr>
			<tr>
				<td>수량: 
				<select name="qty_drink">
					<option selected="selected" value="${drink.mno}_0">0</option>
					<option value="${drink.mno}_1">1</option>
					<option value="${drink.mno}_2">2</option>
					<option value="${drink.mno}_3">3</option>
					<option value="${drink.mno}_4">4</option>
					<option value="${drink.mno}_5"">5</option>
				</select>

				</td>
				<td>가격: ${drink.price}</td>
			</tr>
		</table>
	</c:forEach>
	<h1>디저트</h1>
	<c:forEach var="dessert" items="${dessertList}">
		<table style="width:30%; margin: 10px; display:inline;"">
			<tr>
				<th><img
					src="http://10.10.10.93:8080/getFile?fname=s_${dessert.img}" /></th>
			</tr>
			<tr>
				<td>${dessert.menu}</td>
			</tr>
			<tr>
				<td>수량:
					<select name="qty_dessert">
					<option selected="selected" value="${dessert.mno}_0">0</option>
					<option value="${dessert.mno}_1">1</option>
					<option value="${dessert.mno}_2">2</option>
					<option value="${dessert.mno}_3">3</option>
					<option value="${dessert.mno}_4">4</option>
					<option value="${dessert.mno}_5"">5</option>
					</select>
				</td>
				<td>가격: ${dessert.price}</td>
			</tr>
		</table>
	</c:forEach>
	
	<button>주문하기</button>
</form>
<button>취소</button>
</body>
</html>