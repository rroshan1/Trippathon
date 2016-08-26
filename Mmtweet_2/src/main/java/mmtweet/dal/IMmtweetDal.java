package mmtweet.dal;

import java.util.List;

import mmtweet.pojos.Comment;
import mmtweet.pojos.TweetMessage;

public interface IMmtweetDal {
	
	public boolean addMessage(String userId, TweetMessage message);
	public boolean addComment(String userId, String messageId, Comment comment);
	public List<TweetMessage> getMessagesByUserId(String userId);
	public List<TweetMessage> getCommentedMessagesByUserId(String userId);

}
