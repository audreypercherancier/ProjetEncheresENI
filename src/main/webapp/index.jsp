<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Page de connexion</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  
</head>
<body>
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<div class="container">
		<div class="col-8 offset-2">
			<div class="row justify-content-evenly">
				<!-- commencer la boucle c:foreach ici -->
				<div class="card text-center col-5 my-3 p-0 shadow">
					<a href="#" class="card-header text-decoration-none">Nom
						vendeur</a> <img
						src="https://ik.imagekit.io/uwzsb7j5w/wp-content/uploads/sites/2/2022/10/vente-aux-encheres-illustration.jpg"
						class="img-fluid" alt="fuck" />
					<div class="card-body">
						<h5 class="card-title">Désignation article</h5>
						<p class="card-text">Description article
							balablablablablablablablablablablalbablalbalbablablabla</p>
						<p class="card-text">prix vente en cours</p>
						<a href="#" class="btn btn-primary">Voir l'enchère</a>
					</div>
					<div class="card-footer text-muted">temps restant enchere</div>
				</div>
				<div class="card text-center col-5 my-3 p-0 shadow">
					<a href="#" class="card-header text-decoration-none">Nom
						vendeur</a> <img
						src="https://ik.imagekit.io/uwzsb7j5w/wp-content/uploads/sites/2/2022/10/vente-aux-encheres-illustration.jpg"
						class="card-img-top" alt="fuck" />
					<div class="card-body">
						<h5 class="card-title">Désignation article</h5>
						<p class="card-text">Description article
							balablablablablablablablablablablalbablalbalbablablabla</p>
						<p class="card-text">prix vente en cours</p>
						<a href="#" class="btn btn-primary">Voir l'enchère</a>
					</div>
					<div class="card-footer text-muted">temps restant enchere</div>
				</div>
				<div class="card text-center col-5 my-3 p-0 shadow">
					<a href="#" class="card-header text-decoration-none">Nom
						vendeur</a> <img
						src="https://ik.imagekit.io/uwzsb7j5w/wp-content/uploads/sites/2/2022/10/vente-aux-encheres-illustration.jpg"
						class="card-img-top" alt="fuck" />
					<div class="card-body">
						<h5 class="card-title">Désignation article</h5>
						<p class="card-text">Description article
							balablablablablablablablablablablalbablalbalbablablabla</p>
						<p class="card-text">prix vente en cours</p>
						<a href="#" class="btn btn-primary">Voir l'enchère</a>
					</div>
					<div class="card-footer text-muted">temps restant enchere</div>
				</div>
				<!-- terminer boucle /c:foreach> ici -->
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>

</html>
