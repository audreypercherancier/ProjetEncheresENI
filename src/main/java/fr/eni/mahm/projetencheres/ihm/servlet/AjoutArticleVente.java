package fr.eni.mahm.projetencheres.ihm.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;
import fr.eni.mahm.projetencheres.bo.Categorie;
import fr.eni.mahm.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class AjoutArticleVente
 */
@WebServlet("/VendreUnArticle")
public class AjoutArticleVente extends HttpServlet {
private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticleALaVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager articleMgr = new ArticleManager();
		
		Utilisateur utilisateur = (Utilisateur) request.getAttribute("connectedUser");
		System.out.println(utilisateur);
		ArticleVendu articleAVendre;
		
		String nom = request.getParameter("");
		String description = request.getParameter("");
		Categorie categorie = new Categorie(request.getParameter("")); 
		int prixBase = request.getParameter();
		Date DebutEnchere = request.getParameter();
		Date FinArticle = request.getParameter() ;
		
		try {
			
			articleAVendre = new ArticleVendu(nom, description, DebutEnchere, FinArticle, prixBase, utilisateur.getNoUtilisateur(), categorie);
			
			articleMgr.ajouter(articleAVendre);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
