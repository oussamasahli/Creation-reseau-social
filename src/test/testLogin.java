package test;
//import java.util.Hashtable;
//import java.util.Set;
//import java.util.Iterator;

public class testLogin {
	
	//on va shématiser la base de donnée , on va utiliser des hashtables (clé:valeur) --> (login:id_user)
	//Hashtable <String,String> h=  new Hashtable<String,String>();
	
	
	// classe test login mettant en scène le comportement attendue du servlet loggin
	// je les mets en public pour eviter de faire des getteur , de toute facon cest juste des tests
	public String login,mdp;
	
	public testLogin(String login,String mdp) {
		this.login=login;
		this.mdp=mdp;
	}
	
	//on simule l'action d'aller interroger la base de donnée pour récupérer l'id de l'utilisateur
	
	/*public static String getUser(String log) {
		//on parcourt la hashtable à la recherche du login , et sa valeur l'id de l'utilisateur
		int i=0;// pour récupérer l'index associé à la veleur du login trouvé
		//je stocke l'ensemble des clé de la hashtable dans un ensempble
		//j'associe mon ensemble à un iterateur
		// de cette manière je oeux récupérer ma clé qui représente la valeur de mon id
		Set keys= Hashtable.KeySet();
		
		for(String s: h) {
			if(s==log)
				return h.get
		}
	}*/
	
	
	//génère une chaine aléatoire --> pour provoquer la création d'une clé
		public static String generate(int length)
		{
			    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
			    String pass = "";
			    for(int x=0;x<length;x++)
			    {
			       int i = (int)Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
			       pass += chars.charAt(i);
			    }
			    //System.out.println(pass);
			    return pass;
		}
	
}
