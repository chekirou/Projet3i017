package Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import DataBase.DataBase;

public class DataBaseTools {
	public static  Exception ajout_base(String nom, String prenom, String login, String password, String sexe, int age) {
		// TODO Auto-generated method stub
		try
		{
			boolean res;
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DataBase.getMySQLConnection();
			String q = "Insert into Users values(null, \""+ login+"\", \""+ password+"\", \""+ prenom+"\", \""+ nom +"\", \""+ sexe+"\",\""+age+"\");";
			Statement s = c.createStatement();
			int rs = s.executeUpdate(q);
			s.close();
			c.close();
			return null;
		}catch(Exception e){
				e.printStackTrace();
				return e;
		}
			
	}
	public static boolean correctPassword(String login, String password) {
		//on verifie la correspondance entre le login et le mdp dans la bd
		Connection c = DataBase.getMySQLConnection();
		Statement s = c.createStatement();
		String q = "SELECT login, mdp from User where login ='"+login +"'"+" and mdp ='" + password + "'";
		ResultSet rs = s.executeUpdate(q);
		if (rs.next()) {
			return true;
		}
		rs.close();
		s.close();
		c.close();
		return false;
	}
	
	public static boolean existsUser(String login) throws SQLException {
		Connection c = DataBase.getMySQLConnection();
		Statement s = c.createStatement();
		String q = "SELECT * FROM user WHERE user_login="+login+";";
		ResultSet rs = s.executeUpdate(q);
		boolean userExists=true;
		while (rs.next()){
			userExists=true;
		}
		return userExists;
	}
}
		
