package test;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import bd.DBStatic;

public class TestcoMongo {

	public static void main(String [] args) {
	try {
		/**** Connect to MongoDB ****/ 
	     MongoClientURI mgURI = new MongoClientURI(DBStatic.mongo_bd); 
	     MongoClient mongo = new MongoClient(mgURI); 
	     /**** Get database ****/ 

	     MongoDatabase dataBase = mongo.getDatabase(DBStatic.ma_base); 
	     MongoCollection<Document> userCollection = dataBase.getCollection("CollectionName"); 
	     Document document = new Document(); 
	     document.put("key1", "john"); 
	     document.put("key2", "billy"); 
	     // insert into database 
	     userCollection.insertOne(document);
	     System.out.println("La connexion est ok");
	     mongo.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
		System.out.println("laa connexion a mongo a echoue");
	}
	}
}
