/**
 * 
 */
package fr.eni.mahm.projetencheres.dal.utilisateur;

import java.util.List;

import fr.eni.mahm.projetencheres.bo.Utilisateur;

/**
 * @author audreypercherancier
 *
 */
public interface UtilisateurDAO {

	void delete(int noUtilisateur); 
	Utilisateur login(String email,String pwd);
	void insert(Utilisateur u); 
	void update(Utilisateur u); 
	List<Utilisateur> selectAll(); 
	Utilisateur selectById(int noUtilisateur);
	Utilisateur selectByIdPublic(int noUtilisateur); 
	Utilisateur verificationMdp(String motDePasse); 
	
}
