package gov.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Citoyen
 *
 */
@Entity

public class Citoyen implements Serializable {

	   
	@Id
	private Integer id;
	private static final long serialVersionUID = 1L;

	public Citoyen() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
}
