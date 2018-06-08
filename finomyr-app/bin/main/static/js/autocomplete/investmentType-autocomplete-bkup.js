/**
 * 
 */
$(document).ready(function() {
	$('input.autocomplete').onclick = autocompleteTaxation();
});

$(function autocompleteTaxation(){
	var suggestions = fetchTaxationAjax();
	
	$('#autocomplete-input-taxation').autocomplete({
		data : suggestions,
		limit: 6,
		onAutocomplete: function(val) {
		      // Callback function when value is autcompleted.
		},
	    minLength: 2, // The minimum length of the input for the autocomplete to start. Default: 1.
	});
});

function fetchTaxationAjax(){
	
	var taxationSuggestions = {};
	$.ajax({
		type:	'GET',
		url:	'/taxation/search?name=',
		success: function (response) {
			var taxationResponse = response;			
			for (var i = 0; i < taxationResponse.length; i++){
				taxationSuggestions[taxationResponse[i].name] = taxationResponse[i].flag;
			}
		}
	});
	return taxationSuggestions;
}

/*$('input.autocomplete').click(function() {
	 autocompleteTaxation();
 });*/