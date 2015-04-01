$(document).ready( function () {
	$('.contactFormDiv').hide();
});

function scrollToContactForm() {
	$('.contactMsg').hide();
	$('.contactFormDiv').show();
	$('html, body').animate({scrollTop: $(".contactFormDiv").offset().top}, 1000);
	$('.pricingContainer').hide();
	$('.detailsContainer').hide();
};

function submitQuery() {
	$('.contactMsg').hide();
	$('.epcInfoContainer').hide();
	$('.jumbotron').hide();
	$('.contactFormDiv').html("<h1>Please wait while your message is sent.</h1>");
};

function scrollToPricing() {
	$('.contactMsg').hide();
	$('.contactFormDiv').hide();
	$('.detailsContainer').show();
	$('.pricingContainer').show();
	$('html, body').animate({scrollTop: $(".pricingContainer").offset().top}, 1000);
};

function refresh() {
	$('.contactMsg').hide();
	window.location="../../templates/index.html";
};

function scrollToMoreInfo() {
	$('.contactMsg').hide();
	$('.contactFormDiv').hide();
	$('html, body').animate({scrollTop: $("#info").offset().top - 60}, 1000);	
}