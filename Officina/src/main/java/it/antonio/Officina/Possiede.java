package it.antonio.Officina;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Possiede {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private boolean scelta;
	
	
	private int costo;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idGuasto")
	private Guasto guasto;
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idAuto")
	private Auto auto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Guasto getGuasto() {
		return guasto;
	}

	public void setGuasto(Guasto guasto) {
		this.guasto = guasto;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public boolean isScelta() {
		return scelta;
	}

	public void setScelta(boolean scelta) {
		this.scelta = scelta;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	
	
	
	
}

