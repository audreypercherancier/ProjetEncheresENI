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
 * Servlet implementation class RechercherPar
 */
@WebServlet("/Contient")
public class Contient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contient() {
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
		
		List<ArticleVendu> listeArticleVendu=null;
		String nomArticle;
		nomArticle = request.getParameter("nomArticle");
	
		if(nomArticle !=null ) {
			listeArticleVendu = verifierArticlesContient(nomArticle);
			
		}else {
			listeArticleVendu=verifierArticles();
		}
		
		request.setAttribute("listeArticleVendu", listeArticleVendu);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
		
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
		System.out.println(listeArticleVendu + "premier");
		while (success.hasNext()) {
			ArticleVendu article = success.next();
			if(article.getDateFinEncheres().before(now)) {
				success.remove();
			}
		}
		System.out.println(listeArticleVendu + "avant");
		return listeArticleVendu;
		
	}

	private static List<ArticleVendu> verifierArticlesContient(String nomArticle){
		List<ArticleVendu> listeArticleVendu;
		ArticleManager articleMgr = new ArticleManager();
		listeArticleVendu = articleMgr.selectionArticleParNom(nomArticle);
		
		// -----------------boucle de tri ------------------//
		/*
		 * on enleve les articles vendus
		 */
		Date now = new Date(System.currentTimeMillis());
		
		Iterator<ArticleVendu> success = listeArticleVendu.iterator();
		System.out.println(listeArticleVendu + "premier");
		while (success.hasNext()) {
			ArticleVendu article = success.next();
			if(article.getDateFinEncheres().before(now)) {
				success.remove();
			}
		}
		System.out.println(listeArticleVendu + "avant");
		return listeArticleVendu;
		
	}

}
