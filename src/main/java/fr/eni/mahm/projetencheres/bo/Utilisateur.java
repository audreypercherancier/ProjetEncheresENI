package fr.eni.mahm.projetencheres.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Audrey
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
	
	//--------lien interclasses---------//
	private List<ArticleVendu> articles = new ArrayList<>(); //liste d'article vendu par l'utilisateur //MFail4562
	private List<Enchere> encheresEffectuees = new ArrayList<>();
	
	// Constructeur surchargé sans id 
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
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
		this.credit = credit;
		this.administrateur = administrateur;
	}

	// Constructeur surchargé sans id et sans admin
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit) {
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
		this.credit = credit;
	}


	public Utilisateur() {}
	
//---------------------------------------METHODE/FUNCTION ZONE---------------------------------------//
	public void VendArticle(ArticleVendu article) {
		this.articles.add(article);
	}
	
	public void faitUneEnchere(ArticleVendu article, int montant) {
		if(Enchere.enchereValide(article, montant)) {
			encheresEffectuees.add(new Enchere(this, article, montant));
		}
	}
	
//---------------------------------------------GETTER SETTER ZONE-------------------------------------------------------//
	
	public List<ArticleVendu> getArticles() {
		return articles;
	}

	/**
	 /!\ modifie l'intégralité de la liste /!\
	 * @param articles
	 */
	public void setArticles(List<ArticleVendu> articles) {
		this.articles = articles;
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

	
	//--------------------------------------------------------------------------------------------------------------//
	
	
	
	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", credit=" + credit + ", administrateur=" + administrateur + "]";
	} 
	
	
	
	
	
	
	
	
	
	
}
