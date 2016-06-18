package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import gov.esprit.enums.TypeTrajet;

@Entity
public class Station implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private double lat;
	private double lon;
	private TypeTrajet type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public TypeTrajet getType() {
		return type;
	}
	public void setType(TypeTrajet type) {
		this.type = type;
	}
	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Station(int id, double lat, double lon, TypeTrajet type) {
		super();
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.type = type;
	}
	
	

}
