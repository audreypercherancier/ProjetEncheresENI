package fr.eni.mahm.projetencheres.ihm.servlet.enchere;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;

/**
 * Servlet implementation class ListeEnchereConnecte
 */
@WebServlet("/ListeEnchereConnecte")
public class ListeEnchereConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ArticleVendu> listeArticleVendu=null;
		ArticleManager articleMgr= new ArticleManager();
		int idUtilisateurConnecte;
		Date dateDujour;
		String optionsRadios, achatsEncheresOuvertes, achatsDejaEncherie,achatsEncheresGagnantes,ventesEnCours,ventesNonCommences,ventesTerminees;
		optionsRadios = request.getParameter("optionsRadios");
		achatsEncheresOuvertes = request.getParameter("achatsEncheresOuvertes");
		achatsDejaEncherie = request.getParameter("achatsDejaEncherie");
		achatsEncheresGagnantes = request.getParameter("achatsEncheresGagnantes");	
		ventesEnCours = request.getParameter("ventesEnCours");
		ventesNonCommences = request.getParameter("ventesNonCommences");
		ventesTerminees = request.getParameter("ventesTerminees");
		idUtilisateurConnecte = Integer.parseInt(request.getParameter("userConnected"));
		System.out.println(optionsRadios);
		System.out.println("user "+idUtilisateurConnecte);
		dateDujour = new Date(System.currentTimeMillis());
		System.out.println(dateDujour);
		
		if (achatsEncheresOuvertes !=null) {
			//toutes les encheres ou la date de debutenchere est superieur ou egal a la date du jour
			// SELECT * FROM encheres.articles_vendus WHERE date_debut_encheres <= "dateDujour" pas oublié les quotes 
			System.out.println("affiche param1 "+achatsEncheresOuvertes);
		}
		if (achatsDejaEncherie !=null) {
			//tout les articles ou il ya une enchere dans la tabvle enchere ou le noutilisaeut = user connected
			//SELECT DISTINCT av.* FROM encheres.encheres e INNER JOIN articles_vendus av ON e.no_article=av.no_article where e.no_utilisateur=idUtilisateurConnecte
			System.out.println("affiche param2 "+achatsDejaEncherie);
		}
		if (achatsEncheresGagnantes !=null) {
			//Voir avec mathieu P
			//
			System.out.println("affiche param3 "+achatsEncheresGagnantes);
		}
		if (ventesEnCours !=null) {
			// tout les articles ou no_utilisateur=userconnected et la date de debut<date du jour< date de fin
			//SELECT * FROM encheres.articles_vendus where no_utilisateur=idUtilisateurConnecte and date_debut_encheres<="dateDujour"<=date_fin_encheres
			System.out.println("affiche param4 "+ventesEnCours);
		}
		if (ventesNonCommences !=null) {
			// tout les articles ou no_utilisateur=userconnected et la date du jour<date de debut
			// SELECT * FROM encheres.articles_vendus where no_utilisateur=idUtilisateurConnecte and "dateDujour"<=date_debut_encheres
			System.out.println("affiche param5 "+ventesNonCommences);
		}
		if (ventesTerminees !=null) {
			// tout les articles ou no_utilisateur=userconnected et la date de fin > date du jour
			//SELECT * FROM encheres.articles_vendus where no_utilisateur=idUtilisateurConnecte and "dateDujour"> date_fin_encheres
			System.out.println("affiche param6 "+ventesTerminees);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		

}

}
