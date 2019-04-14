package Services;

import org.json.JSONException;
import org.json.JSONObject;

import Tools.FriendTools;

public class Friend {
	public static JSONObject addFriend(String myLogin, String key, String hisLogin) {

		JSONObject obj = null;
		if (myLogin == null || hisLogin == null || key == null) {
			obj = Tools.ServiceTools.refused(6);

		} else if (!Tools.UserTools.existsUser(myLogin) || !Tools.UserTools.existsUser(hisLogin)) {
			obj = Tools.ServiceTools.refused(4);
		} else if (!Tools.UserTools.keyLogin(myLogin, key)) {
			obj = Tools.ServiceTools.refused(7);
		} else if (Tools.FriendTools.dejaAmis(myLogin, hisLogin)){
			obj = Tools.ServiceTools.refused(11);	
		} else {
			obj = new JSONObject();
			try {
				if (Tools.FriendTools.addfollowing(myLogin, hisLogin)) {

					obj.put("ajout de l'ami", "ok ");

				} else {
					obj.put("ajout de l'ami", "failed");
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return obj;

	}

	public static JSONObject listFriends(String login) {

		JSONObject obj = null;
		if (login == null) {
			obj = Tools.ServiceTools.refused(3);

		} else if (!Tools.UserTools.existsUser(login)) {
			obj = Tools.ServiceTools.refused(4);
		} else {

			try {
				obj = FriendTools.listFriends(login);

				obj.put("amis ", "ok ");

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return obj;

	}

	public static JSONObject unFriend(String myLogin, String key, String hisLogin) {

		JSONObject obj = null;
		if (myLogin == null || hisLogin == null) {
			obj = Tools.ServiceTools.refused(6);

		} else if (!Tools.UserTools.existsUser(myLogin)) {
			obj = Tools.ServiceTools.refused(4);
		} else if (!Tools.UserTools.keyLogin(myLogin, key)) {
			obj = Tools.ServiceTools.refused(7);
		}
		else if(!FriendTools.dejaAmis(myLogin, hisLogin))
		{
			obj = Tools.ServiceTools.refused(10);
		}
		else {
			// suprimer le friend dans la base de données
			FriendTools.unfollow(myLogin,hisLogin);
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
