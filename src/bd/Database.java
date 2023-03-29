package bd;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//un database va me permmettre d'instancier un Dtasource et d'en récuperer ses connections à la BD

public class Database {
	//on va essayer de gérer les connexion
		//une connexion à une base de donnée est une ressource très coûteuse
		//quand faut-il ouvrir et fermer une connexion ?
		//faut til garder une connexion ouverte entre deux utilisations de la base ?
		//Lorsque le client n'a plus besoin de la connexion , il apelle la methode close
		//qui la restitue au pool(la connexion n'est pas fermé --> L'appel à la méthode Connection.close() ne ferme pas vraiment la connexion
	    //avec la base de données mais la libère pour qu'elle retourne dans le pool.)
		//le pool est fournit par une source de donnée de type DataSource
		//le Datasource peut etre vu comme une base de donnée représenter par un fichier texte
		//contenant les connections antérieur des clients
	
	private DataSource dataSource;
	
	public Database(String jndiname) throws SQLException {
		//Le constructeur de la classe DataBase instancie le dataSource 
		//le datasource contiendra un ensemble de connection
		//ces connections sont accessible vie la methode getConnection du dataSource
		
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/"+jndiname);
		}catch (NamingException e){
			throw new SQLException(jndiname +" is missing in JNDI:"+ e.getMessage());
		}
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	
}
