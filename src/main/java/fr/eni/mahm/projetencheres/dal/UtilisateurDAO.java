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
	

	private final String MYSQLLOGIN="select pseudo,nom,prenom,email,password,from utilisateurs where email=? and password=?";
	private final String MYSQLDELETE="delete from utilisateurs where no_utilisateur=";
	private final String MYSQLINSERT="insert into utilisateurs (pseudo,nom,prenom,email,telephone,rue,codePostal,ville,credit,administrateur)  values(?,?,?,?,?,?,?,?,?,?)";
	private final String MYSQLUPDATE="update utilisateurs set nom=?,prenom=?,email=?,password=?, where pseudo=?";
	private final String MYSQLSELECTALL="select pseudo,nom,prenom,email,rue,codePostal,ville,credit from utilisateurs";
	private final String MYSQLSELECTBYID="select pseudo,nom,prenom,email,rue,codePostal,ville,credit from utilisateurs where pseudo=?";
	
	
	//--------------------------------LOGIN---------------------------//
	public Utilisateur login(String email,String pwd) 
	{
		Utilisateur utilisateur=null;
		try {
			Connection con = connectBDD.getConnection();
			PreparedStatement pstmt = con.prepareStatement(MYSQLLOGIN);
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
				stmt.setBoolean(10, u.isAdministrateur());
				//stmt.setString(4, u.getPassword());
				stmt.executeUpdate();
				ResultSet rs;
				rs=stmt.getGeneratedKeys();
				rs.next();
				
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
				stmt.setString(1, u.getPseudo ());
				stmt.setString(2, u.getNom());
				stmt.setString(3, u.getPrenom());
				stmt.setString(4, u.getEmail());
				stmt.setString(5, u.getTelephone());
				stmt.setString(6, u.getRue());
				stmt.setString(7, u.getCodePostal());
				stmt.setString(8, u.getVille());
				stmt.executeUpdate();
				//new AdresseDao().update(u.getRue(), u.getCodePostal(),u.getVille(), cnx);
				cnx.close();
			} 
			catch (SQLException e) 
			{
				
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
		//------------------------SELECTBYID-------------------------------//
		public Utilisateur selectById(int noUtilisateur)
		{
			Connection cnx;
			PreparedStatement stmt;
			ResultSet rs;
			cnx=connectBDD.getConnection();
			Utilisateur u=new Utilisateur();
			try 
			{
				stmt=cnx.prepareStatement(MYSQLSELECTBYID);
				stmt.setInt(1, noUtilisateur);
				rs=stmt.executeQuery();
				stmt.getString(1,"noUtilisateur" );
				stmt.setString(2, u.getNom());
				stmt.setString(3, u.getPrenom());
				stmt.setString(4, u.getEmail());
				stmt.setString(5, u.getTelephone());
				stmt.setString(6, u.getRue());
				stmt.setString(7, u.getCodePostal());
				stmt.setString(8, u.getVille());
				cnx.close();		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return u;
		}
		
		}
		
		
		