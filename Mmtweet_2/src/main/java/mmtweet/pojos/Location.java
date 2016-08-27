package mmtweet.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javadocmd.simplelatlng.LatLng;

public class Location {
	@JsonIgnore
	private LatLng latlng = LatLng.random();

	private double latitude;
	private double longitude;

	private String latitudeStr = "0";
	private String longitudeStr = "0";
	
	public Location()
	{
	}

	public Location(double latitude, double longitude)
	{
		latlng.setLatitudeLongitude(latitude, longitude);
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
		latlng.setLatitudeLongitude(this.latitude, this.longitude);
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
		latlng.setLatitudeLongitude(this.latitude, this.longitude);
	}

	public String getLatitudeStr() {
		return latitudeStr;
	}

	public void setLatitudeStr(String latitudeStr) {
		this.latitudeStr = latitudeStr;
		try
		{
			this.latitude = Double.parseDouble(latitudeStr);
		}
		catch (Exception e)
		{
			this.latitude = 0;
		}
		latlng.setLatitudeLongitude(this.latitude, this.longitude);
	}

	public String getLongitudeStr() {
		return longitudeStr;
	}

	public void setLongitudeStr(String longitudeStr) {
		this.longitudeStr = longitudeStr;
		try
		{
			this.longitude = Double.parseDouble(longitudeStr);
		}
		catch(Exception e)
		{
			this.longitude = 0;
		}
		latlng.setLatitudeLongitude(latitude, longitude);
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
