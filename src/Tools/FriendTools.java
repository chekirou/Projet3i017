package Tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;



import DataBase.DataBase;
import Services.User;

public class FriendTools {
	public static JSONObject listFriends(String login)
	{
		// renvoie un objet JSON avec tout les friends dedans 
		JSONObject obj = new JSONObject();
		List<String> liste = new ArrayList<String>();
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT login2 FROM friendships WHERE login1='" + login + "';";
			ResultSet rs = s.executeQuery(q);
			while (rs.next()) {
				liste.add(rs.getString("login2"));
			}
			obj.put("friends", liste);
			rs.close();
			s.close();
			c.close();

		} catch (SQLException| JSONException e) {

		}	
		return obj;
	}

	public static boolean addfollowing(String follower, String followed) {
		try {
			boolean res;
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DataBase.getMySQLConnection();

			String q = "Insert into friendships values('" + follower + "', '" + followed + "');";
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

	public static boolean unfollow(String myLogin, String hisLogin) {
		
		try {
			boolean res;
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DataBase.getMySQLConnection();

			String q = "Delete from friendships where login1='" + myLogin + "' and login2='" + hisLogin + "';";
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

	public static boolean dejaAmis(String myLogin, String hisLogin) {
		// TODO Auto-generated method stub
		boolean check = false;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM friendships WHERE  login1='" + myLogin + "' and login2='" + hisLogin + "';";
			ResultSet rs = s.executeQuery(q);
			
			if (rs.next()) {
				check = true;
			}
			rs.close();
			s.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		return check;
	}

	public static int countFriends(String login) {
		// TODO Auto-generated method stub
		int i = 0;
		
		List<String> liste = new ArrayList<String>();
		
			Connection c;
			try {
				c = DataBase.getMySQLConnection();
			
			Statement s = c.createStatement();
			String q = "SELECT login2 FROM friendships WHERE login1='" + login + "';";
			ResultSet rs = s.executeQuery(q);
			while (rs.next()) {
				i++;
			}
			rs.close();
			s.close();
			c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		return i;
	}
	public static int countsubs(String login) {
		// TODO Auto-generated method stub
		int i = 0;
		
		List<String> liste = new ArrayList<String>();
		
			Connection c;
			try {
				c = DataBase.getMySQLConnection();
			
			Statement s = c.createStatement();
			String q = "SELECT login2 FROM friendships WHERE login2='" + login + "';";
			ResultSet rs = s.executeQuery(q);
			while (rs.next()) {
				i++;
			}
			rs.close();
			s.close();
			c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		return i;
	}

	public static List<String> listeFollows(String login) {
		// TODO Auto-generated method stub
		// renvoie un objet JSON avec tout les friends dedans 
				List<String> liste = new ArrayList<String>();
				try {
					Connection c = DataBase.getMySQLConnection();
					Statement s = c.createStatement();
					String q = "SELECT login2 FROM friendships WHERE login1='" + login + "';";
					ResultSet rs = s.executeQuery(q);
					while (rs.next()) {
						liste.add(rs.getString("login2"));
					}
					
					rs.close();
					s.close();
					c.close();

				} catch (SQLException e) {

				}	
				return liste;
	}
}
