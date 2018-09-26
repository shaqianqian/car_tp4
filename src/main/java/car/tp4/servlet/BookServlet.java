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
@WebServlet("/books")
public class BookServlet extends HttpServlet {

  @EJB
  private BookBean bookBean;
  
  @EJB
  private PanierBean panierBean;
  
  private Panier panier;

  /**
   * Initialisation de la base avec un livre
   */
  @Override
  public void init() throws ServletException {
	  try {
		bookBean.addBook(new Book("mignon", "lapin", 1997, 100));
		bookBean.addBook(new Book("physique", "profA", 1999, 50));
		bookBean.addBook(new Book("math", "profB", 2000, 1));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
 
  /**
   * Creation d'un panier si il n'existe pas. Affichage des livres de la base.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  
	  this.panier = (Panier) request.getSession().getAttribute("panier");
	  
	  if(this.panier == null){
		  this.panier = new Panier();
		  request.getSession().setAttribute("panier", panier);
	  }
	  
	  List<Book> books = null;
	try {
		books = bookBean.getAllBooks();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  request.setAttribute("books", books);
	  
	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/book.jsp");
	  dispatcher.forward(request, response);
  }


  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
      return "Servlet for getting the list of all books";
  }

}
