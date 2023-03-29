package services;
import org.json.*;

public class setProfil {
	public static JSONObject Setprofil(String cle) {
		
		//Verif si la cle est null
		if(cle==null)
			return ErrorJSON.serviceRefused("Warning argument",-1); // on appelle la methode service Refused de la classe ErrorJSON
		
		//verifier si la clé existe dans la base dedonnée
		//appel la méthode setProfil(String cle ) de la class UserTools qui modifie le profil de l'utilisateur associé à cette clé
		
		
		return ErrorJSON.serviceAccepted();		
		
	}
}
