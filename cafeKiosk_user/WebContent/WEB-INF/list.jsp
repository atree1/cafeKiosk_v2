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
						<div class="panel-heading"></div>
						<!-- /.panel-heading -->

						<div class="panel-body" width="300px">
							<form action="/user/order" method="POST">

								<div style="margin-bottom: 20px">
									<h1>음료</h1>

									<c:forEach var="drink" items="${drinkList}">
										<table style="width: 30%; margin: 10px; display: inline;">
											<tr>
												<th><img
													src="http://10.10.10.93:8080/getFile?fname=s_${drink.img}" /></th>
											</tr>
											<tr>
												<td>${drink.menu}</td>
											</tr>
											<tr>
												<td>가격: ${drink.price}</td>
												<td>수량: <select name="qty_drink">
														<option selected="selected" value="${drink.mno}_0">0</option>
														<option value="${drink.mno}_1">1</option>
														<option value="${drink.mno}_2">2</option>
														<option value="${drink.mno}_3">3</option>
														<option value="${drink.mno}_4">4</option>
														<option value="${drink.mno}_5"">5</option>
												</select>

												</td>

											</tr>
										</table>
									</c:forEach>
								</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<div class="panel panel-default">
						<div class="panel-heading"></div>
						<div class="panel-body" width="300px">

							<h1>디저트</h1>
							<c:forEach var="dessert" items="${dessertList}">
								<table style="width: 30%; margin: 10px; display: inline;"">
									<tr>
										<th><img
											src="http://10.10.10.93:8080/getFile?fname=s_${dessert.img}" /></th>
									</tr>
									<tr>
										<td>${dessert.menu}</td>
									</tr>
									<tr>
										<td>가격: ${dessert.price}</td>
										<td>수량: <select name="qty_dessert">
												<option selected="selected" value="${dessert.mno}_0">0</option>
												<option value="${dessert.mno}_1">1</option>
												<option value="${dessert.mno}_2">2</option>
												<option value="${dessert.mno}_3">3</option>
												<option value="${dessert.mno}_4">4</option>
												<option value="${dessert.mno}_5"">5</option>
										</select>
										</td>

									</tr>
								</table>
							</c:forEach>

						</div>

						<button class="btn btn-primary" style="margin-bottom: 5px">주문하기</button>
						</form>
						<button class="btn btn-danger" onClick="window.location.reload()">취소</button>
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