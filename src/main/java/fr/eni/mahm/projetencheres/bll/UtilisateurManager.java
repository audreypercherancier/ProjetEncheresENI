package fr.eni.mahm.projetencheres.bll;

import fr.eni.mahm.projetencheres.bo.Utilisateur;
import fr.eni.mahm.projetencheres.dal.DAOFactory;
import fr.eni.mahm.projetencheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	private UtilisateurDAO userDAO;
	
	//-----------CONSTRUCTOR-------------------//
	public UtilisateurManager() {
		userDAO = DAOFactory.getUtilisateurDAO();
	}
	
	//----------FUNCTION---------------------//
	public Utilisateur connexion(String email, String password) {
		Utilisateur userConnected = null;
		
		try {
			userConnected = userDAO.login(email, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return userConnected;
	}
	
	public void modifier(Utilisateur c) {
		userDAO.update(c);
	}
	public void inscription(Utilisateur nouvelUtilisateur) {
		userDAO.insert(nouvelUtilisateur);
		
	}
	

}
