package fr.eni.mahm.projetencheres.dal.enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.eni.mahm.projetencheres.bo.Enchere;
import fr.eni.mahm.projetencheres.dal.ConnectBDD;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private final String INSERT = "INSERT INTO encheres (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)";

	@Override
	public Enchere recupererEnchere(int noArticle) {
		return null;
	}

	@Override
	public Enchere recupererDerniereEnchere(int noArticle) {
		return null;
	}

	@Override
	public void ajouter(Enchere enchere) {
		
		try(Connection cnx = ConnectBDD.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(INSERT);
			//-------------insert enchere---------------//
			pstmt.setDate(1, enchere.getDateEnchere());
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.setInt(3, enchere.getArticle().getNoArticle());
			pstmt.setInt(4, enchere.getEncherisseur().getNoUtilisateur());
			
			pstmt.executeUpdate();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
