package mmtweet.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mmtweet.pojos.TweetMessage;
import mmtweet.pojos.Comment;

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

   
   public void addMessage(int userId, TweetMessage msg)
   {
	   String sql;
	   try {
		   sql = "INSERT INTO message (user_id, text, origin_location, current_location, views, is_pinned, creation_time, flight_number) VALUES (";
		   
		   //sql += msg.getMessageId() + ",";
		   if (userId != msg.getUserId())
			   System.out.println("\nERROR: addMessage(): User id mismatch!! Roshan.\n");
		   sql += msg.getUserId() + ",";
		   sql += "'" + msg.getText() + "',";
		   sql += "'" + msg.getOriginLocation() + "',";
		   sql += "'" + msg.getCurrentLocation() + "',";
		   sql += msg.getViews() +  ",";
	       sql += msg.getPinned() +  ",";	//CHECK
	       sql += "'" + msg.getCreationTime() + "',";
	       sql += "'" + msg.getFlightNumber() + "'";
										   
		   sql += ");";
		   stmt.executeUpdate(sql);
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
   }
   
   
   public void addComment(int userId, int messageId, Comment comment)
   {
	   String sql;
	   try {
		   sql = "INSERT INTO comment (user_id, message_id, text, current_location, creation_time) VALUES (";
		   if (userId != comment.getUserId())
			   System.out.println("\nERROR: addComment(): User id mismatch!! Roshan.\n");
		   sql += comment.getUserId() + ",";
		   sql += messageId + ",";
		   sql += "'" + comment.getText() + "',";
		   sql += "'" + comment.getOriginLocation() + "',";
	       sql += "'" + comment.getCreationTime() + "'";

		   sql += ");";
		   stmt.executeUpdate(sql);
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
   }
   
   public List<TweetMessage> getMessagesByUserId(int userId)
   {
	   List<TweetMessage> msgList = new ArrayList<TweetMessage>();
	   String sql;
	   try {
		   sql = "SELECT * FROM message WHERE user_id=" + userId + ";";
		   ResultSet rs = stmt.executeQuery(sql);
		   TweetMessage msg = new TweetMessage();
		   while(rs.next()){
			   //Retrieve by column name
			   msg.setMessageId(rs.getInt("message_id"));
			   msg.setText(rs.getString("text"));
			   msg.setOriginLocation(rs.getString("origin_location"));
			   msg.setCurrentLocation(rs.getString("current_location"));
			   msg.setViews(rs.getInt("views"));
			   //TBD: Add for list of comments
			   msg.setPinned(rs.getBoolean("is_pinned"));
			   msg.setCreationTime(rs.getString("creation_time"));
			   msg.setFlightNumber(rs.getString("flight_number"));
			   
			   msgList.add(msg);
		   }
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	   return msgList;
   }
   

   public List<TweetMessage> getCommentedMessagesByUserId(int userId)
   {
	   List<TweetMessage> msgList = new ArrayList<TweetMessage>();
	   String sql, inner_sql;
	   ResultSet inner_rs;
	   try {
		   sql = "SELECT message_id FROM comment WHERE user_id=" + userId + ";";
		   ResultSet rs = stmt.executeQuery(sql);
		   TweetMessage msg = new TweetMessage();
		   while(rs.next()){
			   inner_sql = "SELECT * FROM message WHERE message_id=" + rs.getInt("message_id") + ";";
			   inner_rs = stmt.executeQuery(inner_sql);
			   //Retrieve by column name
			   msg.setMessageId(inner_rs.getInt("message_id"));
			   msg.setText(inner_rs.getString("text"));
			   msg.setOriginLocation(inner_rs.getString("origin_location"));
			   msg.setCurrentLocation(inner_rs.getString("current_location"));
			   msg.setViews(inner_rs.getInt("views"));
			   //TBD: Add for list of comments
			   msg.setPinned(inner_rs.getBoolean("is_pinned"));
			   msg.setCreationTime(inner_rs.getString("creation_time"));
			   msg.setFlightNumber(inner_rs.getString("flight_number"));
			   
			   msgList.add(msg);
		   }
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	   return msgList;   
   }
   
   
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
   
}
