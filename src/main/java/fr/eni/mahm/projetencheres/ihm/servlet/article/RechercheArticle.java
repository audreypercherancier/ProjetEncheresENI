package fr.eni.mahm.projetencheres.ihm.servlet.article;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bll.EnchereManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Enchere;
import fr.eni.mahm.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class RechercheArticle
 */
@WebServlet("/RechercheArticle")
public class RechercheArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static List<ArticleVendu> listeArticleVendu = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listeArticleVendu.clear();
		HttpSession session = request.getSession();
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("userConnected");
		if (utilisateurConnecte != null) {
			EnchereManager enchereMgr = new EnchereManager();
			Date dateDujour;
			String achatsEncheresOuvertes, achatsDejaEncherie, achatsEncheresGagnantes, ventesEnCours,
					ventesNonCommences, ventesTerminees;
			achatsEncheresOuvertes = request.getParameter("achatsEncheresOuvertes");
			achatsDejaEncherie = request.getParameter("achatsDejaEncherie");
			achatsEncheresGagnantes = request.getParameter("achatsEncheresGagnantes");
			ventesEnCours = request.getParameter("ventesEnCours");
			ventesNonCommences = request.getParameter("ventesNonCommences");
			ventesTerminees = request.getParameter("ventesTerminees");
			dateDujour = new Date(System.currentTimeMillis());

			// ---------------------------recherche pour
			// achat-------------------------------//
			if (achatsEncheresOuvertes != null) {
				listeArticleVendu.addAll(verifierArticles(request));

				Iterator<ArticleVendu> ouvertureOk = listeArticleVendu.iterator();
				while (ouvertureOk.hasNext()) {
					ArticleVendu articleAVerifie = ouvertureOk.next();
					if (articleAVerifie.getDateDebutEncheres().after(dateDujour)
							|| articleAVerifie.getNoVendeur() == utilisateurConnecte.getNoUtilisateur()) {
						ouvertureOk.remove();
					}
				}
			}
			if (achatsDejaEncherie != null) {
				List<Enchere> verifEnchere = enchereMgr.recupererMesEncheres(utilisateurConnecte.getNoUtilisateur());
				if (listeArticleVendu.isEmpty()) {
					listeArticleVendu.addAll(verifierArticles(request));
				}

				Iterator<ArticleVendu> articleEncherieOk = listeArticleVendu.iterator();
				while (articleEncherieOk.hasNext()) {
					Boolean nonContenue = true;
					ArticleVendu articleAVerif = articleEncherieOk.next();
					for (Enchere enchere : verifEnchere) {
						if (enchere.getArticle().getNoArticle() == articleAVerif.getNoArticle()) {
							nonContenue = false;
						}
					}
					if (nonContenue) {
						articleEncherieOk.remove();
					}

				}

			}
			if (achatsEncheresGagnantes != null) {
				for (ArticleVendu articleGagne : utilisateurConnecte.getArticlesAchetes()) {
					listeArticleVendu.add(articleGagne);
				}
			}

			// -----------------------------recherche vente
			// -----------------------------------//
			if (ventesEnCours != null) {
				listeArticleVendu.addAll(verifierArticles(request));

				Iterator<ArticleVendu> idVendeurOk = listeArticleVendu.iterator();
				while (idVendeurOk.hasNext()) {
					ArticleVendu articleAVerifie = idVendeurOk.next();
					if (ventesNonCommences == null) {
						if (articleAVerifie.getNoVendeur() != utilisateurConnecte.getNoUtilisateur()
								|| articleAVerifie.getDateDebutEncheres().after(dateDujour)) {
							idVendeurOk.remove();
						}
					} else {
						if (articleAVerifie.getNoVendeur() != utilisateurConnecte.getNoUtilisateur()) {
							idVendeurOk.remove();
						}
					}
				}
			}
			if (ventesNonCommences != null) {
				if (ventesEnCours == null) {
					listeArticleVendu.addAll(verifierArticles(request));

					Iterator<ArticleVendu> idVendeurOk = listeArticleVendu.iterator();
					while (idVendeurOk.hasNext()) {
						ArticleVendu articleAVerifie = idVendeurOk.next();
						if (articleAVerifie.getNoVendeur() != utilisateurConnecte.getNoUtilisateur()
								|| articleAVerifie.getDateDebutEncheres().before(dateDujour)) {
							idVendeurOk.remove();
						}
					}
				}
			}
			if (ventesTerminees != null) {
				for (ArticleVendu articleVendu : utilisateurConnecte.getArticlesVendus()) {
					listeArticleVendu.add(articleVendu);
				}
			}

		}

		// --------------------------fonctionne meme en deco------------------------//

		String nomArticle = request.getParameter("nomArticle");
		int categorie = 0;
		if (nomArticle != null) {
			listeArticleVendu = verifierArticlesContient(nomArticle, request);
		}
		
		if (request.getParameter("categories") != null) {
			categorie = Integer.parseInt(request.getParameter("categories"));
		}
		if (categorie != 0) {
			listeArticleVendu = verifierArticlesCategorie(categorie, request);
		} else if (listeArticleVendu.isEmpty()) {
			listeArticleVendu = verifierArticles(request);
		}

		request.setAttribute("listeArticleVendu", listeArticleVendu);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	private static List<ArticleVendu> verifierArticles(HttpServletRequest request) {

		HttpSession session = request.getSession();
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("userConnected");
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

	// ------------------------CATEGORIE---------------------------------------------//

	private static List<ArticleVendu> verifierArticlesCategorie(int noCategorie, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("userConnected");
		ArticleManager articleMgr = new ArticleManager();

		if (listeArticleVendu.isEmpty()) {
			listeArticleVendu = articleMgr.articlesEnVente();
		}
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

	// ------------------------------------------------- PAR NOM ARTICLE
	// CONTENU--------------------------------------------//

	private static List<ArticleVendu> verifierArticlesContient(String nomArticle, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("userConnected");
		ArticleManager articleMgr = new ArticleManager();

		if (listeArticleVendu.isEmpty()) {
			listeArticleVendu = articleMgr.articlesEnVente();
		}
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
