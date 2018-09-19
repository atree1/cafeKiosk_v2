
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<form method="post">
	<input type="hidden" name="mno" value="${menu.mno}">

	<div class="form-group">
		<label> 메뉴이름</label> <input class="form-control" type="text"
			name="menu" value="${menu.menu}">
	</div>

	<div class="form-group">
		<label>가격</label> <input class="form-control" type="text" name="price"
			value="${menu.price}">
	</div>

	<div class="form-group">
		<label>이미지</label> <input class="form-control" type="text" name="img"
			value="${menu.img}">
	</div>

	<button class="btn btn-primary">수정</button>

</form>
<form method="post" action="/store/remove">
	<input type="hidden" name="mno" value="${menu.mno}">
	<button class="btn btn-danger">삭제</button>
</form>