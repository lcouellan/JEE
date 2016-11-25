<jsp:include page="fragments/header.html" />

<h1>Ajouter un produit</h1>

<form method="post" action="add">

<ul>
  <li>Nom&nbsp;: <input type="text" name="productName" /></li>
  <li>Prix au kg&nbsp;: <input type="text" name="productPricePerKg" /></li>
  <li>Poids disponible&nbsp;: <input type="text" name="productWeight" /></li>
</ul>
<input type="submit" value="Ajouter" />

</form>

<jsp:include page="fragments/footer.html" />
