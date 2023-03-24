package fr.eni.mahm.projetencheres.ihm.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.mahm.projetencheres.bll.UtilisateurManager;
import fr.eni.mahm.projetencheres.bo.Utilisateur;


/**
 * Servlet implementation class ModifierUtilisateur
 */
@WebServlet("/modifier")
public class ModifierUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifier.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Utilisateur u;
		try {
			
			
			u=new Utilisateur(request.getParameter("pseudo"),
					request.getParameter("nom"), 
					request.getParameter("prenom"),
					request.getParameter("email"),
					request.getParameter("numero"),
					request.getParameter("rue"),
					request.getParameter("codePostal"),
					request.getParameter("ville"),
					request.getParameter("motDePasse"));
					
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}


