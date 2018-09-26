
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css">
<title>Home</title>
</head>
<body>
<%
if(request.getAttribute("resultat")!="echou"){
%>
<h1 align="center">reussie de supprimer livre : <%=request.getParameter("id")%></h1>
<% } else{%>

<h1 align="center">Il n'existe pas ce livre </h1>
<% } %>
  <div class="centre">
	<form method="get" action="books">
		<button type="submit">Rentre</button>
	</form>
	</div>
</body>

</html>