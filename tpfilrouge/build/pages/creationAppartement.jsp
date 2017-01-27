<%--<%@page import="products.Product" %>
<%@page import="products.ProductDBStub" %>

<%
  ProductDBStub db=new ProductDBStub ();
  Product funny=db.getFunnyProduct();
%>--%>

<jsp:include page="../fragments/header.html" />

<h1>Creation d'un appartement</h1>
<form class=".form-horizontal" method="post" action="ajouter">
   	<div class="form-group">
   		<label class=".control-label col-sm-2">Adresse : </label>
      <div class"col-sm-10">
     		<input type="text" name="adresse" />
      </div>
   	</div>
   	<div class="form-group">
   		<label class=".control-label col-sm-2">nombre de pièces : </label>
      <div class"col-sm-10">
     		<input type="text" name="nbPieces" />
      </div>
   	</div>
   	<div class="form-group">
   		<label class=".control-label col-sm-2">Surface : </label>
      <div class"col-sm-10">
     		<input type="text" name="surface" placeholder="en m²"/>
      </div>
   	</div>
	<input class="btn btn-success btn-lg btn-block"type="submit" value="Valider" />
</form>

<jsp:include page="../fragments/footer.html" />
