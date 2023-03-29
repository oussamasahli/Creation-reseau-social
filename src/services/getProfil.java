package services;

import org.json.JSONObject;

public class getProfil {

	public static JSONObject Getprofil(String login) {
	
		
		if(login==null)
			return ErrorJSON.serviceRefused("Warning argument",-1); 
		
		String id=tools.UserTools.getId(login);
		String nom=tools.UserTools.getNom(id);
		String prenom=tools.UserTools.getPrenom(id);
		
		
		return ErrorJSON.serviceAcceptedProfil(id,login,nom,prenom);		
		
	}
}
