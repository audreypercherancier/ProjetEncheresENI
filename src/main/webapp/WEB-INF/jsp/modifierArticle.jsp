<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.eni.mahm.projetencheres.bo.ArticleVendu"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Modifier l'article</title>
		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
		<h1 class="text-center">Modification de l'article</h1>
		<div class="container py-5">
			<div class="row">
				
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label class="form-label" for="form3Example2">Nom article</label>
						 <input type="text" name="nomArticle" id="form3Example2" class="form-control"
						 	value="${nArticle.nomArticle}"
							placeholder="${nArticle.nomArticle}" required />
						<div class="invalid-feedback">Veuillez saisir un nom de l'article</div>
					</div>
				</div>
				
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label class="form-label" for="form3Example2">Description</label>
						 <input type="text" name="description" id="form3Example2" class="form-control"
						 	value="${nArticle.description}"
							placeholder="${nArticle.description}" required />
						<div class="invalid-feedback">Veuillez saisir un descripstion pour l'article</div>
					</div>
				</div>
				
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label class="form-outline" for="form3Example2">Categorie</label>
						<select name="categorie" id="categorie" class="form-control" required>
											<option value="">Choississez une catégorie</option>
											<option value="1">Hygiène et Santé</option>
											<option value="2">Animalerie</option>
											<option value="3">Maison</option>
											<option value="4">Jardin</option>
											<option value="5">Sports et Loisirs</option>
											<option value="6">Jeux et Jouets</option>
											<option value="7">Bricolage</option>
											<option value="8">Mode</option>
											<option value="9">High-Tech</option>
											<option value="10">Véhicules</option>
											<option value="11">Autres</option>
									</select> 
						 <input type="text" name="categorie"  id="datefield"  class="form-control"
						 	value="${nArticle.categorie}"
							placeholder="${nArticle.categorie}" required />
						<div class="invalid-feedback">Veuillez choisir la categorie de l'article</div>
					</div>
				</div>
				
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label class="form-label" for="form3Example2">Prix</label>
						 <input type="text" name="miseAPrix" id="form3Example2" class="form-control"
						 	value="${nArticle.miseAPrix}"
							placeholder="${nArticle.miseAPrix}" required />
						<div class="invalid-feedback">Veuillez saisir le prix e vente pour l'article</div>
					</div>
				</div>
				
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label class="form-label" for="form3Example2">Date de dédut des encheres</label>
						 <input type="text" name="dateDebutEncheres" id="form3Example2" class="form-control"
						 	value="${nArticle.dateDebutEncheres}"
							placeholder="${nArticle.dateDebutEncheres}" required />
						<div class="invalid-feedback">Veuillez saisir la date du début des encheres</div>
					</div>
				</div>
				
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label class="form-label" for="form3Example2">Date de fin des encheres</label>
						 <input type="text" name="dateFinEncheres"  id="datefield"  class="form-control"
						 	value="${nArticle.dateFinEncheres}"
							placeholder="${nArticle.dateFinEncheres}" required />
						<div class="invalid-feedback">Veuillez saisir la date du début des encheres</div>
					</div>
				</div>
				
			</div>
		</div>
	</body>
</html>