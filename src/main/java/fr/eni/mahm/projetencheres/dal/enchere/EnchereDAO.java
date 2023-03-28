package fr.eni.mahm.projetencheres.dal.enchere;

import fr.eni.mahm.projetencheres.bo.Enchere;

public interface EnchereDAO {

	public Enchere recupererEnchere(int noArticle);
	public Enchere recupererDerniereEnchere(int noArticle);	
	public void ajouter(Enchere enchere);
	
}
