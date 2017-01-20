package jdbclogements;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logements.Logement;

public class AddLogementServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve the logement entered
        String adresse=request.getParameter("adresse");
        double surface=null;
        double nbPieces=null;
        try {
            surface=new Double(request.getParameter("surface"));
            nbPieces=new Double(request.getParameter("nbPieces"));
        } catch (Exception e) {
            this.terminate(request,response,"Impossible de voir les caractéristiques du logement ("+e+"), merci de resaisir ce dernier.");
            return;
        }

        // Insert logement into DB
        Logement logement=new Logement(adresse,surface,nbPieces);
        try {
            LogementsDBHandler.getDb().create(product);
        } catch (Exception e) {
            this.terminate(request,response,"Erreur d'insertion dans la base ("+e+").");
            return;
        }

        // Everything went well
        this.terminate(request,response,"Nous avons bien pris en compte le nouveau logement, merci.");

    }

    protected void terminate (HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/toc.jsp?message="+message));
    }

    @Override
    public void destroy () {
        try {
            LogementsDBHandler.close();
        } catch (SQLException e) {
            this.log("Erreur lors de la cloture de la connexion SQL ("+e+").");
       }
    }

}
