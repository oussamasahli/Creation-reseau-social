package services;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Maptest {

	public static JSONArray MapTest(String map,String reduce) {
	
		
		List<String> liste= tools.CommentTools.getResMap(map,reduce);
		
		return ErrorJSON.serviceAcceptedMap(liste);
		
	}

}
