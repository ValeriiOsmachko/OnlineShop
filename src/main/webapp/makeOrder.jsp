<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Make Order</title>
<link href="/Task10/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/Task10/resources/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="/Task10/resources/css/style1.css" rel="stylesheet"
	type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="New Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 




</script>
<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<!-- start menu -->
<link href="/Task10/resources/css/memenu.css" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="/Task10/resources/js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="js/simpleCart.min.js">
	
</script>
</head>
<body>
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
						<li><a class="lock" href="login.html">Login</a></li>
						<li><a class="lock" href="register.html">Register</a></li>
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
						<li class="active grid"><a class="color8" href="index.html">Home</a></li>
						<li><a class="color1" href="#">Shop</a>
							<div class="mepanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li><a href="products.html">Accessories</a></li>
												<li><a href="products.html">Bags</a></li>
												<li><a href="products.html">Caps & Hats</a></li>
												<li><a href="products.html">Hoodies & Sweatshirts</a></li>
												<li><a href="products.html">Jackets & Coats</a></li>
												<li><a href="products.html">Jeans</a></li>
												<li><a href="products.html">Jewellery</a></li>
												<li><a href="products.html">Jumpers & Cardigans</a></li>
												<li><a href="products.html">Leather Jackets</a></li>
												<li><a href="products.html">Long Sleeve T-Shirts</a></li>
												<li><a href="products.html">Loungewear</a></li>
											</ul>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li><a href="products.html">Shirts</a></li>
												<li><a href="products.html">Shoes, Boots & Trainers</a></li>
												<li><a href="products.html">Shorts</a></li>
												<li><a href="products.html">Suits & Blazers</a></li>
												<li><a href="products.html">Sunglasses</a></li>
												<li><a href="products.html">Sweatpants</a></li>
												<li><a href="products.html">Swimwear</a></li>
												<li><a href="products.html">Trousers & Chinos</a></li>
												<li><a href="products.html">T-Shirts</a></li>
												<li><a href="products.html">Underwear & Socks</a></li>
												<li><a href="products.html">Vests</a></li>
											</ul>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Popular Brands</h4>
											<ul>
												<li><a href="products.html">Levis</a></li>
												<li><a href="products.html">Persol</a></li>
												<li><a href="products.html">Nike</a></li>
												<li><a href="products.html">Edwin</a></li>
												<li><a href="products.html">New Balance</a></li>
												<li><a href="products.html">Jack & Jones</a></li>
												<li><a href="products.html">Paul Smith</a></li>
												<li><a href="products.html">Ray-Ban</a></li>
												<li><a href="products.html">Wood Wood</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div></li>
						<li class="grid"><a class="color2" href="#"> Lookbook</a>
							<div class="mepanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li><a href="products.html">Accessories</a></li>
												<li><a href="products.html">Bags</a></li>
												<li><a href="products.html">Caps & Hats</a></li>
												<li><a href="products.html">Hoodies & Sweatshirts</a></li>
												<li><a href="products.html">Jackets & Coats</a></li>
												<li><a href="products.html">Jeans</a></li>
												<li><a href="products.html">Jewellery</a></li>
												<li><a href="products.html">Jumpers & Cardigans</a></li>
												<li><a href="products.html">Leather Jackets</a></li>
												<li><a href="products.html">Long Sleeve T-Shirts</a></li>
												<li><a href="products.html">Loungewear</a></li>
											</ul>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li><a href="products.html">Shirts</a></li>
												<li><a href="products.html">Shoes, Boots & Trainers</a></li>
												<li><a href="products.html">Shorts</a></li>
												<li><a href="products.html">Suits & Blazers</a></li>
												<li><a href="products.html">Sunglasses</a></li>
												<li><a href="products.html">Sweatpants</a></li>
												<li><a href="products.html">Swimwear</a></li>
												<li><a href="products.html">Trousers & Chinos</a></li>
												<li><a href="products.html">T-Shirts</a></li>
												<li><a href="products.html">Underwear & Socks</a></li>
												<li><a href="products.html">Vests</a></li>
											</ul>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Popular Brands</h4>
											<ul>
												<li><a href="products.html">Levis</a></li>
												<li><a href="products.html">Persol</a></li>
												<li><a href="products.html">Nike</a></li>
												<li><a href="products.html">Edwin</a></li>
												<li><a href="products.html">New Balance</a></li>
												<li><a href="products.html">Jack & Jones</a></li>
												<li><a href="products.html">Paul Smith</a></li>
												<li><a href="products.html">Ray-Ban</a></li>
												<li><a href="products.html">Wood Wood</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div></li>
						<li><a class="color4" href="blog.html">Blog</a></li>
						<li><a class="color6" href="contact.html">Conact</a></li>
					</ul>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>

	</div>


	
	<div class="container">
	<h2 class="text-center">Your order is</h2>
		<table class="table table-hover table-striped" title="width:100%">
			<tr>
				<th><c:out value="Name Of Car" /></th>
				<th><c:out value="Amount" /></th>
				<th><c:out value="Price for one" /></th>
			</tr>
			<c:forEach items="${sessionScope.cart.getCart()}" var="cart">
				<tr>
					<td><c:out value="${cart.key.name}" /></td>
					<td><c:out value="${cart.value}" /></td>
					<td><c:out value="${cart.key.price}" /></td>
				</tr>
			</c:forEach>
		</table>
		
		<p class="text-left">Total price of your order is: ${sessionScope.cart.countTotalPriceFromCart()}</p>
	</div>


	<!--content-->
	<div class=" container">
		<div class=" register">
			<h1>Make Order</h1>
			<form action="CheckoutServlet" method="POST">
				<div class="col-md-6 register-top-grid">
					<h3>Delivery informaition</h3>
					<div>
						<span>Input Address</span> <input type="text" name="address">
					</div>
					<!-- 	<div>
						<span>Last Name</span> <input type="text">
					</div>
					<div>
						<span>Email Address</span> <input type="text">
					</div> -->
					<!-- <a class="news-letter" href="#"> <label class="checkbox"><input
							type="checkbox" name="checkbox" checked=""><i> </i>Sign
							Up for Newsletter</label>
					</a> -->
				</div>
				<div class="col-md-6 register-top-grid">
					<h3>Bank details</h3>
					<div>
						<span>Card Number</span> <input type="text" name="cardNumber">
					</div>
					<!-- <div>
						<span>Confirm Password</span> <input type="password">
					</div>  -->
					<input type="submit" value="Confirm Order">

				</div>
				<div class="clearfix"></div>
			</form>
		</div>
	</div>
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
				� 2015 New store All Rights Reserved | Design by <a
					href="http://w3layouts.com/" target="_blank">W3layouts</a>
			</p>
		</div>
	</div>
</body>
</html>