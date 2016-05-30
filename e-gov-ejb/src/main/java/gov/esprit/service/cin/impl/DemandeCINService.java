package gov.esprit.service.cin.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import gov.esprit.business.CinInfo;
import gov.esprit.domain.Citoyen;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;
import gov.esprit.service.cin.DemandeCINServiceLocal;
import gov.esprit.service.cin.DemandeCINServiceRemote;
import gov.esprit.service.user.UserServiceLocal;
import gov.esprit.utils.GenerateValues;

/**
 * Session Bean implementation class DemandeCINService.
 * 
 * @author monta
 */
@Stateful
@LocalBean
public class DemandeCINService implements DemandeCINServiceRemote, DemandeCINServiceLocal {

	/**
	 * {@link UserServiceLocal}.
	 */
	@EJB
	UserServiceLocal userServiceLocal;
	
    /**
     * Default constructor. 
     */
    public DemandeCINService() {
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see gov.esprit.service.cin.DemandeCINServiceLocal#forCin(gov.esprit.domain.Citoyen, boolean, boolean)
	 */
	@Override
	public CinInfo forCin(Citoyen citoyen, boolean isExtrait, boolean isResidenceProof, Gouvernerat gouvernerat) throws EgovException {
		
		if (citoyen == null){

			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_CITOYEN");
		}
		if(!isExtrait){
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_EXTRAIT_DE_NAISSANCE");
		}
		if(!isResidenceProof){
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_PREUVE_DE_RESIDENCE");
		}
		
		CinInfo cinInfo = new CinInfo();
		cinInfo.setProprietaire(citoyen);
		cinInfo.setDateExpedition(LocalDateTime.now());
		cinInfo.setNumero(GenerateValues.nextInt(8));
		cinInfo.setReferenceEmpreinte(UUID.randomUUID().toString());
		
		return cinInfo;
	}

}
