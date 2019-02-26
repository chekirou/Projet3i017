package Services;

import org.json.JSONException;
import org.json.JSONObject;

import Tools.MessageTools;
import Tools.MongoTools;
import Tools.ServiceTools;

public class Message {
	public static JSONObject addMessage(String myLogin,String key, String Message)
	{
		
		JSONObject obj = null;
		if(myLogin == null || key == null || Message == null)
		{
			obj = Tools.ServiceTools.refused(3);
			
		}
		else if(!Tools.UserTools.existsUser(myLogin))
		{
			obj = Tools.ServiceTools.refused(4);
		}
		else if(!Tools.UserTools.keyLogin(myLogin, key))
		{
			obj = Tools.ServiceTools.refused(7);
		}
		else
		{
			// recuperer l'id
			int id = ServiceTools.getID(myLogin);
			// ajouter dans la base de données le message 
			MessageTools.addMessage(id, myLogin, Message);
			try {
				obj = new JSONObject();
				obj.put("ajout du message", "ok ");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
		
	}
	public static JSONObject listMessages(String login)
	{
		
		JSONObject obj = null;
		if(login == null)
		{
			obj = Tools.ServiceTools.refused(3);
			
		}
		else if(!Tools.UserTools.existsUser(login))
		{
			obj = Tools.ServiceTools.refused(4);
		}
		else
		{
			// renvoie la liste des messages
			
			// hisLogin dans les amis de myLogin
			
				int id = ServiceTools.getID(login);
				obj = MessageTools.listMessages(id);
				
				//obj.put("messages ok", "ok ");
				
			
		}
		
		return obj;
		
	}
	public static JSONObject deleteMessage(String myLogin,String key, String MessageId)
	{
		
		JSONObject obj = null;
		if(myLogin == null || key == null || MessageId == null)
		{
			obj = Tools.ServiceTools.refused(3);
			
		}
		else if(!Tools.UserTools.existsUser(myLogin))
		{
			obj = Tools.ServiceTools.refused(4);
		}
		else if(!Tools.UserTools.keyLogin(myLogin, key))
		{
			obj = Tools.ServiceTools.refused(7);
		}
		/*else if(!Tools.MessageTools.existsMessage(MessageId))
		{
			obj = Tools.ServiceTools.refused(8);
		}*/
		else
		{
			// supprimer dans la base de données le message 
			try {
				obj = new JSONObject();
				obj.put("suppression du message", "ok ");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
		
	}
}
