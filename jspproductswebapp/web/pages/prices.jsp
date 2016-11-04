<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="oneProduct" class="products.Product" scope="session" />

<%-- Initializing bean --%>
<c:if test="${!empty param['name']}">
  <jsp:setProperty name="oneProduct" property="name" value="${param['name']}" />
</c:if>
<c:if test="${!empty param['pricePerKg']}">
  <jsp:setProperty name="oneProduct" property="pricePerKg" value="${param['pricePerKg']}" />
</c:if>
<c:if test="${!empty param['weight']}">
  <jsp:setProperty name="oneProduct" property="weight" value="${param['weight']}" />
</c:if>

<jsp:include page="fragments/header.jsp" />

<h1>Prix des produits</h1>

<%-- Displaying product and price --%>
<c:choose>
  <c:when test="${!empty oneProduct.name}">
    <p>
      Notre produit&nbsp;: <c:out value="${oneProduct}" />
      co&ucirc;te <%= oneProduct.getPrice() %>&nbsp; euros.
    </p>
  </c:when>
  <c:otherwise>
    <p>Vous n'avez pas s&eacute;lectionn&eacute; de produit.</p>
  </c:otherwise>
</c:choose>

<form method="post" action="prices">
<ul>
  <li>Produit souhait&eacute;: <input type="text" size="20" name="name" value="${oneProduct.name}" /></li>
  <li>Prix au kilo&nbsp;: <input type="text" name="pricePerKg" value="${oneProduct.pricePerKg}" /></li>
  <li>Poids souhait&eacute;&nbsp;: <input type="text" name="weight" value="${oneProduct.weight}" /></li>
</ul>
<p><input type="submit" value="Calculer" /></p>
</form>

<jsp:include page="fragments/footer.html" />
