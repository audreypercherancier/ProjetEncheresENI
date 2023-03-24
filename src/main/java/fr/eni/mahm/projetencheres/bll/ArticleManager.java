package fr.eni.mahm.projetencheres.bll;

import java.util.List;

import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.dal.article.ArticleDAO;
import fr.eni.mahm.projetencheres.dal.DAOFactory;

public class ArticleManager {

	private static ArticleDAO articleDAO;
	
	//-----------CONSTRUCTEUR ZONE-----------//
	public ArticleManager() {
		articleDAO = DAOFactory.getArticleDAO();
	}
	
	//-----------FUNCTION-----------//
	/**
	 * ajoute un article en BD
	 * @param articleAVendre
	 */
	public void ajouter(ArticleVendu articleAVendre) {
		articleDAO.ajouter(articleAVendre);
	}
	
	/**
	 * recupere tout les articles en BD
	 * @return
	 */
	public List<ArticleVendu> articlesEnVente(){	
		 return articleDAO.selectionArticles();
	}
	
	/**
	 * supprime l'article en BD via son numero unique
	 * @param noArticle
	 */
	public void supprimer(int noArticle) {
		articleDAO.supprimer(noArticle);
	}
	
	/**
	 * recupere les informations d'un article precis en BD
	 * @param noArticle
	 * @return
	 */
	public ArticleVendu articleSelectionne(int noArticle) {
		return articleDAO.selectionParNoArticle(noArticle);
	}
	
	/**
	 * modifie l'article en BD
	 * @param articleAModifie
	 */
	public void modifier(ArticleVendu articleAModifie) {
		articleDAO.modifier(articleAModifie);
	}
	
	













}
