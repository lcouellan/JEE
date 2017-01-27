package logementsdb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logements.Appartement;
import logements.Maison;
import logements.Logement;
import logements.ILogementDB;

public class SQLLogementDB implements ILogementDB {

    /** The name for the SQL table where to store logements. */
    protected String table;

    /** A prepared statement for creations. */
    private PreparedStatement createLogementStatement;

    /** A prepared statement for retrieval of one logement. */
    private PreparedStatement retrieveLogementStatement;

    /** A link to the database. */
    protected Connection link;

    /**
     * Builds a new instance.
     * @param link An active connection to an SQL database
     * @param table The name of the table where to store logements
     * @throws SQLException if a database access error occurs
     */
    public SQLLogementDB (Connection link, String table) throws SQLException {
        this.link=link;
        this.table=table;
        String query=null;
        query="INSERT INTO `"+this.table+"` VALUES(?,?,?)";
        this.createLogementStatement=this.link.prepareStatement(query);
        query="SELECT * FROM `"+this.table+"` WHERE adresse=?";
        this.retrieveLogementStatement=this.link.prepareStatement(query);
    }

    public void addLogement (Logement logement) throws SQLException {
        this.create(logement);
    }

    public List<Logement> getAll () throws SQLException {
        return this.retrieveAll();
    }

    /**
     * Resets the link to the database.
     * This method can be used in case the connection breaks down.
     * @param link An active link to the database
     */
    public void setLink (Connection link) {
        this.link=link;
    }

    /**
     * Creates the necessary table in the database. Nothing occurs if the table already exists.
     * @throws SQLException if a database access error occurs
     */
    public void createTables () throws SQLException {
        String query="CREATE TABLE IF NOT EXISTS `"+this.table+"` (";
        query+="`surface` DOUBLE NOT NULL, ";
        query+="`nbPieces` INT NOT NULL, ";
        query+="`adresse` VARCHAR(255) NOT NULL, ";
	query+="`surfaceExterieur` DOUBLE NOT NULL, ";
        query+="PRIMARY KEY (`adresse`) ";
        query+=")";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }

    /**
     * Stores a new logement in the database.
     * @param logement The logement 
     * @throws SQLException if a database access error occurs
     */
    public void create (Logement logement) throws SQLException {
	this.createTables();
        this.createLogementStatement.setDouble(1,logement.getSurface());
        this.createLogementStatement.setInt(2,logement.getNbPieces());
        this.createLogementStatement.setString(3,logement.getAdresse());
        this.createLogementStatement.execute();
    }

    /**
     * Retrieves all the logements in the database.
     * @return A list of all logements in the database
     * @throws SQLException if a database access error occurs
     */
    public List<Logement> retrieveAll () throws SQLException {
        String query="SELECT * FROM `"+this.table+"`";
        ResultSet rs=null;
        Statement statement=this.link.createStatement();
        rs=statement.executeQuery(query);
        List<Logement> res=new ArrayList<Logement>();
        while (rs.next()) {
        	if (rs.getDouble("surfaceExterieur") != 0) {
        		res.add(new Maison(rs.getDouble("surface"),rs.getInt("nbPieces"),rs.getString("adresse"),rs.getDouble("surfaceExterieur")));
        	}
        	else {
        		res.add(new Appartement(rs.getDouble("surface"),rs.getInt("nbPieces"),rs.getString("adresse")));
        	}
        }
        return res;
    }

    /**
     * Retrieves a logement in the database.
     * @param name The name of the logement
     * @return A logement, or null if none with the given name exists in the database
     * @throws SQLException if a database access error occurs
     */
    public Logement retrieve (String adresse) throws SQLException {
        this.retrieveLogementStatement.setString(1,adresse);
        ResultSet rs=this.retrieveLogementStatement.executeQuery();
        if (!rs.next()) {
            return null;
        }
//        if (rs.getDouble("surfaceExterieur") != 0) {
//   		 return new Maison(rs.getDouble("surface"),rs.getInt("nbPieces"),rs.getString("adresse"),rs.getDouble("surfaceExterieur"));
//        }
//        else {
        	return new Appartement(rs.getDouble("surface"),rs.getInt("nbPieces"),rs.getString("adresse"));
        //}
    }

    /**
     * Drops the table from the database. Nothing occurs if the table does not exist.
     * @throws SQLException if a database access error occurs
     */
    public void deleteTables () throws SQLException {
        String query="DROP TABLE IF EXISTS `"+this.table+"`";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }

    /**
     * Deletes a logement. Nothing occurs in case the logement does not exist in the database.
     * @param logement The logement
     * @throws SQLException if a database access error occurs
     */
    public void delete (Logement logement) throws SQLException {  
        String query="DELETE FROM `"+this.table+"` WHERE adresse=\""+logement.getAdresse()+"\"";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }

	@Override
	public void delete(String arg0) throws Exception {
		// TODO Auto-generated method stub	
	}

	@Override
	public boolean exists(String arg0) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid(int arg0, int arg1, String arg2) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<String> retrieveAllAdresses() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String arg0, Logement arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
