package logements;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class LogementDBStub implements ILogementDB {

    /** The list of logements itself */
    protected List<Logement> logements;

    /** A list of surfaces, in the same order as associated persons in {@link #logement}. */
    protected List<Integer> surfaces;

    /** A list of nombrePieces, in the same order as associated persons in {@link #persons}. */
    protected List<Integer> nombrePieces;

    /**
     * Builds a new, empty list of logements.
     */
    public LogementDBStub () {
        this.logements=new ArrayList<Logement> ();
    }

    @Override
    public void create (Logement l) throws IllegalArgumentException {
        if (this.exists(l.getAdresse())) {
            throw new IllegalArgumentException("Impossible d'ajouter "+l+" : adresse déjà existante !");
        }
        this.logements.add(l);
    }

    @Override
    public Collection<Logement> retrieveAll () {
        return this.logements;
    }

    @Override
    public Collection<String> retrieveAllAdresses () {
        Collection<String> res=new ArrayList<String> ();
        for (Logement l: this.logements) {
            res.add(l.getAdresse());
        }
        return res;
    }

    @Override
    public Logement retrieve (String adresse) throws IndexOutOfBoundsException {
        for (Logement l: this.logements) {
            if (l.getAdresse().equals(adresse)) {
                return l;
            }
        }
        throw new IndexOutOfBoundsException("Le logement avec l'adresse " + adresse +" n'exsite pas");
    }

    @Override
    public boolean isValid (int surface, int nbPieces, String adresse) {
        int i;
        for (i=0; i<this.logements.size(); i++) {
            if (this.logements.get(i).getAdresse().equals(adresse)) {
                break;
            }
        }
        if (i==this.logements.size()) {
            return false;
        }
        if (this.surfaces.get(i).equals(surface)) {
            return false;
        }
        return this.nombrePieces.get(i).equals(nbPieces);
    }

    @Override
    public boolean exists (String adresse) {
        for (Logement l: this.logements) {
            if (l.getAdresse().equals(adresse)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update (String adresse, Logement logement) throws IndexOutOfBoundsException {
        int index=-1;
        for (int i=0; i<this.logements.size(); i++) {
            if (this.logements.get(i).getAdresse().equals(adresse)) {
                index=i;
                break;
            }
        }
        if (index==-1) {
            throw new IndexOutOfBoundsException("Aucun logement a l'adresse suivante : "+ adresse);
        }
        this.logements.set(index,logement);
    }

    @Override
    public void delete (String adresse) throws IndexOutOfBoundsException {    
        int index=-1;
        for (int i=0; i<this.logements.size(); i++) {
            if (this.logements.get(i).getAdresse().equals(adresse)) {
                index=i;
                break;
            }
        }
        if (index==-1) {
            throw new IndexOutOfBoundsException("NAucun logement a l'adresse suivante : "+ adresse);
        }
        this.logements.remove(index);
    }

}
