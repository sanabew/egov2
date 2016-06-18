package gov.esprit.service.abonnement.impl;

import gov.esprit.enums.TypeTrajet;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;
import gov.esprit.domain.AbonnementTransport;
import gov.esprit.domain.Compte;
import gov.esprit.domain.ContratMariage;
import gov.esprit.domain.Station;
import gov.esprit.domain.Transaction;
import gov.esprit.enums.TypeHoraire;
import gov.esprit.service.abonnement.AbonnementServiceLocal;
import gov.esprit.service.abonnement.AbonnementServiceRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class AbonnementService
 */
@Stateless
@LocalBean
public class AbonnementService implements AbonnementServiceRemote, AbonnementServiceLocal {

	/**
	 * Default constructor.
	 * 
	 * @return
	 */
	public AbonnementService() {
	}
@PersistenceContext
	EntityManager entitymanager;
@Override
	public int getPrix(TypeTrajet t, TypeHoraire h) {
		Query query = entitymanager
				.createQuery("select c from AbonnementTransport c  where c.trajet=:tra AND c.horaire=:hor");
		query.setParameter("tra", t);
		query.setParameter("hor", h);
		List<AbonnementTransport> abonnement = query.getResultList();
		if (!abonnement.isEmpty()) {
			return abonnement.get(0).getPrix();
		}
		return -1;

	}

	@Override
	public void addAbonnement(AbonnementTransport ab){
		entitymanager.persist(ab);
	}
	
	@Override
	public void addStation(Station s){
		entitymanager.persist(s);
	}
	
	@Override
	public List<Station> detailTrajet(TypeTrajet type) {
		
		Query query = entitymanager.createQuery("select s from Station s  where s.type = :trajet ");
		query.setParameter("trajet", type);
		return (List<Station>)query.getResultList();
		
		
	}
	
}
