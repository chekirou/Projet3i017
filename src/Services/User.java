package Services;


import org.json.JSONException;
import org.json.JSONObject;

import Tools.DataBaseTools;

public class User {
	public User() {}
	public static JSONObject createUser(String nom, String prenom, String login, String password, String sexe, int age)
	{
		JSONObject obj = null;
		if(nom  == null || prenom == null || login == null || password == null || sexe == null || age <0)
		{
			obj = Tools.ServiceTools.refused(3);
			
		}
		else if(!Tools.UserTools.checkPassword(password))
		{
			obj = Tools.ServiceTools.refused(2);
		}
		else if(Tools.UserTools.existsUser(login, false))
		{
			obj = Tools.ServiceTools.refused(1);
		}
		else
		{
			//ajouter a la base de donnees 
			Exception res = DataBaseTools.ajout_base(nom, prenom, login, password, sexe, age);
			try {
				if(res == null)
				{
					obj = new JSONObject().put("creation ", "ok");
				}
				else
				{
					obj = new JSONObject().put("creation ", res.toString());
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
	}
	
	public static JSONObject login(String login, String password)
	{
		
		JSONObject obj = null;
		if(login == null || password == null)
		{
			obj = Tools.ServiceTools.refused(3);
			
		}
		else if(!Tools.UserTools.existsUser(login, true))
		{
			obj = Tools.ServiceTools.refused(4);
		}
		else if(!Tools.UserTools.correctPassword(login ,password))
		{
			obj = Tools.ServiceTools.refused(5);
		}
		else
		{
			//generer une clef de 32 caracteres
			String clef = "clef";
			// associer a un login dans la base
			try {
				obj = new JSONObject();
				obj.put("connexion", "ok ");
				obj.put("key", clef);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
		
	}
	
	
	
	public static JSONObject logout(String login, String key)
	{
		// enlever la key de la base
		JSONObject obj = null;
		if (Tools.UserTools.keyLogin(login,key)) {
			try {
				obj = new JSONObject();
				obj.put("deconnection", "ok ");
				Tools.UserTools.logoutBd(login);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
		
	}
}
