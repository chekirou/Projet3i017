package Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.sql.Connection;

import DataBase.DataBase;

public class UserTools {
	public static JSONObject ajout_base(String nom, String prenom, String login, String password, String sexe,
			String date_naissance, String email) {
		JSONObject obj = new JSONObject();
		try {
			boolean res;
			
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DataBase.getMySQLConnection();

			String q = "Insert into Users values(null, '" + login + "', PASSWORD('" + password + "'), '" + prenom
					+ "', '" + nom + "', '" + sexe + "','" + date_naissance + "','" + email + "');";
			Statement s = c.createStatement();
			int rs = s.executeUpdate(q);
			s.close();
			c.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				obj.put("error", e.getMessage());
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return obj;
		}

	}



	public static boolean existsUser(String login) {
		boolean userExists = false;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM Users WHERE login='" + login + "';";
			ResultSet rs = s.executeQuery(q);
			userExists = false;
			if (rs.next()) {
				userExists = true;
			}
			rs.close();
			c.close();
			s.close();

		} catch (SQLException e) {

		}
		return userExists;
	}

	public static boolean correctPassword(String login, String pass) {
		boolean userExists = false;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM Users WHERE login='" + login + "' and password=PASSWORD('"+ pass +"');";
			ResultSet rs = s.executeQuery(q);
			userExists = false;
			if (rs.next()) {
				userExists = true;
			}
			rs.close();
			s.close();
			c.close();

		} catch (SQLException e) {

		}
		return userExists;
	}

	public static boolean keyLogin(String login, String key) {
		boolean check = false;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM Session WHERE login='" + login + "' and clef='"+ key +"' ;";
			ResultSet rs = s.executeQuery(q);
			
			if (rs.next()) {
				check = true;
			}
			s.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		if(check)
		{
			check = ServiceTools.checkdate(login, key);
		}
		
		return check;
	}


	public static boolean addSession(String login, String clef) {
		// TODO Auto-generated method stub
		try {
			boolean res;
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DataBase.getMySQLConnection();
			String q = "Insert into Session values('" + login + "', '" + clef + "', now() ' );";
			Statement s = c.createStatement();
			int rs = s.executeUpdate(q);
			s.close();
			c.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean deleteSession(String login, String key) {

		try {
			boolean res;
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DataBase.getMySQLConnection();

			String q = "Delete from Session where login='" + login + "' and clef='" + key + "';";
			Statement s = c.createStatement();
			int rs = s.executeUpdate(q);
			s.close();
			c.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static JSONObject InfoUsers(String login) {
		JSONObject obj = new JSONObject();
		List<String> liste = new ArrayList<String>();
			try {
				Connection c = DataBase.getMySQLConnection();
				Statement s = c.createStatement();
				String q = "SELECT nom, prenom, genre, DOB, email FROM Users WHERE login='" + login + "';";
				ResultSet rs = s.executeQuery(q);

				while (rs.next()) {
					liste.add(rs.getString("nom"));
					liste.add(rs.getString("prenom"));
					liste.add(rs.getString("genre"));
					liste.add(rs.getString("DOB"));
					liste.add(rs.getString("email"));
				}
				obj.put("infos", liste);
				rs.close();
				c.close();
				s.close();

			} catch (SQLException| JSONException e) {

			}	
			return obj;
		}
			
	

	

}
