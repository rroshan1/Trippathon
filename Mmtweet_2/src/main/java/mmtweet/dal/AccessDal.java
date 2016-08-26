package mmtweet.dal;

import java.util.ArrayList;
import java.util.List;

import mmtweet.pojos.Comment;
import mmtweet.pojos.Location;
import mmtweet.pojos.TweetMessage;
import mmtweet.dao.AccessDB;

public class AccessDal implements IMmtweetDal {

	private AccessDB db;
	public AccessDal() {
		// TODO Auto-generated constructor stub
		db = new AccessDB();
		db.init();
	}
	
	@Override
	public boolean addMessage(String userId, TweetMessage message) {
		db.addMessage(userId, message);
		return true;
	}

	@Override
	public boolean addComment(String userId, int messageId, Comment comment) {
		db.addComment(userId, messageId, comment);
		return true;
	}

	@Override
	public List<TweetMessage> getMessagesByUserId(String userId) {
		return db.getMessagesByUserId(userId);
	}

	@Override
	public List<TweetMessage> getCommentedMessagesByUserId(String userId) {
		return db.getCommentedMessagesByUserId(userId);
	}

	@Override
	public List<TweetMessage> getMessagesByLatLongWindow(double minLatitude, double maxLatitude, double leftLongitude, double rightLongitude) 
	{
		return db.getMessagesByLatLongWindow(minLatitude, maxLatitude, leftLongitude, rightLongitude);
	}

	@Override
	public List<TweetMessage> getAllMessages(boolean isPinned) {
		return db.getAllMessages(isPinned);
	}

	@Override
	public boolean updateMessageLocation(int messageId, Location currentLocation, long lastUpdationTime) {
		db.updateMessageLocation(messageId, currentLocation, lastUpdationTime);
		return true;
	}

	protected void finalize() throws Throwable{
		db.destroy();
	}
}
