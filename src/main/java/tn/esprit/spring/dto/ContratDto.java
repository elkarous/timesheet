package tn.esprit.spring.dto;



import java.util.Date;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContratDto {

	private int reference;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	private String typeContrat;
	@OneToOne
	private EmployeDto employe;
	private float salaire;
	
}
