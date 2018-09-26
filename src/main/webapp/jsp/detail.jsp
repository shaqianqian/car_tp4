<%@page import="car.tp4.entity.Book"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css">
<title>Home</title>
</head>
<body>


	<%
		Book book = (Book) request.getAttribute("id");
	%>
<div class="centre">

	<form method="get" action="/books">
		<button type="submit">Homepage</button>
	</form>
	</br>
<table border="1" class="dataintable">
		
		   <tr> <td>Id</td><td> <%=book.getId()%></td></tr>
		   <tr><td>Titre</td><td><%=book.getTitle()%></td></tr>
			<tr><td>Auteur</td><td><%=book.getAuthor()%></td></tr>
			<tr><td>Annee</td><td><%=book.getYear()%></td></tr>
			<tr><td>Quantite</td><td><%=book.getQuantite()%></td></tr>

		
		</table>
	</div>	
		
	
	

</body>

</html>