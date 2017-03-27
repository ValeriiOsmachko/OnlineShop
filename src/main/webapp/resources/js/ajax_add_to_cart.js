
/*
 * Adding product into cart with AJAX, Servlet and JSP.
 */

$('.linkAddItem').on('click',function(event) {
	var elem = $(this);
	console.log(elem);
	var product_id = elem.find('.idProd').val();
	alert(product_id);
		$.ajax({
			url:'AddProductToCartServlet',
			type: 'POST',
			dataType: 'json',
			data: jQuery.param({
				idProduct:product_id 
			}),
			success: function(data) {
					var totalPrice = JSON.stringify(data.totalCost);
					var totalCount = JSON.stringify(data.totalCount);
			           console.log(totalPrice);
			           console.log(totalCount);
				   $('#totalPrice').text(totalPrice);
		           $('#totalCount').text(totalCount);
		           console.log("succes ajax");
			},
			error: function() {
				window.location.replace("register.jsp");
				alert("You couldn't use cart before you registrate!");
			}
		});
		 event.preventDefault();
});