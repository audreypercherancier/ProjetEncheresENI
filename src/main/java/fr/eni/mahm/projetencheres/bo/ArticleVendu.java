/**
 * 
 */
package fr.eni.mahm.projetencheres.bo;

import java.sql.Date;

/**
 * @author Thoumire Mathieu & Mathieu Perin
 * @description Classe modélisant la vente d'un article
 * @date 20-03-2023
 * @version POO - V1.2
 */
public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int miseAPrix;
	private int prixVente = 0;
	private int etatVente;

	// -----------------lien interclasses-----------------//
	private Enchere enchereGagnante;
	private int noVendeur;
	private Retrait lieuRetrait;
	private Categorie categorie;

	// -------------------- CONSTRUCTOR ZONE --------------------//

	/**
	 * constructeur a appelé lors de la creation d'un article avec lieu retrait
	 * IDENTIQUE domicile vendeur
	 * 
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @description constructeur surchargé sans id
	 */
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int miseAPrix, int etatVente, Categorie categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
		this.categorie = categorie;
	}

	/**
	 * constructeur a appelé lors de la creation d'un article avec lieu retrait
	 * DIFFERENT domicile vendeur
	 * 
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param etatVente
	 * @param enchereGagnante
	 * @param lieuRetrait
	 */
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int miseAPrix, int etatVente, Enchere enchereGagnante, Retrait lieuRetrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
		this.enchereGagnante = enchereGagnante;
		this.lieuRetrait = lieuRetrait;
	}

	/**
	 * pour recuperiation avec objet special AUDREY 
	 * constructeur a modifie dans le futur avec les enchere
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param enchereGagnante
	 * @param vendeur
	 * @param lieuRetrait
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int miseAPrix, int prixVente, 
			int noVendeur, Retrait lieuRetrait, Categorie categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.noVendeur = noVendeur;
		this.lieuRetrait = lieuRetrait;
		this.categorie = categorie;
	}

	/**
	 * @description constructeur
	 */
	public ArticleVendu() {
	}

	// --------------------------------------------METHOD/FUNCTION ZONE----------------------------------------//
	

		/**
	 	* tu casses les couilles mathieuP
	 	*/
	//public void finEnchere() {
	//	Date now = new Date(System.currentTimeMillis());
	//	int creditVendeur = this.getVendeur().getCredit();
	//	if (this.getDateFinEncheres().equals(now) || this.getDateFinEncheres().before(now)) {
	//		if (this.getPrixVente() > 0) {
	//			this.vendeur.setCredit(creditVendeur += this.prixVente);
	//			this.getEnchereGagnante().getEncherisseur().gagneEnchere(this);
	//		}
	//	}
//	}
	

	// -----------------------------------------GETTER SETTER ZONE----------------------------------------//
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


	/**
	 * @return the lieuRetrait
	 */
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	/**
	 * @param lieuRetrait the lieuRetrait to set
	 */
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
	

	/**
	 * @return the noVendeur
	 */
	public int getNoVendeur() {
		return noVendeur;
	}

	/**
	 * @param noVendeur the noVendeur to set
	 */
	public void setNoVendeur(int noVendeur) {
		this.noVendeur = noVendeur;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	// --------------------------------------------------------------------------------------------------------------//
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
	}

}
