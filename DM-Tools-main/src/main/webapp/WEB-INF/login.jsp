<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Login/Register</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" style="position: relative; height: 100%">

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light rounded-bottom bronze mb-3">
			<a href="#" class="navbar-brand mx-3">DM Tools</a>
		</nav>
	</div>

	<div class="container" style="position: relative; z-index: 0;">
		<div class="parchment"></div>

		<div class="row p-4">
			<div class="col-sm-5 p-3 my-2" style="position: relative;">
				<div class="parchment"></div>
				<div class="card bg-transparent">
					<fieldset class="card-body">
						<legend class="h3 card-title">Register</legend>

						<form:form action="/register" method="post" modelAttribute="registerUser">
							<div class="my-3 form-group">
								<form:label for="name" path="name">Name</form:label>
								<form:input id="name" path="name" class="form-control" type="text" placeholder="Enter Name"/>
								<form:errors path="name" class="text-danger offset-3"/>
							</div>
							<div class="my-3 form-group">
								<form:label for="email" path="email">Email Address</form:label>
								<form:input id="email" path="email" class="form-control" type="email" aria-describedby="emailHelp" placeholder="Enter Email"/>
								<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
								<form:errors path="email" class="text-danger offset-3"/>
							</div>
							<div class="my-3 form-group">
								<form:label for="password" path="password">Password</form:label>
								<form:password id="password" path="password" class="form-control" placeholder="Enter Password"/>
								<form:errors path="password" class="text-danger offset-3"/>
							</div>
							<div class="my-3 form-group">
								<form:label for="confirmPassword" path="confirmPassword">Password Confirmation</form:label>
								<form:password id="confirmPassword" path="confirmPassword" class="form-control" placeholder="Confirm Password"/>
								<form:errors path="confirmPassword" class="text-danger offset-3"/>
							</div>
							<div class="my-2 form-group">
								<input type="submit" class="btn btn-primary" value="Register"/>
							</div>
						</form:form>
					</fieldset>
				</div>
			</div>
			<div class="col-sm-6 p-3 my-2 ms-auto" style="position: relative;">
				<div class="parchment"></div>
				<div class="card bg-transparent">
					<fieldset class="card-body">
						<legend class="h3 card-title">Login</legend>

						<form:form action="/login" method="post" modelAttribute="loginUser">
							<div class="my-3 form-group">
								<form:label for="loginEmail" path="loginEmail">Email</form:label>
								<form:input id="loginEmail" path="loginEmail" class="form-control" type="email" placeholder="Enter Email"/>
								<form:errors path="loginEmail" class="text-danger offset-3" />
							</div>
							<div class="my-3 form-group">
								<form:label for="loginPassword" path="loginPassword">Password:</form:label>
								<form:password id="loginPassword" path="loginPassword" class="form-control" placeholder="Enter Password"/>
								<form:errors path="loginPassword" class="text-danger offset-3"/>
							</div>
							<div class="my-2 form-group">
								<input type="submit" class="btn btn-primary" value="Login"/>
							</div>
						</form:form>
					</fieldset>
				</div>
			</div>
		</div>
		<svg>
			<filter id="wearify">
			<feTurbulence x="0" y="0" baseFrequency="0.02" numOctaves="5" seed="1" />
			<feDisplacementMap in="SourceGraphic" scale="20" />
			</filter>
		</svg>
	</div></div>
</body>
</html>