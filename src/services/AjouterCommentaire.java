package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

public class AjouterCommentaire {
	
public static JSONObject addCommentaire(String cle,String texte,String nomColl) {
		
		if((cle==null) || (texte==null) || (nomColl==null) )
			return ErrorJSON.serviceRefused("Warning Argument", -1);
		if(!tools.UserTools.keyExist(cle))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		
		String id_msg=tools.CommentTools.insertCommentaire(cle,texte,nomColl);

		
		String login=tools.UserTools.getIdByKey(cle);
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dat = dateFormat.format(actuelle);
		
		
		return ErrorJSON.serviceAcceptedMessage(id_msg,login,dat); 
	
	}
}
