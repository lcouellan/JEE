<jsp:include page="fragments/header.jsp" />
<c:if test="${!empty param['message']}">
  <p class="message">${param["message"]}</p>
</c:if>
<h1>Actions</h1>
<ul>
  <li><a href="compte/creer">Creer son compte</a></li>
  <li><a href="logements">Liste de tous les logements</a></li>
  <li><a href="logement/creer">Créer un logement</a></li>
</ul>

<jsp:include page="fragments/footer.html" />
