package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class ContratServiceImpl implements IContratService {


	@Autowired
	ContratRepository contratRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	private static final Logger l = Logger.getLogger(ContratServiceImpl.class);



	public List<Contrat> getAllContrats() {
		l.info("In getAllContrats() : ");
		List<Contrat> list=null;
	try {
		
	
		list=(List<Contrat>) contratRepository.findAll();
		l.info("la list de contrats est"+list);
	}catch(Exception e) {
		l.error("il y a erreur"+e);
	}
		l.info("Out getAllContrats() ");
		return list ;
	}


	@Override
	public Integer ajouterContrat(Contrat contrat) {
		l.debug("In ajouterContrat");
		try{
			contratRepository.save(contrat);
			l.info("Contrat ajouter avec ref = "+contrat.getReference());
			l.debug("Out ajouterContrat");
			return contrat.getReference();
		} catch (Exception e) {
			l.error("erreur dans la methode ajouterContrat :"+e);
			return null;
		}
	}





	@Override
	public int deleteContratById(int contratId) {
		l.debug("In deleteContratById ");
		try {
			
				contratRepository.deleteById(contratId);
		
				
			

		} catch (Exception e) {
			l.error("erreur methode deleteContratById :" + e);
			

		}
		return -1;
	}


	@Override
	public void deleteAllContratJPQL() {
		l.debug("In deleteAllContratJPQL ");
		employeRepository.deleteAllContratJPQL();
		l.info("Liste de contrats a été supprimer");
		
	}
}
