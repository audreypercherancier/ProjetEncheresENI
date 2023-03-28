package fr.eni.mahm.projetencheres.ihm.servlet.enchere;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;

/**
 * Servlet implementation class FaireEnchere
 */
@WebServlet({"/detailArticle" , "/enchereEffectuee"})
public class FaireEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ArticleVendu article;
		ArticleManager articleMgr = new ArticleManager();

		article = articleMgr.articleSelectionne(Integer.parseInt(request.getParameter("noArticle")));
		

		session.setAttribute("article", article);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/enchere.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArticleVendu article = (ArticleVendu) session.getAttribute("article");
		
		//TODO		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/enchere.jsp");
		rd.forward(request, response);
		
	}

}
