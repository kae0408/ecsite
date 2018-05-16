/**
 *
 */

$(function(){
	$(".button").prop('disabled', true);
});


$(function(){
	$(".check-box").change(function(){
		$(".button").prop('disabled',false);
	});
});