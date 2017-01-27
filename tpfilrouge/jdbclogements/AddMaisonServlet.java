package jdbclogements;

import logements.Logement;
import logements.Maison;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMaisonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve the appartement entered
        String adresse=request.getParameter("adresse");
        double surface=0.0;
        Integer nbPieces=0;
        double surfaceExterieure = 0.0;
        try {
            surface=new Double(request.getParameter("surface"));
            nbPieces=new Integer(request.getParameter("nbPieces"));
            surfaceExterieure = new Double(request.getParameter("surfaceExterieure"));
        } catch (Exception e) {
            this.terminate(request,response,"Impossible de voir les caractéristiques de la maison ("+e+"), merci de resaisir ce dernier.");
            return;
        }

        Maison maison=new Maison(surface,nbPieces,adresse,surfaceExterieure);

        try {
            LogementsDBHandler.getDb().create(maison);
        } catch (Exception e) {
            this.terminate(request,response,"Erreur d'insertion dans la base ("+e+").");
            return;
        }

        // Everything went well
        this.terminate(request,response,"Nous avons bien pris en compte la nouvelle maison, merci.");

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
