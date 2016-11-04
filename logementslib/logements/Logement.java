package logements;

public abstract class Logement {

    protected double surface;

    protected int nbPieces;

    protected String adresse;

    public Logement (double surface, int nbPieces, String adresse) {
        this.surface = surface;
        this.nbPieces = nbPieces;
        this.adresse = adresse;
    }

    public double getSurface() {
        return this.surface;
    }
   
    public int getNbPieces() {
        return this.nbPieces;
    }

    public String getAdresse() {
        return this.adresse;
    }
}
