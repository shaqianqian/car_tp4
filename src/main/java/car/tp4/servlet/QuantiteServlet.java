package car.tp4.servlet;

import car.tp4.entity.Book;
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
 * Change les quantites des livres disponibles
 * @author shaqianqian
 *
 */
@WebServlet("/quantite")
public class QuantiteServlet extends HttpServlet {

    @EJB
    private BookBean bookBean;



    /**
     * Entre le id de livre et une nouvelle quantite ,et change la quantite de livre par nouvelle quantite
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int quantite=0;
      	long id=Long.parseLong(request.getParameter("id"));
    	Book b=bookBean.getBookById(id).get(0);
    	try{quantite= Integer.parseInt(request.getParameter("quantite")); 	}
    	catch(NumberFormatException e) {quantite=b.getQuantite();
    	request.setAttribute("erreur","NumberFormatException");}
    	request.setAttribute("ancien_quantite", b.getQuantite()+"");
        bookBean.setQuantiteByID(id, quantite);
    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/quantite.jsp");
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
