/**JS for Other Income Entry Form
 * @since 0.2.1
 * @version 1.0
 */

var dateFields = document.querySelectorAll('.input-date');

/* Renders Pikaday date picker for the required form fields */
for(fld in dateFields) {
	new Pikaday({
	    field: dateFields[fld],
	    format: 'DD-MM-YYYY',
	    firstDay: 1,
	    minDate: new Date(2000, 0, 1),
	    maxDate: new Date(2049, 12, 31),
	    yearRange: [2000,2049],
	    showTime: false,
	    autoClose: false,
	    use24hour: false
	});
}


/* Call setDate() on window load so that fields are populated with today's date*/
/*window.onload = setDate;*/
/*window.onload = function () {
	setDate();
	setActiveNavbarTab();
};*/

/**
 * Function which formats today's date and inserts it in desired form fields
 */
/*function setDate()
{
var date = new Date();

var day = date.getDate();
var month = date.getMonth() + 1;
var year = date.getFullYear();

if (month < 10) month = "0" + month;
if (day < 10) day = "0" + day;

var today = year + "-" + month + "-" + day;
var today = day + "-" + month + "-" + year;

var dateFields = document.getElementsByClassName('input-date');
for(var i = 0; i< dateFields.length ; i++)
{
	dateFields[i].value = today;
}
document.getElementById('investmentDate').value = today;
}*/

/*function setActiveNavbarTab()
{
	var selectedTabLoc = document.querySelector('a[href="'+this.location.pathname+'"]');
	var parentElm = selectedTabLoc.parentElement;
	parentElm.classList.add('active');
}*/
/* Renders date picker for the required form fields */
/*var datepicker = new Pikaday({
    field: document.getElementById('investmentDate'),
    format: 'DD-MM-YYYY',
    firstDay: 1,
    minDate: new Date(2000, 0, 1),
    maxDate: new Date(2049, 12, 31),
    yearRange: [2000,2049],
    showTime: false,
    autoClose: false,
    use24hour: false
});*/
/*document.getElementsByName("clear")[0].onclick = alert("reset");*/
/*document.getElementById('clearButton').onclick = alert("reset");*/
/*document.forms.addOtherIncomeForm.onsubmit = alert("submit");*/
/*document.forms.addOtherIncomeForm.onreset = alert("reset");*/