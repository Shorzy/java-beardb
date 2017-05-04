package mjn.beardb.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	
	@Id
	@Column(name="name")
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}
