package services;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.*;
import services.ErrorJSON;

//cette classe regroupera les diffï¿½rent service associï¿½ aux Commentaire --> serach , add et delete
public class Comment {

	public static JSONObject addComment(String cle,String text) {
		
		//on test si les valeur sont nul --> cest a dire mal initialisï¿½ dans la query string
		if((cle==null) || (text==null))
			return ErrorJSON.serviceRefused("Warning Argument", -1);
		
		//On peut faire un autre test pour regarder si la clï¿½ ï¿½ laquelle on se rï¿½fï¿½re elle fait rï¿½fï¿½rence ï¿½ une clï¿½ existante
		//dans la base de donnee du style : boolean is_cle= cleExist(cle); --> interroge la Bd renvoie true si la clï¿½ existe dans La BD
		//mathode cleExist(String cle) --> ï¿½ mettre dans la classe toolsComment du package toools
		
		if(!tools.UserTools.keyExist(cle))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		
		//Enfin  si on sait que la clï¿½ existe dans la bd , alors on peut ajouter le commentaire
		//Insï¿½rer le commentaire dans MONGODB
		
		String id_msg=tools.CommentTools.insertMessage(cle,text);
		//cré un collection pour ce message , afin qu'on puisse lui associer des commentaires, le nom de la collection sera lobjectid du message afin de bien distinguer les differentes collection de commentaires
		tools.CommentTools.CreateCollComm(id_msg);
		
		String login=tools.UserTools.getIdByKey(cle);
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dat = dateFormat.format(actuelle);
		
		
		return ErrorJSON.serviceAcceptedMessage(id_msg,login,dat); // la sortit ne nï¿½cï¿½ssite aucun affichage , donc on peut appeller service accepted sans aucun commentaire
	
	}
}
