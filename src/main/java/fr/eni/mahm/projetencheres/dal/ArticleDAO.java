package fr.eni.mahm.projetencheres.dal;

import java.util.List;

import fr.eni.mahm.projetencheres.bo.ArticleVendu;

/**
 * 
 * @author MFail4562
 * @version 1.0.0
 */
public interface ArticleDAO {
	
	void supprimer(int noArticle);
	void ajouter(ArticleVendu article);
	void modifier(ArticleVendu article);
	List<ArticleVendu> selectionArticles();
	ArticleVendu selectionParNoArticle(int noArticle);
}
