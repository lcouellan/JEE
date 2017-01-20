<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="jdbclogements.LogementsDBHandler" %>

<%
  Appartement test = new Appartement(200.0 , 8 , " 7 Allée du Raphapha 14000 Caen");
%>
<jsp:include page="fragments/header.jsp" />

<h1>Test logement</h1>

<table>
<tr><th>Adresse</th><th>Surface</th><th>Nombre de pièces</th></tr>
<tr>
  <td><%= test.getAdresse() %></td>
    <td><%= test.getSurface() %> m2</td>
    <td><%= test.getNbPieces() %> pièces</td>
</tr>
</table>

<h1>Tous nos logements</h1>
<ul>

  <c:set var="withSurface" value="${!empty param['action'] && param['action']=='surface'}" />

  <c:forEach var="logement" items="<%= LogementsDBHandler.getDb().retrieveAll() %>">
    <li>
      ${logement}
      <c:if test="${withSurface}">[surface&nbsp;: ${logement.surface}]</c:if>
    </li>
  </c:forEach>
</ul>

<jsp:include page="fragments/footer.html" />