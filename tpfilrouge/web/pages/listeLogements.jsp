<%@page import="logements.Logement" %>
<%@page import="logements.Appartement" %>
<%@page import="logements.LogementsDBStub" %>

<%
  LogementsDBStub db = new LogementsDBStub ();
  Appartement test = new Appartement(200.0 , 8 , " 7 Allée du Raphapha 14000 Caen")
%>
<jsp:include page="fragments/header.jsp" />

<h1>Liste des logements</h1>

<table>
<tr><th>Adresse</th><th>Surface</th><th>Nombre de pièces</th></tr>
<tr>
 	<td><%= test.getAdresse() %></td>
    <td><%= test.getSurface() %> m2</td>
    <td><%= test.getNbPieces %> pièces</td>
</tr>
</table>

<jsp:include page="fragments/footer.html" />
