package Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mysql.jdbc.Connection;

import DataBase.DataBase;

public class MessageTools {
	public static boolean addMessage(int id, String login, String message) {
		MongoDatabase mb = MongoTools.getConnexionMongo();
		MongoCollection<Document> mc = mb.getCollection("Messages");
		Document d = new Document();
		d.append("author_id", id);
		d.append("author_name", login);
		d.append("message", message);
		mc.insertOne(d);
		return true;

	}
	public static JSONObject listMessages(int id) {
		JSONObject obj = new JSONObject();
		try
		{
		MongoDatabase db = MongoTools.getConnexionMongo();
		MongoCollection<Document> mc = db.getCollection("Messages");
		Document d = new Document();
		
		d.append("author_id", id);
		MongoCursor<Document> cursor = mc.find(d).iterator();

		while (cursor.hasNext()) {

			Document ok = cursor.next();
			obj.put(ok.getString("author_name"), ok.getString("message"));
			System.out.println(ok);
		}
		}catch(JSONException e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	public static void deleteMessage(String id_message)
	{
		MongoDatabase db = MongoTools.getConnexionMongo();
		MongoCollection<Document> mc = db.getCollection("Messages");
		Document d = new Document();
		d.append("_id",new ObjectId(id_message));
		mc.deleteOne(d);
		
	}
	

	/*public static boolean existsMessage(String id_message) {
		// TODO Auto-generated method stub
		boolean userExists = false;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM  WHERE _id='" + new ObjectId(id_message) + "';";
			ResultSet rs = s.executeQuery(q);
			userExists = false;
			if (rs.next()) {
				userExists = true;
			}

		} catch (SQLException e) {

		}
		return userExists;
		return false;
	}*/
}
