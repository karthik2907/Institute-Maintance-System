import java.io.*;   
import java.sql.*;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       // request.getRequestDispatcher("link.html").include(request, response);  
        Statement stmt=null;
         ResultSet rs=null;
        String str=request.getParameter("type");
        String name=request.getParameter("name");  
        String password=request.getParameter("pwd");  
            String user_name="";
             String user_password="";
             try{
                 Class.forName("com.mysql.jdbc.Driver");
		       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","2907");   
                         stmt=con.createStatement();
                                  if(str.equals("student"))
                                 rs=stmt.executeQuery("select * from student where name='"+name+"' and password='"+password+"'");
                                  else
                                    rs=stmt.executeQuery("select * from admin where name='"+name+"' and password='"+password+"'");
                                while(rs.next())
				{				         
				      user_name=rs.getString("name");
					  user_password=rs.getString("password");         					                        
				} 
                                if((name.equals(user_name)&&password.equals(user_password))&&(str.equals("student")))
				{
                                     request.getRequestDispatcher("student_profile.html").include(request, response);  
					 /*out.println("I am Student");
                                        out.println("Welcome, "+name); 
                                        
                                            HttpSession session=request.getSession();  
                                            session.setAttribute("name",name);  
                                            out.println("we are going to write student accsesible tiems heree")*/
				}
                                else if((name.equals(user_name)&&password.equals(user_password))&&(str.equals("professor")))
				{
					/* out.println("I am Admin");
                                        out.println("Welcome, "+name); 
                                        
                                            HttpSession session=request.getSession();  
                                            session.setAttribute("name",name);  
                                            out.println("we are going to write admin accsesible tiems heree")*/
                                    request.getRequestDispatcher("professor_profile.html").include(request, response);  
                                    
				}
				else
				{
					   out.println("<html><body onload=\"alert('Username or Password incorrect')\"></body></html>");
                                              if(str.equals("student"))
                                            request.getRequestDispatcher("student_login.html").include(request, response);  
                                              else
                                            request.getRequestDispatcher("admin_login.html").include(request, response); 
				}
				
                 }
             catch (Exception e2){
                 out.println("<html><body onload=\"alert('Something error occured try again!!😥')\"></body></html>");
                  if(str.equals("student"))
                  request.getRequestDispatcher("student_login.html").include(request, response);  
                  else
                  request.getRequestDispatcher("admin_login.html").include(request, response); 
             }
            out.close();
          }  
}  
/* Connection con=null;
            Statement stmt=null;
            ResultSet rs=null;
            String username=request.getParameter("uname");
            String password=request.getParameter("pwd");
             String staff_name="";
             String staff_password="";
			try
			{
		 		Class.forName("com.mysql.jdbc.Driver");
		        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","2907");   
                        stmt=con.createStatement(); 
                    rs=stmt.executeQuery("select * from student where name='"+username+"' and password='"+password+"'");
				
                          while(rs.next())
				{				         
				      staff_name=rs.getString("name");
					  staff_password=rs.getString("password");         					                        
				} 
				if((username.equals(staff_name)&&password.equals(staff_password)))
				{
					out.println("<h1>Login success</h1>");
				}
				else
				{
					out.println("<h1>Login fail</h1>");
				}
			}
			catch(Exception e)
			{
				out.println(e);	
			}

*/
