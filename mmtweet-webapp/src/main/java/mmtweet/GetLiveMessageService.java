package mmtweet;

import java.util.List;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.window.RectangularWindow;

import mmtweet.dal.IMmtweetDal;
import mmtweet.pojos.Location;
import mmtweet.pojos.TweetMessage;
import mmtweet.pojos.vo.GetLiveMessagesRequest;
import mmtweet.pojos.vo.GetLiveMessagesResponse;
import mmtweet.pojos.vo.MmtweetConstants;

public class GetLiveMessageService {
	IMmtweetDal dal;

	public GetLiveMessagesResponse getLiveMessages(GetLiveMessagesRequest request){
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
	}
}
