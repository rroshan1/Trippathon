package mmtweet.webservices;

import java.util.List;
import java.util.concurrent.Callable;

import com.javadocmd.simplelatlng.window.RectangularWindow;

import mmtweet.dal.AccessDal;
import mmtweet.dal.IMmtweetDal;
import mmtweet.pojos.Location;
import mmtweet.pojos.TweetMessage;
import mmtweet.pojos.vo.MmtweetConstants;

public class UpdateMessageLocationService implements Callable<String> {

	IMmtweetDal dal = new AccessDal();
	@Override
	public String call() throws Exception
	{
		while (true)
		{
			System.out.println("Going to fetch all non-pinned messages from dal");
			//fetch all non-pinned messages from dal
			List<TweetMessage> messageList = dal.getAllMessages(false);
			if (messageList == null)
				return null;
			//iterate on each
			System.out.println("Going to iterate on each");
			for (TweetMessage message : messageList)
			{
				System.out.println("message=" + message.toString());
				if (message.getPinned())
				{
					System.err.println("pinned message returned; no need to update location");
					continue;
				}
				// 	find updated location as per weather
				Location currentLocation = message.getCurrentLocation();
				Long lastUpdationTime = message.getLastUpdationTime();
				System.out.println("going to find updated location as per weather; currentLocation" + currentLocation.toString() + ",lastUpdationTime" + lastUpdationTime.toString());
				Location updatedLocation = getUpdatedLocation(currentLocation, lastUpdationTime);
				//	set in dal
				System.out.println("going to set in db; updatedLocation="+updatedLocation.toString());
				dal.updateMessageLocation(message.getMessageId(), updatedLocation, System.currentTimeMillis());
			}
			System.out.println("going to sleep");
			Thread.sleep(MmtweetConstants.UPDATE_LOCATION_FREQUENCY);
		}
	}
	
	private Location getUpdatedLocation(Location currentLocation, Long lastUpdationTime)
	{
		Long currentTime = System.currentTimeMillis();
		Long delta = currentTime - lastUpdationTime;
		if ( delta < 0 )
		{
			System.err.println("delta < 0; currentTime="+currentTime + ",lastUpdationTime="+lastUpdationTime);
			return null;
		}
		double distance = delta * MmtweetConstants.WIND_SPEED;	//unit of distance will be meter

		//based on wind direction, find +deltaLat, +deltaLng, -deltaLat, -deltaLng
		//create RectangularWindow
		double deltaLat = 0;
		double deltaLng = 0;
		
		if (MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.N 
				|| MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.S)
			deltaLat = distance;
		else if (MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.E
				|| MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.W)
			deltaLng = distance;
		
		RectangularWindow window = new RectangularWindow(currentLocation.getLatLng(), deltaLat, deltaLng);
		
		//based on direction do get one corner of the rectangle
		double updatedLat = currentLocation.getLatitude();
		double updatedLong = currentLocation.getLongitude();
		if (MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.N)
			updatedLat = window.getMaxLatitude();
		else if (MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.S)
			updatedLat = window.getMinLatitude();
		else if (MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.E)
			updatedLong = window.getRightLongitude();
		else if (MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.W)
			updatedLong = window.getLeftLongitude();

		return new Location(updatedLat, updatedLong);
	}

	
}
