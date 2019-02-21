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

	public static void addMessage(int id, String login, String message) {
		MongoDatabase mb = getConnexionMongo();
		MongoCollection<Document> mc = mb.getCollection("Messages");
		Document d = new Document();
		d.append("author_id", id);
		d.append("author_name", login);
		d.append("message", message);
		mc.insertOne(d);

	}

	public static void listMessages(int id) {

		MongoDatabase db = getConnexionMongo();
		MongoCollection<Document> mc = db.getCollection("Messages");
		Document d = new Document();
		d.append("author_id", id);
		MongoCursor<Document> cursor = mc.find(d).iterator();

		while (cursor.hasNext()) {

			Document ok = cursor.next();
			System.out.println(ok);
		}
	}

	public static void deleteMessage(int id_message)
	{
		MongoDatabase db = getConnexionMongo();
		MongoCollection<Document> mc = db.getCollection("Messages");
		Document d = new Document();
		d.append("_id",id_message);
		mc.deleteOne(d);
		
	}
		

	public static void main(String[] args) {
		MongoTools.addMessage(150, "chekirou", "coucou");
		MongoTools.addMessage(151, "Leygonie", "hello");
		System.out.println("suppression");
		MongoTools.deleteMessage(0);
		
		
		
	}
}
