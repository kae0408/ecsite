/**
 *
 */

$(function(){
	$(".button").prop('disabled', true);
});


$(function(){
	$(".select-box").change(function(){
		$(".button").prop('disabled',false);
	});
});