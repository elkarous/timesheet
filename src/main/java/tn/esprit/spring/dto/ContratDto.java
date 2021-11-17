package tn.esprit.spring.dto;



import java.util.Date;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.spring.entities.Employe;

public class ContratDto {

	public ContratDto(Date dateDebut2, String string, int i) {

	}

	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	

	
	private String typeContrat;
	

	private float telephone;

	
	@OneToOne
	private Employe employe;

	public ContratDto(Date dateDebut, String typeContrat, float salaire) {
		super();
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}

	private float salaire;
	

	
}
