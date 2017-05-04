package mjn.beardb.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="holiday")
public class Holiday implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private int duration;
	
	@Id
	@Column(name="name")
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	@Column(name="duration")
	public int getDuration(){
		return duration;
	}
	public void setDuration(int duration){
		this.duration = duration;
	}
}
