package mmtweet.pojos.vo;

import mmtweet.pojos.Comment;

public class DoCommentRequest {
	private String userId;
	private String messageId;
	private Comment comment;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	
}
