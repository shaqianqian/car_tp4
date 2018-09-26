<%@page import="car.tp4.entity.Book"%>
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
	<h1 align="center">Mon Panier</h1>
	 <div class="centre1">
	 
	<div class="input">
	<form method="POST" action="command">
		<input type="hidden" name="type" value="valide"> 
		<input type="submit" value="confirmer la commande" class="button" >
	</form>
	</div>

   <div class="input">
	<form method="POST" action="command">
		<input type="hidden" name="type" value="reset"> 
		<input type="submit" value="annuler la commande"  class="button" >
	</form>
	</div>

	 <div class="input">
		<form method="get" action="/books">
		<input type="submit" class="button" value="Continue de shopping">
	    </form>

	   </div>
	   </div>
	<div class="centre1">
	<table border="1" class="dataintable">
		<tr>
		    <th>ID de Livre</th>
			<th>Titre</th>
			<th>Auteur</th>
			<th>Annee</th>
			<th>Annule</th>
		</tr>

		<%
			Collection<Book> books_in_paniers = (Collection<Book>) request.getAttribute("books_in_paniers");
			for (Book book : books_in_paniers) {
				out.print("<tr><td>" + book.getId() + "</td><td>" + book.getTitle() + "</td><td>" + book.getAuthor() + "</td><td> " + book.getYear()
						+ "</td>");
				%>
			<td>	
			<form method="POST" action="panier">
			<input type="hidden" name="bookId" value=<%=book.getId()%>> 
			<input type="hidden" name="type" value="annule">
			<input type="submit" class="button" value="annuler ce livre"> 
			
			 </form>	</td>
				
		<%		out.print("</tr>");
			}
		%>
	</table></div>

</body>

<style>
table {
	border-collapse: collapse;
}

td, th /* Mettre une bordure sur les td ET les th */ {
	border: 1px solid black;
}
</style>
</html>