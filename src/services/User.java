package services;

import org.json.JSONObject;

public class User {
	//je définit ici mon service create user
	//un utilisateur est définit par son nom et son prénom, login et mot de passe
	// je déclare ma méthode en static , pour pourvoir la réutiliser sans créer une instance de cette classe
	public static JSONObject createUser(String nom, String prenom, String login,String mdp) {
	
	//le type de id est String car si id est un int on ne peut pas le comparer à null
	//ce service génère un objet json permettant d'afficher les données représentatif de l'utilisateur au format json
	//l'objet json sera crée par l'appel à la fonction service refused
		
	//1- vérification arguments non null
		if((nom==null) || (prenom==null) || (login==null) || (mdp==null) )
			return (ErrorJSON.serviceRefused("Wrong Argument",-1));
		
	//2- vérification si user existant 
		if(tools.UserTools.isUser2(login))
			return (ErrorJSON.serviceRefused("Error SQL: User already exist",1000));
		
		
	//3- Insert dans la base de données 
		if(!tools.UserTools.insertUser2(login,mdp,prenom,nom))
			return (ErrorJSON.serviceRefused("Error Sql: insert dosent make",1000));
		
		//la sortit affiché est vide , donc il est inutile de faire passer des attribut à cet fontion
		return (ErrorJSON.serviceAccepted());
	
}

}
