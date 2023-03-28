package fr.eni.mahm.projetencheres.ihm.servlet.enchere;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;
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
     * @see HttpServlet#HttpServlet()
     */
    public ListeEnchereConnecte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ArticleVendu> listeArticleVendu=null;
		ArticleManager articleMgr= new ArticleManager();
		String param;
		param = request.getParameter("optionsRadios");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/articleSelonFiltre.jsp");
		
		switch (param) {
		case "achatsEncheresOuvertes":
			//enchere ou la date est commencé exexution query +machin manager +liste
			System.out.println(param);
			
			request.setAttribute("listeArticleVendu", listeArticleVendu);
			rd.forward(request, response);
			break;		
		case "achatsDejaEncherie":
			//enchere ou le userconnected a deja bid
			System.out.println(param);
			request.setAttribute("listeArticleVendu", listeArticleVendu);		
			rd.forward(request, response);
			break;
		case "achatsEncheresgagnantes":
			//enchere ou le userconnected est le user qui a la derniere enchere
			System.out.println(param);
			rd.forward(request, response);
			break;
		case "ventesEnCours":
			//vente ou le user est le vendeur + date > aujourd'hui
			System.out.println(param);
			rd.forward(request, response);
			break;
		case "ventesNonCommences":
			//vente ou la date est superieur a celle d'aujourd'hui
			System.out.println(param);
			rd.forward(request, response);
			break;
		case "ventesTerminees":
			//vente ou le user est le nonoocted et la vente terminé
			System.out.println(param);
			rd.forward(request, response);
			break;
		default:
			break;
		}
		
	}

}
