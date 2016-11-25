<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="fragments/header.html" />

<c:if test="${!empty param['message']}">
  <p class="message">${param["message"]}</p>
</c:if>

<h1>Liste des pages</h1>
<ul>
  <li><a href="all">Tous les produits</a>
  <li><a href="all?action=prices">Tous les produits, avec leur prix</a>
  <li><a href="addProduct">Ajouter un produit</a>
</ul>

<jsp:include page="fragments/footer.html" />
