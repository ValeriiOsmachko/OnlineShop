<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${sessionScope.categories}" var="category">
	<tr>
		<td>Employee ID: <c:out value="${employee.eid}" /></td>
		<td>Employee Pass: <c:out value="${employee.ename}" /></td>
	</tr>
</c:forEach>