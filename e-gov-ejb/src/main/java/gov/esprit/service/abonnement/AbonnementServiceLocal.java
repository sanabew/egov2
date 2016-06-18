package gov.esprit.service.abonnement;

import java.util.List;

import javax.ejb.Local;

import gov.esprit.domain.AbonnementTransport;
import gov.esprit.domain.Station;
import gov.esprit.enums.TypeHoraire;
import gov.esprit.enums.TypeTrajet;
import gov.esprit.exception.EgovException;

@Local
public interface AbonnementServiceLocal {
	void addAbonnement(AbonnementTransport ab);

	int getPrix(TypeTrajet t, TypeHoraire h);
	void addStation(Station s);
	public List<Station> detailTrajet(TypeTrajet type);
}
