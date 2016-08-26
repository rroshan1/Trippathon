import java.sql.SQLException;

import mmtweet.dao.AccessDB;
import mmtweet.pojos.Comment;
import mmtweet.pojos.Location;
import mmtweet.pojos.TweetMessage;;
public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		AccessDB db = new AccessDB();
		Location loc1 = new Location(12.123456, 24.123456);
	
		db.init();
		
		/*TweetMessage msg= new TweetMessage();
		msg.setUserId("rakesh");
		msg.setText("Goodbye!!");
		msg.setOriginLocation(loc1);
		msg.setCurrentLocation(loc1);
		msg.setViews(0);
		msg.setPinned(false);
		msg.setCreationTime((long)115);
		db.addMessage("rakesh", msg);*/
		
		/*Comment cmnt = new Comment();
		cmnt.setUserId("rakesh");
		cmnt.setText("Comment Automated");
		cmnt.setCreationTime("145 ");
		cmnt.setOriginLocation(loc1);
		db.addComment("rakesh", 3, cmnt);*/
		
		//db.getMessagesByUserId("roshan");
		
		db.getCommentedMessagesByUserId("vivek");
		db.destroy();
		}catch(Exception e)
		{
			System.out.println("Error!!");
		}
		System.out.println("Done");
	}

}
