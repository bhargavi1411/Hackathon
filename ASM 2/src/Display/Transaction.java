package Display;
import java.sql.*;
import java.util.List;

   public class Transaction 	
   {
     
	   static String transaction_name;
	
	   static ResultSet rs1 = null; 
      public static String transaction(UserBean bean) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
	
         
         String username =bean.getUsername();
         String account_type=bean.getAccountType();
       
	    
         String searchQuery =
              "select transaction_name from User_transaction where user_name ='" + username
              +"' and account_type = '" + account_type + "'";
        		 ;
	    
      // "System.out.println" prints in the console; Normally used to trace the process
      System.out.println("Query: "+searchQuery);
	    
      try 
      {
         //connect to DB 
    	  UserDAO.currentCon = ConnectionManager.getConnection();
         stmt=UserDAO.currentCon.createStatement();
         rs1 = stmt.executeQuery(searchQuery);	       
         boolean more = rs1.next();
	       
         // if user does not exist set the isValid variable to false
         if (!more) 
         {
            System.out.println("Sorry, No transactions for the account type");
            bean.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) 
         {
             //transaction_name = rs1.getString("transaction_name");
        	 transaction_name= rs1.getString("transaction_name");
	     	
           
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs1 != null)	{
            try {
               rs1.close();
            } catch (Exception e) {}
               rs1 = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (UserDAO.currentCon != null) {
            try {
            	UserDAO.currentCon.close();
            } catch (Exception e) {
            }

            UserDAO.currentCon = null;
         }
      }

return transaction_name;
	
      }	
   }
