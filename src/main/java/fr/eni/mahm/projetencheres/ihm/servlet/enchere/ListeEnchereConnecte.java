package fr.eni.mahm.projetencheres.ihm.servlet.enchere;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String param, param1, param2,param3,param4,param5,param6;
		param = request.getParameter("optionsRadios");
		param1 = request.getParameter("achatsEncheresOuvertes");
		param2 = request.getParameter("achatsDejaEncherie");
		param3 = request.getParameter("achatsEncheresGagnantes");	
		param4 = request.getParameter("ventesEnCours");
		param5 = request.getParameter("ventesNonCommences");
		param6 = request.getParameter("ventesTerminees");
		idUtilisateurConnecte = Integer.parseInt(request.getParameter("userConnected"));
	
		System.out.println("user"+idUtilisateurConnecte);
		
		if (param1 !=null) {
			//toutes les encheres ou la date de debutenchere est superieur ou egal a la date du jour
			// SELECT * FROM encheres.articles_vendus WHERE date_debut_encheres <= CURDATE()
			System.out.println("affiche param1 "+param1);
		}
		if (param2 !=null) {
			//tout les articles ou toutes les encheres ont le userconnected=no_utilisateur
			//
			System.out.println("affiche param2 "+param2);
		}
		if (param3 !=null) {
			//tout les article ou 
			//
			System.out.println("affiche param3 "+param3);
		}
		if (param4 !=null) {
			// tout les articles ou no_utilisateur=userconnected et la date de debut<date du jour< date de fin
			//
			System.out.println("affiche param4 "+param4);
		}
		if (param5 !=null) {
			// tout les articles ou no_utilisateur=userconnected et la date du jour<date de debut
			//
			System.out.println("affiche param5 "+param5);
		}
		if (param6 !=null) {
			// tout les articles ou no_utilisateur=userconnected et la date de fin > date du jour
			//
			System.out.println("affiche param6 "+param6);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/articleSelonFiltre.jsp");
		rd.forward(request, response);
		

}

}
