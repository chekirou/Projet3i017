package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Friend;
import Services.User;

public class AddFriend extends HttpServlet{
	public AddFriend() {}
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
		out.print(Friend.addFriend(myLogin, key, hisLogin));
		out.flush();
		
	}
}
