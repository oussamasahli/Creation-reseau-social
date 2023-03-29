package services;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.*;



public class ErrorJSON {
	//Vu que les service nont pas tous les m�me sorties lorsqu'il sont accept� , jai d�cid� de red�finir la m�thode serviceAccepted
	//De cette facon la methode ServiceAccepted prendra en param�tre les valeurs des parametre � afficher en sortie au format json
	
	//retourne un objet json avec un message d'erreur si le service recoit de mauvais parametre
	public static JSONObject serviceRefused(String message,int coderr){
		JSONObject o =null;
		try {
			o=new JSONObject();
			o.put("message",message);
			o.put("code", coderr);
			return o;
		}catch(JSONException ex) {
			System.out.println("ErrorJson : 100000"); //les erreurs json surviennent quand lojbet json na pas pu etre cr�e correctement
			System.out.println(ex);
		}
		
		return o;
		
	}
	
	//on utilisera cette version de serviceAccepted lorsquil ne sera pas n�cessaire d'afficher quelque chose en sortie 
	//c-a-d lorsque le service qui appelle cette methode , le fait sans passer de param�tres
	
	public static JSONObject serviceAccepted() {
		JSONObject o=null;
		//pour l'instant je teste , dont j'ecris ok pour dire que mon service a fonctionn�
		try {
			o=new JSONObject();
			o.put("etat","ok");
			o.put("code", 200);
			return o;
		}catch(JSONException e) {
			System.out.println("ErrorJson : 100000"); //les erreurs json surviennent quand lojbet json na pas pu etre cr�e correctement
			System.out.println(e);
		}
		
		return o;
	}
	
	
	
	
//Red�finition du service Accepted pour le login 	
	
	
	
	public static JSONObject serviceAcceptedLogin(int id, String login, String cle) {
		
		JSONObject o=null;
		try {
			o=new JSONObject();
			o.put("id", id);
			o.put("login", login);
			o.put("cle", cle);
			o.put("code", 200);
		}catch(JSONException e) {
			System.out.println("ErrorJson : 100000"); //les erreurs json surviennent quand lojbet json na pas pu etre cr�e correctement
			System.out.println(e);
		}
		
		return o;
	}

	
	
//Red�finition du service accepted pour listMessage --> renvoie un objet Json affichant tous les commentaire contenue dans la liste l
	
	public static JSONObject  getMessageJson(ObjectId Object_id, String msg,String login){
		JSONObject message=null;
		try {
		   message = new JSONObject();
		   message.put("Object_id", Object_id);
		   message.put("message", msg);
		   message.put("login", login);
		   return message;
		}catch(Exception e) {
			System.out.println("erreur dans la fonction getMessageJson");
		}
		return message;
    } 
	
	
	public static JSONArray serviceAcceptedComment(List<String> l,List<ObjectId> ob,List<String> logins,List<String> dates) {
		JSONArray monTableau=null;
		JSONObject o =null;
		JSONObject mon_message=null;
		
		try {
			int j=0;
			int i=0;
			o=new JSONObject();
			o.put("code", 200);
			monTableau = new JSONArray();
			monTableau.put(o);
			
			for(i=0;i<l.size();i++) {
				mon_message=new JSONObject();
				mon_message.put("message",l.get(i));
				mon_message.put("Object_id",ob.get(i));
				mon_message.put("login",logins.get(i));
				mon_message.put("date",dates.get(i));
				monTableau.put(mon_message);
				j++;
			}
			
		}catch(Exception e) {
			System.out.println("ErreurJson : 100000");
			System.out.println(e.getMessage());
		}
		
		return monTableau;
	}
	
	
	
	
	public static JSONArray serviceRefusedComment(String message,int coderr){
		JSONObject o =null;
		JSONArray tab=null;
		try {
			o=new JSONObject();
			tab= new JSONArray();
			o.put("message",message);
			o.put("code", coderr);
			tab.put(o);
			return tab;
		}catch(JSONException ex) {
			System.out.println("ErrorJson : 100000"); //les erreurs json surviennent quand lojbet json na pas pu etre cr�e correctement
			System.out.println(ex);
		}
		
		return tab;
		
	}
	
	
	
