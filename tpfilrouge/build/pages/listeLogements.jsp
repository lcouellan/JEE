<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="jdbclogements.LogementsDBHandler" %>


<jsp:include page="fragments/header.jsp" />

<h1>Tous nos logements</h1>

<div class="row">
  <c:forEach var="logement" items="<%= LogementsDBHandler.getDb().retrieveAll() %>">
  	<div class="col-md-4">
	    <div class="thumbnail">
	    <img src="images/logement.jpg" alt="image par défaut">
	    <div class="caption">
	      <h4>${logement}</h4>
	    </div>
	  </div>
	</div>
  </c:forEach>
</div>

<jsp:include page="fragments/footer.html" />
