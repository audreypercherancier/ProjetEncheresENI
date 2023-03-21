package fr.eni.mahm.projetencheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.ecole.DAL.AdresseDao;
import fr.eni.ecole.DAL.UtilBDD;
import fr.eni.mahm.projetencheres.bo.Utilisateur;


public class UtilisateurDAO {
	

	private final String SQLINSERT="insert into utilisateur (nom,prenom,email,password,dateNaissance,id_role)  values(?,?,?,?,?,?)";
	
	
	
	public Utilisateur login(String email,String pwd) 
	{
		Utilisateur utilisateur=null;
		try {
			Connection con = connectBDD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(MySQLLOGIN);
			pstmt.setString(1,email);
			pstmt.setString(2,pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				 utilisateur= rsToUtilisateur(rs);
			}
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return utilisateur;
	}
	//-----------------------------DELET-------------------------//
	public void delete(int u)
	{
		Connection cnx;
		Statement stmt;
		cnx=connectBDD.getConnection();
		try 
		{
			stmt=cnx.createStatement();
			stmt.executeUpdate(SQLDELETE+u);
			cnx.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	//------------------------INSERT-------------------------------//
	
	public void insert(Utilisateur u)
	{
		Connection cnx=null;
		PreparedStatement stmt;
		cnx=public void insert(Utilisateur u)
		{
			Connection cnx=null;
			PreparedStatement stmt;
			cnx=UtilBDD.getConnection();
			
			try 
			{
				cnx.setAutoCommit(false);
				stmt=cnx.prepareStatement(SQLINSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setString(1, u.getNom());
				stmt.setString(2, u.getPrenom());
				stmt.setString(3,u.getEmail());
				stmt.setString(4, u.getPassword());
				stmt.setDate(5,new Date(u.getDateNaissance().toEpochDay()*24*3600*1000));
				stmt.setInt(6,u.getRole().getId());
				stmt.executeUpdate();
				ResultSet rs;
				rs=stmt.getGeneratedKeys();
				rs.next();
				u.setId(rs.getInt(1));
				u.getAdresse().setId(u.getId());
				new AdresseDao().insert(u.getAdresse(),cnx);
				cnx.commit();
				
				cnx.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				try 
				{
					cnx.rollback();
					cnx.close();
				}
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// TODO Auto-generated catch block
				e.printStackTrace();
			}.getConnection();
		
		try 
		{
			cnx.setAutoCommit(false);
			stmt=cnx.prepareStatement(SQLINSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, u.getNom());
			stmt.setString(2, u.getPrenom());
			stmt.setString(3,u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setDate(5,new Date(u.getDateNaissance().toEpochDay()*24*3600*1000));
			stmt.setInt(6,u.getRole().getId());
			stmt.executeUpdate();
			ResultSet rs;
			rs=stmt.getGeneratedKeys();
			rs.next();
			u.setId(rs.getInt(1));
			u.getAdresse().setId(u.getId());
			new AdresseDao().insert(u.getAdresse(),cnx);
			cnx.commit();
			
			cnx.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try 
			{
				cnx.rollback();
				cnx.close();
			}
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
