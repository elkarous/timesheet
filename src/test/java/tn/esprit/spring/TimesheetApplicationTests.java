package tn.esprit.spring;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.controller.ControllerEntrepriseImpl;
import tn.esprit.spring.entities.Entreprise;

@SpringBootTest
class TimesheetApplicationTests {


    @Autowired
    ControllerEntrepriseImpl entrepriseController;

    Integer a,b;

    @Test
    public void testAjouterEntreprise(){

        Entreprise ent=new Entreprise("esprit","Ghazala");
        a= entrepriseController.ajouterEntreprise(ent);
        assertNotNull(a);


    }

    @Test
    public void testGetEntrepriseById(){

        Entreprise ent= entrepriseController.getEntrepriseById(13);

        assertNotNull(ent);

    }
}
