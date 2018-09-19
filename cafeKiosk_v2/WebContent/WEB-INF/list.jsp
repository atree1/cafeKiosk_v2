<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	
<c:forEach var="menu" items="${list}">
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
</c:forEach>

	<a href="/store/write"><button>메뉴 추가</button></a>