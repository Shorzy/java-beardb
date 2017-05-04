package mjn.beardb.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="bear")
public class Bear implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private Set<Hat> hats;

	@Id
	@Column(name="name")
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@OneToMany(mappedBy="bear", fetch=FetchType.EAGER)
	public Set<Hat> getHats(){
		return hats;
	}
	
	public void setHats(Set<Hat> hats){
		this.hats = hats;
	}
}
