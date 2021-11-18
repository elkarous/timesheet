package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tn.esprit.spring.repository.EntrepriseRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class TimesheetApplicationTests {

	@Autowired
	EntrepriseRepository repo;
	
	@Test
	void contextLoads() {
		System.out.println(repo);
		assertTrue(true);
	}

}
