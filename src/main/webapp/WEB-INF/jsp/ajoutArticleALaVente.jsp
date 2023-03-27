<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<title >Insert title here</title>
</head>
<body style="background-color: #eee;">
	<%@ include file="/WEB-INF/jsp/insertion/entete.jsp"%>
	<h1>Nouvelle vente</h1>
	<div class="col-lg-8">
			<div class="container py-5">
			<div class="card mb-4">
	<div class="card-body">
		<form action="VendreUnArticle" method="post">
			
				<label class="text-center"> Nom Article </label>
				<input type="text" name="nomArticle" required> <br>
				<label style="vertical-align : top"> Description Article </label> <textarea rows="3" cols="20"
					name="descriptionArticle" required></textarea> <br>
				<select name="categorie" id="categorie" required>
					<option value="">Choississez une catégorie</option>
					<option value="1">Hygiène et Santé</option>
					<option value="2">Animalerie</option>
					<option value="3">Maison</option>
					<option value="11">Autres</option>
				</select> 
				
				<label> Mise à prix</label> 
				<input type="number" name="prixinitial" required> <br>
				<label> Date de début d'enchères </label> 
				<input type="date" name="datedebutencheres" required> <br>
				<label> Date de fin d'enchères </label> 
				<input type="date" name="datefinencheres" required> <br>
		
				<fieldset>
					<legend>Retrait</legend>
					
					<label for="rue">Rue : </label>
					<input type="text" name="rue" id="rue" value="${userConnected.getRue()}" required/>
					
					<label for="cp">Code postal : </label>
					<input type="number" name="codePostal" id="cp" value="${userConnected.getCodePostal()}" required/>
					
					<label for="ville">Ville : </label>
					<input type="text" name="ville" id="ville" value="${userConnected.getVille()}" required/>
					
				</fieldset>
		
				<input type="submit" value="Valider" /> <a type="button" href="#">
					Annuler </a>
			
		</form>
		</div>
			</div>
			</div>
	</div>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>