package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import Services.Friend;
import Services.User;

public class CheckFriends extends HttpServlet{
	public CheckFriends() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		// nom prenom login password
		String myLogin = request.getParameter("My_login");
		String hisLogin = request.getParameter("His_login");
		String key = request.getParameter("key");
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		JSONObject obj = new JSONObject();
		try {
			obj.put("amis", Tools.FriendTools.dejaAmis(myLogin, hisLogin));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(obj);
		out.flush();
		
	}
}

