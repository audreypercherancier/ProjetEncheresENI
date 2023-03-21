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
	private Utilisateur encherisseur;

	//------------------------ CONSTRUCTOR ZONE ------------------------//
	/**
	 * visibilité package, doit faire l'objet d'une validation avant creation
	 * @param encherisseur
	 * @param article
	 * @param montantEnchere
	 */
	Enchere(Utilisateur encherisseur, ArticleVendu article, int montantEnchere) {
		this.article = article;
		this.dateEnchere = new Date(System.currentTimeMillis());
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
		this.setEnchere();
	}
	
	/**
	 * verifie la validité de l'enchere
	 * @param article
	 * @param montant
	 * @return
	 */
	public static boolean enchereValide(ArticleVendu article, int montant) {
		Date now = new Date(System.currentTimeMillis());
		boolean valide = true;
			if(article.getMiseAPrix() > montant || article.getPrixVente() > montant || article.getDateFinEncheres().before(now) || article.getDateDebutEncheres().after(now)){
				valide = false;
			}
		return valide;
	}
	
	private void setEnchere() {
		if(this.article.getEnchereGagnante() != null) {
			
		}
		this.article.setEnchereGagnante(this);
	}

	//------------------------ GETTER/SETTER ZONE------------------------//

	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the dateEnchere
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * @return the article
	 */
	public ArticleVendu getArticle() {
		return article;
	}

	/**
	 * @return the encherisseur
	 */
	public Utilisateur getEncherisseur() {
		return encherisseur;
	}
	
	
	
	
	

}
