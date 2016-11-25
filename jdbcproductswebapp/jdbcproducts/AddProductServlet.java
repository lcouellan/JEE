package jdbcproducts;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products.Product;

/**
 * A Servlet which adds a product to the database and displays a confirmation or error message on
 * the "table of contents" page.
 * @author Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France.
 * @since January, 2014
 */
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve the product entered
        String name=request.getParameter("productName");
        Float pricePerKg=null;
        Float weight=null;
        try {
            pricePerKg=new Float(request.getParameter("productPricePerKg"));
            weight=new Float(request.getParameter("productWeight"));
        } catch (Exception e) {
            this.terminate(request,response,"Impossible de lire prix et/ou poids ("+e+"), merci de resaisir le produit.");
            return;
        }

        // Insert product into DB
        Product product=new Product(name,pricePerKg,weight);
        try {
            ProductsDBHandler.getDb().create(product);
        } catch (Exception e) {
            this.terminate(request,response,"Erreur d'insertion dans la base ("+e+").");
            return;
        }

        // Everything went well
        this.terminate(request,response,"Nous avons bien pris en compte le nouveau produit, merci.");

    }

    /**
     * Terminates the response of this servlet by displaying table of contents and a message.
     * @param request The request for this call
     * @param response The response for this call
     * @param message The message to be forwarded to table of contents
     */
    protected void terminate (HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/toc.jsp?message="+message));
    }

    @Override
    public void destroy () {
        try {
            ProductsDBHandler.close();
        } catch (SQLException e) {
            this.log("Erreur lors de la cl&ocirc;ture de la connexion SQL ("+e+").");
       }
    }

}
