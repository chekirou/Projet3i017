package Services;

import org.json.JSONException;
import org.json.JSONObject;

import Tools.FriendTools;

public class Friend {
	public static JSONObject addFriend(String myLogin,String key, String hisLogin)
	{
		
		JSONObject obj = null;
		if(myLogin == null || hisLogin == null)
		{
			obj = Tools.ServiceTools.refused(6);
			
		}
		else if(!Tools.UserTools.existsUser(myLogin, true))
		{
			obj = Tools.ServiceTools.refused(4);
		}
		else if(!Tools.UserTools.keyLogin(myLogin, key))
		{
			obj = Tools.ServiceTools.refused(7);
		}
		else
		{
			// ajouter dans la base de données le 
			// hisLogin dans les amis de myLogin
			
			try {
				obj = new JSONObject();
				obj.put("ajout de l'ami", "ok ");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
		
	}
	public static JSONObject listFriends(String login)
	{
		
		JSONObject obj = null;
		if(login == null)
		{
			obj = Tools.ServiceTools.refused(3);
			
		}
		else if(!Tools.UserTools.existsUser(login, true))
		{
			obj = Tools.ServiceTools.refused(4);
		}
		else
		{
			
			try {
				obj = FriendTools.listFriends(login);
				
				obj.put("amis ok", "ok ");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
		
	}
	public static JSONObject unFriend(String myLogin,String key, String hisLogin)
	{
		
		JSONObject obj = null;
		if(myLogin == null || hisLogin == null)
		{
			obj = Tools.ServiceTools.refused(6);
			
		}
		else if(!Tools.UserTools.existsUser(myLogin, true))
		{
			obj = Tools.ServiceTools.refused(4);
		}
		else if(!Tools.UserTools.keyLogin(myLogin, key))
		{
			obj = Tools.ServiceTools.refused(7);
		}
		else
		{
			// suprimer le friend dans la base de données
			try {
				obj = new JSONObject();
				obj.put("suppression de l'ami", "ok ");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
		
	}
	
}

