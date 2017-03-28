# OnlineShop
<a href="https://travis-ci.org/ValeriiOsmachko/OnlineShop"><img src="https://travis-ci.org/ValeriiOsmachko/OnlineShop.svg?branch=master" alt="Build Status" /></a>
<p>This is <strong>CLASSICAL</strong> web application which is created with usage of Servlet API and software design patterns.</p>
<strong>Requirements of this application were next:</strong>
<ul>
<li>Create jsp pages for this shop: Registration page, Products page and so on.</li>
<li>Create client side validation of registration page in 2 ways: using JQuery and JS.</li>
<li>Create server side validation for all application, were it is necessary.</li>
<li>Check user login for existing and implement appropriate logic.</li>
<li>Implementation of next functionality: if exception was happend(invalid input data) during registration,
user don't have to fill data again. Data in input fileds of form must be saved from the previous input, and show info messages above fields,
where data isn't valid.</li>
<li>Create captcha on registration page. Implement this using strategy pattern in 3 ways: hidden field, cookie and session(Strategy 
should be chosen according the init-params of servlet).Captcha value must be passed to the user ONLY on the picture. Captcha should 
be printed by separate servlet. Captcha should be viewed on jsp using custom tag. Create captcha timeout. Old captchas must be 
cleaned in separate Thread.</li>
<li>Create all service and dao layers: Create own transaction manager in dao layer.</li>
<li>Create custom tag, where if user is not log in, should be viewed login form, otherwise user's name and avatar(or button for uploading
his avatar). Avatar has to be stored in server catalog or somewhere computer directory.</li>
<li>Implement products page, create the opportunity of filtering products by category, brand, manufacturer, price range and opportunity 
of sorting.Filtering and sorting must be done on the DB side, and should be executed in one sql query.Query should be build dynamically by 
own query builder(is not allowed to use sql query building libraries).</li>
<li>Create pagination of products page using url-rewriting.</li>
<li>Tool bar with filters(category, name, brands) should be generated dynamically.</li>
<li>Create shopping cart using AJAX(All flow including the confirmation of order). Must be opportunities of adding, removing, counting 
total amount and total price of products in cart.</li>
<li>Create opportunity of monitoring orders and their info(status ,date and time, owner info, id and so on).</li>
<li>Implementation of l18n. Language selector should be in custom tag.</li>
<li>Create mechanism of choosing preferable locale using servlet's filters and HttpServletRequestWrapper.</li>
<li>Create filter that turns on caching.</li>
<li>Create filter(GZIP filter) that squeezes response body if content-type is text.</li>
<li>Create the opportunity of temporary user ban if amount of incorrect login attempts were more than n.</li>
<li>Implementation of authorization.</li>
</ul>

<strong>Technologies:</strong>
<ul>
<li>java 8</li>
<li>maven</li>
<li>Servlet API</li>
</ul>

How to use?
<ol>
<li>Make <strong>git clone</strong> of this repository</li>
<li>Open project with you IDE</li>
<li>Execute SQL script in MySQL DB that is located here: <strong>/resources/sql/</strong></li>
<li>Check DB credentials in file <strong>/src/main/webapp/META-INF/context.xml</strong> 
and fix if it necessary</li>
<li>Run application on Tomcat</li>
</ol>
