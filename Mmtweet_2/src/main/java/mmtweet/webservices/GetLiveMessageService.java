package mmtweet.webservices;

import mmtweet.dal.IMmtweetDal;
import mmtweet.pojos.vo.GetLiveMessagesResponse;

public class GetLiveMessageService {
	IMmtweetDal dal;

	public GetLiveMessagesResponse getLiveMessages(String latitude,String longitude){
		GetLiveMessagesResponse response = new GetLiveMessagesResponse();

		try
		{
			double currentLatitude = Double.parseDouble(latitude);
			double currentLongitude = Double.parseDouble(longitude);
			
			//take rectangle window from current location
			//find rectangle corners
			LatLng currentLatLng = new LatLng(currentLatitude, currentLongitude);
			RectangularWindow window = new RectangularWindow(currentLatLng, MmtweetConstants.LIVE_MESSAGE_WINDOW_WIDTH, MmtweetConstants.LIVE_MESSAGE_WINDOW_HEIGHT, MmtweetConstants.LIVE_MESSAGES_DISTANCE_UNIT);
			double minLatitude = window.getMinLatitude();
			double maxLatitude = window.getMaxLatitude();
			double leftLongitude = window.getLeftLongitude();
			double rightLongitude = window.getRightLongitude();
			
			//call dal to find messages between corner points
			List<TweetMessage> messageList = dal.getMessagesByLatLongWindow(minLatitude, maxLatitude, leftLongitude, rightLongitude);
			response.setMessageList(messageList);
		}
		catch(Exception e)
		{
			System.out.println("error in getLiveMessages " + e.printStackTrace());
		}
		return response;
	}
}
