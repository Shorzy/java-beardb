package mjn.beardb.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mjn.beardb.ejb.Vacation;
import mjn.beardb.ejb.VacationId;

/**
 * Session Bean implementation class HatEAOImpl
 */
@Stateless
public class VacationEAOImpl implements VacationEAOLocal {

	@PersistenceContext(unitName="BearDB")
	EntityManager em;
	
    public VacationEAOImpl() {

    }

    public Vacation findVacationByVacationId(VacationId vacationId){
    	return em.find(Vacation.class, vacationId);
    }
    
    public Vacation createVacation(Vacation vacation){
    	em.persist(vacation);
    	return vacation;
    }
    
    public Vacation updateVacation(Vacation vacation){
    	em.merge(vacation);
    	return vacation;
    }
    
    public void deleteVacation(VacationId vacationId){
    	Vacation v = this.findVacationByVacationId(vacationId);
    	if(v != null){
    		em.remove(v);
    	}
    }
}
