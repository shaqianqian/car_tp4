package car.tp4.servlet;

import car.tp4.entity.BookBean;
import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;


/**
 * Servlet pour la recherche de livre selon la titre ou auteur
 * @author shaqianqian
 *
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @EJB
    private BookBean bookBean;


    /**
     * Affiche la liste des livres répondant aux critères de la recherche
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        if(request.getParameter("init")==null) {
    	try{
    		request.setAttribute("books", bookBean.getBooksWithSearch(request.getParameter("attribut"), request.getParameter("search")));
    		request.setAttribute("search", request.getParameter("search"));
    	}
    	catch(Exception e){
    		try {
				request.setAttribute("books", bookBean.getAllBooks());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
        } else {
        	try {
				request.setAttribute("books", bookBean.getAllBooks());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/book.jsp");
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
