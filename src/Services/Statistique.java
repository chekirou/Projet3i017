package Services;

import org.json.JSONException;
import org.json.JSONObject;

import Tools.DataBaseTools;
import Tools.FriendTools;

public class Statistique {
	
	public static JSONObject Stat() {

		JSONObject obj = null;
		double co;
		int inscrits;

		try {
			co= DataBaseTools.nbConnectes();
			inscrits=DataBaseTools.nbInscrits();
			co=(1.0*co)/inscrits;
			obj.put("pourcentage de personnes connectées", co);
			obj.put("Nombre d'utilisateurs inscrits sur Twister", inscrits);

		} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		return obj;

	}
	
}
