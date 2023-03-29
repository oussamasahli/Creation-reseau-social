package services;

import org.json.JSONObject;

public class removeFriend {
	
public static JSONObject Removefriend(String cle,String id_friend) {
		
		//Verifie si les paramettre ne sont pas null
		if((cle==null) || (id_friend==null))
			return ErrorJSON.serviceRefused("Warning argument",-1);
		
		//V�rifie si l'id de lami existe dans la base de donn�e
		if(!tools.UserTools.userExist(id_friend))
			return (ErrorJSON.serviceRefused("Error SQL: user dont exist",1000));
		
		//V�rifie si la cl� fait r�f�rence� un utilisteur (rappel : la cl� est g�n�r� quand un uutilisateur se connect)
		if(!tools.UserTools.keyExist(cle))
			return ErrorJSON.serviceRefused("SQL error", 1000);

		//V�rifier si cet ami est  dans la liste d'ami de user avant de le supprimer
				//boolean is_ami= isFriend(cle,id_friend) --> v�rifie si l'ami fait partie de la liste d'ami de l'utilisateur
				
		if(!tools.FriendTools.isFriend(cle,id_friend))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		//Supprime l'amie de la liste des amies de lutilisateur dans la base de donn�es
		if(!tools.FriendTools.removeFriend(cle,id_friend))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		return ErrorJSON.serviceAccepted();
		
		
	}
}
