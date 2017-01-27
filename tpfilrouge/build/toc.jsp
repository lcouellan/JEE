<jsp:include page="fragments/header.jsp" />

<div class="contenu">
	<c:if test="${!empty param['message']}">
	  <p class="message">${param["message"]}</p>
	</c:if>

	<h1>Projet JEE</h1>
</div>

<jsp:include page="fragments/footer.html" />
