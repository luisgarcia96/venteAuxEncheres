<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scal=1.0"/>

<meta name="description" content=""/>
<meta name="author" content="Yasmine.H"/>

<style type = "text/css">

<%@ include file = "/WEB-INF/css/style.css"%>
<%@ include file = "/WEB-INF/css/formStyle.css"%>

</style>
<!--  <link rel="stylesheet" type="text/css" href="/WEB-INF/css/formStyle.css"/>-->

<title>Connexion</title>

</head>
<body>
	<!-- Header -->
	<%@ include file="/WEB-INF/include/header.jsp" %>
	
	<!-- Mise en place du formulaire de connexion -->
	<section class="connexion">
		<div class="max-width">
				<!-- Titre -->
           		<h1 class="title">Connexion</h1>
           		<div class="connexion-content">
           		
           			<!-- Création du formulaire -->
	           		<form method ="post" action="./connexion">
	           			<!-- Affichage de l'erreur -->
	           			<c:if test="${!empty erreur}"><p style="color:red;"><c:out value="${erreur }"/></p></c:if>
	           			
	           			<!-- Champ de l'identifiant -->
	           			<div class="form">
	           				<label for="login" class="identifiant">Identifiant :</label>
	           				<!-- La case à remplir par l'Email ou le login de connexion -->
							<input type="text" class="ch-identifiant" id="login" name="login" required ="required" maxlength="60"/>		
	           			</div>
	           			
	           			<!-- Champ du mot de passe -->
	           			<div class="pass">
	           				<label for="motDePasse" class="password">Mot de Passe :</label>
	           				<!-- La case à remplir par le mot de pasee de connexion -->
							<input type="password" class="ch-password" id="motDePasse" name="motDePasse" required ="required" maxlength="20"/>
	           			</div>
	           			
	           			<div class="check">
	           				<!-- Bouton se connecter -->
	           				<button type="submit" class="btn-connexion">Se Connecter</button>
	           				<!-- Une checkbox pour la fonction se souvenir -->
	           				<input type="checkbox" class="form-check" id="souvenir" />
	           				<label class="souvenir" for="souvenir">Se souvenir de moi</label> 
	           			</div>
	           		</form>
           		</div>
           		
           		<!-- Bouton Créer un compte -->
           		<div class="btn-create-user">
	           		<button class="btn-inscription"><a href="createUser">Créer un compte</a></button>
           		</div>
           	</div>
	</section>
	
	<!-- Footer -->
	<%@ include file="/WEB-INF/include/footer.jsp" %>
</body>
</html>
