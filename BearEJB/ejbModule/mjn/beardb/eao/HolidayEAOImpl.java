package mjn.beardb.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mjn.beardb.ejb.Holiday;

@Stateless
public class HolidayEAOImpl implements HolidayEAOLocal {

	@PersistenceContext(unitName="BearDB")
	EntityManager em;
	
    public HolidayEAOImpl() {

    }

    public Holiday findHolidayByName(String name){
    	return em.find(Holiday.class, name);
    }
    
    public Holiday createHoliday(Holiday holiday){
    	em.persist(holiday);
    	return holiday;
    }
    
    public Holiday updateHoliday(Holiday holiday){
    	em.merge(holiday);
    	return holiday;
    }
    
    public void deleteHoliday(String name){
    	Holiday h = this.findHolidayByName(name);
    	if(h != null){
    		em.remove(h);
    	}
    }
}
