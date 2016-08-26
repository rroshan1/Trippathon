package mmtweet.webservices;

import mmtweet.dal.IMmtweetDal;
import mmtweet.pojos.vo.GetLiveMessagesResponse;

public class GetLiveMessageService {
	IMmtweetDal dal;

	public GetLiveMessagesResponse getLiveMessages(String latitude,String longitude){/*
		GetLiveMessagesResponse response = new GetLiveMessagesResponse();
		if (request == null || request.getCurrentLocation() == null)
			return response;
		
		//take rectangle window from current location
		//find rectangle corners
		Location currentLocation = request.getCurrentLocation();
		LatLng currentLatLng = currentLocation.getLatLng();
		RectangularWindow window = new RectangularWindow(currentLatLng, MmtweetConstants.LIVE_MESSAGE_WINDOW_WIDTH, MmtweetConstants.LIVE_MESSAGE_WINDOW_HEIGHT, MmtweetConstants.LIVE_MESSAGES_DISTANCE_UNIT);
		double minLatitude = window.getMinLatitude();
		double maxLatitude = window.getMaxLatitude();
		double leftLongitude = window.getLeftLongitude();
		double rightLongitude = window.getRightLongitude();
		
		//call dal to find messages between corner points
		List<TweetMessage> messageList = dal.getMessagesByLatLongWindow(minLatitude, maxLatitude, leftLongitude, rightLongitude);
		response.setMessageList(messageList);

		return response;
	*/
	return new GetLiveMessagesResponse();    
	}
}