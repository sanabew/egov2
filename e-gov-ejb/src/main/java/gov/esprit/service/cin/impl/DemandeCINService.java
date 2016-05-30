package gov.esprit.service.cin.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import gov.esprit.service.cin.DemandeCINServiceLocal;
import gov.esprit.service.cin.DemandeCINServiceRemote;

/**
 * Session Bean implementation class DemandeCINService
 */
@Stateful
@LocalBean
public class DemandeCINService implements DemandeCINServiceRemote, DemandeCINServiceLocal {

    /**
     * Default constructor. 
     */
    public DemandeCINService() {
        // TODO Auto-generated constructor stub
    }

}
