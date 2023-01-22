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
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" style="position: relative; height: 100%">

		<div class="container">
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
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<div class="navbar-nav">
						<a class="btn btn-success nav-item">Welcome home, <c:out value="${loggedUser.name}" /></a>
					</div>
						<div class="navbar-nav ms-auto">
							<a href="/logout" class="btn btn-danger nav-item">Log Out</a>
						</div>
					</div>
				</div>
			</nav>
		</div>

		<div class="container" style="position: relative; z-index: 0;">
			<div class="parchment"></div>

			<main class="container-fluid p-4">
				<div class="container-fluid">
					<h2>NPC's</h2>
					<a href="/manualnpc/new" class="btn btn-primary">New Manual NPC</a>
					<a href="/newbasicnpc/new" class="btn btn-primary">New Auto NPC</a>

					<div class="py-2">
						<a href="/home/nameasc" class="btn btn-secondary">Sort By
							Name(Asc)</a> <a href="/home/raceasc" class="btn btn-secondary">Sort
							By Race(Asc)</a> <a href="/home/crasc" class="btn btn-secondary">Sort
							By Cr(Asc)</a>
					</div>


					<table class="table">
						<thead>
							<tr>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="NPC" items="${npcs}">
								<tr>
									<td>
										<div class="container p-3 mt-2 mb-2"
											style="position: relative;">
											<div class="parchment"></div>

											<div class="card card-border-0 bg-transparent">
												<a href="/npc/${NPC.id}/view" class="btn card-link">
													<div class="card-header">
														<span class="badge bg-secondary">${NPC.race}</span> <span
															class="badge bg-secondary">${NPC.sex}</span> <span
															class="badge bg-secondary">${NPC.archetype}</span> <span
															class="badge bg-secondary">${NPC.socialAlignment}
															/ ${NPC.moralAlignment}</span> <span class="badge bg-secondary">Age:
															${NPC.age}</span> <span class="badge bg-secondary">CR:
															${NPC.challengeRating}</span>
													</div>
													<div class="card-body">
														<h5 class="card-title">${NPC.name} the
															${NPC.profession}</h5>
														<p class="card-text">${aNPC.appearance}</p>
													</div>
												</a>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</main>
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
