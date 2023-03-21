package fr.eni.mahm.projetencheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.mahm.projetencheres.bo.Utilisateur;


public class UtilisateurDAO {
	

	private final String SQLLOGIN="select pseudo,nom,prenom,email,password,         // from utilisateur where email=? and password=?";
	private final String MYSQLDELETE="delete from utilisateur where pseudo=";
	private final String MYSQLINSERT="insert into utilisateur (pseudo,nom,prenom,email,telephone,rue,codePostal,ville)  values(?,?,?,?,?,?,?,?)";
	private final String MYSQLUPDATE="update utilisateur set nom=?,prenom=?,email=?,password=?,             where pseudo=?";
	private final String MYSQLSELECTALL="select pseudo,nom,prenom,email,password,               //from utilisateur";
	private final String MYSQLSELECTBYID="select pseudo,nom,prenom,email,password,        ///from utilisateur where pseudo=?";
	
	
	//--------------------------------LOGIN---------------------------//
	public Utilisateur login(String email,String pwd) 
	{
		Utilisateur utilisateur=null;
		try {
			Connection con = connectBDD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(SQLLOGIN);
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
	
	//--------------------------------DELET---------------------------//
	public void delete(int u)
	{
		Connection cnx;
		Statement stmt;
		cnx=connectBDD.getConnection();
		try 
		{
			stmt=cnx.createStatement();
			stmt.executeUpdate(MYSQLDELETE+u);
			cnx.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	//------------------------INSERT-------------------------------//
	
		public void insert(Utilisateur u)
		{
			Connection cnx=null;
			PreparedStatement stmt;
			cnx=connectBDD.getConnection();
			
			try 
			{
				cnx.setAutoCommit(false);
				stmt=cnx.prepareStatement(MYSQLINSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setString(1, u.getPseudo ());
				stmt.setString(2, u.getNom());
				stmt.setString(3, u.getPrenom());
				stmt.setString(4, u.getEmail());
				stmt.setString(5, u.getTelephone());
				stmt.setString(6, u.getRue());
				stmt.setString(7, u.getCodePostal());
				stmt.setString(8, u.getVille());
				stmt.setInt(9, u.getCredit());
				//stmt.setString(4, u.getPassword());
				stmt.executeUpdate();
				ResultSet rs;
				rs=stmt.getGeneratedKeys();
				rs.next();
			
				//u.getRue().setPseudo(u.getPseudo());
				//new adresseDAO().insert(u.getAdresse(),cnx);
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
					e1.printStackTrace();
				}
					e.printStackTrace();
			}
			}
		//------------------------UPDATE-------------------------------//
		public void update(Utilisateur u)
		{
			Connection cnx;
			PreparedStatement stmt;
			cnx=connectBDD.getConnection();
			try 
			{
				stmt=cnx.prepareStatement(MYSQLUPDATE);
				stmt.setString(1, u.getNom());
				if(u.getPrenom()!=null)
				{
					stmt.setString(2, u.getPrenom());
				}
				else
				{
					stmt.setNull(2, Types.VARCHAR);
				}
				stmt.setString(3,u.getEmail());
				//stmt.setString(4, u.getPassword());
				stmt.setString(7, u.getPseudo());
				stmt.executeUpdate();
				//new AdresseDao().update(u.getRue(), u.getCodePostal(),u.getVille(), cnx);
				cnx.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//------------------------SELECTALL-------------------------------//
		public List<Utilisateur> selectAll()
		{
			Connection cnx;
			Statement stmt;
			ResultSet rs;
			ArrayList<Utilisateur> lst=null;
			cnx=connectBDD.getConnection();
			try 
			{
				stmt=cnx.createStatement();
				rs=stmt.executeQuery(MYSQLSELECTALL);
				lst=new ArrayList<>();
				
				while(rs.next())
				{
					lst.add(rsToUtilisateur(rs));
				}
				cnx.close();		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return lst;
		}
		//------------------------SELECTBYPSEUDO-------------------------------//
		public Utilisateur selectById(int pseudo)
		{
			Connection cnx;
			PreparedStatement stmt;
			ResultSet rs;
			cnx=connectBDD.getConnection();
			Utilisateur u=null;
			try 
			{
				stmt=cnx.prepareStatement(MYSQLSELECTBYID);
				stmt.setInt(1, pseudo);
				rs=stmt.executeQuery();
				if(rs.next())
				{
					u=rsToUtilisateur(rs);
				}
				cnx.close();		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return u;
		}
}
		
		