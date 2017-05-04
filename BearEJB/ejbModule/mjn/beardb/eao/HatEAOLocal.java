package mjn.beardb.eao;

import javax.ejb.Local;

import mjn.beardb.ejb.Hat;

@Local
public interface HatEAOLocal {

	public Hat findById(int id);
	public Hat createHat(Hat hat);
	public Hat updateHat(Hat hat);
	public void deleteHat(int id);
	
}
