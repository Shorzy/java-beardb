package mjn.beardb.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mjn.beardb.ejb.Location;

@Stateless
public class LocationEAOImpl implements LocationEAOLocal {

	@PersistenceContext(unitName="BearDB")
	EntityManager em;
	
    public LocationEAOImpl() {

    }

    public Location findLocationByName(String name){
    	return em.find(Location.class, name);
    }
    
    public Location createLocation(Location hat){
    	em.persist(hat);
    	return hat;
    }
    
    public Location updateLocation(Location hat){
    	em.merge(hat);
    	return hat;
    }
    
    public void deleteLocation(String name){
    	Location l = this.findLocationByName(name);
    	if(l != null){
    		em.remove(l);
    	}
    }
}
