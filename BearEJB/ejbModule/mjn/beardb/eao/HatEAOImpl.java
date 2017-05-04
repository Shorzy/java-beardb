package mjn.beardb.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mjn.beardb.ejb.Hat;

@Stateless
public class HatEAOImpl implements HatEAOLocal {

	@PersistenceContext(unitName="BearDB")
	EntityManager em;
	
    public HatEAOImpl() {

    }

    public Hat findById(int id){
    	return em.find(Hat.class, id);
    }
    
    public Hat createHat(Hat hat){
    	em.persist(hat);
    	return hat;
    }
    
    public Hat updateHat(Hat hat){
    	em.merge(hat);
    	return hat;
    }
    
    public void deleteHat(int id){
    	Hat h = this.findById(id);
    	if(h != null){
    		em.remove(h);
    	}
    }
}
