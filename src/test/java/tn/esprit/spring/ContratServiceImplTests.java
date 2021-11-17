package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.mockito.InjectMocks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.ContratServiceImpl;



@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ContratServiceImplTests {
	@InjectMocks
	ContratServiceImpl cs;
	@Mock
	EmployeRepository employeRepository;
	@Mock

	ContratRepository contratRepository;
	
	@Test
	public void testGetAllContrats(){

		List <Contrat> contrats= new ArrayList(); 
		contrats.add(new Contrat(new Date(),"Stage1",3089));
		contrats.add(new Contrat(new Date(),"Stage2",8432));
		
		
		given(contratRepository.findAll()).willReturn(contrats);
		
		// When 
		List<Contrat> lc =cs.getAllContrats();
		
		// Assert 
		assertSame(lc,contrats);
		

	}
	
	@Test
	public void testAjouterContrat() {
		// Given
		Date date = new Date();
		Contrat c=new Contrat(date,"Stage",2000);
		
		given(contratRepository.save(c)).willReturn(c);
		
		// When 
		int idC=cs.ajouterContrat(c);
		
		// Assert
		assertEquals(idC,c.getReference());
	}
	
	@Test
	public void shouldSuccessDeleteContratById() {
		// Given
		int idC = 5;	
		
		//When
		int i=cs.deleteContratById(idC);
		
		// Assert
		assertEquals(i,idC);
		verify(contratRepository,times(1)).deleteById(idC);
		
	}
	
	@Test
	public void shouldSuccessDeleteAllContrat() {
		// When
		cs.deleteAllContrat();
		
		//Assert
		verify(contratRepository,times(1)).deleteAll();
		
		
	}
	
}
	
	

