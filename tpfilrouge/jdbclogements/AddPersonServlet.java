package jdbclogements;

import persons.Person;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve the person entered
        String email=request.getParameter("email");
        String name=request.getParameter("name");
        String firstName=request.getParameter("firstName");

        Person person = new Person(name,firstName,email);

        try {
            PersonsDBHandler.getDb().create(person);
        } catch (Exception e) {
            this.terminate(request,response,"Erreur d'insertion dans la base ("+e+").");
            return;
        }

        // Everything went well
        this.terminate(request,response,"Nous avons bien pris en compte la nouvelle personne, merci.");

    }

    protected void terminate (HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/toc.jsp?message="+message));
    }

    @Override
    public void destroy () {
        try {
            PersonsDBHandler.close();
        } catch (SQLException e) {
            this.log("Erreur lors de la cloture de la connexion SQL ("+e+").");
       }
    }

}
