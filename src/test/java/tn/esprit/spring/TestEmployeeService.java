package tn.esprit.spring;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.controller.ControllerEmployeImpl;
import tn.esprit.spring.controller.ControllerEntrepriseImpl;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;




@SpringBootTest
@RunWith(SpringRunner.class)

public class TestEmployeeService {
	
	
	@Autowired
    ControllerEmployeImpl Controller;
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


	@Test 
	public void mettreAjourEmailByEmployeIdTest() {
		/*Employe employe=new Employe(50,"wajdi","Ammar","wajdi@gmail.tn","123456",true,Role.ADMINISTRATEUR);
		employeService.addOrUpdateEmploye(employe);
	employeService.mettreAjourEmailByEmployeId("wajdi@esprit.tn", 50);*/
	employeService.deleteEmployeById(50);
		
		
	}

	
}
