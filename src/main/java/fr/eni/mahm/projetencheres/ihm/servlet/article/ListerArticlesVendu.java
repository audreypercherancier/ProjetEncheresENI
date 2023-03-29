package fr.eni.mahm.projetencheres.ihm.servlet.article;

import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;

/**
 * Servlet implementation class ListerArticlesVendu
 */
@WebServlet("/accueil")
public class ListerArticlesVendu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		List<ArticleVendu> listeArticleVendu;
		listeArticleVendu = verifierArticles();

		
		// System.out.println("liste ici "+listeArticleVendu);
		request.setAttribute("listeArticleVendu", listeArticleVendu);
		request.getRequestDispatcher("index.jsp").forward(request, response);

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	

	private static List<ArticleVendu> verifierArticles(){
		List<ArticleVendu> listeArticleVendu;
		ArticleManager articleMgr = new ArticleManager();
		listeArticleVendu = articleMgr.articlesEnVente();

		// -----------------boucle de tri ------------------//
		/*
		 * on enleve les articles vendus
		 */
		Date now = new Date(System.currentTimeMillis());
	
		Iterator<ArticleVendu> success = listeArticleVendu.iterator();
		while (success.hasNext()) {
			ArticleVendu article = success.next();
			if(article.getDateFinEncheres().before(now)) {
				if(article.getNoAcquereur() == 0) {
					System.out.println("tutut!");
					articleMgr.assignerAcquereur(article);
				}
				success.remove();
			}
		}
		return listeArticleVendu;
		
	}

}
