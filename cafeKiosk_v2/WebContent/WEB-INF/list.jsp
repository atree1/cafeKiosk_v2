<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:forEach var="menu" items="${list}">
	<tr class="odd gradeX">
		<td>${menu.mno}</td>
		<td>${menu.menu }</td>
		<td>${menu.price }</td>
		<td>${menu.img }</td>
		<form action="/store/modify">
			<input type="hidden" name='mno' value=${menu.mno}>
			<button>수정/삭제</button>
		</form>

	</tr>
</c:forEach>
<div class="well">
	<ul class="pagination">
		<c:if test="${pageMaker.prev}">
			<li><a
				href="list?page=${pageMaker.start-1}&size=${pageMaker.pageDTO.size}">Prev</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
			<li ${pageMaker.pageDTO.page==num?"class='active'":""}><a
				href="list?page=${num}&size=${pageMaker.pageDTO.size}">${num}</a></li>
		</c:forEach>
		<c:if test="${pageMaker.next}">
			<li><a
				href="list?page=${pageMaker.end+1}&size=${pageMaker.pageDTO.size}">Next</a></li>
		</c:if>
	</ul>
</div>

<a href="/store/write"><button>메뉴 추가</button></a>
<a href="/main.jsp"><button>메인</button></a>