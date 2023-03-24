/**
 * 
 */
package fr.eni.mahm.projetencheres.dal;

import fr.eni.mahm.projetencheres.dal.article.ArticleDAO;
import fr.eni.mahm.projetencheres.dal.article.ArticleDAOJdbcImpl;

/**
 * @author audreypercherancier
 *
 */
public abstract class DAOFactory {
	
	
	public static UtilisateurDAO getUtilisateurDAO() {		
		return new UtilisateurDAOJdbcImpl(); 
	}
	
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}
	
}
