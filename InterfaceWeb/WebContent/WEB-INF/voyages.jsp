<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Voyages</title>
</head>
<body>
	<div id="banner" class = "banner">
		<h1>Recherche de Voyage</h1>
	</div>
	<div id="search" class = "search">
		<form method="post" action="voyage">
			<p><label for="Pays ou Ville" >Nom :</label><input type="text" name="pays" id="pays" /></p>
		</form>
	</div>
	<div id="results" class="results">
		<% 
			String attribut = (String) request.getAttribute("toDisplay");//récupération de l'attribut passé en paramètre.
			out.println( attribut );//affichage de l'attribut;
		%>
	</div>
</body>