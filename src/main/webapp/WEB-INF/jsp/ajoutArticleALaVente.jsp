<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	
	<br>
	
	<h1 class="text-center">Nouvelle vente</h1>
	
	<div class="card-body px-4 py-5 px-md-5">
	

	<form action="VendreUnArticle" method="post">

	<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label> Nom Article </label>
						<input type="text" name="nomArticle" required> <br>
						
					</div>
				</div>
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label style="vertical-align : top"> Description Article </label> 
						<textarea rows="3" cols="20" name="descriptionArticle" required></textarea> <br>
					</div>
				</div>
	</div>
	
	<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label>Catégorie du produit</label>
						
						<select name="categorie" id="categorie" required>
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
								
					</div>
				</div>
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label> Mise à prix</label> <input type="number" name="prixinitial" required> <br>
						
					</div>
				</div>
	</div>
	
	<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						<label> Date de début d'enchères </label> <input type="date" name="datedebutencheres" required> <br>
					</div>
				</div>
				
				<div class="col-md-6 mb-4">
					<div class="form-outline">

						<label> Date de fin d'enchères </label> <input type="date" name="datefinencheres" required> <br>
					</div>
				</div>
	</div>
	
	<fieldset>
		<legend>Retrait</legend>
	<div class="row">
				<div class="col-md-6 mb-4">
					<div class="form-outline">
						
							<label for="rue">Rue : </label>
							<input type="text" name="rue" id="rue" value="${userConnected.getRue()}" required/>
		
							<label for="cp">Code postal : </label>
							<input type="number" name="codePostal" id="cp" value="${userConnected.getCodePostal()}" required/>
		
					</div>
				</div>
				<div class="col-md-6 mb-4">
					<div class="form-outline">
							<label for="ville">Ville : </label>
							<input type="text" name="ville" id="ville" value="${userConnected.getVille()}" required/>
					</div>
				</div>
	</div>
	
	</fieldset>

		<input type="submit" value="Valider" /> <a type="button" href="#">
			Annuler </a>
	</form>

	</div>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
<script type="text/javascript" src="vendor/javascript/checkConfirmationPassword.js"></script>
<script type="text/javascript" src="vendor/javascript/checkRequired.js"></script>


<style type="text/css">
.form-control {
border-width : 0.5px; 
}
</style>
</html>
