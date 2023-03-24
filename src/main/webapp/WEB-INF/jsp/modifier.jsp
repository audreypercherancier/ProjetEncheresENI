<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.eni.mahm.projetencheres.bo.Utilisateur"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Modifier Utilisateur</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<h1 class="text-center">Modification</h1>
	<div class="card-body px-4 py-5 px-md-5">
		<form method="POST" action="modifier">
			<!-- 2 column grid layout with text inputs for the first and last names -->
			<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<input type="text" name="nom" id="form3Example1"
							class="form-control" value="${userConnected.nom}"
							placeholder="${userConnected.nom}" /> <label class="form-label"
							for="form3Example1">Nom</label>
					</div>
				</div>
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<input type="text" name="prenom" id="form3Example2"
							class="form-control" value="${userConnected.prenom}"
							placeholder="${userConnected.prenom}" /> <label
							class="form-label" for="form3Example2">Prenom</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<input type="text" name="pseudo" id="form3Example3"
							class="form-control" value="${userConnected.pseudo}"
							placeholder="${userConnected.pseudo}" /> <label
							class="form-label" for="form3Example3">Pseudo</label>
					</div>
				</div>
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<input type="number" name="numero" id="form3Example4"
							class="form-control" value="${userConnected.telephone}"
							placeholder="${userConnected.telephone}" /> <label
							class="form-label" for="form3Example4">Telephone</label>
					</div>
				</div>
			</div>

			<!-- Email input -->
			<div class="form-outline mb-4">
				<input type="email" name="email" id="form3Example5"
					class="form-control" value="${userConnected.email}"
					placeholder="${userConnected.email}" /> <label class="form-label"
					for="form3Example5">Adresse Email</label>
			</div>

			<!-- Password input -->
			<div class="form-outline mb-4">
				<input type="password" name="motDePasse" id="form3Example6"
					class="form-control" value="${userConnected.motDePasse}"
					placeholder="${userConnected.motDePasse}" /> <label
					class="form-label" for="form3Example6">Mot de passe</label>
			</div>

			<div class="form-outline mb-4">
				<input type="password" name="motDePasse" id="form3Example6"
					class="form-control" value="${userConnected.motDePasse}"
					placeholder="${userConnected.motDePasse}" /> <label
					class="form-label" for="form3Example6">Confirmation Mot de
					passe</label>
			</div>

			<!-- Email input -->
			<div class="form-outline mb-4">
				<input type="text" name="rue" id="form3Example7"
					class="form-control" value="${userConnected.rue}"
					placeholder="${userConnected.rue}" /> <label class="form-label"
					for="form3Example7">Rue</label>
			</div>
			<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<input type="number" name="codePostal" id="form3Example8"
							class="form-control" value="${userConnected.codePostal}"
							placeholder="${userConnected.codePostal}" /> <label
							class="form-label" for="form3Example8">Code Postal</label>
					</div>
				</div>

				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<input type="text" name="ville" id="form3Example9"
							class="form-control" value="${userConnected.ville}"
							placeholder="${userConnected.ville}" /> <label
							class="form-label" for="form3Example9">Ville</label>
					</div>
				</div>
			</div>
			<input type="hidden" name="id" value="${userConnected.noUtilisateur}">
			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block mb-4">
				Modifier</button>
		</form>

		<form action="delete" method="post">
			<button type="submit" value="${userConnected.noUtilisateur}"
				name="id" class="btn btn-warning btn-block mb-4">Supprimer
			</button>
		</form>
		
		
	</div>

	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>