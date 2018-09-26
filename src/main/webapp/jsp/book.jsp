<%@page import="car.tp4.entity.Book"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css">
<title>Acceuil</title>
</head>
<body>
 <h1 align="center">Welcome to our bookshop</h1>
    <div class="button">
	<form method="get" action="/add">
		<button type="submit">Ajouter un livre</button>
	</form>
	  </div> 
  <div class="button">
	<form method="get" action="panier">
		<button type="submit">Mon panier</button>
	</form>
	 </div> 
<div class="button">
	<form method="post" action="AllPanierServlet">
		<input type="hidden" name="type" value="liste">
		<button type="submit">All the commands</button>
	</form>
	</div> 
 
<div class="button">
	<form method="post" action="search">
   
		<label>Rechercher par : </label>
		
		   <input type="radio" name="attribut" value="author"  checked="true"/> Auteur 
			<input type="radio" name="attribut" value="title" /> Titre 
			<label>Recherche : </label> <input type="text" name="search" /> <input type="submit" value="search" /> 
           
	<br>
		<button type="submit" name="init" value="init"  class="recherche">Homepage</button>

	    </form>
	
  </div>

  
 <br/>
 
 <div class="button">
	<form method="post" action="delete">
   
		<input type="text" name="id" /> 
      
		<button type="submit" class="recherche">delete</button>
    
	</form>
  </div>
   <br/>
  <h2 align="center">Mes livres</h2>
   <div class="centre1">
		<table border="1" class="dataintable">
		<tr>
		    <th>Id</th>
			<th>Titre</th>
			<th>Auteur</th>
			<th>
			<form method="post" action="booksSort">
			<input type="submit" name="type" value="-->"  /> 
			<input type="submit" name="type" value=" <-- "  /> 
			</form>
			</th>
			<th>Quantite</th>
			<th>BuyBuy</th>
	
		</tr>
		<%
            Collection<Book> books = (Collection<Book>) request.getAttribute("books");
	     

        /*    for (Book book: books) {
               out.print("Author: " + book.getAuthor() + ", Title: " + book.getTitle()+", id: " + book.getId());
               out.print("\n");
           } */

            for (Book book: books) {
            	if(book.getQuantite() <= 0){
      /*   	out.print("<tr><td> " + book.getId() + "</td> <td><a href=\"/book?id=" + book.getId() + "\">" + book.getTitle() + "</td><td>"
				+ book.getAuthor() + "</td><td> " + book.getYear() + "</td><td> " + book.getQuantite()
				+ "</td></tr>"); */
	
        	
            	}
            	else
            	{
        	%>
		
		
			<%
			out.print("<tr><td> " + book.getId() + "</td><td><a href=\"/detail?id=" + book.getId() + "\">" + book.getTitle() ); 
			%>
			
			 <form method="POST" action="detail">
		     <input type="hidden" name="id" value=<%=book.getId()%>> 
			 <input type="submit" value="Details"/>
			 
		   <% out.print( "</td><td>"+ book.getAuthor() + "</td><td> " + book.getYear() + "</td>"); %>
	

			
		</form>
			 <form method="POST" action="quantite">
			 <td><input type="text" name="quantite" value=<%=book.getQuantite()%>>
		     <input type="hidden" name="id" value=<%=book.getId()%>> 
			 <input type="submit" value="Changez votre quantite"/></td>
			 
			 
			
		</form>
			 <form method="POST" action="panier">
		
			 <input type="hidden" name="bookId" value=<%=book.getId()%>> 
			 <input type="hidden" name="type" value="add">
			 <td><input type="submit" name="order" value="Ajouter au panier"/></td>
			 
			 </tr>
			
		</form>
		<%
            	}
            }
		%>
		</table></div><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
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
