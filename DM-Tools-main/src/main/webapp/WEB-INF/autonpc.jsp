<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Auto NPC</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" style="position: relative; height: 100%">

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light rounded-bottom bronze mb-3">
			<a href="#" class="navbar-brand mx-3">DM Tools</a>

			<div class="container-fluid">
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse h4" id="navbarCollapse">
					<div class="navbar-nav" aria-label="breadcrumb">
						<a class="breadcrumb-item nav-item" href="#">Home</a>
						<a class="breadcrumb-item nav-item active" aria-current="page">Auto NPC Creation</a>
					</div>

					<div class="navbar-nav ms-auto">
						<a href="/logout" class="btn btn-danger nav-item">Log Out</a>
					</div>
				</div>
			</div>
		</nav>

		<div class="container" style="position: relative; z-index: 0;">
			<div class="parchment"></div>
	
			<div class="row p-4">
				<h1>Auto NPC Creation</h1>

				<div class="p-2">
					<label>Race: </label>
					<c:out value="${basicNPC.race}"></c:out>
				</div>
				<div class="p-2">
					<label>Alignment: </label>
					<c:out value="${basicNPC.socialAlignment} / ${basicNPC.moralAlignment}"></c:out>
				</div>
				<div class="p-2">
					<label>Sex: </label>
					<c:out value="${basicNPC.sex}"></c:out>
				</div>
				<div class="p-2">
					<label>Archetype: </label>
					<c:out value="${basicNPC.archetype}"></c:out>
				</div>
				<div class="p-2">
					<label>CR: </label>
					<c:out value="${basicNPC.challengeRating}"></c:out>
				</div>

				<form:form action="/autonpc/new" method="POST"
					modelAttribute="basicNPC">
					
					<div class="p-2">
						<form:label path="name">Name:</form:label>
						<br>
						<form:errors path="name" />
						<form:input path="name" />
					</div>

					<div class="p-2">
						<form:label path="age">Age:</form:label>
						<br>
						<form:errors path="age" />
						<form:input path="age" />
					</div>

					<div class="p-2">
						<form:label path="profession">Profession / Title:</form:label>
						<br>
						<form:errors path="profession" />
						<form:input path="profession" />
					</div>

					<div class="p-2">
						<form:label path="appearance">Appearance:</form:label>
						<br>
						<form:errors path="appearance" />
						<form:textarea rows="3" cols="50" path="appearance" />
					</div>

					<div class="p-2">
						<form:label path="quirks">Quirks:</form:label>
						<br>
						<form:errors path="quirks" />
						<form:textarea rows="1" cols="50" path="quirks" />
					</div>

					<div class="p-2">
						<form:label path="background">Background:</form:label>
						<br>
						<form:errors path="background" />
						<form:textarea rows="1" cols="50" path="background" />
					</div>

					<div class="p-2">
						<form:label path="motivation">Motivation:</form:label>
						<br>
						<form:errors path="motivation" />
						<form:textarea rows="1" cols="50" path="motivation" />
					</div>
					
					<form:input type="hidden" path="race" value="${basicNPC.race}" />
					<form:input type="hidden" path="socialAlignment" value="${basicNPC.socialAlignment}" />
					<form:input type="hidden" path="moralAlignment" value="${basicNPC.moralAlignment}" />
					<form:input type="hidden" path="sex" value="${basicNPC.sex}" />
					<form:input type="hidden" path="archetype" value="${basicNPC.archetype}" />
					<form:input type="hidden" path="challengeRating" value="${basicNPC.challengeRating}" />

					<a href="/home" class="btn btn-primary">Back</a>
					<input type="submit" class="btn btn-primary col-1"
						value="Add NPC" />
				</form:form>
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