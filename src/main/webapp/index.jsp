<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.List,fr.eni.mahm.projetencheres.bo.ArticleVendu" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Page d'accueil</title>
		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	</head>
<body>
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
		<div class="container">
			<div class="col-8 offset-2">
				<div class="row justify-content-evenly">
					<c:forEach var= "listeArticleVendu" items = "${requestScope.listeArticleVendu}" >
						<div class="card text-center col-5 my-3 p-0 shadow">
							<a href="#" class="card-header text-decoration-none">${listeArticleVendu.noArticle}</a> 
							<img src="https://ik.imagekit.io/uwzsb7j5w/wp-content/uploads/sites/2/2022/10/vente-aux-encheres-illustration.jpg" class="img-fluid" alt="fuck" />
							<div class="card-body">
								<h5 class="card-title">${listeArticleVendu.nomArticle}</h5>
								<hr>
								<p class="card-text">Description: ${listeArticleVendu.description} </p>
								<hr>
								<p class="card-text">Date debut des encheres: ${listeArticleVendu.dateDebutEncheres} </p>
								<hr>
								<p class="card-text">Date fin des encheres:${listeArticleVendu.dateFinEncheres} </p>
								<hr>
								<p class="card-text">Prix de l'article ${listeArticleVendu.prixVente} </p>
								<hr>
								<a href="#" class="btn btn-primary">Voir l'enchère</a>
							</div>
							<div class="card-footer text-muted">temps restant enchere</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>

</html>
