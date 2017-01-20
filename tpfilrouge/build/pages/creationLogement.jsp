<%--<%@page import="products.Product" %>
<%@page import="products.ProductDBStub" %>

<%
  ProductDBStub db=new ProductDBStub ();
  Product funny=db.getFunnyProduct();
%>--%>

<jsp:include page="../fragments/header.jsp" />

<h1>Creation de logement</h1>

<form method="post" action="add">
	<p>
		<label>Type : </label>
		<select name="logement">
			<option value="appartement">Appartement</option>
			<option value="maison">Maison</option>
		</select>
	</p>
   	<p>
   		<label>Adresse : </label>
   		<input type="text" name="adresse" />
   	</p>
   	<p>
   		<label>nombre de pièces : </label>
   		<input type="text" name="nbPieces" />
   	</p>
   	<p>
   		<label>Surface : </label>
   		<input type="text" name="surface" />
   	</p>
	<p><input type="submit" value="Valider" /></p>
</form>

<jsp:include page="../fragments/footer.html" />
