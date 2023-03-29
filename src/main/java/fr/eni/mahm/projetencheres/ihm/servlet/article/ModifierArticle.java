package fr.eni.mahm.projetencheres.ihm.servlet.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.mahm.projetencheres.bll.ArticleManager;
import fr.eni.mahm.projetencheres.bo.ArticleVendu;

/**
 * Servlet implementation class ModifierArticle
 */
@WebServlet("/ModifierArticle")
public class ModifierArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifierArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int nArticle;
		ArticleManager articleMgr =new ArticleManager();
		
		try {
			nArticle=Integer.parseInt(request.getParameter("nArticle"));
			ArticleVendu articleModifie =new ArticleVendu();
			request.getParameter("nomArticle");
			request.getParameter("description");
			request.getParameter("dateDebutEncheres");
			request.getParameter("dateFinEncheres");
			request.getParameter("miseAPrix");
			request.getParameter("prixVente");
			
			articleModifie.setNoVendeur(articleModifie.getNoVendeur());
			
			
			articleMgr.modifier(articleModifie);
			session.setAttribute("article", articleModifie);
			response.sendRedirect("/ProjetEncheresENI/modifierArticle"); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
