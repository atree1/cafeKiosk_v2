
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<form method="post">

	<div class="form-group">
		<label> 메뉴이름</label> <input class="form-control" type="text"
			name="menu">
	</div>

	<div class="form-group">
		<label>가격</label> <input class="form-control" type="text" name="price">
	</div>

<div class="form-group">
		<label>이미지</label> <input class="form-control" type="text" name="img">
	</div>

	<button class="btn btn-primary">등록</button>

</form>
<form action="/store/list">
	<button class="btn btn-danger">취소</button>
</form>