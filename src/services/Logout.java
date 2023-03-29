package services;
import org.json.*;
import services.ErrorJSON;

public class Logout {
	
	public static JSONObject logout(String cle) {
		//prend en entrée une clé , cette clé a été généré par le login
		//ici on se contente de générer une clé aléatoirement
		//mais on pourra vérifier si cette clé existe , c'est à dire si elle est associé à la création d'un loggin
		//car on rappele qu'à la création d'un loggin on a la génération d'une clé
		//en -1) on teste si la valeur des paramètres est null , cest à dire si rien n'a été passé en valeur dans la query string
		if(cle==null)
			return ErrorJSON.serviceRefused("Warning argument",-1); // on appelle la methode service Refused de la classe ErrorJSON
		
		//-on peut supposer faire un test sur l'existance de cette clé , à savoir si elle est associé à une clé qui a été généré lors de la création d'un login
		//du style regarder dans la base de donnée si cette clé existe
		//si la clé n'existe pas dans la base de données sql 
		//on genère un seviceRefused("SQLerror",100);
		
		if(!tools.UserTools.keyExist(cle))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		//je crois que enfait il faut généré une clé uniquement quand on se logue, et apres on supprime cette clé quand on se logout
		if(!tools.UserTools.closeSession(cle))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		
		return ErrorJSON.serviceAccepted();
		
		
	}
}
