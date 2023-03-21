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
	
	private int noRetrait;
	private String rue;
	private int codePostal;
	private String ville;
	
	/**
	 * @param noRetrait
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(int noRetrait, String rue, int codePostal, String ville)  throws CodePostalException, NoRetraitExeption {
		super();
		this.setNoRetrait (noRetrait);
		this.rue = rue;
		this.setCodePostal (codePostal);
		this.ville = ville;
	}
	
//--------------------------------------------SETTER ET GETTER-----------------------------------------------//
	public int getNoRetrait() {
		return noRetrait;
	}

	public void setNoRetrait(int noRetrait)  throws NoRetraitExeption {
		if(noRetrait>0)
		{
		this.noRetrait = noRetrait;
		}
		else
		{
		throw new NoRetraitExeption("erreur sur le numero");
		}
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) throws CodePostalException
		{
		if(codePostal>1000 && codePostal<98999)
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
