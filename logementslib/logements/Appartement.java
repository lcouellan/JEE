package logements;

public class Appartement extends Logement {

	public Appartement(double surface, int nbPieces, String adresse) {
		super(surface, nbPieces, adresse);
	}
	
	public String toString() {
		return "Appartement de " + this.surface + " m² et de " + nbPieces +" pièces à l'adresse suivante : "+adresse; 
	}
}
