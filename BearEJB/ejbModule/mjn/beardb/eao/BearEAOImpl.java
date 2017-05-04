package mjn.beardb.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mjn.beardb.ejb.Bear;

@Stateless
public class BearEAOImpl implements BearEAOLocal {

    @PersistenceContext(unitName="BearDB")
	private EntityManager em;
    
    public BearEAOImpl() {
    	
    }
    
    public Bear findByName(String name){
    	return em.find(Bear.class, name);
    }
    
    public Bear createBear(Bear bear){
    	em.persist(bear);
    	return bear;
    }
    
    public Bear updateBear(Bear bear){
    	em.merge(bear);
    	return bear;
    }
    
    public void deleteBear(String name){
    	Bear b = this.findByName(name);
    	if(b != null){
    		em.remove(b);
    	}
    }

}
