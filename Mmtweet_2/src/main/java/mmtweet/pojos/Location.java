package mmtweet.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javadocmd.simplelatlng.LatLng;

public class Location {
	@JsonIgnore
	private LatLng latlng;

	private double latitude;
	private double longitude;

	private String latitudeStr = "0";
	private String longitudeStr = "0";
	
	public Location()
	{
		latlng = LatLng.random();
	}

	public Location(String latitudeStr, String longitudeStr)
	{
		try
		{
			this.latitudeStr = latitudeStr;
			this.latitude = Double.parseDouble(latitudeStr);
		}
		catch (Exception e)
		{
			this.latitude = 0;
		}
		try
		{
			this.longitudeStr = longitudeStr;
			this.longitude = Double.parseDouble(longitudeStr);
		}
		catch(Exception e)
		{
			this.longitude = 0;
		}
		latlng = new LatLng(latitude, longitude);
	}
	
	public Location(double latitude, double longitude)
	{
		latlng = new LatLng(latitude, longitude);
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return this.latitude;
	}
	public double getLongitude() {
		return this.longitude;
	}
	
	public LatLng getLatLng()
	{
		return this.latlng;
	}

	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
