package fr.eni.mahm.projetencheres.bo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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
	private int credit = 100;
	private boolean administrateur = false;

	// --------lien interclasses---------//
	private List<ArticleVendu> articlesVendus= new ArrayList<>(); // liste d'articles vendu par l'utilisateur
	private List<ArticleVendu> articlesAchetes = new ArrayList<>(); // liste d'articles vendu par l'utilisateur
	private List<Enchere> encheresEffectuees = new ArrayList<>();

	//--------------------------CONSTRUCTOR ZONE----------------------------//
	/**
	 * Constructeur par défault
	 */
	public Utilisateur() {
		
	}
	
	
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
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.setPrenom(prenom);
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	/**  Constructeur inscription et modification, 
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
			String codePostal, String ville, String motDePasse, boolean administrateur){
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.setPrenom(prenom);
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.setMotDePasse(motDePasse);
		this.administrateur = administrateur;
	}

	/**
	 *  Constructeur surchargé sans id et sans admin pour inscription
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
			String codePostal, String ville, String motDePasse) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.setPrenom(prenom);
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.setMotDePasse(motDePasse);
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
			String codePostal, String ville, int credit) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.setPrenom(prenom);
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.credit = credit;
	}
	
	
/**   CONSTRUCTEUR ENCORE POUR AUDREY
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.setPrenom(prenom);
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	

/** 	CONSTRUCTEUR ENCORE ET TOUJOURS POUR AUDREY
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param motDePasse
	 */
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String motDePasse) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.setPrenom(prenom);
		this.email = email;
		this.motDePasse = motDePasse;
	}
	
	
	

/**  Constructeur pour Audrey modification profil
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
 */
public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
		String rue, String codePostal, String ville, String motDePasse) {
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
}

/**
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
 */
public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email,String motDePasse, String telephone,
		String rue, String codePostal, String ville, int credit) {
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
}

/**
 * pour recuperation derniere enchere db
 * @param noUtilisateur
 * @param pseudo
 */
public Utilisateur(String pseudo, int noUtilisateur, int credit) {
	this.noUtilisateur = noUtilisateur;
	this.pseudo = pseudo;
	this.credit = credit;
}

//---------------------------------------METHODE/FUNCTION ZONE---------------------------------------//



	public void faitUneEnchere(ArticleVendu article, int montant) {
		if (this.getCredit() > montant && Enchere.enchereValide(article, montant)) {
			encheresEffectuees.add(new Enchere(this, article, montant));
			this.setCredit(this.getCredit() - montant);
		}
	}

	
	public void ajoutArticleAchete(ArticleVendu article) {
		this.articlesAchetes.add(article);
	}
	
	public void ajoutArticlesVendus(ArticleVendu article) {
		this.articlesVendus.add(article);
	}
//---------------------------------------------GETTER SETTER ZONE-------------------------------------------------------//

	public List<ArticleVendu> getArticlesVendus() {
		return articlesVendus;
	}

	/**
	 * /!\ modifie l'intégralité de la liste /!\
	 * 
	 * @param articles
	 */
	public void setArticlesAVendre(List<ArticleVendu> articles) {
		this.articlesVendus = articles;
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
		return nom.toUpperCase();
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1);
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
		this.motDePasse = hashagePwd(motDePasse);
	}
	
	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	
	/**
	 * @return the encheresEffectuees
	 */
	public List<Enchere> getEncheresEffectuees() {
		return encheresEffectuees;
	}
	
	/**
	 * @return the articlesAchetes
	 */
	public List<ArticleVendu> getArticlesAchetes() {
		return articlesAchetes;
	}




	//--------hashage lachement volé a thierry----------//
	public static String hashagePwd(String password) {
		MessageDigest md=null;
		StringBuffer sb=new StringBuffer();
		byte[] reponse;
		try {
			md=MessageDigest.getInstance("SHA");
			reponse=md.digest(password.getBytes());
			for(int i:reponse)
			{
				sb.append((Integer.toString((i&0xff)+0x100, 16).substring(1)));
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	

	// --------------------------------------------------------------------------------------------------------------//



	@Override
	public String toString() {
		return this.getPrenom()+" "+this.getNom();
	}

}
