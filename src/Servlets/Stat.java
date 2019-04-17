package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import Services.Statistique;

	
@SuppressWarnings("serial")
public class Stat extends HttpServlet{
	public Stat() {}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	{
	
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(Statistique.Stat());
		out.flush();
			
	}
}
	

