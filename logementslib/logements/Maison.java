package logements;

public class Maison extends Logement{
	public double surfaceExterieur;
	
	public Maison(double surface, int nbPieces, String adresse, double surfaceExterieur) {
		super(surface, nbPieces, adresse);
		this.surfaceExterieur = surfaceExterieur;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Maison de " + this.surface + " m² avec " + this.surfaceExterieur +" m² de surface extérieur et de " + nbPieces +" pièces à l'adresse suivante : "+adresse; 
	}
}
