package gov.esprit.business;

import gov.esprit.domain.EtapeCin;
import gov.esprit.domain.EtapePasseport;
import gov.esprit.domain.EtapePermis;

public class TraiterDemandeInfo {
	
	private int numDmande;
	private EtapeCin etapeCin;
	private EtapePasseport etapePasseport;
	private EtapePermis etapePermis;
	private boolean conforme;
	
	public TraiterDemandeInfo() {
		conforme = true;
	}
	
	public int getNumDmande() {
		return numDmande;
	}
	public void setNumDmande(int numDmande) {
		this.numDmande = numDmande;
	}
	public EtapeCin getEtapeCin() {
		return etapeCin;
	}
	public void setEtapeCin(EtapeCin etapeCin) {
		this.etapeCin = etapeCin;
	}
	public EtapePasseport getEtapePasseport() {
		return etapePasseport;
	}
	public void setEtapePasseport(EtapePasseport etapePasseport) {
		this.etapePasseport = etapePasseport;
	}
	public EtapePermis getEtapePermis() {
		return etapePermis;
	}
	public void setEtapePermis(EtapePermis etapePermis) {
		this.etapePermis = etapePermis;
	}

	public boolean isConforme() {
		return conforme;
	}

	public void setConforme(boolean conforme) {
		this.conforme = conforme;
	}

	
}
