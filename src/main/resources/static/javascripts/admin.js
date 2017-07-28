var updateTable = function(data) {
	$("#table-ajax tbody > tr").remove();
	$.each(data, function(i, item) {
		$("#table-ajax tbody").append("<tr><td class='text-center'>"
				+ "<a href=\"/admin/products/\"" + item.id +
				">" + item.name + "</a></td>" +
				"<td class=\"text-center\">" + item.price.currency + " " + item.price.amount +
				"</td><td class=\"text-center\">" + item.category.name +
				"</td></tr>");
						
	});
};

var ajaxOpts = {
		type:"GET",
		url:"/admin/api/products/search",
		success: updateTable
};
//{"

$(document).ready(function() {
	$("#button-search").click(function(e) {
		console.log("stop");
		e.preventDefault();
		$.ajax({
			type: "GET",
			url: "/admin/api/products/search",
			data: {
				"name": $("#name").val(),
				"category.name": $("#category option:selected").val()
			},
			success: updateTable
		});
	});
});