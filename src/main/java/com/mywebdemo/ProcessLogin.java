package com.mywebdemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessLogin
 * mvn archetype:generate 
-DgroupId=com.mywebdemo 
-DartifactId=MyMavenWebAppDemo
-DarchetypeArtifactId=maven-archetype-webapp 
-DinteractiveMode=false
 */

public class ProcessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String password="patel";
    String passwd;
    int count;
    /**
     * Default constructor. 
     */
    public ProcessLogin() {
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException
    {
    	// Always call super.init(config) first  (servlet mantra #1)
        super.init(config);
        
        // Try to load the initial count from our saved persistent state
        try {
          FileReader fileReader = new FileReader("InitPassword.password");
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          passwd = bufferedReader.readLine();
           System.out.println("Read from InitPassword "+passwd);
          bufferedReader.close();
          return;
        }
        catch (FileNotFoundException ie) { ie.printStackTrace();}  // no saved state
        catch (IOException io) { io.printStackTrace();}            // problem during read

        // No luck with the saved state, check for an init parameter
        if (null==passwd && passwd.equals("")){
        	passwd = getInitParameter ("password");
        	System.out.println("Read from getInitParameter "+passwd);
        }

    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("##### Your Action is initiated #######");

		String responsePage="fail.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(responsePage);;
		
		request.getRequestDispatcher("displayData.jsp");

		 	String name=request.getParameter("username");  
		    String pwd=request.getParameter("password"); 
	    
		    String action = request.getParameter("action");
		    System.out.println("Your action is :"+action);
		    
		    if ("Login".equals(action)) {
		    	System.out.println("Login pressed");	
		    	System.out.println("Password should be :"+passwd); 
		    
			       
			    if(pwd.equals(passwd)){ 
			    	responsePage="success.jsp";
			    	request.setAttribute("dname", name);			    	
			    	rd=request.getRequestDispatcher(responsePage);;
			        rd.include(request, response); 
	
			    }  
			    else{
			    	request.setAttribute("dname", name);
			    	request.setAttribute("dmessage", "Sorry UserName or Password Error!"); 
			    	rd.include(request, response); 		                      
			    }  
		    } else if ("Reset".equals(action) || "Change".equals(action)) {
		    	System.out.println(action+" pressed");
		    	
		    	if ("Reset".equals(action)){
		    		System.out.println("Inside Reset");
		    		
		    		
			    	PrintWriter out = response.getWriter(  ); 
			        response.setContentType("text/html"); 
			        try {
			        out.println("<!DOCTYPE html");  
			        out.println("<html><head>");
			        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'></head>");
			        out.println("<body bgcolor='silver'>");
			        out.println("<form action='ProcessLogin' method='post'>");
			        out.println("<center><table border='0' width='70%' cellpadding='1'>");  
			        out.println("<tr><td><h2>Please enter new password below -</h2></td></tr>");  
			        out.println("<tbody><tr><td><input type='text' name='passwod'></td></tr><br/>");
			        out.println("<tr><td><input type='submit' name='action' value='Change'></td></tr></tbody></table></center>");
			        out.println("</form></body></html>"); 
			        } finally {
			            out.close();  // Always close the output writer
			        }
		    	
		    	} else if("Change".equals(action)){
		    		
		    		System.out.println("Inside Change ");
		    		 if (null!=request.getParameter("passwod")){
					    	try {
					    	      FileWriter fileWriter = new FileWriter("InitPassword.password");
					    	      String paswd = request.getParameter("passwod");
					    	      passwd = paswd;
					    	      fileWriter.write(paswd);
					    	      fileWriter.close();
					    	      System.out.println("Reset password to "+paswd +"successful.");
					    	    }
					    	    catch (IOException e) { 
					    	    	e.printStackTrace();// problem during write
					    	    }
				        } 
		    		 
		    		PrintWriter out = response.getWriter(  ); 
			        response.setContentType("text/html"); 
		    		try {
				        out.println("<!DOCTYPE html");  // HTML 5
				        out.println("<html><head>");
				        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'></head>");
				        out.println("<body bgcolor='silver'>");
				        out.println("<form action='ProcessLogin' method='post'>");
				        out.println("<H1>Password changed successfully!</H1>");
				        out.println("<a href='index.jsp'>Login page</a>");				        
				        
				        out.println("</body></form></body></html>");
				        } finally {
				            out.close();  // Always close the output writer
				        }
		    	}
		    	
		    }
	} 
	
	public long multiply(int a,int b){
		return a*b;
	}

}
