package gov.esprit.service.permis.impl;

import gov.esprit.business.TraiterDemandeInfo;
import gov.esprit.domain.Citoyen;
import gov.esprit.domain.Demande;
import gov.esprit.domain.EtapeCin;
import gov.esprit.domain.EtapePasseport;
import gov.esprit.domain.EtapePermis;
import gov.esprit.domain.Permis;
import gov.esprit.enums.EtatDemande;
import gov.esprit.enums.TypeDemande;
import gov.esprit.enums.TypePermis;
import gov.esprit.exception.EgovException;
import gov.esprit.service.citoyen.CitoyenServiceLocal;
import gov.esprit.service.demande.DemandeServiceLocal;
import gov.esprit.service.permis.PermisServiceLocal;
import gov.esprit.service.permis.PermisServiceRemote;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class PermisService
 */
@Stateless
@LocalBean
public class PermisService implements PermisServiceRemote, PermisServiceLocal {

	Demande demande = new Demande();
	Citoyen citoyen = new Citoyen();
	@EJB
	CitoyenServiceLocal citoyenservice;
	
	@EJB
	DemandeServiceLocal demandeservice;
	
	@PersistenceContext
	EntityManager entitymanager;
    /**
     * Default constructor. 
     */
    public PermisService() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void demanderPermis(String cin) {
		Demande demande = new Demande();
		Citoyen citoyen = new Citoyen();
		try {

			citoyen = citoyenservice.findByCin(cin);
			demande.setCitoyen(citoyen);
			demande.setDate(new Date());
			demande.setType(TypeDemande.DEMANDE_PERMIS);
			demande.setEtat(EtatDemande.EN_ATTENTE);
			EtapePermis etapes = new EtapePermis();
			etapes.initialize();
			EtapeCin etapes2 = new EtapeCin();
			etapes2.initialize();
			EtapePasseport etapes3 = new EtapePasseport();
			etapes3.initialize();
			demande.setEtapePermis(etapes);
			demande.setEtapeCin(etapes2);
			demande.setEtapePasseport(etapes3);

			entitymanager.persist(demande);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Override
	public void demanderRenouvPermis(String cin) throws EgovException {
		Demande demande = new Demande();
		Citoyen citoyen = new Citoyen();
		try {
			citoyen = citoyenservice.findByCin(cin);
			demande.setCitoyen(citoyen);
			demande.setDate(new Date());
			demande.setType(TypeDemande.RENOUV_PERMIS);
			demande.setEtat(EtatDemande.EN_ATTENTE);
			EtapePermis etapes = new EtapePermis();
			EtapeCin etapes2 = new EtapeCin();
			etapes2.initialize();
			EtapePasseport etapes3 = new EtapePasseport();
			etapes3.initialize();
			demande.setEtapePermis(etapes);
			demande.setEtapeCin(etapes2);
			demande.setEtapePasseport(etapes3);
			entitymanager.persist(demande);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Override
	public void attribuerPermis(int numdemande) {

		try {
			Permis permis = new Permis();
			Demande demande = demandeservice.rechercherDemande(numdemande);
			System.out.println(demande.toString());
			permis.setCitoyen(demande.getCitoyen());
			permis.setType(TypePermis.BE);
			permis.setDateAttribution(new Date());
			Calendar cal = Calendar.getInstance();
			cal.setTime(permis.getDateAttribution());
			cal.add(Calendar.YEAR, 10);
			Date d = cal.getTime();
			permis.setDateExpiration(d);
			entitymanager.merge(permis);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
   
    
    @Override
	public void traiterDemandePermis(TraiterDemandeInfo info, int numero) {
		Demande demande = new Demande();
		try {
			demande = rechercherDemandePermis(numero);
			demande.setEtapePermis(info.getEtapePermis());
			demande.setEtapeCin(info.getEtapeCin());
			demande.setEtapePasseport(info.getEtapePasseport());
			
			if (info.isConforme() == true) {
				demande.setEtat(EtatDemande.IRRIGULARITE);
			} else {

				if (demande.getEtapePermis().isLivraisonPermis()) {
					demande.setEtat(EtatDemande.DELIVREE);
				} else {
					if (demande.getEtapePermis().isImpressionPermis()
							&& demande.getEtapePermis().isCertifMedicalPermis()
							&& demande.getEtapePermis().isExamenPermis() && demande.getEtapePermis().isPhotosPermis()) {
						demande.setEtat(EtatDemande.PRET);
						attribuerPermis(demande.getId());
					} else {
						demande.setEtat(EtatDemande.EN_COURS);
					}
				}
			}
			demandeservice.updateDemande(demande);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Override
	public Demande rechercherDemandePermis(int numero) throws EgovException {
		Demande demande = null;

		try {

			Query query = entitymanager.createQuery("SELECT c FROM Demande c WHERE c.id = :numero");
			query.setParameter("numero", numero);
			
			demande = (Demande) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return demande;
	}

   
   
    

}
