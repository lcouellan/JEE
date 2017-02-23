<%--<%@page import="products.Product" %>
<%@page import="products.ProductDBStub" %>

<%
  ProductDBStub db=new ProductDBStub ();
  Product funny=db.getFunnyProduct();
%>--%>

<jsp:include page="../fragments/header.html" />

<h1>Creation de compte</h1>

<form class="form-signin" method="post" action="ajouter">
   	<div class="form-group">
   		<label class=".control-label">Votre prenom : </label>
   		<div>
	   		<input type="text" name="firstName" />
	   	</div>
   	</div>
   	<div class="form-group">
   		<label class=".control-label">Votre nom : </label>
   		<div>
	   		<input type="text" name="name" />
	   	</div>
   	</div>
   	<div class="form-group">
   		<label class=".control-label">Votre email : </label>
   		<div>
	   		<input type="text" name="email" />
	   	</div>
   	</div>
	<input class="btn btn-success btn-lg btn-block" type="submit" value="Valider" />
</form>

<jsp:include page="../fragments/footer.html" />
