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
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class RechercheArticle
 */
@WebServlet("/RechercheArticle")
public class RechercheArticle extends HttpServlet {
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
		//TODO
		
		
		
		
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
				if (article.getNoAcquereur() == 0) {
					article = articleMgr.assignerAcquereur(article);
				}
				if (utilisateurConnecte != null && utilisateurConnecte.getNoUtilisateur() == article.getNoAcquereur()) {
					utilisateurConnecte.ajoutArticleAchete(article);
				}
				if (utilisateurConnecte != null && utilisateurConnecte.getNoUtilisateur() == article.getNoVendeur()) {
					utilisateurConnecte.ajoutArticlesVendus(article);
					int credit = utilisateurConnecte.getCredit();
					utilisateurConnecte.setCredit(credit + article.getPrixVente());
				}

				success.remove();

			}
		}
		session.setAttribute("userConnected", utilisateurConnecte);
		return listeArticleVendu;
	}
	
	//------------------------CATEGORIE---------------------------------------------//
	
	private static List<ArticleVendu> verifierArticlesCategorie(int noCategorie, HttpServletRequest request) {
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
				if (article.getNoAcquereur() == 0) {
					article = articleMgr.assignerAcquereur(article);
				}
				if (utilisateurConnecte != null && utilisateurConnecte.getNoUtilisateur() == article.getNoAcquereur()) {
					utilisateurConnecte.ajoutArticleAchete(article);
				}
				if (utilisateurConnecte != null && utilisateurConnecte.getNoUtilisateur() == article.getNoVendeur()) {
					utilisateurConnecte.ajoutArticlesVendus(article);
					int credit = utilisateurConnecte.getCredit();
					utilisateurConnecte.setCredit(credit + article.getPrixVente());
				}

				success.remove();

			}
			if (article.getCategorie().getNoCategorie() != noCategorie && listeArticleVendu.contains(article)) {
				success.remove();
			}
		}

		session.setAttribute("userConnected", utilisateurConnecte);
		return listeArticleVendu;

	}
	
	//------------------------------------------------- PAR NOM ARTICLE CONTENU--------------------------------------------//
	
	private static List<ArticleVendu> verifierArticlesContient(String nomArticle, HttpServletRequest request) {
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
				if (article.getNoAcquereur() == 0) {
					article = articleMgr.assignerAcquereur(article);
				}
				if (utilisateurConnecte != null && utilisateurConnecte.getNoUtilisateur() == article.getNoAcquereur()) {
					utilisateurConnecte.ajoutArticleAchete(article);
				}
				if (utilisateurConnecte != null && utilisateurConnecte.getNoUtilisateur() == article.getNoVendeur()) {
					utilisateurConnecte.ajoutArticlesVendus(article);
					int credit = utilisateurConnecte.getCredit();
					utilisateurConnecte.setCredit(credit + article.getPrixVente());
				}

				success.remove();

			}
			if (!article.getNomArticle().contains(nomArticle.toLowerCase()) && listeArticleVendu.contains(article)) {
				success.remove();
			}
		}

		session.setAttribute("userConnected", utilisateurConnecte);
		return listeArticleVendu;

	}

}
