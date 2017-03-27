<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://com.epam.osmachko" prefix="capthca" %> 
 <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="ex" uri="WEB-INF/tlds/mytags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Javascript Validation</title>
<script type="text/javascript" language="javascript" src="resources/js/validation.js"></script>
<link href="/Task10/resources/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
</head>
<body>

<div class="main">
     <h2>Signup with</h2>
		<form name="singInForm" onsubmit="return validate();" action="./LoginServlet" method="POST">
		   <div class="lable">
		        <div class="col_1_of_2 span_1_of_2"><span id="namemsg" style="color:Red;">${requestScope.errors.firstname}</span><input type="text" name="firstName" class="text" value="${requestScope.user.firstName}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'First Name';}" id="active"></div>
                <div class="col_1_of_2 span_1_of_2"><span id="lastnamemsg" style="color:Red;">${requestScope.errors.lastname}</span><input type="text" name="lastName" class="text" value="${requestScope.user.lastName}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Last Name';}"></div>
                <div class="clear"> </div>
		   </div>
		   <div class="lable-2">
			   <span id="emailmsg" style="color:Red;">${requestScope.errors.email}</span>
		        <input type="text" name="email" class="text" value="${requestScope.user.email}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'your@email.com ';}">
				<span id="passmsg" style="color:Red;">${requestScope.errors.password}</span>
		        <input type="password" name="password" class="text" value="${requestScope.user.password}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password ';}">
		      	<span id="loginmsg" style="color:Red;">${requestScope.errors.login}</span>
				<input type="text" name="login" class="text" value="${requestScope.user.login}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Login';}">
			
				<ex:Hello/>
		
				<!-- <img src="CaptchaServlet"> -->
				<!-- <input type="text" name="captcha" class="text"> -->
		   </div>
		   <!--<h3>By creating an account, you agree to our <span class="term"><a href="#">Terms & Conditions</a></span></h3>-->
		   <div class="submit">
			  <input type="submit" name="submit" value="Create account" >
		   </div>
		   <div class="clear"></div>
		</form>
		</div>
   		<div class="copy-right">
   			
			<p>Template by <a href="http://w3layouts.com">w3layouts</a></p> 
		</div>
				
<script type="text/javascript" language="javascript" src="resources/js/validation.js"></script>
</body>
</html>