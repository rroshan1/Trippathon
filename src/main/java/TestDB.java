import java.sql.SQLException;

import mmtweet.dao.AccessDB;
import mmtweet.pojos.TweetMessage;;
public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		AccessDB db = new AccessDB();
		db.init();
		TweetMessage msg= new TweetMessage();
		msg.setUserId(2);
		msg.setText("Goodbye!!");
		msg.setOriginLocation("abc");
		msg.setViews(0);
		msg.setPinned(false);
		msg.setCreationTime("27/08/2016 9 pm");
		db.addMessage(2, msg);
		db.destroy();
		}catch(Exception e)
		{
			System.out.println("Error!!");
		}
		System.out.println("Done");
	}

}
