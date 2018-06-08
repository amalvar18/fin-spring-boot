/**
 * 
 */


var elem = document.querySelector('.collapsible');
var instance = M.Collapsible.init(elem, null);

var selEelem = document.querySelector('select');
var selInstance = M.FormSelect.init(selEelem, null);

$(document).ready(function() {	
	/*$('select').formSelect();*/
	$.ajax({
		type:	'GET',
		url:	'/taxation/search?name=',
		success: function (response) {
			var taxationResponse = response;
			var taxationSuggestions = {};
			for (var i = 0; i < taxationResponse.length; i++){
				taxationSuggestions[taxationResponse[i].name] = taxationResponse[i].flag;
				console.log("TS[TR[" + i + "].name]->" + taxationResponse[i].name);
				console.log("TR[" + i + "].flag-->" + taxationResponse[i].flag);
			}
			
			$('#autocomplete-input-taxation').autocomplete({
				data : taxationSuggestions,
				limit: 6,
				onAutocomplete: function(val) {
				      // Callback function when value is autcompleted.
				},
			    minLength: 2, // The minimum length of the input for the autocomplete to start. Default: 1.
			});
		}
	});	
});