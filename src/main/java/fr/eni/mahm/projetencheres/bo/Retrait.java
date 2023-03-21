/**
 * 
 */
package fr.eni.mahm.projetencheres.bo;

import fr.eni.mahm.projetencheres.exceptions.CodePostalException;
import fr.eni.mahm.projetencheres.exceptions.NoRetraitExeption;

/**
 * @author           Hind El Moutawakil
 * @description      Classe modélisant la vente d'un article
 * @date             20-03-2023
		 * @version POO - V1.0
 */
public class Retrait {
	private String rue;
	private String codePostal;
	private String ville;
	
	/**
	 * @param noRetrait
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(String rue, String codePostal, String ville)  throws CodePostalException, NoRetraitExeption {
		this.rue = rue;
		this.setCodePostal (codePostal);
		this.ville = ville;
	}
//--------------------------SETTER ET GETTER-----------------------------------//
	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) throws CodePostalException
		{
		if(Integer.parseInt(codePostal) > 1000 && Integer.parseInt(codePostal)<98999)
		{
		this.codePostal = codePostal;
		}
		else
		{
		throw new CodePostalException("erreur sur le code postal");
		}
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
}
