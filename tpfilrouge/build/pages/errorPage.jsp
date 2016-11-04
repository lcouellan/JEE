<%@ page isErrorPage="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="path" value="<%= request.getContextPath() %>" />
<c:set var="cssPath" scope="request" value="<%= request.getContextPath()+"/" %>" />

<jsp:include page="../fragments/header.jsp" />

<h1>Erreur</h1>
<p>
  Une erreur inattendue s'est produite. Toutes nos excuses.
</p>
<c:if test="${!empty exception}">
  <p>La trace de l'erreur est&nbsp;:</p>
  <pre><% exception.printStackTrace(response.getWriter()); %></pre>
</c:if>
<p>
  <a href="<%= request.getContextPath() %>">Retourner &agrave; l'accueil</a>
</p>

<jsp:include page="../fragments/footer.html" />
