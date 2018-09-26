
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css">
<title>Home</title>
</head>
<body>



<%
if(request.getAttribute("erreur")!="NumberFormatException"){
%>

<h1 align="center">Tu as reussi de changer le quantite de livre : <%=request.getParameter("id")%> De <%=request.getAttribute("ancien_quantite")%> a <%=request.getParameter("quantite")%></h1>

<%
} else{
%>
<h1 align="center">Tu as echoue de changer le quantite de livre, entrez une chiffre comme la quantite de livre svp</h1>
<%
}
%>


  <div class="centre">
	<form method="get" action="books">
		<button type="submit">Rentre</button>
	</form>
	</div>
</body>

</html>