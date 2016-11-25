package jdbcproducts;

import productsdb.SQLProductDB;
import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A class for accessing the database for products. This class can be used as a bean with (read-only) property "db".
 * Strings host, database, username, password, and table are expected to be found.
 * At any moment there is only one instance of the link to the database, and one instance of the SQLProductsDB class, maintained by this class.
 * Connector/J is used for accessing the DBMS.
 * @author Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France.
 * @since February, 2012
 */
public class ProductsDBHandler {

    /** The unique link to the database (null if none active). */
    private static Connection link;

    /** The unique instance of class SQLProductsDB (null if none). */
    private static SQLProductDB db;

    /**
     * Returns the instance of SQLProductDB.
     * @throws NamingException if strings host, database, username, password, or table cannot be found
     * @throws SQLException if any problem occurs for accessing the database
     */
    public static SQLProductDB getDb () throws NamingException, SQLException {
        if (ProductsDBHandler.db==null) {
            ProductsDBHandler.initialize();
        }
        return ProductsDBHandler.db;
    }

    /**
     * Releases the connection to the database.
     * @throws SQLException if any problem occurs while closing the connection
     */
    public static void close () throws SQLException {
        if (ProductsDBHandler.link!=null) {
            ProductsDBHandler.link.close();
        }
    }

    // Helper methods =====================================================================

    /**
     * Initializes the connection to the database and the instance of SQLProductsDB.
     * For each of these objects, nothing occurs if it is already initialized.
     * @throws NamingException if strings host, database, username, password, or table cannot be found
     * @throws SQLException if any problem occurs for accessing the database
     */
    private static void initialize () throws NamingException, SQLException {
        InitialContext initialContext = new InitialContext();
        String host=initialContext.doLookup("java:comp/env/host");
        String database=initialContext.doLookup("java:comp/env/database");
        String username=initialContext.doLookup("java:comp/env/username");
        String password=initialContext.doLookup("java:comp/env/password");
        String table=initialContext.doLookup("java:comp/env/table");
        ProductsDBHandler.db=new SQLProductDB(ProductsDBHandler.getLink(host,database,username,password),table);
    }

    /**
     * Returns the link to the database, which is active.
     * @param host The hostname for the DBMS
     * @paam database The name for the database to use in the DBMS
     * @param username The username for connecting to the database
     * @param password The password for connecting to the database
     * @return An active link to the database
     * @throws SQLException if no active link can be established
     */
    private static Connection getLink (String host, String database, String username, String password) throws SQLException {
        if (ProductsDBHandler.link==null) {
            MysqlDataSource ds=new MysqlDataSource();
            ds.setServerName(host);
            ds.setDatabaseName(database);
            ProductsDBHandler.link=ds.getConnection(username,password);
        }
        if (!ProductsDBHandler.link.isValid(0)) {
            throw new SQLException("Failed to initialize a valid connection to database.");
        }
        return ProductsDBHandler.link;
    }

}
