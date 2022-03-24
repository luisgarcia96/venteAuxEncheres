<%@page import="vae.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Boolean monProfil = false;
	Utilisateur utilisateur = (Utilisateur)request.getAttribute("utilisateur");
	String pseudo = (String) request.getAttribute("pseudo");
	if(utilisateur.getLogin().contentEquals(pseudo)){
		monProfil = true;
	}
%>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Ventes Aux Enceheres</title>
		<style type = "text/css">
			<%@ include file = "/WEB-INF/css/style.css"%>
			<%@ include file = "/WEB-INF/css/afficherProfil.css"%>
		</style>
	</head>
	<body>
		<%@include file="../include/header.jsp" %>
		
		<main>
		 	<% if(monProfil){  %>
		 		<h2>Mon profil</h2>
			<% } else { %>
				<h2>Profil de <%= pseudo %></h2>
			<% } %>
			
			
			<div>
				<div class="display"><p class="libelle">Pseudo:</p><p class="affLibelle"><%= utilisateur.getLogin() %></p></div>
				<div class="display"><p class="libelle">Nom:</p><p class="affLibelle"><%= utilisateur.getNom() %></p></div>
				<div class="display"><p class="libelle">Prenom:</p><p class="affLibelle"><%= utilisateur.getPrenom() %></p></div>
				<div class="display"><p class="libelle">Email:</p><p class="affLibelle"><%= utilisateur.getEmail() %></p></div>
				<div class="display"><p class="libelle">Telephone:</p><p class="affLibelle"><%= utilisateur.getTelephone() %></p></div>
				<div class="display"><p class="libelle">Rue:</p><p class="affLibelle"><%= utilisateur.getRue() %></p></div>
				<div class="display"><p class="libelle">Code postal:</p><p class="affLibelle"><%= utilisateur.getCodePostal() %></p></div>
				<div class="display"><p class="libelle">Ville:</p><p class="affLibelle"><%= utilisateur.getVille() %></p></div>
			</div>
			
			<% if(monProfil){ %>
				<button id="modifier" type="button" onclick="window.location.href='modifierProfil'">Modifier</button>
			<% } %>
		</main>
		<%@include file="../include/footer.jsp" %>
	</body>
</html>