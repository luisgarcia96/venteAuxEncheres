<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="../css/style.css">
		<title>Ventes Aux Enceheres</title>
		<style type = "text/css">
			<%@ include file = "/WEB-INF/css/style.css"%>
			<%@ include file = "/WEB-INF/css/createUser.css"%>
		</style>
	</head>
	<body>
		<%@include file="../include/header.jsp" %>
		<%@include file="../include/navEnchere.jsp" %>
		
		<main>
			<h2 class="title">Création de votre compte utilisateur</h2>
			
			<form method="POST" action="createUser" id="createUserForm">
				<div class = form-block>
					<label for="pseudo">Pseudo</label>
					<input type="text" name="pseudo" placeholder="votre pseudo" required>
				</div>
				<div class = form-block>
					<label for="nom">Nom</label>
					<input type="text" name="nom" placeholder="Votre nom" required>
				</div>
				<div class = form-block>
					<label for="prenom">Prenom</label>
					<input type="text" name="prenom" placeholder="Votre prénom" required>
				</div>
				<div class = form-block>
					<label for="email" >Email</label>
					<input type="email" name="email" placeholder="votre-email@mail.fr" required>
				</div>
				<div class = form-block>
					<label for="telephone">Téléphone</label>
					<input type="tel" name="telephone" placeholder="0612345678" required>
				</div>
				<div class = form-block>
					<label for="rue">Adresse</label>
					<input type="text" name="rue" placeholder="6 rue Gambetta" required>
				</div>
				<div class = form-block>
					<label for="postal">Code postal</label>
					<input type="number" name="postal" min="10000" max="99999" placeholder="49000" required>
				</div>
				<div class = form-block>
					<label for="ville">Ville</label>
					<input type="text" name="ville" placeholder="Votre ville" required>
				</div>
				<div class = form-block>
					<label for="password">Mot de passe</label>
					<input id="password" type="password" minlength="6" maxlength="20" name="password" placeholder="mot de passe" required >
				</div>
				<div class = form-block>
					<label for="password2">Confirmer</label>
					<input id="password2" type="password" minlength="6" maxlength="20" name="password2" placeholder="mot de passe" required >
				</div>

					<input type="submit" id="submit">
					<p id="error"></p>
			</form>
		
		</main>
		<%@include file="../include/footer.jsp" %>
	</body>
</html>