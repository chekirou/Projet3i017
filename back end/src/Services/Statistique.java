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
			obj=new JSONObject();
			obj.put("per", co);
			obj.put("nbi", inscrits);

		} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		return obj;

	}
	
}
