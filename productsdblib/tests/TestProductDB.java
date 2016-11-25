package tests;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import products.Product;
import productsdb.SQLProductDB;

public class TestProductDB {

    // Arguments: DBMS host, database, username, and password, resp., in args[0], ..., args[3]
    public static void main (String [] args) {
        if (args.length!=4) {
            System.err.println("You must specify DB host, database, username, and password as arguments");
            System.exit(1);
        }
        System.out.print("Testing class SQLProductsDB... ");
        System.out.flush();
        SQLProductDB db=null;
        Connection link=null;
        try {
            link=TestProductDB.createLink(args[0],args[1],args[2],args[3]);
            db=new SQLProductDB(link,"tableProduitsTest");
            TestProductDB.test(db);
        } catch (SQLException e) {
            System.out.println("Exception: "+e);
        } catch (AssertionError e) {
            System.out.println("AssertionError e: "+e);
        } finally {
            try {
                db.deleteTables();
            } catch (SQLException e) {
                System.out.println("Exception: "+e);
            }
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

    protected static void test (SQLProductDB db) throws SQLException, AssertionError {
        db.createTables();
        db.create(new Product("Petits pois",2.0f,0.5f));
        db.create(new Product("Haricots",1.5f,0.4f));
        List<Product> res=db.retrieveAll();
        assert res.size()==2;
        boolean petitsPois=false;
        float petitsPoisPerKg=0;
        float petitsPoisWeight=0;
        for (Product p: res) {
            if ("Petits pois".equals(p.getName())) {
                petitsPois=true;
                petitsPoisPerKg=p.getPricePerKg();
                petitsPoisWeight=p.getWeight();
                break;
            }
        }
        assert petitsPois;
        assert petitsPoisPerKg==2.0f;
        assert petitsPoisWeight==0.5f;
        Product p=db.retrieve("Petits pois");
        assert "Petits pois".equals(p.getName());
        assert p.getPricePerKg()==2.0f;
        assert p.getWeight()==0.5f;
        db.delete(p);
        assert db.retrieveAll().size()==1;
        assert db.retrieve("Petits pois")==null;
    }

}
