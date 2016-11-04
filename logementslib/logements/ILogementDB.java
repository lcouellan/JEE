package services;

import java.util.Collection;

public interface ILogementDB {

    public void create (Logement l) throws Exception;

    public Collection<Logement> retrieveAll () throws Exception;

    public Collection<String> retrieveAllAdresses () throws Exception;

    public Service retrieve (String adresse) throws Exception;

    public boolean isValid (int surface, int nbPieces, String adresse) throws Exception;

    public boolean exists (String adresse) throws Exception;

    public void update (String adresse, Logement logement) throws Exception;

    public void delete (String adresse) throws Exception;

}