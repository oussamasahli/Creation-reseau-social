package bd;


import com.mongodb.client.MongoClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mongodb.client.MongoClients;


import bd.DBStatic;

//cette classe s'occupe de g�n�rer des connexion

public class MesConnexion {
	
	private static Database database=null;
	
	public MesConnexion(Database db) {
		database=db;
	}
	
//cette m�thode renvoie une connexion � une base de donn�e
	//si on utilise la m�thode du pooling( --> vu comme une boite de connexions)
	//alors on genere un datasource � partir de l'objet database cr��
	//si au contraire on n'utilise pas la m�thode de pooling , alors on cr�e 
	//une nouvelle connexion avec le driverManager
	
	//cette methode est static , on a pas besoin de cr�er une instance de la classe mes connexion pour l'utiliser
	
	public static Connection getMySqlConnection() throws SQLException{
		if(DBStatic.mysql_pooling==false) {
			return (DriverManager.getConnection("jdbc:mysql://" + DBStatic.mysqlHost+"/" +
		DBStatic.mysqlDB,DBStatic.mysqlUser,DBStatic.mysqlPasswd));
		}
		//sinon
		if(database==null) {
			database=new Database("jdbc/db");
		}
		return(database.getConnection());
		//ca cera le datasource cr�e dans ce database qui g�n�rera la connexion
	
	
	}
	
	
	
	

//Methode qui renvoie une connexion  à MongoDB 
	

	public static MongoClient getConnexionMongo() throws Exception{
			
		try {
			com.mongodb.client.MongoClient mongo = MongoClients.create(DBStatic.mongo_bd);
			return mongo;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("La connexion à MongoDB n'a pas marché\n");
			return null;
		}
		
	}

	
	
}
