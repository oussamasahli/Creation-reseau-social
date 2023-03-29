package services;

import org.json.JSONObject;

public class SearchFriend {
public static JSONObject searchFriend(String id_user,String id_friend) {
		
		
		if((id_user==null)||(id_friend==null))
			return ErrorJSON.serviceRefused("Warning argument",-1); // on appelle la methode service Refused de la classe ErrorJSON
		
		//Verification si les utisateur existent --> pour id_user et id_frieend
		if(!tools.UserTools.userExist(id_friend))
			return (ErrorJSON.serviceRefused("Error SQL: user dont exist",1000));
		
		if(!tools.UserTools.userExist(id_user))
			return (ErrorJSON.serviceRefused("Error SQL: user dont exist",1000));
		
		//verif si l'ami fait partie des mais de l'utilisateur
		if(!tools.FriendTools.isFriend2(id_user,id_friend))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		//on verra si on adapte la sortit
		
		return ErrorJSON.serviceAccepted();		
		
	}
}
