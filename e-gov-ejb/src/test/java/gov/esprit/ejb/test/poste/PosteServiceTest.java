package gov.esprit.ejb.test.poste;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Test;

import gov.esprit.service.poste.PosteServiceLocal;


public class PosteServiceTest {

	
	
	@Test
	public void shouldOuvrirCompteValid(){
		try {
			
			Context context = new InitialContext();
			PosteServiceLocal posteService = (PosteServiceLocal) context
				.lookup("e-gov-ear/e-gov-ejb/PosteService!gov.esprit.service.PosteServiceLocal");
			
			 posteService.ouvrirCompte("CIN_TEST");
			 assertEquals(1, posteService.findAll().size());
			 
		} catch (Exception e){
			fail("unexpected error occurs!" + e.getMessage());
		}
		
	}

}
