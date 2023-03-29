package test;
import org.json.*;

public class testLoginMain {
	public static void main(String[] args) {
		
		testLogin Login=new testLogin("ouss","azerty");
		String cle=testLogin.generate(32); // simule la cr�ation d'une cl� de 32 caract�re
		JSONObject o=null;
		try {
			o=new JSONObject();
			//j'insere les valeurs des attribut du login dans lobjet json , pour que ces valeurs soit affich�es au format json
			o.put("login", Login.login);
			o.put("mdp", Login.mdp);
			o.put("cle",cle);
			//je regarde si mes valeur ont bien �t� ins�rer dans l'objet
			System.out.println(o.getString("login"));
			System.out.println(o.getString("mdp"));
			System.out.println(o.getString("cle"));
		}catch(JSONException e){
			System.out.println(e); // il y a eu une erreur de la cr�ation d el'objet json 
		}
		
	}
}
