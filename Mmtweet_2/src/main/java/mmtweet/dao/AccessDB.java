package mmtweet.dao;
import java.sql.*;

import mmtweet.pojos.TweetMessage;

public class AccessDB {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/trippathon";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root@123";
   Connection conn = null;
   Statement stmt = null;
   
   public void init() {
	   try{
	      Class.forName("com.mysql.jdbc.Driver");
	
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
   }
/*   
   public void putMessage(TweetMessage msg)
   {
	   
	   String sql;
	   sql = "SELECT * FROM user";
	   ResultSet rs = stmt.executeQuery(sql);
	  
	   while(rs.next()){
     //Retrieve by column name
     int id  = rs.getInt("id");
     String user_id = rs.getString("user_id");

     //Display values
     System.out.print("ID: " + id);
     System.out.print(", User ID: " + user_id + "\n");
      }	   
   }*/
   
  
   public void destroy() {
	   try{
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
   }
   
}//end FirstExample
