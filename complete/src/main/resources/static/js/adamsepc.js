function submitQuery() {
	var name = $('#name').val();
	var email = $('#email').val();
	var contact = $('#contact').val();
	var query = $('#query').val();

	var valid = true;
	if(name=='') {
		$('#nameError').show();
		$('#nameErrorSpacer').show();
		$('#name').addClass('errorInput');
		valid = false;
	}
	if(email=='') {
		$('#emailError').show();
		$('#emailErrorSpacer').show();
		$('#email').addClass('errorInput');
		valid = false;
	}
	if(contact=='') {
		$('#contactError').show();
		$('#contactErrorSpacer').show();
		$('#contact').addClass('errorInput');
		valid = false;
	}
	if(valid) {
		$('#contactFormForm').submit();
		$('#submit-btn').val('Submitting your query, please wait...')
		$('#submit-btn').attr('disabled', 'true');
	}
	return valid;
}