package mjn.beardb.eao;

import javax.ejb.Local;

import mjn.beardb.ejb.Bear;

@Local
public interface BearEAOLocal {
	public Bear findByName(String name);
	public Bear createBear(Bear bear);
	public Bear updateBear(Bear bear);
	public void deleteBear(String name);
}
