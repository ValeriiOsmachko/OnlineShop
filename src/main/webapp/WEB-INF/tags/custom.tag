<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${pageContext.request.locale}"/>
<fmt:setBundle basename="resources" var="lang"/>


<c:choose>
	<c:when test="${empty sessionScope.logUser}">
		<span>${sessionScope.ban}</span>
		<form action="SignInServlet" method="POST">
			<fmt:message key="inputLogin" bundle="${lang}"/> <input type="text" name="login"> <fmt:message key="inputPassword" bundle="${lang}"/> <input
				type="password" name="password"> <input type="submit"
				name="submit" value="SignIn">
		</form>

	</c:when>
	<c:otherwise>
	
			<div class="user-img">
				<img src="ShowAvatarServlet"
					class="img-circle user-img img-thumbnail" alt="">
			</div>
			User name:<c:out value="${sessionScope.logUser.firstName}"></c:out>
		<br>
			User login:<c:out value="${sessionScope.logUser.login}"></c:out>
		<form action="UploadServlet" enctype="multipart/form-data"
			method="POST">
			<input type="file" name="avatar" value="choose avatar"> <input
				type="submit" value="Upload Avatar">
		</form>
	</c:otherwise>
</c:choose>