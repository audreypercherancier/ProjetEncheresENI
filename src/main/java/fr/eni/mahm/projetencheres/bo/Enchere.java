/**
 * 
 */
package fr.eni.mahm.projetencheres.bo;

import java.sql.Date;

/**
 * @author MFail4562
 * @version 1.0.0
 */
public class Enchere {
	private Date dateEnchere;
	private int montantEnchere;
	
	//---------lien interclasses---------//
	private ArticleVendu article;

	//------------------------ CONSTRUCTOR ZONE ------------------------//
	public Enchere(ArticleVendu article, int montantEnchere) {
		this.article = article;
		this.dateEnchere = new Date(System.currentTimeMillis());
		this.montantEnchere = montantEnchere;
	}
	
	//------------------------ GETTER/SETTER ZONE------------------------//
	
	
	

}
