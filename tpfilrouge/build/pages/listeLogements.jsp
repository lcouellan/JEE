<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="jdbclogements.LogementsDBHandler" %>


<jsp:include page="fragments/header.jsp" />

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