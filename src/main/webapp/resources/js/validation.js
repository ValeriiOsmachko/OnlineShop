function validate() 
{
    var fname = document.singInForm.firstName.value; 
    var lname = document.singInForm.lastName.value;
    var email = document.singInForm.email.value;
    var password = document.singInForm.password.value;
    var login = document.singInForm.login.value;
    var reg = new RegExp("^[a-zA-Z ]{2,30}$");
    var regEmail = new RegExp("^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
    var regPassword = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8,})$");
    var regLogin = new RegExp("^[a-z0-9_-]{3,15}$");
        valid = true;
        if(!reg.test(fname))
         {
             var node = document.createTextNode("Not Valid name");
             document.getElementById("namemsg").appendChild(node);
            document.singInForm.firstName.focus();
            valid = false;
         }
         
         if(!reg.test(lname))
         {
            var node1 = document.createTextNode("Not Valid last name");
            document.getElementById("lastnamemsg").appendChild(node1);
            document.singInForm.lastName.focus() ;
            valid = false;
         }
         if(!regEmail.test(email)) 
         {
             var node2 = document.createTextNode("Not Valid email");
            document.getElementById("emailmsg").appendChild(node2);
            document.singInForm.email.focus() ;
            valid = false;
         }

         if(!regPassword.test(password)) 
         {
             var node3 = document.createTextNode("Not valid password");
             document.getElementById("passmsg").appendChild(node3);
            document.singInForm.password.focus() ;
            valid = false;
         }
        if(!regLogin.test(login)) 
         {
             var node4 = document.createTextNode("Not valid login");
             document.getElementById("loginmsg").appendChild(node4);
            document.singInForm.password.focus() ;
            valid = false;
         }

         
        return valid;
}


