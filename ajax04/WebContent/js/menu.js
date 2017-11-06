$(document).on('click','.submn',function(e) {
		e.stopPropagation();
		$(this).find('ul').slideToggle();
	});	
