package test;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


import bd.DBStatic;

public class TestMessage {
	public static void main(String[] args) {
		
		try {
			//List<String> messages = new ArrayList<String>();
			MongoClient mongo = bd.MesConnexion.getConnexionMongo();
			MongoDatabase mDB=mongo.getDatabase(DBStatic.ma_base);
			MongoCollection<Document> coll=mDB.getCollection("Comments");
			int id=Integer.parseInt("1720");
			Document query = new Document();
			ObjectId idd= new ObjectId("5c718b3cf8b9170937c63692");
			
			query.append("_id",idd);
			
			MongoCursor<Document> cursor = coll.find(query).iterator();
			while(cursor.hasNext()) {
				Document o = cursor.next();
				String s=o.getString("message"); 
				System.out.println(s);
			}
			mongo.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Erreur de connexion : les messages de l'utilisateur n'ont pas pu être lus");
		}
		
	}
}
