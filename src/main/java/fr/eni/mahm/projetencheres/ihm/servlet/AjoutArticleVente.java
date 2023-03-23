package fr.eni.mahm.projetencheres.ihm.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutArticleALaVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleManager articleMgr = new ArticleManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Utilisateur utilisateur = (Utilisateur) request.getAttribute("connectedUser");
		System.out.println(utilisateur);
		ArticleVendu articleAVendre;

		String nom = request.getParameter("nomArticle");
		String description = request.getParameter("descriptionArticle");
		Categorie categorie = new Categorie(Integer.parseInt(request.getParameter("categorie")));
		int prixBase = Integer.parseInt(request.getParameter("prixinitial"));
		Date FinArticle;
		try {
			Date DebutEnchere = (Date) sdf.parse(request.getParameter("datedebutencheres"));
			FinArticle = (Date) sdf.parse(request.getParameter("datefinencheres"));

			try {

				articleAVendre = new ArticleVendu(nom, description, DebutEnchere, FinArticle, prixBase,
						utilisateur.getNoUtilisateur(), categorie);

				articleMgr.ajouter(articleAVendre);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		response.sendRedirect("index.jsp");

	}

}
