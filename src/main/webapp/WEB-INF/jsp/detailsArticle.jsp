<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${articleSelectione.nomArticle}</title>
		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	</head>
<body style="background-color: #eee;">
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
		<section>
		<div class="container py-5">
			<div class="row">
				<div class="col-lg-8">
					<div class="card mb-4">
						<div class="card-body text-center">
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Nom de l'article :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${articleSelectione.nomArticle}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Description :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${articleSelectione.description}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Categorie :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${articleSelectione.categorie.libelle}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Offre initiale:</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${articleSelectione.prixVente}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Meilleur Offre: </p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${articleSelectione.miseAPrix}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Date du d�but  des encheres</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${articleSelectione.dateDebutEncheres}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Date de fin des encheres</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${articleSelectione.dateFinEncheres}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Etat  de la vente :</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${articleSelectione.etatVente}</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Adresse de Retrait</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">${articleSelectione.lieuRetrait}</p>
								</div>
							</div>
      						<hr>
      						<div class="row">
								<div class="col-sm-3">
									<label for="monEnchere">Ma proposition : </label>
								</div>
								<div class="col-sm-9">
      							<input type="number" value="${articleSelectione.getPrixVente() }" id="monEnchere"name="monEnchere" />
      							</div>
      							<input type="submit" class="btn btn-secondary" value="Ench�rir" />
      						</div>    													
						</div>
					</div>
				</div>
				<div class="col-lg-4">
				<div class="card mb-4">
					<div class="card-body text-center">
						<img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2.webp"
							alt="avatar" class="rounded-circle img-fluid"
							style="width: 150px;">
						<p class="text-muted mb-1">${articleSelectione.pseudo}</p>
						<div class="d-flex justify-content-center mb-2">
							<a type="button" class="btn btn-secondary my-2 my-sm-0"
								href="<%=request.getContextPath() %>/compteEncherisseur?pseudo?=${articleSelectione.pseudo}" role="button">Accedez au compte</a>
						</div>
					</div>
				</div>
				</div>
			</div>
		</div>
		
		</section>
		<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>