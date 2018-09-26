package car.tp4.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.tp4.entity.Book;
import car.tp4.entity.BookBean;

/**
 * Servlet pour le tri des livres selon l'année de parution
 * @author shaqianqian
 *
 */
@WebServlet("/booksSort")
public class SortServlet extends HttpServlet {

	@EJB
	private BookBean bookBean;

	/**
	 * affiche la liste des livres de la base de donnée trié par ordre numérique
	 * croissant
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> booksSorted = null;
		try {
			booksSorted = new ArrayList<Book>(bookBean.getAllBooks());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(request.getParameter("type").equals("-->")) {
			Collections.sort(booksSorted);
		}
		else {
			Collections.sort(booksSorted);
			Collections.reverse(booksSorted);}
		request.setAttribute("books", booksSorted);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/booksort.jsp");
		dispatcher.forward(request, response);
	}

}
