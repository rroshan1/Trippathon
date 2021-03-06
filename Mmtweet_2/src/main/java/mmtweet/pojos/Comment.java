package mmtweet.pojos;

import mmtweet.pojos.vo.MmtweetConstants;

public class Comment {
	private String commentId;
	private String userId;
	private String text;
	private Location originLocation;
	private long creationTime=0;
	private String creationTimeStr;

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
	public Location getOriginLocation() {
		return originLocation;
	}
	public void setOriginLocation(Location originLocation) {
		this.originLocation = originLocation;
	}
	public long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
		setCreationTimeStr(MmtweetConstants.getDateInString(this.creationTime));
	}

	public String getCreationTimeStr() {
		return creationTimeStr;
	}
	public void setCreationTimeStr(String creationTimeStr) {
		this.creationTimeStr = creationTimeStr;
	}
}
