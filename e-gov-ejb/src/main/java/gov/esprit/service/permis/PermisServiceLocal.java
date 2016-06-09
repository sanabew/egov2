package gov.esprit.service.permis;

import javax.ejb.Local;

import gov.esprit.exception.EgovException;

@Local
public interface PermisServiceLocal {

	void demanderPermis(String cin) throws EgovException;

	void demanderRenouvPermis(String cin) throws EgovException;

}
