package test;
import org.json.*;
import java.sql.*;
public class TestAddComMain {
	public static void main(String [] args) {
		
		JSONObject o;
		TestAddCom com= new TestAddCom("cle1","bonjour le monde");
		
		try {
			o=new JSONObject();
			o.put("cle",com.cle);
			o.put("text",com.texte);
			System.out.println(o.getString("cle")); //permet de savoir si lobjet json a �t� cr�� et si les �l�ment souhaite y ont bien �t� ins�r�
			System.out.println(o.getString("text"));
			Timestamp t=new Timestamp(System.currentTimeMillis());
			System.out.println(t);
			
		}catch(JSONException e) {
			System.out.println("Error Json : 100000");
			System.out.println(e);
			
		}
	}
}
