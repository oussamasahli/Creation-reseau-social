package services;

import org.json.JSONObject;

public class SuppCommentaire {

	public static JSONObject SupComment(String id_user,String id_message, String nomColl) {
		
		if((id_user==null) || (id_message==null)  || (nomColl==null) )
			return ErrorJSON.serviceRefused("Warning argument",-1);
		
		if(!tools.CommentTools.deleteCommentaire(id_message,nomColl))
			return ErrorJSON.serviceRefused("Error Mongo", 10000);
					
		return ErrorJSON.serviceAccepted();
		
		
	}
	
}
