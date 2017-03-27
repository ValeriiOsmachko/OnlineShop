<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag isELIgnored="false" %>

<%@ attribute  name="parameter" required="true"%>
<%@ attribute  name="parameterValue" required="true"%>
<%@ attribute  name="name" required="true"%>

<c:url value="./Filter" var="filterURL">
    <c:forEach items="${paramValues}" var="currentParam">
        <c:if test="${currentParam.key ne parameter}">
            <c:forEach items="${currentParam.value}" var="item">
                <c:param name="${currentParam.key}"   value="${item}" />
            </c:forEach>
        </c:if>
    </c:forEach>
    <c:param name="${parameter}"   value="${parameterValue}" />
</c:url>

<li class=${param[parameter] == parameterValue ? 'active' : ''} ><a href='<c:out value="${filterURL}" />'>${name}</a></li>


<c:forEach items="${requestScope.filteredProducts}" var="car">
	<c:out value="">FROM TAG</c:out>
	<div class="col-sm-4 col-lg-4 col-md-4">
		<div class="thumbnail">
			<img src="ShowItemPicture?imageId=${car.idProduct}" alt="jeep">
			<div class="caption">
				<h4 class="pull-right">$ ${car.price}</h4>
				<h4>
					<a href="#">${car.name}</a>
				</h4>
				<p>${car.description}
					<a target="_blank" href="http://www.bootsnipp.com">Bootsnipp -
						http://bootsnipp.com</a>.
				</p>
			</div>
			<div class="ratings">
				<p class="pull-right">15 reviews</p>
				<p>
					<span class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span> <span
						class="glyphicon glyphicon-star"></span>
				</p>
			</div>
		</div>
	</div>
</c:forEach>

<c:if test="${currentPage != 1}">
        <td><a href="Filter?page=${sessionScope.currentPage - 1}">Previous</a></td>
    </c:if>
 
    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
            <c:forEach begin="1" end="${sessionScope.noOfPages}" var="i">
                <c:choose>
                    <c:when test="${sessionScope.currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="Filter?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
     
    <%--For displaying Next link --%>
    <c:if test="${sessionScope.currentPage lt noOfPages}">
        <td><a href="Filter?page=${sessionScope.currentPage + 1}">Next</a></td>
    </c:if>
    
    
    