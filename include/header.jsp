<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	
	<nav class ="navbar">
		<div class="max-width">
		<div class ="logo"><a href="accueil">Vent<span>Ench�res</span></a></div>
		<% if(session.getAttribute("login") != null){ %>
			
			<ul class="menu">
					<li><a href="#">Ench�res</a></li>
					<li><a href="<%=request.getContextPath()%>/vendreUnArticle">Vendre un article</a></li>
					<li><a href="<%=request.getContextPath()%>/profil">Mon Profil</a></li>
			</ul>
			
			<form method = "post" action="deconnexion">
					<input type="submit" class="deconnexion" value ="Se d�connecter">
			</form>
			
				<% } %>
				<ul class="menu">
				<% if(session.getAttribute("login") == null){ %>
					<li><a href="connexion">S'inscrire - Se connecter </a></li>
				<% } %>
			</ul>
		</div>	 
	</nav>
</header>
