package Display;

import java.sql.*;
import java.util.*;


   public class ConnectionManager {

      static Connection con;
      static String url;
            
      public static Connection getConnection()
      {
        
         try
         {
        	 System.out.println("Staring connection class");
        	 Class.forName("com.mysql.jdbc.Driver");  
        	 Connection con=DriverManager.getConnection(  
        	 "jdbc:mysql://localhost:3306/test","root","mysql12345");  
        	 //here sonoo is database name, root is username and password  
        	// Statement stmt=con.createStatement();  
        	// ResultSet rs=stmt.executeQuery("select * from tasks");
        	 //while(rs.next())  
        	 //System.out.println(rs.getInt(1) + rs.getString(2));  
        	 
        	
         }
        	 
        	 
            catch (SQLException ex)
            {
               ex.printStackTrace();
            } 
         

         catch(ClassNotFoundException e)
         {
            System.out.println(e);
         }

      return con;
}
   }
