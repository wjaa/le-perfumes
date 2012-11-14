$(document).ready(function () {
		
	$('#accordion a.item').click(function () {

		//slideup or hide all the Submenu
		$('#accordion li').children('ul').slideUp('fast');	
		
		//remove all the "Over" class, so that the arrow reset to default
		$('#accordion a.item').each(function () {
			if ($(this).attr('rel')!='') {
				$(this).removeClass($(this).attr('rel') + 'Over');	
			}
		});
		
		//show the selected submenu
		$(this).siblings('ul').slideDown('fast');
		
		//add "Over" class, so that the arrow pointing down
		$(this).addClass($(this).attr('rel') + 'Over');			

		return false;

	});

});