<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="assets/css/auth_style.css" />
<meta charset="ISO-8859-1">
<title>Auth</title>
</head>
<body>
	<!-- JSP Scriptlet -->
	<%
		if (session.getAttribute("username") != null) {
			response.sendRedirect("dashboard.jsp");
		}
	%>
	<h2>Sign in/up Form</h2>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="<%=request.getContextPath()%>/signup" method="post">
				<h1>Create Account</h1>
				<input type="text" placeholder="Name" name="name" required /> <input
					type="email" placeholder="Email" name="email" required /> <input
					type="password" placeholder="Password" name="password" required />
				<button id="signupButton">Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="<%=request.getContextPath()%>/login" method="post">
				<h1>Sign in</h1>
				<input type="email" placeholder="Email" name="email" required /> <input
					type="password" placeholder="Password" name="password" required />
				<!-- <a href="#">Forgot your password?</a> -->
				<button id="signinButton">Sign In</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>keep connected with us</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello,</h1>
					<p>Enter your details and check the features</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>

	<script src="assets/js/auth_style.js"></script>
</body>
</html>