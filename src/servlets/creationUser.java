package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class creationUser
 */
@WebServlet("/creationUser")
public class creationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creationUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// A l'initialisation de mon servlet , je récupère le datasource

		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//servlet qui utilise le service createUser pour créer un utilisateur
				//recupere les paramètre en méthode GET, passés dans la querystring de l'url donné au serveur
				JSONObject res;
				//response.setContentType(" application / json"); // si je veux afficher au format jsonje modifie le contenttype, sinon poour visualiser laffichage je laisse en text /plain par defaut
				PrintWriter out= response.getWriter();
				String nom=request.getParameter("nom");
				String prenom=request.getParameter("prenom");
				String login=request.getParameter("login");
				String mdp=request.getParameter("mdp");
				//String id_user=request.getParameter("id");
				//int id=Integer.parseInt(id_user)
				
				
				res=services.User.createUser(nom,prenom,login,mdp);
				out.println(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
