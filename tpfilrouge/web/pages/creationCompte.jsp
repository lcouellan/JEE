<%--<%@page import="products.Product" %>
<%@page import="products.ProductDBStub" %>

<%
  ProductDBStub db=new ProductDBStub ();
  Product funny=db.getFunnyProduct();
%>--%>

<jsp:include page="../fragments/header.jsp" />

<h1>Creation de compte</h1>

<form method="post" action="success">
   	<p><label>Votre prenom : </label><input type="text" name="prenom" /></p>
   	<p><label>Votre nom : </label><input type="text" name="nom" /></p>
   	<p><label>Votre email : </label><input type="text" name="email" /></p>
	<p><input type="submit" value="Valider" /></p>
</form>

<jsp:include page="../fragments/footer.html" />
