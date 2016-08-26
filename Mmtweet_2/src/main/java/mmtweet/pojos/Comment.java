package mmtweet.pojos;

public class Comment {
	private String commentId;
	private String userId;
	private String text;
	private Location originalLocation;
	private String creationTime;

	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Location getOriginalLocation() {
		return originalLocation;
	}
	public void setOriginalLocation(Location originalLocation) {
		this.originalLocation = originalLocation;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	
	
}
