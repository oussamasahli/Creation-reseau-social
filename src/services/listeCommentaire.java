package services;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONArray;

public class listeCommentaire {
	
	public static JSONArray listComms(String nomColl) {
		
		
		if((nomColl==null))
			return ErrorJSON.serviceRefusedComment("Erreur argument",-1);

		List<String> messages=new ArrayList<String>();
		List<ObjectId> ids_msg=new ArrayList<ObjectId>();
		List<String> TotalLogins= new ArrayList<String>();
		List<String> TotalDate= new ArrayList<String>();
		
	    //recupere tous les messages de la collection nomcoll
		
		messages=tools.CommentTools.getComms(nomColl);
		ids_msg=tools.CommentTools.getIdComms(nomColl);
		TotalLogins=tools.CommentTools.getTotalLogins(nomColl);
		TotalDate=tools.CommentTools.getTotalDate(nomColl);
		
		
		return ErrorJSON.serviceAcceptedComment(messages,ids_msg,TotalLogins,TotalDate);
		
		
	}
}