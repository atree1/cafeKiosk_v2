<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tr class="odd gradeX">
		<td>${menu.mno}</td>
		<td>${menu.menu }</td>
		<td>${menu.price }</td>
		<td>${menu.img }</td>
		<form action="/store/modify">
			<input type="hidden" name='mno' value=${menu.mno}>
			<button>수정/삭제</button>
		</form>

	</tr>
</body>
</html>