import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import mmtweet.dao.AccessDB;
import mmtweet.pojos.Comment;
import mmtweet.pojos.Location;
import mmtweet.pojos.TweetMessage;
import mmtweet.webservices.UpdateMessageLocationService;;
public class TestDB {

    public static ExecutorService executorService = Executors.newSingleThreadExecutor();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{

    		System.out.println("inside startUpdateLocationService; going to start UpdateMessageLocationService");
    		executorService.submit(new UpdateMessageLocationService());
/*
			AccessDB db = new AccessDB();
		Location loc1 = new Location(12.123456, 24.123456);
	
		db.init();
		*/
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
		
		//db.getCommentedMessagesByUserId("vivek");
		
		//db.getAllMessages(false);
		
		//db.updateMessageLocation(3, loc1, 190);
		
//		db.destroy();
		}catch(Exception e)
		{
			System.out.println("Error!!");
		}
		System.out.println("Done");
	}

}
