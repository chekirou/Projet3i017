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

public class DataBaseTools {

	public static int nbConnectes() {
		int nb = 0;
		try {

			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM Session ;";

			ResultSet rs = s.executeQuery(q);
			while (rs.next()) {
				nb++;
				

			}
			rs.close();
			s.close();
			c.close();

		} catch (SQLException e) {

		}
		return nb;
	}

	public static int nbInscrits() {
		int nb = 0;
		try {
			Connection c = DataBase.getMySQLConnection();
			Statement s = c.createStatement();
			String q = "SELECT * FROM Users ;";

			ResultSet rs = s.executeQuery(q);
			while (rs.next()) {
				nb++;
				
			}
			rs.close();
			s.close();
			c.close();

		} catch (SQLException e) {

		}

		return nb;
	}

}
