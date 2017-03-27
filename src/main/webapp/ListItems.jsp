<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://com.epam.form" prefix="tg"%>
<%@ taglib uri="http://com.epam.viewCar" prefix="car"%>
<%@ taglib uri="http://com.epam.pagination" prefix="pag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SNAP Homepage</title>

<link href="/Task10/resources/css/bootstrap.min.css" rel="stylesheet">

<link href="/Task10/resources/css/shop-homepage.css" rel="stylesheet">


</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Start Bootstrap</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">About</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Contact</a></li>
				<li><a href="index.jsp">Registrate</a></li>

			</ul>
		</div>
	</div>
	</nav>

	<div class="container">

		<div class="row">
			
			<div class="col-md-3">
				<p class="lead">SNAP</p>
				<div class="list-group">
					<a href="#" class="list-group-item">Category 1</a> <a href="#"
						class="list-group-item">Category 2</a> <a href="#"
						class="list-group-item">Category 3</a>
				</div>
				
				
				<tg:form></tg:form>
				
				<form action="Filter" method="GET">
				Category filter<br>
				<c:forEach items="${requestScope.categories}" var="category">
						<!-- Employee ID:  -->
						<label><input type="checkbox" name="name" value="${category.id}"><c:out value="${category.category}" /></label><br>
						<%-- Employee Pass: <c:out value="${category.category}" /> --%>
				</c:forEach>
				
				Manufacturer filter<br>
				<c:forEach items="${requestScope.manufacturers}" var="manufacturer">
						<!-- Employee ID:  -->
						<label><input type="checkbox" name="manufacturer" value="${manufacturer.id}"><c:out value="${manufacturer.manufacturer}" /></label><br>
						<%-- Employee Pass: <c:out value="${category.category}" /> --%>
				</c:forEach>
				
				Brand filter<br>
				<c:forEach items="${requestScope.products}" var="products">
						<!-- Employee ID:  -->
						<label><input type="checkbox" name="brand" value="${products.name}"><c:out value="${products.name}" /></label><br>
						<%-- Employee Pass: <c:out value="${category.category}" /> --%>
				</c:forEach>
				
				<!-- <input type="text" name="name1"> -->
				
					<div class="checkbox">
						<p>Price filter</p>
						<label>From:<input type="text" name="priceFrom" value=""></label>
					</div>
					<div class="checkbox">
						<label>To:<input type="text" name="priceTo" value=""></label>
					</div>
					<input type="submit" class="btn btn-default pull-right"
						value="Filter">
					Sort By<br>
					<select name="sort">
						<option value="pDESC" >price decrease</option>
						<option value="pASC">price increase</option>
						<option value="nDESC">name decrease</option>
						<option value="nASC" selected="selected">name increase</option>
					</select>
					<input type="hidden" name="currentPage" value="${currentPage}">
				</form>
			</div>
			
			<div class="col-md-9">

				<div class="row carousel-holder">
					
					<div class="col-md-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img class="slide-image" src="http://placehold.it/800x300"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="http://placehold.it/800x300"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="http://placehold.it/800x300"
										alt="">
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>
						
						
				</div>

				
				<c:forEach items="${requestScope.filteredProducts}" var="car">
					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="ShowItemPicture?imageId=${car.idProduct}" alt="jeep">
							<div class="caption">
								<h4 class="pull-right"> $ ${car.price}</h4>
								<h4>
									<a href="#">${car.name}</a>
								</h4>
								<p> ${car.description}
								 <a target="_blank"
										href="http://www.bootsnipp.com">Bootsnipp -
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
				
				<%-- <div class="row">
					
					<car:cars/>
				
			 	
					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="/Task10/resources/images/jeep.jpg" alt="jeep">
							<div class="caption">
								<h4 class="pull-right">$4499.99</h4>
								<h4>
									<a href="#">Grand Cherokee</a>
								</h4>
								<p>
									Fantastic off-road car with huge clearance <a target="_blank"
										href="http://www.bootsnipp.com">Bootsnipp -
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

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="/Task10/resources/images/scania.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$8599.99</h4>
								<h4>
									<a href="#">Scania</a>
								</h4>
								<p>Best truck for transport corporations.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">12 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="/Task10/resources/images/audi.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$9999.99</h4>
								<h4>
									<a href="#">Audi</a>
								</h4>
								<p>Amazing car for people who loves best quality and speed.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">31 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="/Task10/resources/images/mercedes.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$6999.00</h4>
								<h4>
									<a href="#">Fourth Product</a>
								</h4>
								<p>Best solution for big families who enjoys traveling.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">6 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="/Task10/resources/images/ferrari.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$10000.00</h4>
								<h4>
									<a href="#">Ferrari</a>
								</h4>
								<p>Best solution for big families who enjoys traveling.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">6 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="/Task10/resources/images/bmw.jpg" alt="">
							<div class="caption">
								<h4 class="pull-right">$5000.00</h4>
								<h4>
									<a href="#">BMW</a>
								</h4>
								<p>Best solution for big families who enjoys traveling.</p>
							</div>
							<div class="ratings">
								<p class="pull-right">6 reviews</p>
								<p>
									<span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star-empty"></span> <span
										class="glyphicon glyphicon-star-empty"></span>
								</p>
							</div>
						</div>
					</div>
							
				</div> --%>

			</div>

		</div>

	</div>
	
	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; SNAP 2016</p>
			</div>
		</div>
		</footer>

	</div>

	<script src="js/jquery.js"></script>

	<script src="js/bootstrap.min.js"></script>

</body>
</html>