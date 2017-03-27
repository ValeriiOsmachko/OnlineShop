$(document).ready(function() {
    $('#submit').click(function (e) {
        //Initializing variables with form element values  
        var firstname = $("#fname").val();
        var secondname = $("#lname").val();
        var email = $("#lemail").val();
        var password = $("#lpass").val();
        var login = $("#llogin").val();
        //Initializing variables with Regular Exprassions 
        var reg = new RegExp("^[a-zA-Z ]{2,30}$");
        var regEmail = new RegExp("^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
        var regPassword = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8,})$");
        var regLogin = new RegExp("^[a-z0-9_-]{3,15}$");
        
        var valid = true;
        if(!reg.test(firstname)) {
            $("#namemsg").show(1000);
            $("#fname").focus();
            valid = false;
        }
        if(!reg.test(secondname)) {
            $("#lastnamemsg").show(1000);
            $("#lname").focus();
            valid = false;
        }
        if(!regEmail.test(email)) {
            $("#emailmsg").show(1000);
            $("#lemail").focus();
            valid = false;
        }
        if(!regPassword.test(password)) {
            $("#passmsg").show(1000);
            $("#lpass").focus();
            valid = false;
        }
        if(!regPassword.test(password)) {
            $("#logmsg").show(1000);
            $("#llogin").focus();
            valid = false;
        }
        
        return valid;
    });
});