package car.tp4.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.tp4.entity.Book;
import car.tp4.entity.BookBean;
import car.tp4.entity.Panier;
import car.tp4.entity.PanierBean;

/**
 * 
 * Servlet qui affiche le contenu du panier et de le valider ou de l'annuler
 * 
 * @author shaqianqian
 *
 */

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {

	@EJB
	private BookBean bookBean;
	@EJB
	private PanierBean panierBean;

	
	/**
	 * affiche les livres contenu dans le panier
	 */
	@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Panier panier = (Panier) request.getSession().getAttribute("panier");
		request.setAttribute("books_in_paniers", panier.getBooks());

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/panier.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * affiche la liste de toutes les paniers de la base 
	 * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("type").equals("add")) {
 
			Book book = bookBean.getBookById(Long.parseLong(request.getParameter("bookId"))).get(0);
			HttpSession session = request.getSession();
			Panier panier = (Panier) session.getAttribute("panier");
		    if (panier == null) {
                panier = new Panier();
                session.setAttribute("panier", panier);
            }
			panier.addBook(book);
			
			request.setAttribute("books_in_paniers", panier.getBooks());
			bookBean.setQuantiteByID(Long.parseLong(request.getParameter("bookId")), book.getQuantite() - 1);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/panier.jsp");
			dispatcher.forward(request, response);
			
			
		} else if(request.getParameter("type").equals("annule")) {
			
			Book book = bookBean.getBookById(Long.parseLong(request.getParameter("bookId"))).get(0);
			HttpSession session = request.getSession();
			Panier panier = (Panier) session.getAttribute("panier");
			panier.removeBook(book);
			
			request.setAttribute("books_in_paniers", panier.getBooks());
			bookBean.setQuantiteByID(Long.parseLong(request.getParameter("bookId")), book.getQuantite() + 1);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/panier.jsp");
			dispatcher.forward(request, response);
			
			
			
		}
		else {
//			List<Panier> paniers = panierBean.getAllPanier();			
//			request.setAttribute("panier", paniers);
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/AllPanier.jsp");
//			dispatcher.forward(request, response);
		}
	}
}
