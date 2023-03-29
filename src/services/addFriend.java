package services;
import org.json.*;
import services.ErrorJSON;

public class addFriend {

	public static JSONObject Addfriend(String cle,String id_friend) {
		
		//Verifie si les paramettre ne sont pas null
		if((cle==null) || (id_friend==null))
			return ErrorJSON.serviceRefused("Warning argument",-1);
		
		//V�rifie si l'id de lami existe dans la base de donn�e --> userExist(id_friend)
		if(!tools.UserTools.userExist(id_friend))
			return (ErrorJSON.serviceRefused("Error SQL: user dont exist",1000));
		
		//V�rifie si la cl� fait r�f�rence � un utilisteur (rappel : la cl� est g�n�r� quand un uutilisateur se connect)
		//cleExist(cle)
		if(!tools.UserTools.keyExist(cle))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		//V�rifier si cet ami est d�j� dans la liste d'ami de user avant de l'ajouter
		//boolean is_ami= isFriend(cle,id_friend) --> v�rifie si l'ami fait partie de la liste d'ami de l'utilisateur
		
		if(tools.FriendTools.isFriend(cle,id_friend))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		//On sait quon peut lajouter en tant qu'ami
		if(!tools.FriendTools.addFriend(cle,id_friend))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		
		return ErrorJSON.serviceAccepted();
		
		
	}
}
