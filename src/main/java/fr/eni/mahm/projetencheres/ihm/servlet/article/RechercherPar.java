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
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class RechercherPar
 */
@WebServlet("/RechercherPar")
public class RechercherPar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

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
		HttpSession session = request.getSession();
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("userConnected");
		categorie = Integer.parseInt(request.getParameter("categories"));
		System.out.println("coucou la compagnie"+utilisateurConnecte);
		if(categorie !=0 ) {
			listeArticleVendu = verifierArticlesCategorie(categorie , request);
		}else {
			listeArticleVendu=verifierArticles(request);
		}
		
		request.setAttribute("listeArticleVendu", listeArticleVendu);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
		
	}
	
	private static List<ArticleVendu> verifierArticles(HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("userConnected");
		List<ArticleVendu> listeArticleVendu;
		ArticleManager articleMgr = new ArticleManager();
		listeArticleVendu = articleMgr.articlesEnVente();
		// -----------------boucle de tri ------------------//
		/*
		 * on enleve les articles vendus
		 */
		Date now = new Date(System.currentTimeMillis());

		Iterator<ArticleVendu> success = listeArticleVendu.iterator();
		if (utilisateurConnecte != null) {
			utilisateurConnecte.getArticlesAchetes().clear();
			utilisateurConnecte.getArticlesVendus().clear();
		}
		while (success.hasNext()) {
			ArticleVendu article = success.next();
			if (article.getDateFinEncheres().before(now)) {
				System.out.println(article.getNoAcquereur() + "mais quel est donc ce numero ?");
				if (article.getNoAcquereur() == 0) {
					System.out.println(article.getNoVendeur());
					article = articleMgr.assignerAcquereur(article);
					System.out.println(article.getNoAcquereur() + "ca me gave la");
				} else if (utilisateurConnecte != null
						&& utilisateurConnecte.getNoUtilisateur() == article.getNoAcquereur()) {
					utilisateurConnecte.ajoutArticleAchete(article);
					System.out.println(article.getNoAcquereur() + " bis");
				} else if (utilisateurConnecte != null
						&& utilisateurConnecte.getNoUtilisateur() == article.getNoVendeur()) {
					utilisateurConnecte.ajoutArticlesVendus(article);
					System.out.println(article.getNoAcquereur() + " bisous");
				}

				success.remove();
			}
		}

		session.setAttribute("userConnected", utilisateurConnecte);
		return listeArticleVendu;

	}

	private static List<ArticleVendu> verifierArticlesCategorie(int noCategorie, HttpServletRequest request) {
		System.out.println("----------------------------------------------------------------");
		HttpSession session = request.getSession();
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("userConnected");
System.out.println("userconnected nom"+utilisateurConnecte.getNom());
		List<ArticleVendu> listeArticleVendu;
		ArticleManager articleMgr = new ArticleManager();
		listeArticleVendu = articleMgr.articlesEnVente();
		// -----------------boucle de tri ------------------//
		/*
		 * on enleve les articles vendus
		 */
		Date now = new Date(System.currentTimeMillis());

		Iterator<ArticleVendu> success = listeArticleVendu.iterator();
		if (utilisateurConnecte != null) {
			utilisateurConnecte.getArticlesAchetes().clear();
			utilisateurConnecte.getArticlesVendus().clear();
		}
		while (success.hasNext()) {
			ArticleVendu article = success.next();
			System.out.println(article.getCategorie().getNoCategorie() + "test article succes");
			if (article.getDateFinEncheres().before(now)) {
				if (article.getNoAcquereur() == 0) {
				article = articleMgr.assignerAcquereur(article);
				System.out.println("on a chnagé de mathieu entre temps"+article.getNoAcquereur());
				} else if (utilisateurConnecte != null
						&& utilisateurConnecte.getNoUtilisateur() == article.getNoAcquereur()) {
					System.out.println("coucou");
					utilisateurConnecte.ajoutArticleAchete(article);
				} else if (utilisateurConnecte != null
						&& utilisateurConnecte.getNoUtilisateur() == article.getNoVendeur()) {
					System.out.println("coucou2");
					utilisateurConnecte.ajoutArticlesVendus(article);
				}
				
					System.out.println(article.getNoArticle() + "removed");
					success.remove();
				
			}
			System.out.println(noCategorie + "value entrante");
			if(article.getCategorie().getNoCategorie() != noCategorie && listeArticleVendu.contains(article)) {
				System.out.println(article.getNoArticle() + "removed");
				success.remove();
			}
		}

		session.setAttribute("userConnected", utilisateurConnecte);
		System.out.println("user de fin"+utilisateurConnecte);
		return listeArticleVendu;
		

	}

}
