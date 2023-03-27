/**
 * 
 */
package fr.eni.mahm.projetencheres.dal.article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.mahm.projetencheres.bll.UtilisateurManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Categorie;
import fr.eni.mahm.projetencheres.bo.Retrait;
import fr.eni.mahm.projetencheres.dal.ConnectBDD;
import fr.eni.mahm.projetencheres.exceptions.CodePostalException;
import fr.eni.mahm.projetencheres.exceptions.NoRetraitExeption;

/**
 * @author MFail4562
 * @version 1.0.0
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {
	private final String SUPPRIMER = "DELETE FROM articles_vendus, retraits WHERE no_article=?";
	private final String SELECTION_TOUT_ARTICLES = "SELECT av.*, c.libelle, r.rue, r.code_postal, r.ville FROM articles_vendus av INNER JOIN retraits r ON r.no_article = av.no_article INNER JOIN categories c ON c.no_categorie=av.no_categorie ";
	private final String SELECTION_ARTICLE = "SELECT av.*, c.libelle, r.rue, r.code_postal, r.ville FROM articles_vendus av INNER JOIN retraits r ON r.no_article = av.no_article INNER JOIN categories c ON c.no_categorie WHERE av.no_article=?";
	private final String AJOUTER = "INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?)";

	@Override
	public void supprimer(int noArticle) {
		Connection cnx = ConnectBDD.getConnection();
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
			
		try (Connection cnx = ConnectBDD.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(AJOUTER, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, article.getDateDebutEncheres()) ;
			pstmt.setDate(4, article.getDateFinEncheres()) ;
			pstmt.setInt(5, article.getMiseAPrix()) ;
			pstmt.setInt(6, article.getPrixVente()) ;
			pstmt.setInt(7, article.getNoVendeur()) ;
			pstmt.setInt(8, article.getCategorie().getNoCategorie()) ;
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				article.getLieuRetrait().setNoArticle(rs.getInt(1));
			}
			
			try {
				RetraitManager retraitMgr = new RetraitManager();
				retraitMgr.ajouter(article.getLieuRetrait());
			}catch (Exception e) {
				e.printStackTrace();
			}
		
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifier(ArticleVendu article) {
		
	}

	@Override
	public List<ArticleVendu> selectionArticles() {
		List<ArticleVendu> articlesEnVente = new ArrayList<>();
		UtilisateurManager utilisateurMgr = new UtilisateurManager();

		try (Connection cnx = ConnectBDD.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTION_TOUT_ARTICLES);

			while (rs.next()) {
				articlesEnVente.add(new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"),
						new Retrait(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville")),
						new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"))));
				
			}
			
			for (ArticleVendu article : articlesEnVente) {
				article.setVendeur(utilisateurMgr.selectionnerParId(article.getNoVendeur()));
			}
		} catch (SQLException | CodePostalException | NoRetraitExeption e) {
			e.printStackTrace();
		}

		return articlesEnVente;
	}

	@Override
	public ArticleVendu selectionParNoArticle(int noArticle) {
		ArticleVendu article = null;
		UtilisateurManager utilisateurMgr = new UtilisateurManager();

		try (Connection cnx = ConnectBDD.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECTION_ARTICLE);
			pstmt.setInt(1, noArticle);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"),
						rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"),
						new Retrait(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville")),
						new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")));
				
				article.setVendeur(utilisateurMgr.selectionnerParId(article.getNoVendeur()));
			}
			
		
			
			
		} catch (SQLException | CodePostalException | NoRetraitExeption e) {
			e.printStackTrace();
		}

		return article;
	}

}
