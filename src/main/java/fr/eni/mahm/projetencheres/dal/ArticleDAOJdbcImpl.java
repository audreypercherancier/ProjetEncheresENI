/**
 * 
 */
package fr.eni.mahm.projetencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Categorie;
import fr.eni.mahm.projetencheres.bo.Retrait;
import fr.eni.mahm.projetencheres.exceptions.CodePostalException;
import fr.eni.mahm.projetencheres.exceptions.NoRetraitExeption;

/**
 * @author MFail4562
 * @version 1.0.0
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {
	private final String SUPPRIMER = "DELETE FROM articles_vendus WHERE no_article=?";
	private final String SELECTION_TOUT_ARTICLES = "SELECT av.*, c.libelle, r.rue, r.code_postal, r.ville FROM articles_vendus av INNER JOIN retraits r ON r.no_article = av.no_article INNER JOIN categories c ON c.no_categorie ";

	@Override
	public void supprimer(int noArticle) {
		Connection cnx = connectBDD.getConnection();
		try {
			cnx.setAutoCommit(false);
			PreparedStatement pstmt = cnx.prepareStatement(SUPPRIMER);
			pstmt.setInt(1, noArticle);
			pstmt.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			try {
				cnx.rollback();
				cnx.close();
			} catch (SQLException e2) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void ajouter(ArticleVendu article) {

	}

	@Override
	public void modifier(ArticleVendu article) {

	}

	@Override
	public List<ArticleVendu> selectionArticles() {
		List<ArticleVendu> articlesEnVente = new ArrayList<>();

		try (Connection cnx = connectBDD.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTION_TOUT_ARTICLES);

			while (rs.next()) {
				articlesEnVente.add(new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), new Retrait(rs.getString("rue"), rs.getString("code_postal"),  rs.getString("ville")), new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"))));
			}
		} catch (SQLException | CodePostalException | NoRetraitExeption e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArticleVendu selectionParNoArticle(int noArticle) {
		return null;
	}

}
