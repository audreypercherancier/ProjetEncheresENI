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
	<h1>Nouvelle vente </h1>
	
	<form action="ajoutarticle" method="post">
		
		<label> Nom Article </label>
		<input type="text" name="nomArticle" required> <br>
		
		<label> Description Article </label>
		<input type="text" name="descriptionArticle" required> <br>	
		
		<label> Article </label>
		<input type="text" name="nomArticle" required> <br>
		
		<select name="categorie" id="categorie" required >
		    <option value="">Choississez une catégorie</option>
		    <option  name ="hygieneetsante" value="hygieneetsante">Hygiène et Santé</option>
		    <option name ="animalerie" value="animalerie">Animalerie</option>
		    <option name ="maison" value="maison">Maison</option>
		    <option name ="autres" value="autres">Autres</option>
		</select>
		
		<label> Mise à prix</label>
		<input type="number" name="prixinitial" required> <br>
		
		<label> Date de début d'enchères </label>
		<input type="date" name="datedebutencheres" required> <br>
		
		<label> Date de fin d'enchères </label>
		<input type="date" name="datefinencheres" required> <br>
		
		<button type="submit"  name="valider"> Valider </button>
		
	</form>
		<form action="supprimerdonneesArticlepage" method="post">
		<button type="submit"  name="valider"> Supprimer </button>
	</form>
	
<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>