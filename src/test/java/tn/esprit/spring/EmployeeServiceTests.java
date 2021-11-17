package tn.esprit.spring;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	RestControlEmploye controller;
	@Autowired
	IEmployeService employeService;
	
	@Test 
	public void authenticateTest() {
		
	employeService.authenticate("Ouajdi", "45689");
		
		
	}
	
	@Test 
	public void addOrUpdateEmployeTest() {
		Employe employe=new Employe(50,"wajdi","Ammar","wajdi@gmail.tn","123456",true,Role.ADMINISTRATEUR);
	employeService.addOrUpdateEmploye(employe);
		
		
	}


	
/////////////////////////////////////////////seif//////////////////////////////////////////////////////
	
	

	@Test
	public   void  testgetAllEmployes() {
		Employe employe=new Employe(50,"wajdi","Ammar","wajdi@gmail.tn","123456",true,Role.ADMINISTRATEUR);
		employeService.addOrUpdateEmploye(employe);
		employeService.getAllEmployes();
	}
	

	
	
	
	@Test
	public   void  testgetSalaireMoyenByDepartementId() {
		 employeServiceImpl.getSalaireMoyenByDepartementId(5);
	}
	
	
	@Test
	public   void  testdeleteAllContratJPQL() {
		 employeServiceImpl.deleteAllContratJPQL();
	}
	

///////////////////////////////////////////////////////////////// mohamed //////////////////////////////////////////////
@Test
	public void testAffecterContratAEmploye() {
		Date  dateDebut = new Date( "08/07/2021" );
		Employe employe= controller.ajouterEmploye (new EmployeDto( ));
		Contrat contrat = controller.ajouterContrat(new ContratDto(dateDebut, "CDI", 1254));
		controller.affecterContratAEmploye(contrat.getReference(), employe.getId());
	
		
	}
@Test
public void testgetEmployePrenomById() {
 String prenom = employeServiceImpl.getEmployePrenomById(20);
assertThat(prenom).isEqualTo(null);
}
@Test
public void testDeleteEmployeById() {
	Employe employe= controller.ajouterEmploye (new EmployeDto( ));
	assertNotEquals(employe.getId(),0);
	controller.deleteEmployeById(employe.getId());
	
}

}