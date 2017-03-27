<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:choose>
	<c:when test="${sessionScope.logUser == null}">

	</c:when>
	<c:otherwise>
		<form action="LogOutServlet" method="POST">
			<input type="submit" value="LogOut">
		</form>
	</c:otherwise>
</c:choose>