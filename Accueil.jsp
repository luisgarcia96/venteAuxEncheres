<%@page import="java.util.List"%>
<%@page import="vae.bo.Categorie" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String ctPath = request.getContextPath(); %>

<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
	    
		<style type = "text/css">
		<%@ include file = "/WEB-INF/css/style.css"%>
		</style>

		<title>VentEncheres</title>
		
	</head>

	<body>
	
		<%@include file="include/header.jsp" %>
		
		
	<section class="home">
		<div class="max-width">
			<!-- Titre -->
			<h1 class="title">Liste des enchères</h1>
				
			<div class="home-content">
				<div class="column left">
					
					<!-- Formulaire du filtre/Recherche -->
					<form method ="get" action="<%=request.getContextPath()%>/listeArticles">
						<!-- Champ de recherche/filtre -->
						<div class="filter">
			           			<p><label for="search" class="search">Filtres :</label></p>
								<p><input type="search" id="search" name="nomArticle" placeholder="Nom de l'article"/></p>
		           		</div>
		           			
		           		<!-- Liste de catégorie -->
		           		<div class="col">
		                   		<label class="category" for="category">Catégorie :</label>
						                 <%
						                 	List<Categorie> listeCategories = (List<Categorie>)request.getAttribute("listeCategories");
						                 	if(listeCategories != null && listeCategories.size()>0){
						                 %>
						            <!-- Récupération de la liste des catégories de la base de données -->
		                    	<select name="categorie" id="category" class="list">
					                     <%
					                  	 	for(Categorie categorie : listeCategories) {
					                     %>
		                        	<option value="<%=categorie.getNoCategorie() %>"> <%= categorie.getLibelle() %> </option>
					                     <% } %>
					                     <% } %>
				                </select>
                		</div>         				  		
				</div>
					
				<div class="column right">
					<!-- Bouton Rechercher -->
					<button class="btn"><i class="fas fa-search"> Rechercher</i></button>
				</div>
						</form>
					
			</div>
		</div>
	</section>
		
		<!-- Footer -->
		 <%@include file="include/footer.jsp" %>
	</body>
</html>