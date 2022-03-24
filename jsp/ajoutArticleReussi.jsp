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
<title>Ajout article</title>
</head>
<body>
	<%@include file="/WEB-INF/include/header.jsp" %>
	<main>
	<h1>L'article a été ajouté avec succès</h1>
	<a href="<%=request.getContextPath()%>/accueil">Revenir à l'accueil</a>
	</main>
	<%@include file="/WEB-INF/include/footer.jsp" %>
</body>
</html>