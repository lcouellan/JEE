<%@page import="products.IProductDB" %>
<%@page import="products.ProductDBStub" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="fragments/header.jsp" />

<h1>Tous nos produits</h1>
<p>
  Ce script est appel&eacute;
  <c:choose>
    <c:when test="${empty param['action']}">sans param&egrave;tre.</c:when>
    <c:otherwise>avec le param&egrave;tre "${param['action']}".</c:otherwise>
  </c:choose>
</p>
<ul>

  <c:set var="db" value="<%= new ProductDBStub() %>" />
  <c:set var="withPrice" value="${!empty param['action'] && param['action']=='prices'}" />

  <c:forEach var="product" items="${db.getAll()}">
    <li>
      ${product}
      <c:if test="${withPrice}">[price: ${product.price}]</c:if>
    </li>
  </c:forEach>
</ul>

<jsp:include page="fragments/footer.html" />
