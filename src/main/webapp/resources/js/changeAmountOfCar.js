
$('.newAmount').submit(function(event) {
	var elem = $(this);
	var productAmount = elem.find('.abc').val();
	var product_id = elem.find('.idProd').val();
	alert("PROD AM =" + productAmount + ", ID = " + product_id);
	alert(productAmount);
		$.ajax({
			url:'ChangeAmountOfProduct',
			type: 'POST',
			dataType: 'json',
			data: jQuery.param({
				idProduct:product_id,
				amount:productAmount
			}),
			success: function(data) {
					var totalPrice = JSON.stringify(data.totalCost);
					var totalCount = JSON.stringify(data.totalCount);
					var totalAm = JSON.stringify(data.AmountInCart);
					alert(totalAm);
			           console.log(totalPrice);
			           console.log(totalCount);
				   $('#totalPrice').text(totalPrice);
		           $('#totalCount').text(totalCount);
		           $('#totAm').text('My Shopping Bag' + '(' + totalAm + ')');
		           console.log("succes ajax");
			},
			error: function() {
				console.log("ajax error");
			}
		});
		 event.preventDefault();
});
