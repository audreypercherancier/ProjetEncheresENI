package fr.eni.mahm.projetencheres.bo;

import java.util.ArrayList;
import java.util.List;

import fr.eni.mahm.projetencheres.exceptions.CodePostalException;
import fr.eni.mahm.projetencheres.exceptions.NoRetraitExeption;

/**
 * Classe permettant la création d'un utilisateur
 * @author Audrey & Mathieu Perin
 * @version 1.2.0
 */

public class Utilisateur {

	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur = false;

	// --------lien interclasses---------//
	private List<ArticleVendu> articlesAVendre = new ArrayList<>(); // liste d'articles vendu par l'utilisateur
	private List<ArticleVendu> articleAchete = new ArrayList<>(); // liste des articles acquéris par l'utilisateur
	private List<Enchere> encheresEffectuees = new ArrayList<>();

	//--------------------------CONSTRUCTOR ZONE----------------------------//
	
	
	/**
	 * Constructeur pour recuperation DATABASE
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 * @param articlesAVendre
	 * @param articleAchete
	 * @param encheresEffectuees
	 */
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur,
			List<ArticleVendu> articlesAVendre, List<ArticleVendu> articleAchete, List<Enchere> encheresEffectuees) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.articlesAVendre = articlesAVendre;
		this.articleAchete = articleAchete;
		this.encheresEffectuees = encheresEffectuees;
	}
	
	/**
	 *  Constructeur surchargé sans id
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param administrateur
	 */

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, boolean administrateur) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = 0;
		this.administrateur = administrateur;
	}


	/**
	 *  Constructeur surchargé sans id et sans admin
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 */

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = 0;
	}
	
	

	/**
	 * CONSTRUCTEUR SPECIALEMENT CONCU POUR AUDREY
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param credit
	 * @param articlesAVendre
	 * @param articleAchete
	 * @param encheresEffectuees
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, int credit, List<ArticleVendu> articlesAVendre,
			List<ArticleVendu> articleAchete, List<Enchere> encheresEffectuees) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.credit = credit;
		this.articlesAVendre = articlesAVendre;
		this.articleAchete = articleAchete;
		this.encheresEffectuees = encheresEffectuees;
	}

	public Utilisateur() {
	}

//---------------------------------------METHODE/FUNCTION ZONE---------------------------------------//
	public void vendArticle(ArticleVendu article) throws CodePostalException, NoRetraitExeption {
		article.setVendeur(this);
		if (article.getLieuRetrait() == null) {
			article.setLieuRetrait(new Retrait(this.getRue(), this.getCodePostal(), this.getVille()));
		}
		this.articlesAVendre.add(article);
	}
	
	public void annulerVente(ArticleVendu article) {
		if (article.getEnchereGagnante() != null) {
			article.getEnchereGagnante().getEncherisseur().setCredit(article.getEnchereGagnante().getEncherisseur().getCredit()+article.getPrixVente());
		}
		this.articlesAVendre.remove(article);
	}

	public void faitUneEnchere(ArticleVendu article, int montant) {
		if (this.getCredit() > montant && Enchere.enchereValide(article, montant)) {
			encheresEffectuees.add(new Enchere(this, article, montant));
			this.setCredit(this.getCredit() - montant);
		}
	}

	public void gagneEnchere(ArticleVendu articleAcqueris) {
		this.articleAchete.add(articleAcqueris);
	}

//---------------------------------------------GETTER SETTER ZONE-------------------------------------------------------//

	public List<ArticleVendu> getArticlesAVendre() {
		return articlesAVendre;
	}

	/**
	 * /!\ modifie l'intégralité de la liste /!\
	 * 
	 * @param articles
	 */
	public void setArticlesAVendre(List<ArticleVendu> articles) {
		this.articlesAVendre = articles;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	// --------------------------------------------------------------------------------------------------------------//

	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", credit=" + credit + ", administrateur=" + administrateur + "]";
	}

}
