package fr.eni.mahm.projetencheres.dal.retrait;

import java.sql.Connection;

import fr.eni.mahm.projetencheres.bo.Retrait;
import fr.eni.mahm.projetencheres.dal.ConnectBDD;

public class RetraitDAOJdbcImpl implements RetraitDAO{

	private final String SUPPRIMER = "";
	private final String AJOUTER = "INSERT INTO retraits (no_article, rue, code_postal, ville) VALUES (?,?,?,?)";
	private final String MODIFIER = "";
	
	
	
	
	
	
	@Override
	public void supprimer(int noArticle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouter(Retrait lieuRetrait) {
		Connection cnx = ConnectBDD.getConnection();
	}

	@Override
	public void modifier(Retrait nouveauLieuRetrait) {
		// TODO Auto-generated method stub
		
	}

}
