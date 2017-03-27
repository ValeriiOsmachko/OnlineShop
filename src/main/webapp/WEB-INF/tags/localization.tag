<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


 <c:set var="currentUrl"
       value="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}"/>



	<c:choose>
 	<c:when test="${fn:contains(currentUrl, '&lang')}">
            <c:set var="url" value="${fn:substringBefore(currentUrl, '&lang')}"/>
    </c:when>
    <c:otherwise>
       	 <c:set var="url" value="${currentUrl}"/>
    </c:otherwise>
    </c:choose>

 
<div class="localization">

	<a   href="${url}&lang=ru" class="btn btn-info" role="button">Russian</a>
	<a   href="${url}&lang=en" class="btn btn-info"
		role="button">English</a>
</div>

