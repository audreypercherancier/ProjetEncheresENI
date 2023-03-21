package fr.eni.mahm.projetencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.mahm.projetencheres.bo.Retrait;


public class adresseDAO {
	
	private final String MYSQLINSERT="insert into adresses (id_utilisateur,numero,rue,codepostal,ville)  values(?,?,?,?,?)";

	public void insert(Retrait a,Connection c)
	{
		Connection cnx;
		PreparedStatement stmt;
		if(c==null)
		{
			cnx=connectBDD.getConnection();
		}
		else
		{
			cnx=c;
		}
		try 
		{
			stmt=cnx.prepareStatement(MYSQLINSERT);
			stmt.setInt(1, a.getId());
			stmt.setString(3, a.getRue());
			stmt.setInt(4, a.getCodePostal());
			stmt.setString(5, a.getVille());
			stmt.executeUpdate();
			if(c==null)
			{
				cnx.close();
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
}
