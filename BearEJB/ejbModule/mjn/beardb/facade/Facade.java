package mjn.beardb.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mjn.beardb.eao.BearEAOLocal;
import mjn.beardb.eao.HatEAOLocal;
import mjn.beardb.eao.HolidayEAOLocal;
import mjn.beardb.eao.LocationEAOLocal;
import mjn.beardb.eao.VacationEAOLocal;
import mjn.beardb.ejb.Bear;
import mjn.beardb.ejb.Hat;
import mjn.beardb.ejb.Holiday;
import mjn.beardb.ejb.Location;
import mjn.beardb.ejb.Vacation;
import mjn.beardb.ejb.VacationId;

@Stateless
public class Facade implements FacadeLocal {

	@EJB
	private BearEAOLocal bearEAO;
	
	@EJB
	private HatEAOLocal hatEAO;
	
	@EJB
	private HolidayEAOLocal holidayEAO;
	
	@EJB
	private LocationEAOLocal locationEAO;
	
	@EJB
	private VacationEAOLocal vacationEAO;
	
	public Facade() {
		
	}
	
	public Bear findBearByName(String name){
		return bearEAO.findByName(name);
	}
	
	public Bear createBear(Bear bear){
		return bearEAO.createBear(bear);
	}
	
	public Bear createBear(String name){
		Bear b = new Bear();
		b.setName(name);
		return bearEAO.createBear(b);
	}
	
	public Bear updateBear(Bear bear){
		return bearEAO.updateBear(bear);
	}
	
	public void deleteBear(String name){
		bearEAO.deleteBear(name);
	}
	
	public Hat findHatById(int id){
		return hatEAO.findById(id);
	}
	
	public Hat createHat(String colour, String bearName){
		Hat h = new Hat();
		h.setColour(colour);
		Bear b = bearEAO.findByName(bearName);
		h.setBear(b);
		
		hatEAO.createHat(h);
		return h;
	}
	
	public Hat updateHat(Hat hat){
		return hatEAO.updateHat(hat);
	}
	
	public void deleteHat(int id){
		hatEAO.deleteHat(id);
	}

	public Holiday findHolidayByName(String name) {
		return holidayEAO.findHolidayByName(name);
	}

	public Holiday createHoliday(Holiday holiday) {
		return holidayEAO.createHoliday(holiday);
	}

	public Location findLocationByName(String name) {
		return locationEAO.findLocationByName(name);
	}

	public Location createLocation(Location location) {
		return locationEAO.createLocation(location);
	}

	public Vacation findVacationByVacationId(VacationId vacationId) {
		return vacationEAO.findVacationByVacationId(vacationId);
	}

	public Vacation createVacation(Vacation vacation) {
		return vacationEAO.createVacation(vacation);
	}

}
