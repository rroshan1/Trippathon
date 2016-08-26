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
		msg.setViews(0);
		msg.setPinned(false);
		msg.setCreationTime("27/08/2016 9 pm");
		db.addMessage("rakesh", msg);*/
		
		/*Comment cmnt = new Comment();
		cmnt.setUserId("rakesh");
		cmnt.setText("Comment Automated");
		cmnt.setCreationTime("Cr1 ");
		cmnt.setOriginLocation(loc1);
		db.addComment("rakesh", 5, cmnt);*/
		
		//db.getMessagesByUserId(2);
		
		db.getCommentedMessagesByUserId("rakesh");
		db.destroy();
		}catch(Exception e)
		{
			System.out.println("Error!!");
		}
		System.out.println("Done");
	}

}
