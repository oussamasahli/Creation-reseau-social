package services;
import org.json.*;
//import java.io.IOException;
//import tools.UserTools;

public class Login {
	
	public static JSONObject login(String log,String mdp) {
		// id ? key ? --> comment r�cup�rer key
		if((log==null) || (mdp==null))
			return (ErrorJSON.serviceRefused("Warning arg",-1));
	
		//utiliser uuid.tostring our generer une cl�
		if(!tools.UserTools.isUser2(log))
			return (ErrorJSON.serviceRefused("Error SQL: User with  this login doesn't exist",1000));
		
		//cheker le mdp pour voir si il correspond � ce login
		if(!tools.UserTools.checkPassword(log,mdp))
			return (ErrorJSON.serviceRefused("Error SQL : this password doesn't correspond to this login",1000));
		
		//on recupere l'id associ� � cet utilisateur
		int id=tools.UserTools.recupereId(log);
		//L'utilisateur se log, alors je cr� une session , et je renvoie la cl� de connexion cr��
		String cle=tools.UserTools.loggin(log,mdp);
		//System.out.println("cle:  "+cle);
		if(cle==null)
			return (ErrorJSON.serviceRefused("Error SQL: la session n'a pas pu etre cr�er",1000));
		
		
		return ErrorJSON.serviceAcceptedLogin(id,log,cle);// pour avoir une sortie de la forme {id:login:key}
		
		 // A Definir : getUser(login) & insertNullSession(id_user,root)
		
		
		
	}
}
