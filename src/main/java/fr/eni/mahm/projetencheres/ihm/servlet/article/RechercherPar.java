package fr.eni.mahm.projetencheres.ihm.servlet.article;

import java.io.IOException
;
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
@WebServlet("/RechercherPar")
public class RechercherPar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercherPar() {
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
		int categorie;
		categorie = Integer.parseInt(request.getParameter("categories"));
		if(categorie !=0 ) {
			listeArticleVendu = verifierArticlesCategorie(categorie);
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

	private static List<ArticleVendu> verifierArticlesCategorie(int noCategorie){
		List<ArticleVendu> listeArticleVendu;
		ArticleManager articleMgr = new ArticleManager();
		listeArticleVendu = articleMgr.selectionParcategorie(noCategorie);
		
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
