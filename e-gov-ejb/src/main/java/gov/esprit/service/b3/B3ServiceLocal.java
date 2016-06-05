package gov.esprit.service.b3;

import java.util.List;
import javax.ejb.Local;
import gov.esprit.domain.SanctionPenale;

@Local
public interface B3ServiceLocal {

	public List<SanctionPenale> extraireB3(String cin);
}
