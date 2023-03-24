<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Utilisateur</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<div class="container">
		<div class="col-8 offset-2">
			<div class="row justify-content-evenly">
				<% if(request.getAttribute("noUtilisateur") != null) {%>
					<div class="container py-5">
						<div class="row">
							<div class="col-lg-4">
								<div class="card mb-4">
									<div class="card-body text-center">
										<img
											src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2.webp"
											alt="avatar" class="rounded-circle img-fluid"
											style="width: 150px;">
										<h5 class="my-3">${userConnected.pseudo}</h5>
										<p class="text-muted mb-1">nom : ${userConnected.nom} </p>
										<p class="text-muted mb-4">Prénom : ${userConnected.prenom}</p>
										<p class="text-muted mb-4">Email : ${userConnected.email}</p>
										<p class="text-muted mb-4">Ville : ${userConnected.ville}</p>
										<p class="text-muted mb-4">article vendues : : ${userConnected.ville}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				<%}%> 
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>