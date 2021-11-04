package tn.esprit.spring.DTO;

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

	

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public EmployeDto getEmploye() {
		return employe;
	}

	public void setEmploye(EmployeDto employe) {
		this.employe = employe;
	}
	

}
