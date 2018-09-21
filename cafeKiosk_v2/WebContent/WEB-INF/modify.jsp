<%--
  Created by IntelliJ IDEA.
  User: BIT03-04
  Date: 2018-09-12
  Time: 오후 4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

   <div id="wrapper">


      <div id="page-wrapper">
         <div class="row">
            <div class="col-lg-12">
               <h1 class="page-header">내용 수정</h1>
            </div>
            <!-- /.col-lg-12 -->
         </div>
         <!-- /.row -->
         <div class="row">
            <div class="col-lg-12">
               <div class="panel panel-default">
                  <div class="panel-body">
                     <div class="row">
                        <div class="col-lg-6">

                           <form method="post" enctype="multipart/form-data">
                              <input type="hidden" name="mno" value="${menu.mno}">

                              <div class="form-group">
                                 <label> 메뉴이름</label> <input class="form-control" type="text"
                                    name="menu" value="${menu.menu}">
                              </div>

                              <div class="form-group">
                                 <label>가격</label> <input class="form-control" type="text"
                                    name="price" value="${menu.price}">
                              </div>

                              <div class="form-group">
                                 <label>카테고리</label> <select name="category">
                                    <option value="음료">음료</option>
                                    <option value="디저트">디저트</option>
                                 </select>

                              </div>


                              <div class="form-group">
                                 <img src="http://10.10.10.93:8080/getFile?fname=s_${menu.img}" /></p>
                                 <input type='file' name='img' multiple="multiple">
                              </div>
                              <button class="btn btn-primary">수정</button>
                           </form>   
                          
                           <form method="post" action="/store/remove">
                              <input type="hidden" name="mno" value="${menu.mno}">
                              <button class="btn btn-danger">삭제</button>
                           </form>

                        </div>
                        <!-- /.col-lg-6 (nested) -->

                        <!-- /.col-lg-6 (nested) -->
                     </div>
                     <!-- /.row (nested) -->
                  </div>
                  <!-- /.panel-body -->
               </div>
               <!-- /.panel -->
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

