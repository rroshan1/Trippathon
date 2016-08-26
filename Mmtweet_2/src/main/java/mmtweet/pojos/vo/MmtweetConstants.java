package mmtweet.pojos.vo;

import com.javadocmd.simplelatlng.util.LengthUnit;

public class MmtweetConstants {

	public static final double LIVE_MESSAGE_WINDOW_WIDTH = 50;
	public static final double LIVE_MESSAGE_WINDOW_HEIGHT = 50;
	public static final LengthUnit LIVE_MESSAGES_DISTANCE_UNIT = LengthUnit.METER;
	
	public static double WIND_SPEED = 0.005; //unit meter/millisec means 5 meter / sec means 300 meter / min
	public static WindDirection WIND_DIRECTION = WindDirection.N;
	
	public enum WindDirection
	{
		N,
		E,
		W,
		S		
	}
	
	public static void setWindDirection(WindDirection direction)
	{
		WIND_DIRECTION = direction;
	}
	
	public static void setWindSpeed(double speed)
	{
		WIND_SPEED = speed;
	}
}
