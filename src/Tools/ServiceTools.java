package Tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;

import DataBase.DataBase;
import Services.User;

public class ServiceTools {

	public static JSONObject refused(int code) {
		String s = " ";
		switch (code) {
		case 1:
			s = "user existe deja";
			break;
		case 2:
			s = "mot de passe ne respecte pas le format";
			break;
		case 3:
			s = " informations vides";
			break;
		case 4:
			s = "user n'existe pas";
			break;
		case 5:
			s = "mot de passe incorrect";
			break;
		case 6:
			s = "un des login est faux";
			break;
		case 7:
			s = "la clef ne correspond pas";
			break;
		case 8:
			s = "message n'existe pas";
			break;
		case 10:
			s= "ils ne sont pas amis";
			break;
		}

		JSONObject obj = null;
		try {
			obj = new JSONObject().put("erreur", s);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;

	}

	public static boolean correctPassword(String login, String password) {
		try {

			// on verifie la correspondance entre le login et le mdp dans la bd

			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT login, mdp from User where login ='" + login + "'" + " and mdp ='" + password + "';";
			ResultSet rs = s.executeQuery(q);
			if (rs.next()) {
				return true;
			}
			rs.close();
			s.close();
			c.close();
		} catch (SQLException e) {

		}
		return false;
	}
	/**
	 * genere une clef de 32 caracteres
	 * @return
	 */
	public static String generateKey() {
		KeyGenerator gen;
		String text = null;
		
		try {
			gen = KeyGenerator.getInstance("AES");
		
		gen.init(128); /* 128-bit AES */
		SecretKey secret = gen.generateKey();
		byte[] binary = secret.getEncoded();
		text = String.format("%032X", new BigInteger(+1, binary));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	/*
	 * public static String generateHash(String str) { String res= ""; try {
	 * MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	 * messageDigest.update(str.getBytes(), 0, str.length()); res = new
	 * BigInteger(1, messageDigest.digest()).toString(16); }catch(Exception e) {
	 * 
	 * } return res;
	 * 
	 * }
	 */

	public static int getID(String myLogin) {
		int res= -1;
		List<String> liste = new ArrayList<String>();
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT id FROM Users WHERE login='" + myLogin + "';";
			ResultSet rs = s.executeQuery(q);
			while (rs.next()) {
				res = rs.getInt("id");
			}
			
			s.close();
			c.close();

		} catch (SQLException e) {

		}	
		return res;
	}

	public static void updateExpiration(String login) {
		// TODO Auto-generated method stub
		
	try
	{
		Connection c = DataBase.getMySQLConnection();
		String q = "update Session set date_exp=now() where login='"+login+"'";
		Statement s = c.createStatement();
		int rs = s.executeUpdate(q);
		s.close();
		c.close();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	}

	public static boolean checkdate(String login, String key) {
		// TODO Auto-generated method stub
		
		boolean check = false;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM Session WHERE login='" + login + "' and clef='"+ key +"'and date_exp+3600> now() ;";
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
			ServiceTools.updateExpiration(login);
		}
		else
		{
			User.logout(login, key);
		}
		
		return check;
	}

}