	public static JSONArray  serviceAcceptedAmies(List<String> liste_amies, List<String> noms, List<String> prenoms,List<String> logins){
		JSONArray monTableau=null;
		JSONObject o =null;
		JSONObject mon_message=null;
		
		try {
			
			int j=0;
			int i=0;
			o=new JSONObject();
			o.put("code", 200);
			monTableau = new JSONArray();
			monTableau.put(o);
			
			for(i=0;i<liste_amies.size();i++) {
				mon_message=new JSONObject();
				mon_message.put("id",liste_amies.get(i));
				mon_message.put("nom",noms.get(i));
				mon_message.put("prenom",prenoms.get(i));
				mon_message.put("login",logins.get(i));
				monTableau.put(mon_message);
				j++;
			}
			
			return monTableau;
			
		}catch(Exception e) {
			System.out.println("erreur dans la fonction serviceAcceptedAmies");
		}
		return monTableau;
    } 
	
	
	
	
	public static JSONArray serviceRefusedAmies(String message,int coderr){
		JSONObject o =null;
		JSONArray tab=null;
		try {
			o=new JSONObject();
			tab= new JSONArray();
			o.put("message",message);
			o.put("code", coderr);
			tab.put(o);
			return tab;
		}catch(JSONException ex) {
			System.out.println("ErrorJson : 100000");
			System.out.println(ex);
		}
		
		return tab;
		
	}
	
	
	
	
	
	
	public static JSONObject  serviceAcceptedMessage(String id_msg, String login, String date){
		JSONObject o=null;
		try {
		   o = new JSONObject();
		   o.put("code", 200);
		   o.put("id_msg",id_msg);
		   o.put("login",login);
		   o.put("date",date);
		   return o;
		}catch(Exception e) {
			System.out.println("erreur dans la fonction getMessageJson");
		}
		return o;
    } 
	
	
	public static JSONObject  serviceAcceptedUsers(List<String> list_id){
		JSONObject o=null;
		try {
		   o = new JSONObject();
		   String res = String.join(",", list_id);
		   o.put("liste_id", res);
		   return o;
		}catch(Exception e) {
			System.out.println("erreur dans la fonction serviceAcceptedUsers");
		}
		return o;
    } 
	
	
	
	
	public static JSONObject  serviceAcceptedProfil(String id, String login, String nom, String prenom){
		JSONObject o=null;
		try {
		   o = new JSONObject();
		   o.put("id",id);
		   o.put("login",login);
		   o.put("nom",nom);
		   o.put("prenom",prenom);
		   return o;
		}catch(Exception e) {
			System.out.println("erreur dans la fonction serviceAcceptedProfil");
		}
		return o;
    } 
	
	
	
	public static JSONObject serviceAcceptedIsFriend(String res){
		JSONObject o=null;
		try {
		   o = new JSONObject();
		   o.put("isfriend",res);
		}catch(Exception e) {
			System.out.println("erreur dans la fonction serviceAcceptedIsfriend");
		}
		return o;
    } 
	

	public static JSONArray serviceAcceptedMap(List<String> liste){
		JSONObject o =null;
		JSONArray monTableau=null;
		try {

			int j=0;
			int i=0;
			o=new JSONObject();
			o.put("code", 200);
			monTableau = new JSONArray();
			monTableau.put(o);
			JSONObject elem =null;
			
			for(i=0;i<liste.size();i++) {
				elem=new JSONObject();
				elem.put("retour",liste.get(i));
				monTableau.put(elem);
				j++;
			}
			
			return monTableau;
		}catch(JSONException ex) {
			System.out.println("ErrorJson : 100000");
			System.out.println(ex);
		}
		
		return monTableau;
		
	}
	
	
	
}