package Tools;

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
			}catch(Exception e)
			{
				e.printStackTrace();
				return e;
			}
			

		}
	}
		
