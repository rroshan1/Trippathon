package mmtweet.pojos;

import java.util.List;

import mmtweet.pojos.vo.MmtweetConstants;

public class TweetMessage {
	private int messageId;
	private String userId;
	private String text;
	private Location originLocation;
	private Location currentLocation;
	private int views;
	private List<Comment> commentList;
	private boolean isPinned;
	private Long creationTime;
	private String creationTimeStr;
	private String flightNumber;
	private Long lastUpdationTime;
	private String lastUpdationTimeStr;
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
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
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public boolean getPinned() {
		return isPinned;
	}
	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public Long getLastUpdationTime() {
		return lastUpdationTime;
	}
	public void setLastUpdationTime(Long lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
		setLastUpdationTimeStr(MmtweetConstants.getDateInString(this.lastUpdationTime));
	}
	
	public Long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
		setCreationTimeStr(MmtweetConstants.getDateInString(this.creationTime));
	}
	public String getCreationTimeStr() {
		return creationTimeStr;
	}
	public void setCreationTimeStr(String creationTimeStr) {
		this.creationTimeStr = creationTimeStr;
	}
	public String getLastUpdationTimeStr() {
		return lastUpdationTimeStr;
	}
	public void setLastUpdationTimeStr(String lastUpdationTimeStr) {
		this.lastUpdationTimeStr = lastUpdationTimeStr;
	}
	@Override
	public String toString() {
		return "TweetMessage [messageId=" + messageId + ", userId=" + userId + ", text=" + text + ", originLocation="
				+ originLocation + ", currentLocation=" + currentLocation + ", views=" + views + ", commentList="
				+ commentList + ", isPinned=" + isPinned + ", creationTime=" + creationTime + ", flightNumber="
				+ flightNumber + ", lastUpdationTime=" + lastUpdationTime + "]";
	}
	
	
}
