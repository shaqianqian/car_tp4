package car.tp4.servlet;

import car.tp4.entity.BookBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;


/**
 * Servlet pour la recherche de livre
 * @author shaqianqian
 *
 */
@WebServlet("/delete")
public class deleteServlet extends HttpServlet {

    @EJB
    private BookBean bookBean;



    /**
     * Entre l'id de livre pour le supprimer, si il n'exciste pas ce id, on rendre le message d'echoue
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String  delete_id= request.getParameter("id");
    	List<Long> ids=bookBean.getAllId();
    	if(ids.contains(Long.parseLong(delete_id))) {
    	bookBean.deleteBookOnly(Long.parseLong(delete_id));}
    	else {
    	
    		
    		request.setAttribute("resultat","echou");
    	}
    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/delete.jsp");
    	rd.forward(request,response);
 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "servlet for searching books with a keyword";
    }

}
