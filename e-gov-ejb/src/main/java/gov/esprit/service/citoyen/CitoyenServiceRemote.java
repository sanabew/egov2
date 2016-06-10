package gov.esprit.service.citoyen;

import javax.ejb.Remote;

import gov.esprit.domain.Citoyen;

@Remote
public interface CitoyenServiceRemote {

	
	public Citoyen findByCin(String cin) ;

	void addCitoyen(Citoyen c);

}
