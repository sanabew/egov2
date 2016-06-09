package gov.esprit.service.permis;

import javax.ejb.Remote;

import gov.esprit.exception.EgovException;

@Remote
public interface PermisServiceRemote {
	void demanderPermis(String cin) throws EgovException;

	void demanderRenouvPermis(String cin) throws EgovException;

}
