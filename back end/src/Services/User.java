package Services;


import org.json.JSONException;
import org.json.JSONObject;

import Tools.DataBaseTools;
import Tools.ServiceTools;
import Tools.UserTools;

public class User {
	public User() {}
	public static JSONObject createUser(String nom, String prenom,
			String login, String password,
			String sexe, String date_naissance,
			String email)
	{
		JSONObject obj = null;
		if(nom  == null || prenom == null || login == null || password == null || sexe == null || date_naissance == null || email == null)
		{
			obj = Tools.ServiceTools.refused(3);
			
		}
		else if(Tools.UserTools.existsUser(login))
		{
			obj = Tools.ServiceTools.refused(1);
		}
		else
		{
			//ajouter a la base de donnees 
			JSONObject res = UserTools.ajout_base(nom, prenom, login, password, sexe, date_naissance, email);
			try {
				if(res == null)
				{
					obj = new JSONObject().put("creation ", "ok");
				}
				else
				{
					res.append("creation ", "echou�e");
					obj = res;
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
		else if(!Tools.UserTools.existsUser(login))
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
			String clef = ServiceTools.generateKey();
			// associer a un login dans la base
			obj = new JSONObject();
			
			try {
				if(UserTools.addSession(login, clef))
				{
					obj.put("connexion", "ok ");
					obj.put("key", clef);
				}else
				{
					obj.put("connexion", "failed");
				}
				
				
			} catch (JSONException e) {
				e.printStackTrace();
				
			}
		}
		
		return obj;
		
	}
	
	
	
	public static JSONObject logout(String login, String key)
	{
		// enlever la key de la base
		
		JSONObject obj = null;
		if(login == null || key == null)
		{
			obj = Tools.ServiceTools.refused(3);
			
		}
		else if(!Tools.UserTools.existsUser(login))
		{
			obj = Tools.ServiceTools.refused(4);
		}
		else if (Tools.UserTools.deleteSession(login,key)) {
			try {
				obj = new JSONObject();
				obj.put("deconnection", "ok ");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				obj = new JSONObject();
				obj.put("deconnection", "failed ");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
		
	}
}
