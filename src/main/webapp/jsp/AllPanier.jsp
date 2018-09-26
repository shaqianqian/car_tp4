<%@page import="car.tp4.entity.Panier"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css">
<title>Acceuil</title>
</head>
<body>


	<br>
	 <h1 align="center">Toute les commandes</h1>
	 </div>
		<div class="button">
	     <form method="post" action="search">

		<button type="submit" name="init" value="init"  >Homepage</button>

	    </form>
	
  </div>
	 
	<div class="centre">
		<table border="1" class="dataintable">
		<tr>
			<th>Numero de la commande</th>
			<th>IDS de livres</th>
			<th>Quantite de livres</th>

		</tr>

		<%
			Collection<Panier> paniers = (Collection<Panier>) request.getAttribute("panier");
			for (Panier panier : paniers) {
				out.print("<tr><td>" + (panier.getId()-50) + "</td><td>" +panier.getId_livres() + "</td><td>"  + panier.getQuantite() + "</td></tr>");
	
			}
		%>
	</table>
<style>
table {
	border-collapse: collapse;
}

td, th /* Mettre une bordure sur les td ET les th */ {
	border: 1px solid black;
}
</style>
</html>
