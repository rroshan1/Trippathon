package mmtweet.pojos;

import java.util.List;

public class TweetMessage {
	private int messageId;
	private int userId;
	private String text;
	private Location originLocation;
	private Location currentLocation;
	private int views;
	private List<Comment> commentList;
	private boolean isPinned;
	private Long creationTime;
	private String flightNumber;
	private Long lastUpdationTime;
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public String getCreationTime() {
		return creationTime.toString();
	}
	public void setCreationTime(String creationTime) {
		try{
		this.creationTime = Long.parseLong(creationTime);
		}
		catch(Exception e)
		{
			this.creationTime = System.currentTimeMillis();
		}
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
	}
	//TODO: Remove the following 2 functions. Present for compilation error fix.
	public void setOriginLocation(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setCurrentLocation(String string) {
		// TODO Auto-generated method stub
		
	}
}
