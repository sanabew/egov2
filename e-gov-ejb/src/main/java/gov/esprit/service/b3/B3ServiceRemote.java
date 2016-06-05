package gov.esprit.service.b3;

import java.util.List;
import javax.ejb.Remote;
import gov.esprit.domain.SanctionPenale;


@Remote
public interface B3ServiceRemote {
	
	public List<SanctionPenale> extraireB3(String cin);

}
