package services;
import org.json.*;
import services.ErrorJSON;

public class Logout {
	
	public static JSONObject logout(String cle) {
		//prend en entr�e une cl� , cette cl� a �t� g�n�r� par le login
		//ici on se contente de g�n�rer une cl� al�atoirement
		//mais on pourra v�rifier si cette cl� existe , c'est � dire si elle est associ� � la cr�ation d'un loggin
		//car on rappele qu'� la cr�ation d'un loggin on a la g�n�ration d'une cl�
		//en -1) on teste si la valeur des param�tres est null , cest � dire si rien n'a �t� pass� en valeur dans la query string
		if(cle==null)
			return ErrorJSON.serviceRefused("Warning argument",-1); // on appelle la methode service Refused de la classe ErrorJSON
		
		//-on peut supposer faire un test sur l'existance de cette cl� , � savoir si elle est associ� � une cl� qui a �t� g�n�r� lors de la cr�ation d'un login
		//du style regarder dans la base de donn�e si cette cl� existe
		//si la cl� n'existe pas dans la base de donn�es sql 
		//on gen�re un seviceRefused("SQLerror",100);
		
		if(!tools.UserTools.keyExist(cle))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		//je crois que enfait il faut g�n�r� une cl� uniquement quand on se logue, et apres on supprime cette cl� quand on se logout
		if(!tools.UserTools.closeSession(cle))
			return ErrorJSON.serviceRefused("SQL error", 1000);
		
		
		return ErrorJSON.serviceAccepted();
		
		
	}
}
