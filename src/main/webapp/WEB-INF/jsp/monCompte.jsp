<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon compte</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<%@ include file="/WEB-INF/html/entete.html" %>

<section style="background-color: #eee;">
  <div class="container py-5">
    

    <div class="row">
      <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2.webp" alt="avatar"
              class="rounded-circle img-fluid" style="width: 150px;">
            <h5 class="my-3">${user.getPseudo()}</h5>
            <p class="text-muted mb-1">${user.getNom()} ${user.getPrenom()} </p>
            <p class="text-muted mb-4"> Mon Credit : ${user.getCredit()}</p>
            <div class="d-flex justify-content-center mb-2">
              <a type="button" 
			        class="btn btn-secondary my-2 my-sm-0"
			        href="/ProjetEncheresENI/modifier"
			        role="button"
        
        		>modifier</a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-8">
        <div class="card mb-4">
          <div class="card-body">
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Pseudo :</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.getPseudo()}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">nom :</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"> ${user.getNom()}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Prénom :</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"> ${user.getPrenom()}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Email :</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.getEmail() }</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Téléphone :</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"> ${user.getTelephone()}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Rue :</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"> ${user.getRue()}</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Code postal :</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"> ${user.getCodePostal() }</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Ville :</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">  ${user.getVille() }</p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Nombres d'article achetés :</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"></p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0"></p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">Nombres d'article vendues :</p>
              </div>
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