/**
 * 
 */
package fr.eni.mahm.projetencheres.bll;

import fr.eni.mahm.projetencheres.bo.Enchere;
import fr.eni.mahm.projetencheres.dal.DAOFactory;
import fr.eni.mahm.projetencheres.dal.article.ArticleDAO;
import fr.eni.mahm.projetencheres.dal.enchere.EnchereDAO;

/**
 * @author MFail4562
 * @version 1.0.0
 */
public class EnchereManager {
	
	private static EnchereDAO enchereDAO;
	private static ArticleManager articleMgr = new ArticleManager();
	private static UtilisateurManager utilisateurMgr = new UtilisateurManager(); 
	// -----------CONSTRUCTEUR ZONE-----------//
	public EnchereManager() {
		enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	// -----------FUNCTION-----------//
	
	public void faireEnchere(Enchere enchere) {
		if(Enchere.enchereValide(enchere.getArticle(), enchere.getMontantEnchere())) {
			enchereDAO.ajouter(enchere);
			articleMgr.faireEnchere(enchere.getMontantEnchere(), enchere.getArticle().getNoArticle());
			utilisateurMgr.miseAJourSolde(enchere.getEncherisseur().getCredit(), enchere.getEncherisseur().getNoUtilisateur());
		}
	}

}
