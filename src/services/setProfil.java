package services;
import org.json.*;

public class setProfil {
	public static JSONObject Setprofil(String cle) {
		
		//Verif si la cle est null
		if(cle==null)
			return ErrorJSON.serviceRefused("Warning argument",-1); // on appelle la methode service Refused de la classe ErrorJSON
		
		//verifier si la cl� existe dans la base dedonn�e
		//appel la m�thode setProfil(String cle ) de la class UserTools qui modifie le profil de l'utilisateur associ� � cette cl�
		
		
		return ErrorJSON.serviceAccepted();		
		
	}
}
