package test;
import org.json.*;
//import java.io.IOException;
import org.json.JSONException;
import test.TestLogout;

public class TestLogoutMain {
	public static void main(String[] args) {
		
		TestLogout logout=new TestLogout("mapremiereclé");
		JSONObject o=null;
		
		try {
			o=new JSONObject();
			o.put("cle",logout.cle);
			System.out.println(o.getString("cle")); // ca me permet de voir si mon objet json a été créé et si la valeur de cle y a été inséré
		}catch(JSONException e){
			System.out.println(e);
		}
		
	}
}
