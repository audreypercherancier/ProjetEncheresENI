package fr.eni.mahm.projetencheres.dal.enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.mahm.projetencheres.bo.Enchere;
import fr.eni.mahm.projetencheres.bo.Utilisateur;
import fr.eni.mahm.projetencheres.dal.ConnectBDD;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private final String AJOUT = "INSERT INTO encheres (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)";
	private final String DERNIERE_ENCHERE = "SELECT e.montant_enchere, e.date_enchere, u.pseudo, u.no_utilisateur, u.credit FROM encheres e INNER JOIN utilisateurs u ON u.no_utilisateur = e.no_utilisateur WHERE e.no_article = ? ORDER BY e.no_enchere DESC";

	@Override
	public Enchere recupererEnchere(int noArticle) {
		return null;
	}

	@Override
	public Enchere recupererDerniereEnchere(int noArticle) {
		Enchere derniereEnchere = null;
		
		try(Connection cnx = ConnectBDD.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(DERNIERE_ENCHERE);
			pstmt.setInt(1, noArticle);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				derniereEnchere = new Enchere(new Utilisateur(rs.getString("pseudo"), rs.getInt("no_utilisateur"), rs.getInt("credit")), rs.getInt("montant_enchere"), rs.getDate("date_enchere"), noArticle);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return derniereEnchere;
	}

	@Override
	public void ajouter(Enchere enchere) {
		
		try(Connection cnx = ConnectBDD.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(AJOUT);
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
