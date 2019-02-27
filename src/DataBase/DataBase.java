package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DataBase {
	private DataSource dataSource;
	private static DataBase database;
	public DataBase(String jndiname) throws SQLException
	{
		try
		{
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/"+ jndiname);
			
		}
		catch(NamingException e)
		{
			// Handle error that it’s not configured in JNDI.18
			throw new SQLException(jndiname +" is missing in JNDI! : "+e.getMessage());
		}
	}
	public  Connection getConnection()throws SQLException {
	return  dataSource.getConnection();
	}
	public static Connection getMySQLConnection()throws SQLException {
		if(!DBStatic.mysql_pooling) {
			return (Connection) (DriverManager.getConnection("jdbc:mysql://"+ "localhost" +"/"+DBStatic.mysql_db, 
					DBStatic.mysql_username, DBStatic.mysql_password));
		}
		else
		{
			if(database==null) { 
				database=new DataBase("jdbc/db");
			}
			return(database.getConnection());
		}
		
		}
	}


