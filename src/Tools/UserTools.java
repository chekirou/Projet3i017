package Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import DataBase.DataBase;

public class UserTools {
	public static boolean ajout_base(String nom, String prenom, String login, String password, String sexe,
			String date_naissance, String email) {

		try {
			boolean res;
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DataBase.getMySQLConnection();

			String q = "Insert into Users values(null, '" + login + "', PASSWORD('" + password + "'), '" + prenom
					+ "', '" + nom + "', '" + sexe + "','" + date_naissance + "','" + email + "'));";
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

	public static boolean checkPassword(String password) {
		return true;

	}

	public static boolean existsUser(String login) {
		boolean userExists = false;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM user WHERE user_login='" + login + "';";
			ResultSet rs = s.executeQuery(q);
			userExists = false;
			if (rs.next()) {
				userExists = true;
			}

		} catch (SQLException e) {

		}
		return userExists;
	}

	public static boolean correctPassword(String login, String pass) {
		boolean userExists = false;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM user WHERE login='" + login + "' and password=PASSWORD('"+ pass +"');";
			ResultSet rs = s.executeQuery(q);
			userExists = false;
			if (rs.next()) {
				userExists = true;
			}

		} catch (SQLException e) {

		}
		return userExists;
	}

	public static boolean keyLogin(String login, String key) {
		boolean userExists = false;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM Session WHERE login='" + login + "' and password='"+ key +"');";
			ResultSet rs = s.executeQuery(q);
			userExists = false;
			if (rs.next()) {
				userExists = true;
			}

		} catch (SQLException e) {

		}
		return userExists;
	}


	public static boolean addSession(String login, String clef) {
		// TODO Auto-generated method stub
		try {
			boolean res;
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DataBase.getMySQLConnection();

			String q = "Insert into Session values(null, '" + login + "', key='" + clef + "');";
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

			String q = "Delete from Session where login='" + login + "' and key='" + key + "';";
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

}
