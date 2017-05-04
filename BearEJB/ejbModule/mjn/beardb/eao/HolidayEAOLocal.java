package mjn.beardb.eao;

import javax.ejb.Local;

import mjn.beardb.ejb.Holiday;

@Local
public interface HolidayEAOLocal {

	public Holiday findHolidayByName(String name);
	public Holiday createHoliday(Holiday holiday);
	public Holiday updateHoliday(Holiday holiday);
	public void deleteHoliday(String name);
	
}
