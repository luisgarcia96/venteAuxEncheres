<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List" %>
<%@page import="vae.bo.Categorie" %>
<%@page import="vae.exceptions.LectureMessage" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
<style type = "text/css">
<%@ include file = "/WEB-INF/css/style.css"%>
<%@ include file = "/WEB-INF/css/vendreUnArticle.css"%>
</style>
<title>Insert title here</title>
</head>
<body>
		<%@include file="/WEB-INF/include/header.jsp" %>
		
		<main>
			<h2>Nouvelle Vente</h2>
			
		<%
			List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
			if(listeCodesErreur!=null)
			{
		%>
				<p class="erreur">Erreur, l'article n'a pas pu être ajouté :</p>
		<%
				for(int codeErreur:listeCodesErreur)
				{
		%>
					<p class="erreur"><%=LectureMessage.getMessageErreur(codeErreur)%></p>
		<%	
				}
			}
		%>
	<div class="formulaire">	
    <form action="<%=request.getContextPath()%>/vendreUnArticle" method="POST" enctype="multipart/form-data">							
        <section id="descriptionVente">
            <div>

                    <label for="nomArtcile">Article:</label>
                    <input type="text" id="nomArtcile" name="nomArticle" required>
                
            </div>
            <div>
               
                    <label for="categorie">Categorie</label>
                    <%
                    	List<Categorie> listeCategories = (List<Categorie>)request.getAttribute("listeCategories");
                    	if(listeCategories != null && listeCategories.size()>0){
                    %>
                    <select name="categorie" id="categorie">
                    
                    	<%
                    		for(Categorie categorie : listeCategories) {
                    	%>
                    	
                    	
                        <option value="<%=categorie.getNoCategorie() %>"> <%= categorie.getLibelle() %> </option>
                       <% } %>
                       <% } %>
                    </select>
                
            </div>
            <div>   
                    <label id="descriptionContent" for="description">Description:</label>
                    <textarea id="description" name="description" rows="4" cols="35" required minlength="10" placeholder="Vous pouvez écrire ici"></textarea>
               
            </div>
            <div>
                
                    <label for="">Photo de l'article: </label>
                    <input type="file" name="imageArticle" id="imageArticle" accept="image/*" multiple onchange="readFilesAndDisplayPreview(this.files);">
                
            </div>
            <div>
                
                    <label for="prixVente">Prix initial (credits):</label>
                    <input type="number" id="prixVente" name="prixVente" value=1 required min="1">
                
            </div>
            <div>
                
                    <label for="dateDebutEncheres">Début de l'enchère:</label>
                    <input type="date" name="dateDebutEncheres" id="dateDebutEncheres" required  max="2022-12-31">
                
            </div>
            <div>
                
                    <label for="dateFinEncheres">Fin de l'enchère:</label>
                    <input type="date" name="dateFinEncheres" id="dateFinEncheres" required>
                
            </div>
            <div id="retrait">
                <div id="retraitTitle">
                    <h3>Retrait:</h3>
                    <p><%=request.getAttribute("rue") %>, <%=request.getAttribute("codePostal")%> <%=request.getAttribute("ville") %></p>
                </div>
            </div>
            <div>
                <div>
                    <button class="validation">Enregistrer</button>
                    <button class="validation" onclick="window.location.href = '<%=request.getContextPath()%>/accueil'">Annuler</button>
                </div>
            </div>
        </section>
    </form>
    </div>	
		</main>
		<%@include file="/WEB-INF/include/footer.jsp" %>
	
</body>
</html>