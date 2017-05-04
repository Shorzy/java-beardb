package mjn.beardb.eao;

import javax.ejb.Local;

import mjn.beardb.ejb.Vacation;
import mjn.beardb.ejb.VacationId;

@Local
public interface VacationEAOLocal {

	public Vacation findVacationByVacationId(VacationId vacationId);
	public Vacation createVacation(Vacation vacation);
	public Vacation updateVacation(Vacation vacation);
	public void deleteVacation(VacationId vacationId);
	
}
