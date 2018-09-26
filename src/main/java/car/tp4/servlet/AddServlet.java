package car.tp4.servlet;

import javax.servlet.annotation.WebServlet;
import java.util.List;
import car.tp4.entity.Book;
import car.tp4.entity.BookBean;
import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet permettant l'ajout d'un livre dans la base de donnee
 * @author shaqianqian
 *
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {

	@EJB
	private BookBean bookBean;

	/**
	 * Affiche un formulaire permettant d'avoir les champs pour ajouter un livre a la base de donnee
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/add.jsp");
		rd.forward(request, response);
	}

	/**
	 *Recupere les informations sur nouveau livre et le conserve dans la bas de donnee, 
	 *si les livres ont la meme titre et auteur, on va mis a jours juste la quantite de ce livre
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/add.jsp");

		String titre = request.getParameter("titre");
		String auteur = request.getParameter("auteur");
		String annee = request.getParameter("year");
		String quantite = request.getParameter("quantite");

		// request.setAttribute("titre", titre );
		// request.setAttribute("auteur", auteur);
		// request.setAttribute("year", annee);
		// request.setAttribute("quantite", quantite);
		if (titre == "" || titre == null || auteur == null || auteur == "" || annee == null || annee == ""
				|| quantite == null || quantite == "") {
			
			
		} else {
			List<Book> books = bookBean.getBook(titre, auteur, Integer.parseInt(annee));
			if (books.isEmpty()) {
				Book b = new Book(titre, auteur, Integer.parseInt(annee), Integer.parseInt(quantite));
				try {
					bookBean.addBook(b);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				bookBean.setQuantite(titre, auteur, Integer.parseInt(annee),
						Integer.parseInt(quantite) + books.get(0).getQuantite());
			}
		}
		rd.forward(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Servlet for add book";
	}

}
