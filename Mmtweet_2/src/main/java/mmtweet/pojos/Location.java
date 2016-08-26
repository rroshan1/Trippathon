package mmtweet.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javadocmd.simplelatlng.LatLng;

public class Location {
	@JsonIgnore
	private LatLng latlng;

	private double latitude;
	private double longitude;

	public Location()
	{
		latlng = LatLng.random();
	}

	public Location(double latitude, double longitude)
	{
		latlng = new LatLng(latitude, longitude);
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
}
