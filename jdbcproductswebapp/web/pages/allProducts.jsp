<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="jdbcproducts.ProductsDBHandler" %>

<jsp:include page="fragments/header.html" />

<h1>Tous nos produits</h1>
<ul>

  <c:set var="withPrice" value="${!empty param['action'] && param['action']=='prices'}" />

  <c:forEach var="product" items="<%= ProductsDBHandler.getDb().retrieveAll() %>">
    <li>
      ${product}
      <c:if test="${withPrice}">[prix&nbsp;: ${product.price}]</c:if>
    </li>
  </c:forEach>
</ul>

<jsp:include page="fragments/footer.html" />
