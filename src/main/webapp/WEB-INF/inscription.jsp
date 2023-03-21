<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
 <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="index.jsp">ProjetEnchereEni</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    </nav>
 <!-- Section: Design Block -->
<section class="background-radial-gradient overflow-hidden">
  

  <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
    <div class="row gx-lg-5 align-items-center mb-5">
      <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
        <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
          Le meilleur <br />
          <span style="color: hsl(218, 81%, 75%)">site d'enchere </span>
        </h1>
        
      </div>

      <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

        <div class="card bg-glass">
          <div class="card-body px-4 py-5 px-md-5">
            <form method="POST" action="inscription">
              <!-- 2 column grid layout with text inputs for the first and last names -->
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="text" name="nom" id="form3Example1" class="form-control" />
                    <label class="form-label" for="form3Example1">Nom</label>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="text" name="prenom"id="form3Example2" class="form-control" />
                    <label class="form-label" for="form3Example2">Prenom</label>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="text" name="pseudo" id="form3Example3" class="form-control" />
                    <label class="form-label" for="form3Example3">Pseudo</label>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="number" name="numero"id="form3Example4" class="form-control" />
                    <label class="form-label" for="form3Example4">Telephone</label>
                  </div>
                </div>
              </div>

              <!-- Email input -->
              <div class="form-outline mb-4">
                <input type="email" name="email" id="form3Example5" class="form-control" />
                <label class="form-label" for="form3Example5">Adresse Email</label>
              </div>

              <!-- Password input -->
              <div class="form-outline mb-4">
                <input type="password" name="motDePasse"id="form3Example6" class="form-control" />
                <label class="form-label" for="form3Example6">Mot de passe</label>
              </div>

              <!-- Email input -->
              <div class="form-outline mb-4">
                <input type="text" name="rue" id="form3Example7" class="form-control" />
                <label class="form-label" for="form3Example7">Rue</label>
              </div>
				<div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="number" name="codePostal" id="form3Example8" class="form-control" />
                    <label class="form-label" for="form3Example8">Code Postal</label>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div class="form-outline">
                    <input type="text" name="ville"id="form3Example9" class="form-control" />
                    <label class="form-label" for="form3Example9">Ville</label>
                  </div>
                </div>
              </div>
              <!-- Submit button -->
              <button type="submit" class="btn btn-primary btn-block mb-4">
                S'inscrire
              </button>

              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

    <%@ include file="/WEB-INF/html/piedDePage.html" %>
</body>
</html>