package car.tp4.servlet;

import car.tp4.entity.Book;
import car.tp4.entity.BookBean;
import car.tp4.entity.Panier;
import car.tp4.entity.PanierBean;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet permettant l'affichage des listes de livre de la base
 * @author shaqianqian
 *
 */
@WebServlet("/command")
public class CommandServlet extends HttpServlet {

  @EJB
  private BookBean bookBean;
  
  @EJB
  private PanierBean panierBean;
  
  private Panier panier;

 

	/**
	 * Valider ou annuler certain command et puis vider les paniers pour le command prochine.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		this.panier = (Panier) request.getSession().getAttribute("panier");
		if (type.equals("valide") && ( ! this.panier.getBooks().isEmpty())) {
			panierBean.valide_panier(panier);
			request.setAttribute("type", "valide");
		} else {
			List<Book> books = panier.getBooks();
			for (Book book : books) {
				Book b = bookBean.getBookById(book.getId()).get(0);
				bookBean.setQuantiteByID(book.getId(), b.getQuantite() + 1);
				request.setAttribute("type", "annule");
			}
		}
		this.panier = new Panier();
		request.getSession().setAttribute("panier", panier);
		List<Book> books = null;
		try {
			books = bookBean.getAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("books", books);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/Command.jsp");
		dispatcher.forward(request, response);
	}



}
