package gov.esprit.service.poste;

import java.util.List;

import gov.esprit.domain.Compte;
import gov.esprit.domain.Transaction;
import gov.esprit.enums.TypeTransacrion;
import gov.esprit.exception.EgovException;

public interface PosteServiceLocal {
	
	public Compte rechercherCompteParNum(int numeroCompte);
	
	public float consulterSolde(int numeroCompte);
	
	public boolean effectuerTransaction(int numeroCompte, float montant, String cin, TypeTransacrion type)throws EgovException;
	
	public List<Transaction> extraireReleve(int numeroCompte);
	
	public void ouvrirCompte(String cin) throws EgovException;
	
	public List<Compte> findAll();

}
