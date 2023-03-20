package fr.eni.mahm.projetencheres.bo;

/**
 * Classe categorisant une enchere
 * @author Mfail4562
 * @version 1.0.0
 */
public class Categorie {
	private int noCategorie ;
	private String libelle;
	
	//-------------------- CONSTRUCTOR ZONE --------------------//

	public Categorie(int noCategorie, String libelle) {
	this.noCategorie = noCategorie;
	this.libelle = libelle;
}
	//-------------------- GETTER/SETTER ZONE --------------------//

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
