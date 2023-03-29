package bd;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//un database va me permmettre d'instancier un Dtasource et d'en r�cuperer ses connections � la BD

public class Database {
	//on va essayer de g�rer les connexion
		//une connexion � une base de donn�e est une ressource tr�s co�teuse
		//quand faut-il ouvrir et fermer une connexion ?
		//faut til garder une connexion ouverte entre deux utilisations de la base ?
		//Lorsque le client n'a plus besoin de la connexion , il apelle la methode close
		//qui la restitue au pool(la connexion n'est pas ferm� --> L'appel � la m�thode Connection.close() ne ferme pas vraiment la connexion
	    //avec la base de donn�es mais la lib�re pour qu'elle retourne dans le pool.)
		//le pool est fournit par une source de donn�e de type DataSource
		//le Datasource peut etre vu comme une base de donn�e repr�senter par un fichier texte
		//contenant les connections ant�rieur des clients
	
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
