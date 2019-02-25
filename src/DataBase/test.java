package DataBase;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import Services.Friend;
import Services.Message;
import Services.User;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * try { boolean res; Class.forName("com.mysql.jdbc.Driver").newInstance();
		 * Connection c = DataBase.getMySQLConnection(); String q =
		 * "Insert into Users values(null, \"tat\", \"tatata\", \"prenom2\", \"nom2\", \"F\",\"18\");"
		 * ; Statement s = c.createStatement(); int rs = s.executeUpdate(q); s.close();
		 * c.close(); } catch (Exception e) { e.printStackTrace(); }
		 

		// User.createUser("ryma", "upmca", "ryma", "kacia", "F", 21);
		String str = "Hakim-996";
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes(), 0, str.length());
			System.out.println("MD5: " + new BigInteger(1, messageDigest.digest()).toString(16));
		}catch(Exception e)
		{
			
		}*/
		System.out.println(Message.listMessages("curls"));
		

	}

}
