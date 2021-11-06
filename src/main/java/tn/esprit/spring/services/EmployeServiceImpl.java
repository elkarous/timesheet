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
	private static final Logger logger = Logger.getLogger(EmployeServiceImpl.class);

	
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
		} catch (Exception e) {
			logger.error("probléme d'ajout ");
		}
		logger.info(employe);
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {

		logger.debug("debut de la méthodeUpdate");
		Employe employe = null;
		Optional<Employe> employeOP=employeRepository.findById(employeId);
		if(employeOP.isPresent()) {
			employe = employeOP.get();
		
		employe.setEmail(email);
		employeRepository.save(employe);
		logger.info("l'employé "+employe.getNom()+"a changé son email à"+email );
		}
		

		
	}

	@Transactional
	public void affecterEmployeADepartement(int employeId, int depId) {

		
		Employe employeManagedEntity = null;
		Optional<Employe> employeOP=employeRepository.findById(employeId);
		if(employeOP.isPresent()) {
			employeManagedEntity = employeOP.get();
		}
logger.info("gfguihio");
Departement depManagedEntity = null;
Optional<Departement> departementOP=deptRepoistory.findById(depId);
if(departementOP.isPresent()) {
	depManagedEntity = departementOP.get();

		if(depManagedEntity.getEmployes() == null){


			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity);
			depManagedEntity.setEmployes(employes);
		} else {

			depManagedEntity.getEmployes().add(employeManagedEntity);
		}
}
		// à ajouter? 
		deptRepoistory.save(depManagedEntity); 



	}

	@Transactional

	public void desaffecterEmployeDuDepartement(int employeId, int depId)
	{
		Departement dep = null;
		Optional<Departement> departementOP=deptRepoistory.findById(depId);
		if(departementOP.isPresent()) {
			dep = departementOP.get();
		
		

		int employeNb = dep.getEmployes().size();
		for(int index = 0; index < employeNb; index++){
			if(dep.getEmployes().get(index).getId() == employeId){
				dep.getEmployes().remove(index);
				break;//a revoir
			}
		}}
	} 
	
	// Tablesapce (espace disque) 

	public int ajouterContrat(Contrat contrat) {
		contratRepoistory.save(contrat);
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {

		
		Employe employeManagedEntity = null;
		Optional<Employe> employeOP=employeRepository.findById(employeId);
		if(employeOP.isPresent()) {
			employeManagedEntity = employeOP.get();
		}
		Contrat contratManagedEntity = null;
		Optional<Contrat> contratOp=contratRepoistory.findById(contratId);
		if(contratOp.isPresent()) {
			contratManagedEntity = contratOp.get();
		contratManagedEntity.setEmploye(employeManagedEntity);
		}
		contratRepoistory.save(contratManagedEntity);


	}

	public String getEmployePrenomById(int employeId) {

		Employe employeManagedEntity = null;
		String nom=null;
		try {
		Optional<Employe> employeOP=employeRepository.findById(employeId);
		if(employeOP.isPresent()) {
			employeManagedEntity = employeOP.get();
		
       nom =employeManagedEntity.getPrenom();
		}
		}catch(Exception e) {
			logger.error(e);
		}
		return nom;
		
	}
	 
	public void deleteEmployeById(int employeId)
	{ Employe employe = null;
	Optional<Employe> employeOP=employeRepository.findById(employeId);
	if(employeOP.isPresent()) {
		employe = employeOP.get();
	

		for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);
		}
	}
		employeRepository.delete(employe);
	}

	public void deleteContratById(int contratId) {
		Contrat contratManagedEntity = null;
		Optional<Contrat> contratOp=contratRepoistory.findById(contratId);
		if(contratOp.isPresent()) {
			contratManagedEntity = contratOp.get();
		}
		
		contratRepoistory.delete(contratManagedEntity);

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

	public void deleteAllContratJPQL() {
		logger.debug("lancement  de la methode deleteAllContratJPQL ");
		try {
			employeRepository.deleteAllContratJPQL();
			logger.info("suprimé avec succes");
		} catch (Exception e) {
			logger.error("il y a un probleme" + e);

		}

	}

	public float getSalaireByEmployeIdJPQL(int employeId) {
		logger.debug("lancement  de la methode getSalaireByEmployeIdJPQL ");
		float varia = employeRepository.getSalaireByEmployeIdJPQL(employeId);
		logger.info("le salire est : " + varia);
		return varia;
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		logger.debug("lancement  de la methode getSalaireMoyenByDepartementId ");
		Double variable = employeRepository.getSalaireMoyenByDepartementId(departementId);
		logger.info("le salire est : " + variable);
		return variable;
	}

	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		logger.debug("lancement  de la methode getTimesheetsByMissionAndDate ");

		List<Timesheet> timesheets = timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut,
				dateFin);

		logger.info("les donnés sont : " + timesheets);
		return timesheets;

	}

	public List<Employe> getAllEmployes() {

		logger.debug("lancement  de la methode get employé ");
		List<Employe> employes = employeRepository.findAll();
		logger.info("les employer sont : " + employes);
		return employes;
	}

}
