/**
 * 
 */
package fr.eni.mahm.projetencheres.bo;

import java.sql.Date;

/**
 * @author           Thoumire Mathieu
 * @description      Classe modélisant la vente d'un article
 * @date             20-03-2023
 * @version			 POO - V1.0
 */
public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private int etatVente;
	
	//-----------------lien interclasses-----------------//
	private Enchere enchereGagnante;
	
	//-------------------- CONSTRUCTOR ZONE --------------------//
	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @description constructeur surchargé avec id 
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, int etatVente) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	/**
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @description constructeur surchargé sans id 
	 */
	public ArticleVendu( String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, int etatVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	/**
	 * @description constructeur 
	 */
	public ArticleVendu() {
		super();
	}
	
	//--------------------------------------------METHOD/FUNCTION ZONE--------------------------------------------//
	public void finEnchere() {
		//TODO (void a modifié)
	}
	
	//---------------------------------------------GETTER SETTER ZONE-------------------------------------------------------//
	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}
	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}
	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the dateDebutEncheres
	 */
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 */
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	/**
	 * @return the dateFinEncheres
	 */
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}
	/**
	 * @param dateFinEncheres the dateFinEncheres to set
	 */
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	/**
	 * @return the miseAPrix
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}
	/**
	 * @param miseAPrix the miseAPrix to set
	 */
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}
	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	/**
	 * @return the etatVente
	 */
	public int getEtatVente() {
		return etatVente;
	}
	/**
	 * @param etatVente the etatVente to set
	 */
	public void setEtatVente(int etatVente) {
		this.etatVente = etatVente;
	}
	
	/**
	 * @return the enchereGagnante
	 */
	public Enchere getEnchereGagnante() {
		return enchereGagnante;
	}
	/**
	 * @param enchereGagnante the enchereGagnante to set
	 */
	public void setEnchereGagnante(Enchere enchereGagnante) {
		this.enchereGagnante = enchereGagnante;
		this.setPrixVente(enchereGagnante.getMontantEnchere());
	}
	
	
	
	//--------------------------------------------------------------------------------------------------------------//
	
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
	}
	



}
