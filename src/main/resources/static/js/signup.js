//var serverContext = [[@{/}]];

$(document).ready(function () {
    $('#signupForm').submit(function (event) {
        event.preventDefault();

        // Serialize the form data into a JSON object
        const formData = {};
        $(this).serializeArray().map(function (x) {
            formData[x.name] = x.value;
        });

        // Send the JSON data via AJAX as the request body
        $.ajax({
            type: 'POST',
            url: '/user/registration',
            contentType: 'application/json',
            data
            data: JSON.stringify(formData),
            success: function (response) {
                console.log('Form submitted successfully:', response);
                console.log(response.redirectUrl)
                if (response.redirectUrl) {

                    // Redirect to the specified URL
                    window.location.href = response.redirectUrl;
                } else {
                    console.log("Not redirect")
                    // Handle other responses or update the DOM
                }
            },
            error: function (error) {
                console.error('Error submitting form:', error);
            }
        });
    });
});