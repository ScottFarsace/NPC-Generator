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

<title>View NPC</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" style="position: relative; height: 100%">

		<div class="container"></div>
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light rounded-bottom bronze mb-3">
			<a href="#" class="navbar-brand mx-3">DM Tools</a>

			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
					aria-controls="navbarCollapse" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse h4" id="navbarCollapse">
					<div class="navbar-nav" aria-label="breadcrumb">
						<a class="breadcrumb-item nav-item" href="#">Home</a> <a
							class="breadcrumb-item nav-item active" aria-current="page">NPC:
							<c:out value="${aNPC.name}"></c:out>
						</a>
					</div>

					<div class="navbar-nav ms-auto">
						<a href="/logout" class="btn btn-danger nav-item">Log Out</a>
					</div>
				</div>
			</div>
		</nav>

		<div class="container p-5 mt-2 mb-2"
			style="position: relative; z-index: 0;">
			<div class="parchment"></div>

			<div class="row viewnpcpage p-3">
				<h1>
					<c:out value="${aNPC.name}"></c:out>
				</h1>

				<div class="p-2">
					<h4>~Race~</h4>
					<c:out value="${aNPC.race}"></c:out>
				</div>
				<div class="p-2">
					<h4>~Alignment~</h4>
					<c:out value="${aNPC.socialAlignment} / ${aNPC.moralAlignment}"></c:out>
				</div>
				<div class="p-2">
					<h4>~Sex~</h4>
					<c:out value="${aNPC.sex}"></c:out>
				</div>
				<div class="p-2">
					<h4>~Archetype~</h4>
					<c:out value="${aNPC.archetype}"></c:out>
				</div>
				<div class="p-2">
					<h4>~CR~</h4>
					<c:out value="${aNPC.challengeRating}"></c:out>
				</div>
				<div class="p-2">
					<h4>~Age~</h4>
					<c:out value="${aNPC.age}"></c:out>
				</div>
				<div class="p-2">
					<h4>~Profession / Title~</h4>
					<c:out value="${aNPC.profession}"></c:out>
				</div>
				<div class="p-2">
					<h4>~Appearance~</h4>
					<c:out value="${aNPC.appearance}"></c:out>
				</div>
				<div class="p-2">
					<h4>~Quirks~</h4>
					<c:out value="${aNPC.quirks}"></c:out>
				</div>
				<div class="p-2">
					<h4>~Background~</h4>
					<c:out value="${aNPC.background}"></c:out>
				</div>
				<div class="p-2">
					<h4>~Motivation~</h4>
					<c:out value="${aNPC.motivation}"></c:out>
				</div>
			</div>
			<div>
				<a href="/home" class="btn btn-primary">Back</a> 
				<a href="/npc/${aNPC.id}/edit" class="btn btn-warning">Edit</a> 
				<a href="/npc/${aNPC.id}/delete" class="btn btn-danger">Delete</a> 
			</div>
			<svg>
			<filter id="wearify">
			<feTurbulence x="0" y="0" baseFrequency="0.02" numOctaves="5"
					seed="1" />
			<feDisplacementMap in="SourceGraphic" scale="20" />
			</filter>
		</svg>
		</div>
	</div>
</body>
</html>