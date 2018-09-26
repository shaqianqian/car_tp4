
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css">
<title>Home</title>
</head>
<body>
 <div  class="button">
	<form method="get" action="/books">
		<button type="submit">HomePage</button>
	</form>
	</div>
	<br>


	<br>
	<%
		String titre = request.getParameter("titre");
	%>
	<%
		String auteur = request.getParameter("auteur");
	%>
	<%
		String year = request.getParameter("year");
	%>
	<%
		String quantite = request.getParameter("quantite");
	%>
	<%
		if (titre == "" || titre == null || auteur == null || auteur == "" || year == null || year == ""||quantite == null ||quantite  == "") {
	%>
	<div id="book" class="centre">
	<form method="POST" action="add">
<table>
<tr>
<td>Titre</td><td><input type="text" name="titre" /></td>
</tr>
 <tr>
<td>Auteur</td><td><input type="text" name="auteur" /></td>
</tr>
<tr>
<td>Annee de parution</td><td><input type="text" name="year" /></td>
</tr>
 <tr><td>Quantite disponible</td><td><input type="text" name="quantite" /></td>
</tr>
</table>
		<!-- <input	type="submit" value="Send" /> -->
		<button type="submit">Send</button>
	</form>
	</form>
	</div>
	<%
		} else {
	%>
	<div id="book" class="centre">
	<table border="1" class="dataintable">
	<tr>
	 <th>Parametre</th>
    <th>Information</th>
    </tr>
     <tr>
        <td>Titre</td>
        <td> <%=titre%></td>
       </tr>
      <tr>
        <td>Auteur</td>
        <td><%=auteur%></td>
      </tr>
       <tr>
        <td>Annee de parution</td>
        <td><%=year%></td>
        </tr>
         <tr>
        <td>Quantite disponible</td>
        <td><%=quantite%></td>
        </tr>
     </table>
     	<div  class="button">
	<form method="get" action="/add">
		<button type="submit">Ajouter un autre livre</button>
	</form>
	</div>
	</div>
	
	
	<%
		}
	%>

</body>

</html>