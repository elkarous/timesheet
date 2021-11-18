package tn.esprit.spring.dto;

import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;


public class EmployeDto {
	

	
	@Enumerated(EnumType.STRING)
	private Role roleDto;
	@JsonIgnore
	@ManyToMany(mappedBy="employes",fetch=FetchType.EAGER )
	private List<Departement> departementsDto;
	@JsonIgnore
	@OneToOne(mappedBy="employe")
	private Contrat contratDto;
	
	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private List<Timesheet> timesheetsDto;



	
}