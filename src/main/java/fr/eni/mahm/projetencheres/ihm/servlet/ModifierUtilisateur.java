package fr.eni.mahm.projetencheres.ihm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		Utilisateur u = new Utilisateur(); 
		int id;
		UtilisateurManager userMgr = new UtilisateurManager(); 
		try {
			request.setCharacterEncoding("UTF-8");
			id=Integer.parseInt(request.getParameter("id"));
			String ancienMotDePasseEcrit = Utilisateur.hashagePwd(request.getParameter("ancienMotDePasse")); 
			String nouveauMotDePasse = request.getParameter("nouveauMotDePasse"); 
			String nouveauMotDePasseconfirmé = request.getParameter("confirmationNouveauMotDePasse"); 
			u=userMgr.verificationMdp(ancienMotDePasseEcrit); 
			System.out.println(u);
			
			
			if (u!=null) {
				 
				if(nouveauMotDePasse.equals(nouveauMotDePasseconfirmé)) {
					Utilisateur utilisateurModifié = 
					new Utilisateur(request.getParameter("pseudo"),
									request.getParameter("nom"), 
									request.getParameter("prenom"),
									request.getParameter("email"),
									request.getParameter("numero"),
									request.getParameter("rue"),
									request.getParameter("codePostal"),
									request.getParameter("ville"),
									Utilisateur.hashagePwd(nouveauMotDePasse));
				
					userMgr.modifier(utilisateurModifié); 
					response.sendRedirect("/ProjetEncheresENI/AccesProfil"); 

			}	
				else {
					request.setAttribute("invalid-feedback", "Les nouveaux mots de passe ne sont pas exactes, veuillez recommencer."); 
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifier.jsp");
					rd.forward(request, response);
				}
					}else {
						request.setAttribute("invalid-feedback", "Votre mot de passe est incorrect, veuillez réessayer."); 
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifier.jsp");
						rd.forward(request, response);
						
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	}


