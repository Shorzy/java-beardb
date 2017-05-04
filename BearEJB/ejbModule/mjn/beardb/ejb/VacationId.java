package mjn.beardb.ejb;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VacationId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Bear bear;
	private Holiday holiday;
	private Location location;
	
	public VacationId() {
	}
	
	public VacationId(Bear bear, Holiday holiday, Location location) {
		this.bear = bear;
		this.holiday = holiday;
		this.location = location;
	}
	
	@ManyToOne
	@JoinColumn(name="bear", referencedColumnName="name")
	public Bear getBear(){
		return bear;
	}
	public void setBear(Bear bear){
		this.bear = bear;
	}
	
	@ManyToOne
	@JoinColumn(name="holiday", referencedColumnName="name")
	public Holiday getHoliday(){
		return holiday;
	}
	public void setHoliday(Holiday holiday){
		this.holiday = holiday;
	}
	
	@ManyToOne
	@JoinColumn(name="location", referencedColumnName="name")
	public Location getLocation(){
		return location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
	
	public boolean equals(Object other){
		if((this == other)){
			return true;
		}
		
		if((other == null)){
			return false;
		}
		
		if(!(other instanceof VacationId)){
			return false;
		}
		
		VacationId castOther = (VacationId)other;
		
		if(!(this.getBear().getName().equals(castOther.getBear().getName()))){
			return false;
		}
		if(!(this.getHoliday().getName().equals(castOther.getHoliday().getName()))){
			return false;
		}
		if(!(this.getLocation().getName().equals(castOther.getLocation().getName()))){
			return false;
		}
		return true;
	}
	
	public int hashCode(){
		return super.hashCode();
	}
}
