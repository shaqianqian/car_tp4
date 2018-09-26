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

import car.tp4.entity.Panier;
import car.tp4.entity.PanierBean;

/**
 * Servlet implementation class AllPanierServlet
 */
@WebServlet("/AllPanierServlet")
public class AllPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PanierBean panierBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Panier> paniers = panierBean.getAllPanier();			
		request.setAttribute("panier", paniers);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/AllPanier.jsp");
		dispatcher.forward(request, response);
	}
	}


