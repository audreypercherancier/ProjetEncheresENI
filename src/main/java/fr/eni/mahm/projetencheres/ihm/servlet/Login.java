package fr.eni.mahm.projetencheres.ihm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.UtilisateurManager;
import fr.eni.mahm.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = (String) request.getAttribute("login");
		String password = (String) request.getAttribute("password");
		Utilisateur user = null;
		UtilisateurManager userMgr = new UtilisateurManager();
		HttpSession session = request.getSession();
		
		//---------PROCÉDÉ POST INSCRIPTION---------------//
		if (session.getAttribute("newUser") != null) {
			user = (Utilisateur) session.getAttribute("newUser");
			session.setAttribute("userConnected", user);
			Cookie pims;
			pims = new Cookie("lastLogin", user.getEmail());
			pims.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(pims);
			response.sendRedirect("index.jsp");
		} else {

			try {
				user = userMgr.connexion(login, password);

				if (user != null) {
					request.setAttribute("user", user);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/monCompte.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/seConnecter.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login, password;
		Utilisateur u = null;
		login = request.getParameter("login");
		password = Utilisateur.hashagePwd(request.getParameter("password"));
		HttpSession ses;
		ses = request.getSession();
		UtilisateurManager userMgr = new UtilisateurManager();
		u = userMgr.connexion(login, password);

		if (u != null) {
			ses.setAttribute("userConnected", u);
			Cookie pims;
			pims = new Cookie("lastLogin", u.getEmail());
			pims.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(pims);
			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("alert alert-danger", "Identifiant et / ou mot de passe incorrect(s)");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/seConnecter.jsp");
			rd.forward(request, response);
		}

	}
}
