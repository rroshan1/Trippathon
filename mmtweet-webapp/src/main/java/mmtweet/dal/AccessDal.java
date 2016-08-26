package mmtweet.dal;

import java.util.List;

import mmtweet.pojos.Comment;
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
		return null;
	}

	@Override
	public List<TweetMessage> getCommentedMessagesByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TweetMessage> getMessagesByLatLongWindow(double minLatitude, double maxLatitude, double leftLongitude,
			double rightLongitude) {
		// TODO Auto-generated method stub
		return null;
	}

}
