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

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">매장정보</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h3>매장정보 및 매출</h3>
                            <p>매장의 정보와 매출에 대한 정보.</p>
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped">
                                   
                                    <tbody>
                                        <tr>
                                            <th>매장번호</th>
                                            <td colspan="3">${store.sno}</td>
                                         
                                        </tr>
                                        <tr>
                                            <th>가게이름</th>
                                            <td colspan="3">${store.sname}</td>
                                           
                                        </tr>
                                        <tr>
                                            <th>위도</th>
                                            <td>
                                               ${store.lng}
                                            </td>
                                            <th>경도</th>
                                            <td>
                                                ${store.lng}
                                            </td>
                                            
                                        </tr>
                                  
                                       <tr>
                                            <th>총 판매량</th>
                                            <td>
                                               ${count}
                                            </td>
                                            <th>총 매출</th>
                                            <td>
                                                ${getTotal}
                                            </td>
                                            
                                        </tr>
                                         <tr>
                                            <th colspan="4"><span style="color:blue">주문건수 당 매출</span></th>
                                          
                                        </tr>
                                        <c:forEach var="map" items="${map}">
                                        <c:set var="key" value="${map.key}" />
                                        <c:set var="value" value="${map.value}" />
                                         <tr>
                                            <th>주문번호</th>
                                            <td>
                                               ${key}
                                            </td>
                                            <th>주문당 매출</th>
                                            <td>
                                                ${value}
                                            </td>
                                            
                                        </tr>
                                        </c:forEach>
                                       <%--  <c:forEach var="map" items="${map}">
<c:set var="key" value="${map.key}" />
<c:set var="value" value="${map.value}" />
${key}/ ${value}
</c:forEach> --%>
                                        
                                    </tbody>
                                </table>
                            </div>
                           
                        </div>
                    </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
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

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>