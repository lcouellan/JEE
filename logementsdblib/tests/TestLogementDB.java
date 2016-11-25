package tests;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import logements.Appartement;
import logements.Logement;
import logements.Maison;
import logementsdb.SQLLogementDB;

public class TestLogementDB {

    // Arguments: DBMS host, database, username, and password, resp., in args[0], ..., args[3]
    public static void main (String [] args) {
        if (args.length!=4) {
            System.err.println("You must specify DB host, database, username, and password as arguments");
            System.exit(1);
        }
        System.out.print("Testing class SQLLogementDB... ");
        System.out.flush();
        SQLLogementDB db=null;
        Connection link=null;
        try {
            link=TestLogementDB.createLink(args[0],args[1],args[2],args[3]);
            db=new SQLLogementDB(link,"appartements");
            TestLogementDB.test(db);
        } catch (SQLException e) {
            System.out.println("Exception: "+e);
        } catch (AssertionError e) {
            System.out.println("AssertionError e: "+e);
        } finally {
//            try {
//                db.deleteTables();
//            } catch (SQLException e) {
//                System.out.println("Exception: "+e);
//            }
            try {
                link.close();
            } catch (SQLException e) {
                System.out.println("Exception: "+e);
            }
        }
        System.out.println("OK");
    }

    protected static Connection createLink (String host, String database, String username, String password) throws SQLException {
        MysqlDataSource ds=new MysqlDataSource();
        ds.setServerName(host);
        ds.setDatabaseName(database);
        Connection link=ds.getConnection(username,password);
        if (!link.isValid(0)) {
            throw new SQLException("Failed to initialize a valid connection to database.");
        }
        return link;
    }

    protected static void test (SQLLogementDB db) throws SQLException, AssertionError {
        db.createTables();
        // Création en DB de deux logements
        db.create(new Appartement(350,2,"adresse 1 test db"));
        db.create(new Appartement(250,5,"adresse 2 test db"));
        // Liste de tous les logements de la DB
        List<Logement> res=(List<Logement>) db.retrieveAll();
        // Vérification de la taille de la DB, ici 2 car 2 logements
        assert res.size()==2;
        System.out.println(db.retrieve("adresse 1 test db"));
        // On cherche le premier logement
        Logement l = db.retrieve("adresse 1 test db");
        // On vérifie ses arguments
        assert "adresse 1 test db".equals(l.getAdresse());
        assert l.getSurface()==350;
        assert l.getNbPieces()==2;
        // On le supprime
        db.delete(l);
        // On vérifie la suppression avec la liste de logements qui n'est plus égale a 2 mais 1
        assert db.retrieveAll().size()==1;
        // Mais aussi en cherchant si c'est le bon logement qui a été supprimé en recherchant une adresse qui n'existe pas
        assert db.retrieve("adresse 1 test db")==null;
    }

}
