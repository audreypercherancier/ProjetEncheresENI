<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon compte</title>
</head>
<body>
	<p>Pseudo : ${user.getPseudo()}</p>
	<p>nom : ${user.getNom()}</p>
	<p>Prénom : ${user.getPrenom()}</p>
	<p>Email : ${user.getEmail() }</p>
	<p>Téléphone : ${user.getTelephone()}</p>
	<p>Rue : ${user.getRue()}</p>
	<p>Code postal : ${user.getCodePostal() }</p>
	<p>Ville : ${user.getVille() }</p>
	<p>Mon credit : ${user.getCredit()}</p>
	<button type="button">modifier</button>

</body>
</html>