/**
 * 
 */
package fr.eni.mahm.projetencheres.dal;

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
