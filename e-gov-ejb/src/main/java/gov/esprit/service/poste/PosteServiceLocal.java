package gov.esprit.service.poste;

import java.util.List;

import javax.ejb.Local;
import javax.naming.NamingException;

import gov.esprit.domain.Compte;
import gov.esprit.domain.Transaction;
import gov.esprit.enums.TypeTransacrion;
import gov.esprit.exception.EgovException;
@Local
public interface PosteServiceLocal {
	
	public Compte rechercherCompteParNum(int numeroCompte);
	
	public float consulterSolde(int numeroCompte);
	
	public void effectuerTransaction(int numeroCompte, float montant, String cin, TypeTransacrion type)throws EgovException;
	
	public List<Transaction> extraireReleve(int numeroCompte, String cin);
	
	public int ouvrirCompte(String cin) throws EgovException, NamingException;
	
	public List<Compte> findAll();

}
