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

<title>DM Home</title>
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
						<a class="breadcrumb-item nav-item active" aria-current="page">Manual NPC Creation</a>
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
				<h1>Manual NPC Creation</h1>

				<form:form action="/manualnpc/new" method="POST"
					modelAttribute="newNPC">
					<div class="col-sm-6">
						<form:label path="name">Name:</form:label>
						<br>
						<form:errors path="name" />
						<form:input class="col-sm-6" path="name" />
					</div>

					<div class="col-sm-5">
						<form:label path="race">Race:</form:label>
						<br>
						<form:errors path="race" />
						<form:select class="col-sm-4" path="race">
							<option value="Dragonborn">Dragonborn</option>
							<option value="Dwarf">Dwarf</option>
							<option value="Elf">Elf</option>
							<option value="Gnome">Gnome</option>
							<option value="Half_Elf">Half-Elf</option>
							<option value="Halfling">Halfling</option>
							<option value="Half_Orc">Half-Orc</option>
							<option value="Human">Human</option>
							<option value="Tiefling">Tiefling</option>
						</form:select>
					</div>

					<div class="col-sm-5">
						<form:label path="sex">Sex:</form:label>
						<br>
						<form:errors path="sex" />
						<form:select class="col-sm-4" path="sex">
							<option value="Male">Male</option>
							<option value="Female">Female</option>
						</form:select>
					</div>

					<div class="col-sm-5">
						<form:label path="age">Age:</form:label>
						<br>
						<form:errors path="age" />
						<form:input class="col-sm-4" path="age" />
					</div>

					<div class="col-sm-5">
						<form:label path="socialAlignment">Alignment: Lawful, Neutral or Chaotic?</form:label>
						<br>
						<form:errors path="socialAlignment" />
						<form:select class="col-sm-4" path="socialAlignment">
							<option value="Lawful">Lawful</option>
							<option value="Neutral">Neutral</option>
							<option value="Chaotic">Chaotic</option>
						</form:select>
					</div>

					<div class="col-sm-5">
						<form:label path="moralAlignment">Alignment: Good, Neutral or Evil?</form:label>
						<br>
						<form:errors path="moralAlignment" />
						<form:select class="col-sm-4" path="moralAlignment">
							<option value="Good">Good</option>
							<option value="Neutral">Neutral</option>
							<option value="Evil">Evil</option>
						</form:select>
					</div>

					<div class="col-sm-5">
						<form:label path="archetype">Archetype:</form:label>
						<br>
						<form:errors path="archetype" />
						<form:select class="col-sm-4" path="archetype">
							<option value="Adept_Arcane">Adept: Arcane</option>
							<option value="Adept_Divine">Adept: Divine</option>
							<option value="Commoner">Commoner</option>
							<option value="Expert">Expert</option>
							<option value="Aristocrat">Aristocrat</option>
							<option value="Warrior">Warrior</option>
						</form:select>
					</div>

					<div class="col-sm-5">
						<form:label path="challengeRating">Challenge Rating:</form:label>
						<br>
						<form:errors path="challengeRating" />
						<form:input id="cr" class="col-sm-4" path="challengeRating" />
					</div>
					<script>
						$("#cr").attr({
						"type" : "number",
						"min"  : "0",
						"max"  : "10",
					});
					</script>
					<div class="col-sm-6">
						<form:label path="profession">Profession / Title:</form:label>
						<br>
						<form:errors path="profession" />
						<form:input class="col-sm-6" path="profession" />
					</div>

					<div class="col-sm-6">
						<form:label path="appearance">Appearance:</form:label>
						<br>
						<form:errors path="appearance" />
						<form:input class="col-sm-6" path="appearance" />
					</div>

					<div class="col-sm-6">
						<form:label path="quirks">Quirks:</form:label>
						<br>
						<form:errors path="quirks" />
						<form:input class="col-sm-6" path="quirks" />
					</div>

					<div class="col-sm-6">
						<form:label path="background">Background:</form:label>
						<br>
						<form:errors path="background" />
						<form:input class="col-sm-6" path="background" />
					</div>

					<div class="col-sm-6">
						<form:label path="motivation">Motivation:</form:label>
						<br>
						<form:errors path="motivation" />
						<form:input class="col-sm-6" path="motivation" />
					</div>

					<div class="m-2 p-2">
						<a href="/home" class="btn btn-primary">Back</a>
						<input type="submit" class="btn btn-primary col-sm-3" value="Add NPC" />
					</div>
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