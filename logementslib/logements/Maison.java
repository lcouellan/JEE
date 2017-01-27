package logements;

public class Maison extends Logement{
	public double surfaceExterieure;

	public Maison(double surface, int nbPieces, String adresse, double surfaceExterieure) {
		super(surface, nbPieces, adresse);
		this.surfaceExterieure = surfaceExterieure;
	}

	public String toString() {
		return "Maison de " + this.surface + " m² avec " + this.surfaceExterieure +" m² de surface extérieur et de " + nbPieces +" pièces à l'adresse suivante : "+adresse; 
	}

	public double getSurfaceExterieure() {
		return this.surfaceExterieure;
	}
}
