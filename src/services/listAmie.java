package services;
import java.util.ArrayList;
import java.util.List;

import org.json.*;
//import java.io.IOException;
//import tools.UserTools;

public class listAmie {
	
	public static JSONArray listAmies(String id) {

		if(id==null)
			return (ErrorJSON.serviceRefusedAmies("Warning arg",-1));
	
		List<String> mes_amies=new ArrayList<String>();
		mes_amies=tools.FriendTools.getAmies(id);
		
		List<String> noms=new ArrayList<String>();
		List<String> prenoms=new ArrayList<String>();
		List<String> logins=new ArrayList<String>();
		
		for(String idd: mes_amies) {
			noms.add(tools.UserTools.getNom(idd));
			prenoms.add(tools.UserTools.getPrenom(idd));
			logins.add(tools.UserTools.getLogins(idd));
		}
		
		return ErrorJSON.serviceAcceptedAmies(mes_amies,noms,prenoms,logins);
	
	}
}
