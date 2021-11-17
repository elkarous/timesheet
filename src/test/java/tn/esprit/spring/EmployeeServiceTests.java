package tn.esprit.spring;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.controller.ControllerEmployeImpl;
import tn.esprit.spring.controller.RestControlEmploye;
import tn.esprit.spring.dto.ContratDto;
import tn.esprit.spring.dto.EmployeDto;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;




@SpringBootTest
@RunWith(SpringRunner.class)

public class EmployeeServiceTests {
	@Autowired
	EmployeServiceImpl employeServiceImpl;

	
	@Autowired
	RestControlEmploye Controller;
	@Autowired
	IEmployeService employeService;
	
	@Test 
	public void authenticateTest() {
		
	employeService.authenticate("wajdi", "123456");
		
		
	}
	
	@Test 
	public void addOrUpdateEmployeTest() {
		Employe employe=new Employe(50,"wajdi","Ammar","wajdi@gmail.tn","123456",true,Role.ADMINISTRATEUR);
	employeService.addOrUpdateEmploye(employe);
		
		
	}


	/*@Test 
	public void mettreAjourEmailByEmployeIdTest() {
	Employe employe=new Employe(50,"wajdi","Ammar","wajdi@gmail.tn","123456",true,Role.ADMINISTRATEUR);
		employeService.addOrUpdateEmploye(employe);
	employeService.mettreAjourEmailByEmployeId("wajdi@esprit.tn", 50);
	employeService.deleteEmployeById(50);
		
		
	}*/
/////////////////////////////////////////////seif//////////////////////////////////////////////////////
	
	

	@Test
	public   void  testgetAllEmployes() {
		Employe employe=new Employe(50,"wajdi","Ammar","wajdi@gmail.tn","123456",true,Role.ADMINISTRATEUR);
		employeService.addOrUpdateEmploye(employe);
		employeService.getAllEmployes();
	}
	

	/*

	@Test
	public   void  testgetSalaireMoyenByDepartementId() {
		 employeServiceImpl.getSalaireMoyenByDepartementId(5);
	}
	
	/*@Test
	public   void  testgetTimesheetsByMissionAndDate() {
		Employe employe = new Employe("seif" , "rjaibi" , "seif.rjaibi1@esprit.tn", true , Role.ADMINISTRATEUR );
		Mission mission = new Mission("Mission kaloun " , "kililin");
		  Date  dateTime = new Date( "08/07/2019" );
		 employeServiceImpl.getTimesheetsByMissionAndDate(employe, mission , dateTime, dateTime);

	}

	}*/
	
	
	@Test
	public   void  testgetSalaireMoyenByDepartementId() {
		 employeServiceImpl.getSalaireMoyenByDepartementId(5);
	}
	/*

	@Test
	public   void  testgetSalaireByEmployeIdJPQL() {
		 employeServiceImpl.getSalaireByEmployeIdJPQL(10);
	}*/
	
	@Test
	public   void  testdeleteAllContratJPQL() {
		 employeServiceImpl.deleteAllContratJPQL();
	}
	

///////////////////////////////////////////////////////////////// mohamed //////////////////////////////////////////////
@Test
	public void testAffecterContratAEmploye() {
		Date  dateDebut = new Date( "08/07/2021" );
		Employe employe= Controller.ajouterEmploye (new EmployeDto("Chedi","Rhaiem","chedy.rhaiemeu@esprit.tn",true,Role.ADMINISTRATEUR ));
		Contrat contrat = Controller.ajouterContrat(new ContratDto(dateDebut,"CDI",1252));
		Controller.affecterContratAEmploye(contrat.getReference(), employe.getId());
		
		//controllerEmploye.deleteEmployeById(employe.getId());
		
	}
@Test
public void testgetEmployePrenomById() {
 String prenom = employeServiceImpl.getEmployePrenomById(20);
assertThat(prenom).isEqualTo(null);
}
@Test
public void testDeleteEmployeById() {
	Employe employe= Controller.ajouterEmploye (new EmployeDto("Chedi","Rh","chedy.rhaiemeu@esprit.tn",true,Role.ADMINISTRATEUR ));
	assertNotEquals(employe.getId(),0);
	Controller.deleteEmployeById(employe.getId());
	
}

}