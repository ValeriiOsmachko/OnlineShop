<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://com.epam.form" prefix="tg"%>
<%@ taglib uri="http://com.epam.viewCar" prefix="car"%>
<%@ taglib uri="http://com.epam.pagination" prefix="pag"%>
<%@ taglib uri="http://com.epam.localization" prefix="local"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Products</title>
<link href="/Task10/resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/Task10/resources/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="/Task10/resources/css/style1.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="New Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
<!-- start menu -->
<link href="/Task10/resources/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="/Task10/resources/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="/Task10/resources/js/simpleCart.min.js"> </script>

</head>
<body>

<fmt:setLocale value="${pageContext.request.locale}"/>
<fmt:setBundle basename="resources" var="lang"/>

	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="search">
					<form>
						<input type="text" value="Search " onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Search';}">
						<input type="submit" value="Go">
					</form>
				</div>
				<div class="header-left">
					<ul>
						<li><a class="lock" href="login.html"><fmt:message key="login" bundle="${lang}"/></a></li>
						<li><a class="lock" href="cart.jsp"><fmt:message key="cart" bundle="${lang}"/></a></li>
						<li></li>

					</ul>
					<div class="cart box_1">
						<a href="checkout.html">
							<h3>
								<div class="total">
									<span class="simpleCart_total"></span> (<span
										id="simpleCart_quantity" class="simpleCart_quantity"></span>
									items)
								</div>
								<img src="images/cart.png" alt="" />
							</h3>
						</a>
						<p>
							<a href="javascript:;" class="simpleCart_empty">Empty Cart</a>
						</p>

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt=""></a>
				</div>
				<div class=" h_menu4">
					<ul class="memenu skyblue">
						<li class="active grid"><a class="color8" href="index2version.jsp">Home</a></li>
					</ul>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>

	</div>

	

	<local:localization/>
	
	<div class="product">
		<div class="container">
			<div class="col-md-3 product-price">


				<form action="MainPageServlet" method="GET">
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
				
			<%-- 	Brand filter<br>
				<c:forEach items="${requestScope.products}" var="products">
						<!-- Employee ID:  -->
						<label><input type="checkbox" name="brand" value="${products.name}"><c:out value="${products.name}" /></label><br>
						Employee Pass: <c:out value="${category.category}" />
				</c:forEach> --%>
				
				 Input Name: <input type="text" name="name1"> 
				
				Price filter
				From:<input type="text" name="priceFrom" value="">
				To:<input type="text" name="priceTo" value="">
				<!-- 	<div class="checkbox">
						<p>Price filter</p>
						<label>From:<input type="text" name="priceFrom" value=""></label>
					</div>
					<div class="checkbox">
						<label>To:<input type="text" name="priceTo" value=""></label>
					</div> -->
					<input type="submit" class="btn btn-default pull-right"
						value="Filter">
					Sort By<br>
					<select name="sort">
						<option value="pDESC" >price decrease</option>
						<option value="pASC">price increase</option>
						<option value="nDESC">name decrease</option>
						<option value="nASC" selected="selected">name increase</option>
					</select>
					<%-- <input type="hidden" name="currentPage" value="${currentPage}"> --%>
				</form>
				
				<div class=" rsidebar span_1_of_left">
					<div class="of-left">
						<h3 class="cate">Categories</h3>
					</div>
					<ul class="menu">
						<li class="item1"><a href="#">Men </a>
							<ul class="cute">
								<li class="subitem1"><a href="single.html">Cute Kittens
								</a></li>
								<li class="subitem2"><a href="single.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="single.html">Automatic
										Fails </a></li>
							</ul></li>
						<li class="item2"><a href="#">Women </a>
							<ul class="cute">
								<li class="subitem1"><a href="single.html">Cute Kittens
								</a></li>
								<li class="subitem2"><a href="single.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="single.html">Automatic
										Fails </a></li>
							</ul></li>
						<li class="item3"><a href="#">Kids</a>
							<ul class="cute">
								<li class="subitem1"><a href="single.html">Cute Kittens
								</a></li>
								<li class="subitem2"><a href="single.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="single.html">Automatic
										Fails</a></li>
							</ul></li>
						<li class="item4"><a href="#">Accesories</a>
							<ul class="cute">
								<li class="subitem1"><a href="single.html">Cute Kittens
								</a></li>
								<li class="subitem2"><a href="single.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="single.html">Automatic
										Fails</a></li>
							</ul></li>

						<li class="item4"><a href="#">Shoes</a>
							<ul class="cute">
								<li class="subitem1"><a href="product.html">Cute
										Kittens </a></li>
								<li class="subitem2"><a href="product.html">Strange
										Stuff </a></li>
								<li class="subitem3"><a href="product.html">Automatic
										Fails </a></li>
							</ul></li>
					</ul>
				</div>
				<!--initiate accordion-->
				<script type="text/javascript">
					$(function() {
						var menu_ul = $('.menu > li > ul'), menu_a = $('.menu > li > a');
						menu_ul.hide();
						menu_a.click(function(e) {
							e.preventDefault();
							if (!$(this).hasClass('active')) {
								menu_a.removeClass('active');
								menu_ul.filter(':visible').slideUp('normal');
								$(this).addClass('active').next().stop(true,
										true).slideDown('normal');
							} else {
								$(this).removeClass('active');
								$(this).next().stop(true, true).slideUp(
										'normal');
							}
						});

					});
				</script>
				<!---->
				<div class="product-middle">

					<div class="fit-top">
						<h6 class="shop-top">Lorem Ipsum</h6>
						<a href="single.html" class="shop-now">SHOP NOW</a>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="sellers">
					<div class="of-left-in">
						<h3 class="tag">Tags</h3>
					</div>
					<div class="tags">
						<ul>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>

							<div class="clearfix"></div>
						</ul>

					</div>

				</div>
				<!---->
				
				
				
				<div class="product-bottom">
					<div class="of-left-in">
						<h3 class="best">Best Sellers</h3>
					</div>
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.html"><img class="img-responsive "
								src="images/p1.jpg" alt=""></a>

						</div>
						<div class=" fashion-grid1">
							<h6 class="best2">
								<a href="single.html">Lorem ipsum dolor sit amet
									consectetuer </a>
							</h6>

							<span class=" price-in1"> $40.00</span>
						</div>

						<div class="clearfix"></div>
					</div>
					<div class="product-go">
						<div class=" fashion-grid">
							<a href="single.html"><img class="img-responsive "
								src="images/p2.jpg" alt=""></a>

						</div>
						<div class="fashion-grid1">
							<h6 class="best2">
								<a href="single.html">Lorem ipsum dolor sit amet
									consectetuer </a>
							</h6>

							<span class=" price-in1"> $40.00</span>
						</div>

						<div class="clearfix"></div>
					</div>

				</div>
				<div class=" per1">
					<a href="single.html"><img class="img-responsive"
						src="images/pro.jpg" alt="">
						<div class="six1">
							<h4>DISCOUNT</h4>
							<p>Up to</p>
							<span>60%</span>
						</div></a>
				</div>
			</div>
			
				Total price:
				<p id="totalPrice"/> 
				Total amount of products
				<p id="totalCount"/>
			
				<c:forEach items="${requestScope.filteredProducts}" var="car">
				<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="ShowItemPicture?imageId=${car.idProduct}" alt="">
								<div class="pro-grid">
									<div class="linkAddItem">
									<span class="buy-in">Buy Now<a href="#">Add to Cart</a></span>
									<input class="idProd" id="hid" type="hidden" name="idProduct" value="${car.idProduct}">
									</div>
								</div> </a>
						</div>
						<p class="tun">${car.description}</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i> ${car.name} $${car.price}
							</p></a>
					</div>
				</c:forEach>
			
		<!-- 	<div class="col-md-9 product1">
				<div class=" bottom-product">
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="/Task10/resources/images/pi3.jpg" alt="">
								<div class="pro-grid">
									<span class="buy-in">Buy Now</span>
								</div> </a>
						</div>
						<p class="tun">It is a long established fact that a reader</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i>$500.00
							</p></a>
					</div>
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="/Task10/resources/images/pi1.jpg" alt="">
								<div class="pro-grid">
									<span class="buy-in">Buy Now</span>
								</div> </a>
						</div>
						<p class="tun">It is a long established fact that a reader</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i>$500.00
							</p></a>
					</div>
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="/Task10/resources/images/pi4.jpg" alt="">
								<div class="pro-grid">
									<span class="buy-in">Buy Now</span>
								</div> </a>
						</div>
						<p class="tun">It is a long established fact that a reader</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i>$500.00
							</p></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class=" bottom-product">
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="/Task10/resources/images/pi5.jpg" alt="">
								<div class="pro-grid">
									<span class="buy-in">Buy Now</span>
								</div> </a>
						</div>
						<p class="tun">It is a long established fact that a reader</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i>$500.00
							</p></a>
					</div>
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="/Task10/resources/images/pi.jpg" alt="">
								<div class="pro-grid">
									<span class="buy-in">Buy Now</span>
								</div> </a>
						</div>
						<p class="tun">It is a long established fact that a reader</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i>$500.00
							</p></a>
					</div>
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="/Task10/resources/images/pi1.jpg" alt="">
								<div class="pro-grid">
									<span class="buy-in">Buy Now</span>
								</div> </a>
						</div>
						<p class="tun">It is a long established fact that a reader</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i>$500.00
							</p></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class=" bottom-product">
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="/Task10/resources/images/pi3.jpg" alt="">
								<div class="pro-grid">
									<span class="buy-in">Buy Now</span>
								</div> </a>
						</div>
						<p class="tun">It is a long established fact that a reader</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i>$500.00
							</p></a>

					</div>
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="/Task10/resources/images/pi4.jpg" alt="">
								<div class="pro-grid">
									<span class="buy-in">Buy Now</span>
								</div> </a>
						</div>
						<p class="tun">It is a long established fact that a reader</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i>$500.00
							</p></a>
					</div>
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
							<a href="single.html"><img class="img-responsive"
								src="/Task10/resources/images/pi5.jpg" alt="">
								<div class="pro-grid">
									<span class="buy-in">Buy Now</span>
								</div> </a>
						</div>
						<p class="tun">It is a long established fact that a reader</p>
						<a href="#" class="item_add"><p class="number item_price">
								<i> </i>$500.00
							</p></a>
					</div>
					<div class="clearfix"></div>
				</div>

			</div> -->
			<div class="clearfix"></div>
			<nav class="in">
			<ul class="pagination">
				<!-- <li class="disabled"><a href="#" aria-label="Previous"><span
						aria-hidden="true">«</span></a></li> -->
				<!-- <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li> -->
			<!-- 	<li><a href="#">2 <span class="sr-only"></span></a></li>
				<li><a href="#">3 <span class="sr-only"></span></a></li>
				<li><a href="#">4 <span class="sr-only"></span></a></li>
				<li><a href="#">5 <span class="sr-only"></span></a></li> -->
				 <li><!-- <a href="#" aria-label="Next"> --><!-- <span aria-hidden="true">»</span> --> 
				<input type="hidden" name="currentPage" value="${currentPage}">
				<pag:pagination/>
				</a></li>
			</ul>
			</nav>
		</div>

	</div>

	<!---->
                                       
		
	<!--//content-->
	<div class="footer">
		<div class="container">
			<div class="footer-top-at">

				<div class="col-md-4 amet-sed">
					<h4>MORE INFO</h4>
					<ul class="nav-bottom">
						<li><a href="#">How to order</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="contact.html">Location</a></li>
						<li><a href="#">Shipping</a></li>
						<li><a href="#">Membership</a></li>
					</ul>
				</div>
				<div class="col-md-4 amet-sed ">
					<h4>CONTACT US</h4>

					<p>Contrary to popular belief</p>
					<p>The standard chunk</p>
					<p>office: +12 34 995 0792</p>
					<ul class="social">
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>
						<li><a href="#"><i class="rss"> </i></a></li>
						<li><a href="#"><i class="gmail"> </i></a></li>

					</ul>
				</div>
				<div class="col-md-4 amet-sed">
					<h4>Newsletter</h4>
					<p>Sign Up to get all news update and promo</p>
					<form>
						<input type="text" value="" onfocus="this.value='';"
							onblur="if (this.value == '') {this.value ='';}"> <input
							type="submit" value="Sign up">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-class">
			<p>
				© 2015 New store All Rights Reserved | Design by <a
					href="http://w3layouts.com/" target="_blank">W3layouts</a>
			</p>
		</div>
	</div>
	<script src="/Task10/resources/js/ajax_add_to_cart.js"></script>
</body>
</html>