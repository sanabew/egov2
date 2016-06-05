package gov.esprit.service.poste.impl;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import gov.esprit.domain.Citoyen;
import gov.esprit.domain.Compte;
import gov.esprit.domain.Transaction;
import gov.esprit.enums.TypeTransacrion;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;
import gov.esprit.service.citoyen.CitoyenServiceLocal;
import gov.esprit.service.poste.PosteServiceLocal;
import gov.esprit.service.poste.PosteServiceRemote;


@Stateless
@LocalBean
public class PosteService implements PosteServiceRemote, PosteServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
	@EJB
	private CitoyenServiceLocal citoyenServiceLocal;

	public PosteService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte rechercherCompteParNum(int numeroCompte) {

		String jpql = "select c from Compte c  where c.compte.numero=:numeroCompte";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("numeroCompte", numeroCompte);
		Compte compte = (Compte) query.getSingleResult();

		return compte;
	}
	
	public float consulterSolde(int numeroCompte){
		Compte compte = rechercherCompteParNum(numeroCompte);
		return compte.getSolde();
	}

	public boolean effectuerTransaction(int numeroCompte, float montant, String cin, TypeTransacrion type) throws EgovException{
		
		float solde;
		Date date = Calendar.getInstance().getTime();
		Compte compte = rechercherCompteParNum(numeroCompte);
		solde=compte.getSolde();
		Transaction transaction = new Transaction();
		transaction.setMontant(montant);
		transaction.setType(type);
		transaction.setCompte(compte);
		transaction.setDate(date);
		if (cin.equals(compte.getProprietaire().getCin())){
			
			if(type==TypeTransacrion.CREDIT){
				solde = solde+montant;
				compte.setSolde(solde);
				return true;
				
			}else{
				if(solde>=montant){
					solde = solde-montant;
					compte.setSolde(solde);
					entityManager.persist(transaction);
					entityManager.persist(compte);
					return true;
					
				}else{
					throw new EgovException(EgovErrorCode.INVALID_ITEM, "_MONTANT_NON_AUTHORISE");
				}
			}
		}else{
			throw new EgovException(EgovErrorCode.INVALID_ITEM, "_CIN: " + cin);
		}
		
		
	}
	

	public List<Transaction> extraireReleve(int numeroCompte) {
		

		Query query = entityManager.createQuery("select t from Transaction t  where t.compte.numero=:numeroCompte");
		query.setParameter("numeroCompte", numeroCompte);
		return query.getResultList();
	}
	
	public void ouvrirCompte(String cin) throws EgovException{
		
		Citoyen citoyen = citoyenServiceLocal.findByCin(cin);
		
		if(citoyen==null){
			throw new EgovException(EgovErrorCode.INVALID_ITEM, "_CIN: " + cin);
		}
		Compte compte = new Compte();
		compte.setProprietaire(citoyen);
		compte.setSolde(0);
		compte.setNumero(Integer.valueOf(citoyen.getCin()));
		entityManager.persist(compte);
	}
	
	
	public List<Compte> findAll() {
		
		Query query = entityManager.createNativeQuery("select * from Compte");
		return query.getResultList();
	}
}
