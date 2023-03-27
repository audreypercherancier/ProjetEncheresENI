<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>Détail enchere</title>
</head>
<body>
	<%@include file="/WEB-INF/jsp/insertion/entete.jsp"%>
		<h1>Détail de l'enchère</h1>
		
		<form>
		<h2>${article.getNomArticle()}</h2>
		
		<label>description : </label>
		<textarea rows="3" cols="20">${article.getDescription()}</textarea>
		
		<label>categorie : </label>
		<input type="text" value="${article.getCategorie().getLibelle()}">
		
		<label>Meilleur offre :</label>
		<input type="text" value="${article.getPrixVente() }">
		
		<label>Mise à prix : </label>
		<input type="text" value="${article.getMiseAPrix() }">
		
		<label>Fin de l'enchère : </label>
		<input type="text" value="${article.getDateFinEncheres() }">
		
		<label>Lieu de retrait : </label>
		<input type="text" value="${article.getLieuRetrait() }">
		
		<label>Vendeur : </label>
		<input type="text" value="${article.getVendeur().getPseudo() }">
		
		<label>Ma proposition : </label>
		<input type="number" value="${article.getPrixVente() }">
		
		<input type="submit" class="btn btn-secondary" value="Enchérir">
		</form>
	<%@ include file="/WEB-INF/html/piedDePage.html"%>
</body>
</html>