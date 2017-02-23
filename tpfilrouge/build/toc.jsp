<jsp:include page="fragments/header.jsp" />

<div class="contenu">
	<c:if test="${!empty param['message']}">
	  <p class="message">${param["message"]}</p>
	</c:if>

	<!-- Carousel -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="images/slide1.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Faites des économies</h1>
              <p>Logez-vous gratuitement en vacances ou en week-end. Voyagez et profitez toujours plus.</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="images/slide2.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Légal pour les locataires</h1>
              <p>Échangez votre maison en toute légalité même en étant locataire. Plus aucun problème avec votre propriétaire.</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="images/slide3.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Voyagez autrement</h1>
              <p>Vivez une expérience authentique. Découvrez la culture locale et le mode de vie de vos hôtes.</p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>

	<div id="application">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <h3>Adoptez l’échange de maison</h3>
                    <h4>3 bonnes raisons d’échanger sa maison</h4>
                    <div id="home-why-details" class="row details">
                    <div class="col-md-4">
                        <img id="coin" src="images/coin.png" alt="Faîtes des économies" />
                        <h3>Faîtes des économies</h3>
                        <p>Logez-vous gratuitement en vacances ou en week-end. Voyagez et profitez toujours plus.</p>
                    </div>
                    <div class="col-md-4">
                       <img id="check" src="images/check.png" alt="Legal pour les locataires" />
                        <h3>Légal pour les locataires</h3>
                        <p>Échangez votre maison en toute légalité même en étant locataire. Plus aucun problème avec votre propriétaire.</p>
                    </div>
                    <div class="col-md-4">
                        <img id="world" src="images/world.png" alt="Voyagez autrement" />
                        <h3>Voyagez autrement</h3>
                        <p>Vivez une expérience authentique. Découvrez la culture locale et le mode de vie de vos hôtes.</p>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="fragments/footer.html" />
