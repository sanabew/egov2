package PosteTest;

import javax.naming.Context;
import javax.naming.InitialContext;

import gov.esprit.enums.TypeTransacrion;
import gov.esprit.service.poste.PosteServiceRemote;

public class TransactionTest {
	public static void main(String[] args) {
	try{
	Context context = new InitialContext();
	PosteServiceRemote posteservice = (PosteServiceRemote) context
			.lookup("e-gov-ear/e-gov-ejb/PosteService!gov.esprit.service.poste.PosteServiceRemote");
	posteservice.effectuerTransaction(1,80,"2",TypeTransacrion.DEBIT);
	
	}catch(Exception e){
		e.printStackTrace();
	}

}}
