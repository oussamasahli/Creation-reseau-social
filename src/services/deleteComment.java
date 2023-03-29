package services;

//import org.json.JSONObject;
import org.json.*;

public class deleteComment {
	public static JSONObject delComment(String id_user,String id_message) {
			
			//Verifie si les paramettre ne sont pas null   , l'id du message fait référence à la clé du message
			if((id_user==null) || (id_message==null))
				return ErrorJSON.serviceRefused("Warning argument",-1);
			
			//Verification --> estceque le message existe --> boolean is_mess= messageExist(id_message)
			
			if(!tools.CommentTools.messageExist(id_message)) 
				return ErrorJSON.serviceRefused("Mongo error",10000);
			
			//Verification --> estceque l'utilisateur existe, boolean is_user=userExist(id_user)
			
			if(!tools.UserTools.userExist(id_user))
				return ErrorJSON.serviceRefused("SQL error",1000);
						
			//Verification --> esct que le message appartient à cet utilisateur  ,boolean is_him= belongTo(id_user,id_message)
			
			if(!tools.CommentTools.belongTo(id_user,id_message))
				return ErrorJSON.serviceRefused("Error Mongo", 10000);
			
			//appelle de la fonction deleteMessage(id_message) qui supprime le message dans MongoDbs*
			if(!tools.CommentTools.deleteMessage(id_message))
				return ErrorJSON.serviceRefused("Error Mongo", 10000);
						
			return ErrorJSON.serviceAccepted();
			
			
		}
}
