<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
<body>
	<div class="container">
		<div class="col-8 offset-2">
			<div class="row justify-content-evenly">
				<c:forEach var="ArticleVendu"
					items="${requestScope.listeArticleVendu}">
					<div class="card text-center col-5 my-3 p-0 shadow">
						<c:if test="${empty userConnected}">
							<a href="/ProjetEncheresENI/login"
								class="card-header text-decoration-none">${ArticleVendu.pseudo}</a>
						</c:if>
						<c:if test="${!empty userConnected}">
							<a href="AfficherUtilisateur?id=${ArticleVendu.noVendeur}"
								class="card-header text-decoration-none">${ArticleVendu.pseudo}</a>
						</c:if>
						<img
							src="https://ik.imagekit.io/uwzsb7j5w/wp-content/uploads/sites/2/2022/10/vente-aux-encheres-illustration.jpg"
							class="img-fluid" alt="fuck" />
						<div class="card-body">
							<h5 class="card-title">${ArticleVendu.nomArticle}</h5>
							<hr>
							<p class="card-text">Description: ${ArticleVendu.description}
							</p>
							<hr>
							<p class="card-text">Date debut des encheres:
								${ArticleVendu.dateDebutEncheres}</p>
							<hr>
							<p class="card-text">Date fin des
								encheres:${ArticleVendu.dateFinEncheres}</p>
							<hr>
							<p class="card-text">Prix de l'article
								${ArticleVendu.prixVente}</p>
							<hr>
							<c:if test="${empty userConnected}">
								<a href="/ProjetEncheresENI/login" class="btn btn-primary">Voir
									l'enchère</a>
							</c:if>
							<c:if test="${!empty userConnected}">
								<a
									href="<%=request.getContextPath() %>/detailArticle?noArticle=${ArticleVendu.noArticle}"
									class="btn btn-primary">Voir l'enchère</a>
							</c:if>
						</div>
						<div class="card-footer text-muted">temps restant enchere</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="fixed-bottom">
		<%@ include file="/WEB-INF/html/piedDePage.html"%>
	</div>
</body>
</html>