package fr.eni.mahm.projetencheres.ihm.servlet.article;

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
 * Servlet implementation class detailleArticle
 */
@WebServlet("/detailsArticle")
public class detailsArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailsArticle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		ArticleVendu article;
		ArticleManager articleMgr = new ArticleManager();
		
		article =  articleMgr.articleSelectionne(Integer.parseInt(request.getParameter("noArticle")));
		
		session.setAttribute("articleSelectione", article);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailsArticle.jsp");
		rd.forward(request, response);
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArticleVendu noArticle = (ArticleVendu) session.getAttribute("article");
		System.out.println(noArticle.getNoArticle());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailsArticle.jsp");
		rd.forward(request, response);
		
	}

}
