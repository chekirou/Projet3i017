package Tools;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoTools {
	

	public static MongoDatabase getConnexionMongo() {
		com.mongodb.client.MongoClient mongo = MongoClients.create();
		MongoDatabase db = mongo.getDatabase("Chekirou_Leygonie");
		return db;
	}

	

	

	
		
}
