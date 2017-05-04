package mjn.beardb.ejb;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="hat")
public class Hat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String colour;
	private Bear bear;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	@Column(name="colour")
	public String getColour(){
		return colour;
	}
	
	public void setColour(String colour){
		this.colour = colour;
	}
	
	@ManyToOne
	@JoinColumn(name="bear", referencedColumnName="name")
	public Bear getBear(){
		return bear;
	}
	
	public void setBear(Bear bear){
		this.bear = bear;
	}
}
