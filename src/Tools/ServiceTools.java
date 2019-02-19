package Tools;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceTools {
	
	public static JSONObject refused(int code) {
		String s=" ";
		switch(code)
		{
		case 1:
			s = "user existe deja";
			break;
		case 2:
			s = "mot de passe ne respecte pas le format";
			break;
		case 3: 
			s = " informations vides";
			break;
		case 4:
			s = "user n'existe pas"; 
			break;
		case 5: 
			s = "mot de passe incorrect";
			break;
		case 6:
			s = "un des login est faux";
			break;
		case 7:
			s = "la clef ne correspond pas";
			break;
		case 8:
			s = "message n'existe pas";
			break;
		}
		

		JSONObject obj = null;
		try {
			obj = new JSONObject().put("erreur", s);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}

}
