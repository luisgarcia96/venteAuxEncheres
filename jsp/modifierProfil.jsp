<%@page import="vae.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 	Utilisateur utilisateur = (Utilisateur)request.getAttribute("utilisateur"); %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Ventes Aux Enceheres</title>
		<style type = "text/css">
			<%@ include file = "/WEB-INF/css/style.css"%>
			<%@ include file = "/WEB-INF/css/modifierProfil.css"%>
		</style>
	</head>
	<body>
		<%@include file="../include/header.jsp" %>
		
		<main>
		<h2>Modifier mon profil</h2>
		
		<form method="POST" action="modifierProfil" id="deleteUserForm" name="deleteUserForm">
			<input type="submit" name="delete" id="delete" value="Supprimer mon compte">
		</form>
		
				
		<form method="POST" action="modifierProfil" id="updateUserForm">
				<div class = form-block>
					<label for="pseudo">Pseudo</label>
					<input type="text" name="pseudo" placeholder="votre pseudo" value="<%= utilisateur.getLogin() %>" required>
				</div>
				<div class = form-block>
					<label for="nom">Nom</label>
					<input type="text" name="nom" placeholder="Votre nom" value="<%= utilisateur.getNom() %>" required>
				</div>
				<div class = form-block>
					<label for="prenom">Prenom</label>
					<input type="text" name="prenom" placeholder="Votre prénom" value="<%= utilisateur.getPrenom() %>" required>
				</div>
				<div class = form-block>
					<label for="email" >Email</label>
					<input type="email" name="email" placeholder="votre-email@mail.fr" value="<%= utilisateur.getEmail() %>" required>
				</div>
				<div class = form-block>
					<label for="telephone">Téléphone</label>
					<input type="tel" name="telephone" placeholder="0612345678" value="<%= utilisateur.getTelephone() %>" required>
				</div>
				<div class = form-block>
					<label for="rue">Adresse</label>
					<input type="text" name="rue" placeholder="6 rue Gambetta" value="<%= utilisateur.getRue() %>" required>
				</div>
				<div class = form-block>
					<label for="postal">Code postal</label>
					<input type="number" name="postal" min="10000" max="99999" placeholder="49000" value="<%= utilisateur.getCodePostal() %>" required>
				</div>
				<div class = form-block>
					<label for="ville">Ville</label>
					<input type="text" name="ville" placeholder="Votre ville" value="<%= utilisateur.getVille() %>" required>
				</div>
				<div class = form-block>
					<label for="password">Mot de passe</label>
					<input id="password" type="password" minlength="6" maxlength="20" name="password" placeholder="mot de passe" >
				</div>
				<div class = form-block>
					<label for="password2">Confirmer</label>
					<input id="password2" type="password" minlength="6" maxlength="20" name="password2" placeholder="mot de passe" >
				</div>

					<input type="submit" id="submit" value="Modifier">
					<p id="error"></p>
			</form>
		</main>
		<%@include file="../include/footer.jsp" %>
	</body>
</html>