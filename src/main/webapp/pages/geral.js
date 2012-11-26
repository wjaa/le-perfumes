$(document).ready(function () {
		
	$('#accordion a.item').click(function () {
		
		//$('#accordion li').children('ul').slideUp('fast');
		
		if ($(this).hasClass("up")){
			$(this).siblings('ul').slideUp('fast');
			$(this).removeClass("up");
			$(this).addClass("down")
		}else{
			$(this).siblings('ul').slideDown('fast');
			$(this).addClass("up");
			$(this).removeClass("down")
		}
		
		return false;

	});

});