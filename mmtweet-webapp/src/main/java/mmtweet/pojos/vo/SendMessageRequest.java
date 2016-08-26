package mmtweet.pojos.vo;

import mmtweet.pojos.TweetMessage;

public class SendMessageRequest {

	private String userId;
	private TweetMessage message;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public TweetMessage getMessage() {
		return message;
	}
	public void setMessage(TweetMessage message) {
		this.message = message;
	}	
}
