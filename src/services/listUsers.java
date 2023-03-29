package services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

	public class listUsers {

		public static JSONObject listIdsUser() {
		
			List<String> list_id=new ArrayList<String>();
			list_id=tools.UserTools.getIdsUtilsateurs();
			
			if(list_id==null)
				return (ErrorJSON.serviceRefused("Warning arg",-1));
			
			return ErrorJSON.serviceAcceptedUsers(list_id);
		
	}

}
