
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<form method="post" enctype="multipart/form-data">

	<div class="form-group">
		<label> 메뉴이름</label> <input class="form-control" type="text"
			name="menu">
	</div>

	<div class="form-group">
		<label>가격</label> <input class="form-control" type="text" name="price">
	</div>
	<div class="form-group">
		<label>카테고리</label> <select name="category">
			<option value="음료">음료</option>
			<option value="디저트">디저트</option>
		</select>

	</div>
	<div class="form-group">
		<input class="form-control" type='file' name='img' multiple="multiple">
	</div>

	<button class="btn btn-primary">등록</button>

</form>
<form action="/store/list">
	<button class="btn btn-danger">취소</button>
</form>