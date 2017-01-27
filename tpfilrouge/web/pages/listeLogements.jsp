<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="jdbclogements.LogementsDBHandler" %>


<jsp:include page="fragments/header.jsp" />

<h1>Tous nos logements</h1>
<ul>

  <c:forEach var="logement" items="<%= LogementsDBHandler.getDb().retrieveAll() %>">
    <li>
      ${logement}
    </li>
  </c:forEach>
</ul>

<jsp:include page="fragments/footer.html" />
