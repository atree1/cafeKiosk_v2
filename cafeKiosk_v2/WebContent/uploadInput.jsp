<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="upload1" method="post" enctype="multipart/form-data">
	<input type="text" name="mname" >
	<input type="number" name="price"><br><br>
	<img src='http://localhost:8080/getFile?fname=가    나.jpg'>
	<a href='http://localhost:8080/getFile?fname=가    나.jpg'><h1>베놈</h1></a>	
	<input type='file' name='files'  multiple="multiple">

	<button>Save</button>
	
</form>
</body>
</html>