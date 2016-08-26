package mmtweet.pojos.vo;

import mmtweet.pojos.Location;

public class GetLiveMessagesRequest {
		private Location currentLocation;

		public Location getCurrentLocation() {
			return currentLocation;
		}

		public void setCurrentLocation(Location currentLocation) {
			this.currentLocation = currentLocation;
		}
		
		
}
