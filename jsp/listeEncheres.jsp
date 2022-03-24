<%@page import="vae.bo.ArticleVendu"%>
<%@page import="java.util.List"%>
<%@page import="vae.bo.Categorie" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
		<style type = "text/css">
		<%@ include file = "/WEB-INF/css/style.css"%>
		<%@ include file = "/WEB-INF/css/listeEncheres.css"%>
		</style>
		<title>Liste des enchères</title>
	</head>
	<body>
		<div>
			<%@include file="../include/header.jsp" %>
		</div>
		
		<section class="home">
			<div class="max-width">
				<h1 class="title">Liste des enchères</h1>
				<div class="home-content">
					<div class="column left">
					
					<!-- Filtres de la recherche -->
						<form method ="get" action="<%=request.getContextPath()%>/listeArticles">
							<div class="filter">
		           				<p><label for="search" class="search">Filtres :</label></p>
								<p><input type="search" id="search" name="nomArticle" placeholder="Nom de l'article"/></p>
	           				</div>
	           				
	           				<div class="col">
                    			<label class="category" for="category">Categorie</label>
				                    <%
				                    	List<Categorie> listeCategories = (List<Categorie>)request.getAttribute("listeCategories");
				                    	if(listeCategories != null && listeCategories.size()>0){
				                    %>
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
								<button class="btn"><i class="fas fa-search"> Rechercher</i></button>
							</div>
						</form>
						
				</div>	
			</div>
		</section>
		
		
		<main>
		
			<%
				List<ArticleVendu> listeArticlesVendus = (List<ArticleVendu>) request.getAttribute("listeArticlesVendus");  
				if(listeArticlesVendus!=null && listeArticlesVendus.size()>0)
				{
			%>
		
		<!-- Ligne résultat -->
		
			<%
				for(ArticleVendu articleVendu : listeArticlesVendus)
				{
			%>
		
		<!-- Résultats de la recherche -->
		<section class="article">
		
			
			<div class="resultat">
				<div class="photoResultat">
					<img src="<%=request.getContextPath()%><%=articleVendu.getImageArticle()%>"/> 
				</div>
				<div class="informationResultat">
					<h2 class="NomResultat"><%=articleVendu.getNomArticle()%></h2>
					<br>
					<p class="prixResultat"><%=articleVendu.getPrixVente() %> (crédits)</p>
					<p class="dateResultat">Début de l'enchère: <%=articleVendu.getDateDebutEncheres()%></p>
					<br>
					<p class="vendeurResultat">Publié par: <a id="utilisateur" href=""><%=articleVendu.getUtilisateurArticle().getLogin()%></a></p>
				</div>
			</div>
		</section>
		
		
				<% } }else { %>
					<!-- Message s'il n'y a pas de résultats correspondants -->	
					<p id="pasDeResultat">Il n'y a aucun article qui correspond à votre recherche <P>
				<%
					}
				%>
	</main>
		
		
		<%@include file="../include/footer.jsp" %>
	</body>
</html>