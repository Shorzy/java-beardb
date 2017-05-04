package mjn.beardb.eao;

import javax.ejb.Local;

import mjn.beardb.ejb.Location;

@Local
public interface LocationEAOLocal {

	public Location findLocationByName(String name);
	public Location createLocation(Location location);
	public Location updateLocation(Location location);
	public void deleteLocation(String name);
	
}
