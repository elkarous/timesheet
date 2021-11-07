package tn.esprit.spring;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.TimesheetServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimeSheetServiceTests {
	
	  @Autowired
		TimesheetServiceImpl timesheetService;
	   @Test
	    public void testAjouterMission(){

	        Mission mission=new Mission("formation","Formation Angular");
	        timesheetService.ajouterMission(mission);


	    }
	   @Test
	    public void testAffectrMission(){

		   timesheetService.affecterMissionADepartement(25, 5);


	    }
	   @Test
	    public void testajouterTimesheet(){

		  Date  dateTime = new Date( "08/07/2019" );
		  timesheetService.ajouterTimesheet(25, 6,dateTime,dateTime);


	    }
	 /*  @Test

	    }*/
	   @Test
	    public void testfindAllMissionByEmployeJPQL(){

	      
		   timesheetService.findAllMissionByEmployeJPQL(50);


	    }
	   @Test
	    public void testgetAllEmployeByMission(){

		   timesheetService.getAllEmployeByMission(10);


	    }
}
