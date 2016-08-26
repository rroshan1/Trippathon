package mmtweet.pojos.vo;

import java.util.ArrayList;
import java.util.List;

import mmtweet.pojos.TweetMessage;

public class GetLiveMessagesResponse {
	private List<TweetMessage> messageList = new ArrayList<TweetMessage>();

	public List<TweetMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<TweetMessage> messageList) {
		this.messageList = messageList;
	}

}
