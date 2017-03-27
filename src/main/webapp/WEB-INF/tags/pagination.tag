<%@ tag language="java" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:set var="currentUrl"
       value="MainPageServlet?${pageContext.request.queryString}"/>

<c:forEach begin="1" end="${pageCount}" var="i">
    <c:choose>
        <c:when test="${fn:contains(currentUrl, '&page')}">
            <c:set var="url" value="${fn:substringBefore(currentUrl, '&page')}"/>
            <a href="${url}&page=${i}">${i}</a>
        </c:when>
        <c:otherwise>
            <a href="${currentUrl}&page=${i}">${i}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>




    
    