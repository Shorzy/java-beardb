package mjn.beardb.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="vacation")
public class Vacation implements Serializable{

	private static final long serialVersionUID = 1L;
	private VacationId vacationId;
	private String specialNotes;
	
	@EmbeddedId
	public VacationId getVacationId() {
		return vacationId;
	}
	public void setVacationId(VacationId vacationId){
		this.vacationId = vacationId;
	}
	
	@Column(name="special_notes")
	public String getSpecialNotes(){
		return specialNotes;
	}
	public void setSpecialNotes(String specialNotes){
		this.specialNotes = specialNotes;
	}
}
