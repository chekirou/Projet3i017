package DataBase;

import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import Services.User;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*try {
			boolean res;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection c = DataBase.getMySQLConnection();
			String q = "Insert into Users values(null, \"tat\", \"tatata\", \"prenom2\", \"nom2\", \"F\",\"18\");";
			Statement s = c.createStatement();
			int rs = s.executeUpdate(q);
			s.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
				
		User.createUser("ryma", "upmca", "ryma", "kacia", "F", 21);

	}

}
