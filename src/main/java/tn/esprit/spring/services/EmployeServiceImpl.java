package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.controller.ControllerEmployeImpl;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	private static final Logger logger = Logger.getLogger(ControllerEmployeImpl.class);
	@Override
	public Employe authenticate(String login, String password) {
		logger.debug("debut de la méthode authenticate");
		return employeRepository.getEmployeByEmailAndPassword(login, password);
		
	}

	@Override
	public int addOrUpdateEmploye(Employe employe) {
		logger.debug("debut de la méthode addOrUpdateEmploye");
		try {
		employeRepository.save(employe);
		}catch(Exception e ) {
			logger.error("probléme d'ajout ");
		}
		logger.info(employe);
		return employe.getId();
	}


	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		logger.debug("debut de la méthodeUpdate");
		
		Optional<Employe> employe = employeRepository.findById(employeId);
		if (employe.isPresent()) {
			employe.get().setEmail(email);
			employeRepository.save(employe.get());
			logger.info("l'employé "+employe.get().getNom()+"a changé son email à"+email );
		}
	}

	@Transactional	
	public void affecterEmployeADepartement(int employeId, int depId) {
		Optional<Departement> depManagedEntity = deptRepoistory.findById(depId);
		Optional<Employe> employeManagedEntity = employeRepository.findById(employeId);
		if (!depManagedEntity.isPresent() || !employeManagedEntity.isPresent()) {
			return ;
		}
		if(depManagedEntity.get().getEmployes() == null){

			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity.get());
			depManagedEntity.get().setEmployes(employes);
		}else{

			depManagedEntity.get().getEmployes().add(employeManagedEntity.get());
		}

		// à ajouter? 
		deptRepoistory.save(depManagedEntity.get()); 

	}
	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId)
	{
		Optional <Departement> dep = deptRepoistory.findById(depId);
		if (dep.isPresent()) {
		int employeNb = dep.get().getEmployes().size();
		for(int index = 0; index < employeNb; index++){
			if(dep.get().getEmployes().get(index).getId() == employeId){
				dep.get().getEmployes().remove(index);
				break;//a revoir
			}
		}
		}
	} 
	
	// Tablesapce (espace disque) 

	public int ajouterContrat(Contrat contrat) {
		contratRepoistory.save(contrat);
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		Optional <Contrat> contratManagedEntity = contratRepoistory.findById(contratId);
		Optional <Employe> employeManagedEntity = employeRepository.findById(employeId);
		if (contratManagedEntity.isPresent() && employeManagedEntity.isPresent()) {
			contratManagedEntity.get().setEmploye(employeManagedEntity.get());
			contratRepoistory.save(contratManagedEntity.get());
		}
		

	}

	public String getEmployePrenomById(int employeId) {
		Optional <Employe> employeManagedEntity = employeRepository.findById(employeId);
		if (!employeManagedEntity.isPresent()) {
			return ("not fond");
		}
		return employeManagedEntity.get().getPrenom();
	}
	 
	public void deleteEmployeById(int employeId)
	{
		Optional <Employe> employe = employeRepository.findById(employeId);
		if (!employe.isPresent()) {
			return ;
		}
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		for(Departement dep : employe.get().getDepartements()){
			dep.getEmployes().remove(employe);
		}

		employeRepository.delete(employe.get());
	}

	public void deleteContratById(int contratId) {
		Optional <Contrat> contratManagedEntity = contratRepoistory.findById(contratId);
		if (!contratManagedEntity.isPresent()) {
			return ;
		}
		contratRepoistory.delete(contratManagedEntity.get());

	}

	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNames();

	}

	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}

	
//////////////////////////////////////////////////////////khedmett seiff//////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void deleteAllContratJPQL() {
logger.debug("lancement  de la methode deleteAllContratJPQL ");
try {
employeRepository.deleteAllContratJPQL();
logger.info("suprimé avec succes");
}
catch (Exception e) {
logger.error("il y a un probleme"+e);

}

}





public float getSalaireByEmployeIdJPQL(int employeId) {
logger.debug("lancement  de la methode getSalaireByEmployeIdJPQL ");
float varia=employeRepository.getSalaireByEmployeIdJPQL(employeId);
logger.info("le salire est : "+varia);
return varia;
}




public Double getSalaireMoyenByDepartementId(int departementId) {
logger.debug("lancement  de la methode getSalaireMoyenByDepartementId ");
Double variable= employeRepository.getSalaireMoyenByDepartementId(departementId);
logger.info("le salire est : "+variable);
return variable ;
}





public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,Date dateFin) {
logger.debug("lancement  de la methode getTimesheetsByMissionAndDate ");

List<Timesheet> timesheets= timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);

logger.info("les donnés sont : "+timesheets);
return  timesheets;

}


public List<Employe> getAllEmployes() {

logger.debug("lancement  de la methode get employé ");
List<Employe> employes= (List<Employe>) employeRepository.findAll();
logger.info("les employer sont : "+ employes);
return employes;
}


}
