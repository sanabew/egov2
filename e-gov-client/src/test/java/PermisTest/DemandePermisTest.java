package PermisTest;



import javax.naming.Context;
import javax.naming.InitialContext;

import gov.esprit.service.permis.PermisServiceRemote;

public class DemandePermisTest {

	public static void main(String[] args) {
		
		
    	
    
		try{
			
			
		Context context;
		context = new InitialContext();
		PermisServiceRemote permisservice = (PermisServiceRemote) context
				.lookup("e-gov-ear/e-gov-ejb/PermisService!gov.esprit.service.permis.PermisServiceRemote");
		System.out.println("resolution jndi");
		permisservice.demanderPermis("1");
		permisservice.demanderPermis("4");
		System.out.println("permis service");
		}catch(Exception e){
			System.out.println("exception");
			e.printStackTrace();
		}

	}

}
