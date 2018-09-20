<%--
  Created by IntelliJ IDEA.
  User: zzz
  Date: 2018-09-12
  Time: 오후 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="includes/header.jsp"%>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Tables</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->

        <script>
            function change(obj) {
                var sizeValue=obj.options[obj.selectedIndex].value;
                console.log(sizeValue);
                self.location="list?page=1&size="+sizeValue;
            }

        </script>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <h2>${pageMaker}</h2>
                        <table width="100%" class="table table-striped table-bordered table-hover" >
    <h1>음료 메뉴 </h1>
             <c:forEach var="menu1" items="${drinkList}">
	<tr class="odd gradeX">
		<td>${menu1.mno}</td>
		<td>${menu1.menu }</td>
		<td>${menu1.price }</td>
		<td>${menu1.img }</td>
		<td><img src="http://localhost:8080/getFile?fname=s_${menu1.img}"/></td>
		<form action="/store/modify">
			<input type="hidden" name='mno' value=${menu1.mno}>
			<button>수정/삭제</button>
		</form>

	</tr>
</c:forEach>
	    <h1>디저트 메튜</h1>
             <c:forEach var="menu2" items="${dessertList}">
	<tr class="odd gradeX">
		<td>${menu2.mno}</td>
		<td>${menu2.menu }</td>
		<td>${menu2.price }</td>
		<td>${menu2.img }</td>
		<td><img src="http://localhost:8080/getFile?fname=s_${menu2.img}"/></td>
		<form action="/store/modify">
			<input type="hidden" name='mno' value=${menu2.mno}>
			<button>수정/삭제</button>
		</form>

	</tr>
</c:forEach>
<a href="/store/write"><button>메뉴 추가</button></a>
<a href="/store/main"><button>메인</button></a>


                            </tbody>
                        </table>
                        <!-- /.table-responsive -->

                     

                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

<%@include file="includes/footer.jsp"%>
