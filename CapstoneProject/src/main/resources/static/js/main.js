function fire_login_ajax_submit() {

    var user = {}
    user.uname = $("#username").val();
    user.password = $("#password").val();

    $("#btn-login").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/cap/project/users/login",
        data: JSON.stringify(user),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	
        	var status = data.loginStatus;
        	
        	if("success" == status) {
        		window.open("home")
        	} else {
        		$('#loginresponse').html("<h3>" + "Login failed! Re-enter proper credentials" + "</h3>");
        	}
        	     

            console.log("Response Login Status : ", status);
            $("#btn-login").prop("disabled", false);

        },
        error: function (e) {

            var json = "<pre>" + e.responseText + "</pre>";
            $('#loginresponse').html(json);

            console.log("ERROR : ", e);
            $("#btn-login").prop("disabled", false);

        }
    });

}