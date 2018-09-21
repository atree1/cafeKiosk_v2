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


    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Tables</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->

      
    <h1>주문번호:${ono } </h1>
             <c:forEach var="menu1" items="${orderList}">
	<tr class="odd gradeX">
		<td>${menu1.mno}</td>
		<td>${menu1.menu }</td>
		<td>${menu1.price }</td>
		<td>${menu1.qty }</td>
		
	</tr>
</c:forEach>
<h1>총 주문금액: ${total }</h1>
<a href="/user/list"><button>메인</button></a>


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


