package mmtweet.dal;

import java.util.ArrayList;
import java.util.List;

import mmtweet.pojos.Comment;
import mmtweet.pojos.Location;
import mmtweet.pojos.TweetMessage;

public class AccessDal implements IMmtweetDal {

	@Override
	public boolean addMessage(String userId, TweetMessage message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addComment(String userId, String messageId, Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TweetMessage> getMessagesByUserId(String userId) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<TweetMessage> getCommentedMessagesByUserId(String userId) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<TweetMessage> getMessagesByLatLongWindow(double minLatitude, double maxLatitude, double leftLongitude,
			double rightLongitude) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<TweetMessage> getAllMessages(boolean isPinned) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public boolean updateMessageLocation(int messageId, Location currentLocation, String lastUpdationTime) {
		// TODO Auto-generated method stub
		return false;
	}

}
