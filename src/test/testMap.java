package test;


import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import bd.DBStatic;


public class testMap {

	public testMap() {
	}

		
	public static void main(String[] args) {

		
		String map = "function () { var id=this.login; var regex=/bonjour|a/g; var s='bonjour' ; var mess=this.message; var words=mess.match(regex);"
				
						+ "if(words == null){emit(s,0); emit('a',0);}"
						+ "else{"
					
						+"var tf={};" + 
						"for(var i=0; i<words.length; i++){" + 
						"    if(tf[words[i]]==null){" + 
						"	    tf[words[i]]=1;" + 
						"	}else{" + 
						"	    tf[words[i]]=tf[words[i]]+1;" + 
						"	}" + 
						"}"
						
						+ "words = words.filter(function(elem, index, self) {" + 
						"    return index === self.indexOf(elem);" + 
						"});"
						
						+ "for(var i=0; i<words.length;i++){"			
						+ 	"emit(words[i],{ id : tf[words[i]] });"
						+ "}"

						+ "}"
						
					+ "}";

		
		String reduce="function (key,values) {"
				   + " var res=[values.length]; "
					+ "for(var i=0; i<values.length; i++){ "
						+ "res[i]=values[i];"
					+ "}"
					
			+ "return { res}; }" ;
		
		
		/*String reduce="function (key,values) {"
						   + " var res=[values.length]; "
							+ "for(var i=0; i<values.length; i++){ "
								+ "res[i]=values[i];"
							+ "}"
							
							+ "var df=values.length;"
							+ "var N=5;"
							

							+"for(var i=0; i<res.length; i++){"
							+ 	"res[i]=res[i]*Math.log(N/df);"
							+ "}"
							
					+ "return {key : res}; }" ;
		*/
		
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB(DBStatic.ma_base);
		DBCollection coll= db.getCollection("Comments");

		MapReduceCommand cmd = new MapReduceCommand(coll, map, reduce, null, MapReduceCommand.OutputType.INLINE,
				null);

		MapReduceOutput out = coll.mapReduce(cmd);

		for (DBObject o : out.results()) {
			System.out.println(o.toString());
		}
	}

}
