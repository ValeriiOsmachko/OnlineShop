<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cart</title>
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
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="/Task10/resources/js/simpleCart.min.js">
	
</script>
</head>
<body>
	<!--header-->
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
		<div class="check">
			<h1 id="totAm">My Shopping Bag
				(${sessionScope.cart.countAmountOfProductsInCart()})</h1>
			<div class="col-md-9 cart-items">

				<script>
					$(document).ready(function(c) {
						$('.close1').on('click', function(c) {
							$('.cart-header').fadeOut('slow', function(c) {
								$('.cart-header').remove();
							});
						});
					});
				</script>

				<c:forEach items="${sessionScope.cart.getCart()}" var="entry">
					<script>
						$(document).ready(function(c) {
							$('.close1').on('click', function(c) {
								$('.cart-header').fadeOut('slow', function(c) {
									$('.cart-header').remove();
								});
							});
						});
					</script>
					<div class="${entry.key.idProduct}">
					<div class="cart-header">
						<!-- <div class="deleteFromCart"></div> -->
						<!-- <div class="close1"></div> -->
						<button type="button" class="btn btn-primary btn-sm" id="${entry.key.idProduct}" onClick="deleteItem(this.id)">Delete Item</button>
						<div class="cart-sec simpleCart_shelfItem">
							<div class="cart-item cyc">
								<img src="ShowItemPicture?imageId=${entry.key.idProduct}"
									class="img-responsive" alt="" />
							</div>
							<div class="cart-item-info">
								<h3>
									<a href="#">${entry.key.name}</a><span>Model No: 3578</span>
								</h3>
								<form class="newAmount" id="newAmount">
									Input amount of this car: <input class="abc" type="number"
										name="newAmount" id="newAmount" value="${entry.value}"> <input type="submit"
										value="Change Amount"> <input class="idProd" id="hid"
										type="hidden" name="idProduct" value="${entry.key.idProduct}">
								</form>
								<ul class="qty">
									<li><p id="">Price for one amount: ${entry.key.price}</p></li>
									<li><p id="totalCount">Total amount of this car :
											${entry.value}</p></li>
								</ul>

								<div class="delivery">
									<p>Service Charges : Rs.100.00</p>
									<span>Delivered in 2-3 bussiness days</span>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="clearfix"></div>

						</div>
					</div>
					</div>
				</c:forEach>
				<!-- <div class="cart-header">
					<div class="deleteFromCart"></div>
					<div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							<img src="ShowItemPicture?imageId=1" class="img-responsive"
								alt="" />
						</div>
						<div class="cart-item-info">
							<h3>
								<a href="#">Mountain Hopper(XS R034)</a><span>Model No:
									3578</span>
							</h3>
							<ul class="qty">
								<li><p>Size : 5</p></li>
								<li><p>Qty : 1</p></li>
							</ul>

							<div class="delivery">
								<p>Service Charges : Rs.100.00</p>
								<span>Delivered in 2-3 bussiness days</span>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>

					</div>
				</div> -->
				<!-- 	<script>
					$(document).ready(function(c) {
						$('.close2').on('click', function(c) {
							$('.cart-header2').fadeOut('slow', function(c) {
								$('.cart-header2').remove();
							});
						});
					});
				</script>
				<div class="cart-header2">
					<div class="deleteFromCart"></div>
					<div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							<img src="ShowItemPicture?imageId=2" class="img-resp                                                     onsive"
								alt="" />
						</div>
						<div class="cart-item-info">
							<h3>
								<a href="#">Mountain Hopper(XS R034)</a><span>Model No:
									3578</span>
							</h3>
							<ul class="qty">
								<li><p>Size : 5</p></li>
								<li><p>Qty : 1</p></li>
							</ul>
							<div class="delivery">
								<p>Service Charges : Rs.100.00</p>
								<span>Delivered in 2-3 bussiness days</span>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>

					</div>
				</div> -->
			</div>
			<div class="col-md-3 cart-total">
				<a class="continue" href="#">Continue to basket</a>
				<div class="price-details">
					<h3>Price Details</h3>
					<span>Total</span> <span class="total1" id="totalPrice">${sessionScope.cart.countTotalPriceFromCart()}</span>
					<span>Discount</span> <span class="total1">---</span> <span>Delivery
						Charges</span> <span class="total1">150.00</span>
					<div class="clearfix"></div>
				</div>
				<ul class="total_price">
					<li class="last_price">
						<h4>TOTAL</h4>
					</li>
					<li class="last_price"><span>${sessionScope.cart.countTotalPriceFromCart()}</span></li>
					<div class="clearfix"></div>
				</ul>


				<div class="clearfix"></div>
				<a class="order" href="makeOrder.jsp">Place Order</a>
				<div class="total-item">
					<h3>OPTIONS</h3>
					<h4>COUPONS</h4>
					<a class="cpns" href="#">Apply Coupons</a>
					<p>
						<a href="#">Log In</a> to use accounts - linked coupons
					</p>
				</div>
			</div>

			<div class="clearfix"></div>
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
				© 2015 New store All Rights Reserved | Design by <a
					href="http://w3layouts.com/" target="_blank">W3layouts</a>
			</p>
		</div>
	</div>
	<script src="/Task10/resources/js/changeAmountOfCar.js"></script>
	<script src="/Task10/resources/js/ajax_delete_from_cart.js"></script>
</body>
</html>