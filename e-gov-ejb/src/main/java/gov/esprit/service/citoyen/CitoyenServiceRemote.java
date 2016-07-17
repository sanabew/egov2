package gov.esprit.service.citoyen;

import java.util.Date;

import javax.ejb.Remote;

import gov.esprit.domain.Citoyen;
import gov.esprit.domain.Person;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.exception.EgovException;

@Remote
public interface CitoyenServiceRemote {

	public void add(Citoyen citoyen);
	
	public Citoyen findByCin(String cin) throws EgovException;
	
	public Citoyen findByNomAndPrenomAndDateAndGouvernerat(String nom, String prenom, Gouvernerat gouvernerat, Date date)
			throws EgovException;
	public	Citoyen authentificate(String login,String pwd);

	void update(Citoyen citoyen);

}