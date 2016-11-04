<%@page import="products.Product" %>
<%@page import="products.ProductDBStub" %>

<%
  ProductDBStub db=new ProductDBStub ();
  Product funny=db.getFunnyProduct();
%>

<jsp:include page="fragments/header.jsp" />

<h1>Notre produit rigolo</h1>

<table>
  <tr><th>Nom</th><th>Prix au kilo</th><th>Poids</th><th>Prix</th></tr>
  <tr>
    <td><% out.println(funny.getName()); %></td>
    <td><%= funny.getPricePerKg() %> euros/kg</td>
    <td><%= funny.getWeight() %> kg</td>
    <td><%= funny.getPrice() %> euros</td>
  </tr>
</table>

<jsp:include page="fragments/footer.html" />
