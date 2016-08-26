package mmtweet.pojos.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import mmtweet.pojos.TweetMessage;

public class GetMyMessagesResponse {


	private List<TweetMessage> messageList = new ArrayList<TweetMessage>();

	public List<TweetMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<TweetMessage> messageList) {
		this.messageList = messageList;
	}
	
	
}
