package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Services.User;
public class UserCreation extends HttpServlet{
	public UserCreation() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
		// nom prenom login password
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String sexe = request.getParameter("sexe");
		int age = Integer.parseInt(request.getParameter("age"));
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		out.print(User.createUser(nom, prenom, login, password, sexe, age));
		out.flush();
		
	}

}
