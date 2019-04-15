package Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mysql.jdbc.Connection;

import DataBase.DataBase;

public class MessageTools {
	public static boolean addMessage(int id, String login, String message, Date date) {
		MongoDatabase mb = MongoTools.getConnexionMongo();
		MongoCollection<Document> mc = mb.getCollection("Messages");
		Document d = new Document();
		d.append("author_id", id);
		d.append("author_name", login);
		d.append("message", message);
		d.append("date", date);
		mc.insertOne(d);
		return true;

	}

	public static List<Document> listMessages(int id) {
		List<Document> liste = new ArrayList<>();
		
			MongoDatabase db = MongoTools.getConnexionMongo();
			MongoCollection<Document> mc = db.getCollection("Messages");
			Document d = new Document();

			d.append("author_id", id);
			FindIterable <Document> f = mc.find(new Document("author_id", id)).sort(new Document("date", -1));
			MongoCursor<Document> cursor = f.iterator();
			while (cursor.hasNext()) {

				liste.add(cursor.next());
			}
		
		return liste;
	}

	public static void deleteMessage(String id_message) {
		MongoDatabase db = MongoTools.getConnexionMongo();
		MongoCollection<Document> mc = db.getCollection("Messages");
		Document d = new Document();
		d.append("_id", new ObjectId(id_message));
		mc.deleteOne(d);

	}

	public static int countMessages(int id) {
		// TODO Auto-generated method stub
		int i=0;
		JSONObject obj = new JSONObject();
		try {
			MongoDatabase db = MongoTools.getConnexionMongo();
			MongoCollection<Document> mc = db.getCollection("Messages");
			Document d = new Document();

			d.append("author_id", id);
			MongoCursor<Document> cursor = mc.find(d).iterator();

			while (cursor.hasNext()) {

				Document ok = cursor.next();
				JSONObject o = new JSONObject();
				o.append("message", ok.getString("message"));
				o.append("name", ok.getString("author_name"));
				o.append("date", ok.getDate("date"));
				obj.append(ok.getString("author_name"), o);
				i++;
				System.out.println(i);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static List<Document> listMixMessages(List<String> listeFriends) {
		// TODO Auto-generated method stub
		List<Document> liste = new ArrayList<>();
		JSONObject obj = new JSONObject();
		
			MongoDatabase db = MongoTools.getConnexionMongo();
			MongoCollection<Document> mc = db.getCollection("Messages");
			
			Document d = new Document();
			
			FindIterable <Document> f = mc.find(new Document("author_name", new Document("$in", listeFriends))).sort(new Document("date", -1));
			MongoCursor<Document> cursor = f.iterator();
			while (cursor.hasNext()) {
				liste.add(cursor.next());
			}
			
			
			
		
		return liste;
	}

	/*
	 * public static boolean existsMessage(String id_message) { // TODO
	 * Auto-generated method stub boolean userExists = false; try { Connection c =
	 * DataBase.getMySQLConnection(); Statement s = c.createStatement(); String q =
	 * "SELECT * FROM  WHERE _id='" + new ObjectId(id_message) + "';"; ResultSet rs
	 * = s.executeQuery(q); userExists = false; if (rs.next()) { userExists = true;
	 * }
	 * 
	 * } catch (SQLException e) {
	 * 
	 * } return userExists; return false; }
	 */
}
