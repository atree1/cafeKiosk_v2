<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="../vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="../vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="../dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<style>
@media ( min-width : 1200px) {
	.col-lg-6 {
		width: 100% !important
	}
}
</style>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Tables</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>


			<div class="row">
				<div class="col-lg-6">

					<div class="panel panel-default">
						<div class="panel-heading">음료</div>
						<!-- /.panel-heading -->

						<div class="panel-body" width="300px">
					
								<div style="margin-bottom: 20px">
									<h1>음료</h1>
									<c:forEach var="menu1" items="${drinkList}">
										<table class="table"
											style="width: 30%; margin: 20px; display: inline;">
											<tr>
												<td>${menu1.mno}</td>
											</tr>
											<tr>
												<td><img
													src="http://10.10.10.93:8080/getFile?fname=s_${menu1.img}" /></td>
											</tr>
											<tr>
												<td>${menu1.menu }</td>
											</tr>
											<tr>
											<tr>
												<td>${menu1.price }</td>

											</tr>
											<td><form action="/store/modify">
													<input type="hidden" name='mno' value=${menu1.mno}>
													<button class="btn btn-primary">수정/삭제</button>
												</form></td>

											</tr>
										</table>
									</c:forEach>
								</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">디저트</div>
						<div class="panel-body" width="300px">

							<div style="margin-bottom: 20px">
								<div style="display: block;">
									 <c:forEach var="menu2" items="${dessertList}">
										<table class="table"
											style="width: 30%; margin: 20px; display: inline;">
											<tr>
												<td>${menu2.mno}</td>
											</tr>
											<tr>
												<td><img
													src="http://10.10.10.93:8080/getFile?fname=s_${menu2.img}" /></td>
											</tr>
											<tr>
												<td>${menu2.menu }</td>
											</tr>
											<tr>
											<tr>
												<td>${menu2.price }</td>

											</tr>
											<td><form action="/store/modify">
													<input type="hidden" name='mno' value=${menu2.mno}>
													<button class="btn btn-primary">수정/삭제</button>
												</form></td>

											</tr>
										</table>
									</c:forEach>
								</div>

								<a href="/store/write"><button class="btn btn-primary">메뉴 추가</button></a>
<a href="/store/main"><button class="btn btn-primary">메인</button></a>

							</div>
							<!-- /.panel-body -->
						</div>
					</div>
				</div>
			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->

		<!-- jQuery -->
		<script src="../vendor/jquery/jquery.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script src="../vendor/metisMenu/metisMenu.min.js"></script>

		<!-- DataTables JavaScript -->
		<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
		<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
		<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="../dist/js/sb-admin-2.js"></script>

		<!-- Page-Level Demo Scripts - Tables - Use for reference -->
		<script>
			$(document).ready(function() {
				$('#dataTables-example').DataTable({
					responsive : true
				});
			});
		</script>
</body>

</html>
