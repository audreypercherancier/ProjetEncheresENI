<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Utilisateur</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body style="background-color: #eee;">
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<section>
		<div class="container py-5">
			<div class="row">
				<c:forEach var="selectAll" items="${requestScope.selectAll}">
					<div class="col-lg-4">
						<div class="card mb-4">
							<div class="card-body text-center">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2.webp"
									alt="avatar" class="rounded-circle img-fluid"
									style="width: 150px;">
								<h5 class="my-3">${selectAll.pseudo}</h5>
								<p class="text-muted mb-1">nom : ${selectAll.nom}</p>
								<p class="text-muted mb-4">Pr�nom : ${selectAll.prenom}</p>
								<p class="text-muted mb-4">Email : ${selectAll.email}</p>
								<p class="text-muted mb-4">Ville : ${selectAll.ville}</p>
								<p class="text-muted mb-4">article vendues :
									${selectAll.ville}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<div class="fixed-bottom">
		<%@ include file="/WEB-INF/html/piedDePage.html"%>
	</div>
</body>
</html>