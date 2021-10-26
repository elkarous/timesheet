package tn.esprit.spring;




import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.controller.ControllerEmployeImpl;
import tn.esprit.spring.controller.ControllerEntrepriseImpl;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;




@SpringBootTest
@RunWith(SpringRunner.class)

public class TestEmployeeService {
	@Autowired
	EmployeServiceImpl employeServiceImpl;

	
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
		 employeServiceImpl.getAllEmployes();
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
	
}
