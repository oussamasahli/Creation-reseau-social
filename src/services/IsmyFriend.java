package services;

import org.json.JSONObject;

public class IsmyFriend {

	public static JSONObject isMyfriend(String id,String cle) {
	
		
		if(id==null || cle==null)
			return ErrorJSON.serviceRefused("Warning argument",-1); 
		
		String myid= tools.UserTools.getIdByCle(cle);
		System.out.println(myid+","+cle+","+id);
		boolean res=tools.FriendTools.isFriend2(myid,id);
		String val=String.valueOf(res);
		return ErrorJSON.serviceAcceptedIsFriend(val);		
		
	}

}
