package test;
import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import bd.DBStatic;

public class ConnexionMongo {
	public static void main(String [] args) {
		
	try {
		com.mongodb.client.MongoClient mongo = MongoClients.create(DBStatic.mongo_bd);
		MongoDatabase mDB= mongo.getDatabase(DBStatic.ma_base); //la base est automatiquement créé si elle n'existe pas 
		System.out.println("la connexion a mongo ok ");
		//BasicDBObject est remplacé par "Document" : 
		Document  query = new Document ();
		query.append("user_id", 1);
		MongoCollection<Document> coll=mDB.getCollection("acteur");
		//mDB.coll.insert(query);
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("La connexion n'a pas marché\n");
	}
	
	}

}
