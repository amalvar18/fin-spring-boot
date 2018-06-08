/**
 * Javascript common to all Finomyr pages
 */

/* Call setDate() on window load so that fields are populated with today's date*/
/*window.onload = setDate;*/
window.onload = function () {
	setDate();
	setActiveNavbarTab();
};

/**
 * Sets the current location's Navbar item as active 
 */ 
function setActiveNavbarTab() {
	var selectedTabLoc = document.querySelector('a[href="'+this.location.pathname+'"]');
	var parentElm = selectedTabLoc.parentElement;
	parentElm.classList.add('active');
}

/**
 * Function which formats today's date and inserts it in desired form fields
 */
function setDate() {
	var date = new Date();
	
	var day = date.getDate();
	var month = date.getMonth() + 1;
	var year = date.getFullYear();
	
	if (month < 10) month = "0" + month;
	if (day < 10) day = "0" + day;
	
	var today = year + "-" + month + "-" + day;
	var today = day + "-" + month + "-" + year;
	
	var dateFields = document.getElementsByClassName('input-date');
	for(var i = 0; i< dateFields.length ; i++)	{
		dateFields[i].value = today;
	}
	/*document.getElementById('investmentDate').value = today;*/
}