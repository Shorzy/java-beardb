package mjn.beardb.facade;

import javax.ejb.Remote;

import mjn.beardb.ejb.Bear;
import mjn.beardb.ejb.Hat;
import mjn.beardb.ejb.Holiday;
import mjn.beardb.ejb.Location;
import mjn.beardb.ejb.Vacation;
import mjn.beardb.ejb.VacationId;

@Remote
public interface FacadeRemote {

	public Bear findBearByName(String name);
	public Bear createBear(Bear bear);
	public Bear createBear(String name);
	public Bear updateBear(Bear bear);
	public void deleteBear(String name);
	
	public Hat findByHatId(int id);
	public Hat createHat(String colour, String bearName);
	public Hat updateHat(Hat hat);
	public void deleteHat(int id);
	
	public Holiday findHolidayByName(String name);
	public Holiday createHoliday(Holiday holiday);
	
	public Location findLocationByName(String name);
	public Location createLocation(Location location);
	
	public Vacation findVacationByVacationId(VacationId vacationId);
	public Vacation createVacation(Vacation vacation);
}