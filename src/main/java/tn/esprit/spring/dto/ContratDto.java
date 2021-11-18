package tn.esprit.spring.dto;



import java.util.Date;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContratDto {


	public ContratDto(Date dateDebut2, String string, int i) {

	}


	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@OneToOne
	private EmployeDto employe;

	
}