<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Page de connexion</title>
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  </head>
  <body>
    <%@ include file="/WEB-INF/html/entete.html" %>
    <section class="vh-100">
      <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-md-9 col-lg-6 col-xl-5">
            <img
              src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
              class="img-fluid"
              alt="Sample image"
            />
          </div>
          <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
            <form action="login" method="post">
              <!-- Email input -->
              <div class="form-outline mb-4">
                <input
                  type="text"
                  id="form3Example3"
                  name="login"
                  class="form-control form-control-lg"
                  placeholder="Entrez un Email Valide"
                />
                <label class="form-label" for="form3Example3"
                  >Adresse email</label
                >
              </div>

              <!-- Password input -->
              <div class="form-outline mb-3">
                <input
                  type="password"
                  id="form3Example4"
                  name="password"
                  class="form-control form-control-lg"
                  placeholder="Entrer un mot de passe"
                />
                <label class="form-label" for="form3Example4"
                  >Mot de Passe</label
                >
              </div>

              <div class="d-flex justify-content-between align-items-center">
                <!-- Checkbox -->
                <div class="form-check mb-0">
                  <input
                    class="form-check-input me-2"
                    type="checkbox"
                    value=""
                    id="form2Example3"
                  />
                  <label class="form-check-label" for="form2Example3">
                    Se souvenir de moi
                  </label>
                </div>
                <a href="#!" class="text-body">Mot de passe oublié</a>
              </div>

              <div class="text-center text-lg-start mt-4 pt-2">
                <button
                  type="submit"
                  class="btn btn-primary btn-md"
                  style="padding-left: 2.5rem; padding-right: 2.5rem"
                >
                  Login
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <%@ include file="/WEB-INF/html/piedDePage.html" %>
  </body>
</html>
