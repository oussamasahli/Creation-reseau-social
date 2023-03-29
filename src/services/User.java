package services;

import org.json.JSONObject;

public class User {
	//je d�finit ici mon service create user
	//un utilisateur est d�finit par son nom et son pr�nom, login et mot de passe
	// je d�clare ma m�thode en static , pour pourvoir la r�utiliser sans cr�er une instance de cette classe
	public static JSONObject createUser(String nom, String prenom, String login,String mdp) {
	
	//le type de id est String car si id est un int on ne peut pas le comparer � null
	//ce service g�n�re un objet json permettant d'afficher les donn�es repr�sentatif de l'utilisateur au format json
	//l'objet json sera cr�e par l'appel � la fonction service refused
		
	//1- v�rification arguments non null
		if((nom==null) || (prenom==null) || (login==null) || (mdp==null) )
			return (ErrorJSON.serviceRefused("Wrong Argument",-1));
		
	//2- v�rification si user existant 
		if(tools.UserTools.isUser2(login))
			return (ErrorJSON.serviceRefused("Error SQL: User already exist",1000));
		
		
	//3- Insert dans la base de donn�es 
		if(!tools.UserTools.insertUser2(login,mdp,prenom,nom))
			return (ErrorJSON.serviceRefused("Error Sql: insert dosent make",1000));
		
		//la sortit affich� est vide , donc il est inutile de faire passer des attribut � cet fontion
		return (ErrorJSON.serviceAccepted());
	
}

}
