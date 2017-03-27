function deleteItem(clicked_id) {
		$.ajax({
			url:'DeleteProductFromCartServlet',
			type: 'POST',
			dataType: 'json',
			data: jQuery.param	({
				idProduct:clicked_id
			}),
			success: function(data) {
					$('.' + clicked_id + '').fadeOut('slow');
					var totalPrice = JSON.stringify(data.totalCost);
					var totalCount = JSON.stringify(data.totalCount);
			           console.log(totalPrice);
			           console.log(totalCount);
				   $('#totalPrice').text(totalPrice);
		           $('#totalCount').text(totalCount);
		           console.log("succes ajax");
			},
			error: function() {
				console.log("ajax error");
			}
		});
	 event.preventDefault();
}