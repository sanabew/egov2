package gov.esprit.service.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import gov.esprit.service.interfaces.CitoyenServiceLocal;
import gov.esprit.service.interfaces.CitoyenServiceRemote;

/**
 * Session Bean implementation class CitoyenService
 */
@Stateless
@LocalBean
public class CitoyenService implements CitoyenServiceRemote, CitoyenServiceLocal {

    /**
     * Default constructor. 
     */
    public CitoyenService() {
        // TODO Auto-generated constructor stub
    }

}
