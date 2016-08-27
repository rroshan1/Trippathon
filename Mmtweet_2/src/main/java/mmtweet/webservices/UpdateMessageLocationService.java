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
		if ( delta < 0 || lastUpdationTime.longValue() <= 0)
		{
			System.err.println("delta < 0; currentTime="+currentTime + ",lastUpdationTime="+lastUpdationTime);
			return currentLocation;
		}
		double distance = delta * MmtweetConstants.WIND_SPEED;	//unit of distance will be meter

		//based on wind direction, find +deltaLat, +deltaLng, -deltaLat, -deltaLng
		//create RectangularWindow
		double deltaLat = 0;	//this is delta width
		double deltaLng = 0;	// this is delta height
		
		if (MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.N 
				|| MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.S)
			deltaLat = distance*2;
		else if (MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.E
				|| MmtweetConstants.WIND_DIRECTION == MmtweetConstants.WindDirection.W)
			deltaLng = distance*2;
		
		System.out.println("deltaLat="+deltaLat+",deltaLng="+deltaLng+",distance="+distance+",currentTime="+currentTime+",lastUpdationTime="+lastUpdationTime);
		RectangularWindow window = new RectangularWindow(currentLocation.getLatLng(), deltaLat, deltaLng, MmtweetConstants.LIVE_MESSAGES_DISTANCE_UNIT);

		System.out.println("window corners window.getMaxLatitude()=" + window.getMaxLatitude() + ",window.getMinLatitude()=" + window.getMinLatitude() + ",window.getRightLongitude()="+window.getRightLongitude() + ",window.getLeftLongitude()="+window.getLeftLongitude());
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

		updatedLat = currentLocation.getLatitude() * 1.00005;
		updatedLong = currentLocation.getLongitude() * 1.00005;
		
		System.out.println("updatedLat="+updatedLat + ",updatedLong="+updatedLong);
		return new Location(updatedLat, updatedLong);
	}

	
}
