package servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;
import java.io.PrintWriter;

/**
 * Servlet implementation class Loggin
 */
@WebServlet("/Loggin")
public class Loggin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loggin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject o;
		PrintWriter out=response.getWriter();
		String log= request.getParameter("login");
		String mdp=request.getParameter("passwd");
		//La méthode do get de mon servlet , appelle le service create login , avec les parametre de la queryString
		
		o=services.Login.login(log, mdp); // on appelle le service login , dans la classe Login , avec comme parametre le login de 
				
		// l'utilisateur et son mot de passe
		//Si tous c'est bien passé (service accepté) on a un affichage : id,login,clé au formatjson sinon on a un message erreur au format json 
		// si jéxécute mon servlet avec run on server dans eclipse ca marche mais ya pas d'affichage car il supporte par les fichiers format json
		//quand j'ai des probleme de port , je les modifie en cliquand sur le serveur tomcat dans longlet server 
		//ensuite jouvre le fichier au format json dans un editeur de texte comme sublime par exemple
		//Les fichiers au fomat Json généré seront placé dans un répertoire TestTwisterFicherJson
		//Atention --> dans la query String ?login=ouss&passwd=azer   --> ne pas mettre de "" entre les valeur 
		
		out.println(o);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
