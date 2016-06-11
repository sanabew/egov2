package gov.esprit.service.poste;

import java.util.List;

import javax.ejb.Remote;
import javax.naming.NamingException;

import gov.esprit.domain.Compte;
import gov.esprit.domain.Transaction;
import gov.esprit.enums.TypeTransacrion;
import gov.esprit.exception.EgovException;
@Remote
public interface PosteServiceRemote {
	
	public Compte rechercherCompteParNum(int numeroCompte) throws EgovException;
	
	public float consulterSolde(int numeroCompte)throws EgovException;
	
	public void effectuerTransaction(int numeroCompte, float montant, String cin, TypeTransacrion type)throws EgovException;
	
	public List<Transaction> extraireReleve(int numeroCompte , String cin)throws EgovException;
	
	public int ouvrirCompte(String cin) throws EgovException, NamingException;
	
	public List<Compte> findAll();

}
