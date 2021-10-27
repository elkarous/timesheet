package tn.esprit.spring;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.controller.ControllerTimesheetImpl;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTimeSheetService {
	  @Autowired
	    ControllerTimesheetImpl controllerTimesheet;
	   @Test
	    public void testAjouterMission(){

	        Mission mission=new Mission("formation","Formation Angular");
	        controllerTimesheet.ajouterMission(mission);


	    }
	   @Test
	    public void testAffectrMission(){

	        controllerTimesheet.affecterMissionADepartement(25, 5);


	    }
	   @Test
	    public void testajouterTimesheet(){

		  Date  dateTime = new Date( "08/07/2019" );
	        controllerTimesheet.ajouterTimesheet(25, 6,dateTime,dateTime);


	    }
	 /*  @Test
	    public void testvaliderTimesheet(){
		   
		   Date  dateTime = new Date( "08/07/2019" );
		   Employe emp=new Employe(8,"chakib","yahyaoui","chakib@gmail.com","jfllkfjf6",true,Role.ADMINISTRATEUR);
	        controllerTimesheet.validerTimesheet(25, 9, dateTime, dateTime, emp.getId());

	    }*/
	   @Test
	    public void testfindAllMissionByEmployeJPQL(){

	      
	        controllerTimesheet.findAllMissionByEmployeJPQL(50);


	    }
	   @Test
	    public void testgetAllEmployeByMission(){

	        controllerTimesheet.getAllEmployeByMission(10);


	    }
}
