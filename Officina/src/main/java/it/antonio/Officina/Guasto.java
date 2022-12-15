package it.antonio.Officina;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guasto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGuasto;
	private String nomeGuasto;
	private String tipoGuasto;
	
	public Guasto() {
		super();
	}
	
	public Guasto(Long idGuasto, String nomeGuasto, String tipoGuasto) {
		super();
		this.idGuasto = idGuasto;
		this.nomeGuasto = nomeGuasto;
		this.tipoGuasto = tipoGuasto;
	}
	@OneToMany(
			mappedBy="guasto",
			fetch=FetchType.EAGER)
	private Set<Possiede> possiede;

	public Set<Possiede> getPossiede() {
		return possiede;
	}
	
	

	public Long getIdGuasto() {
		return idGuasto;
	}

	public void setIdGuasto(Long idGuasto) {
		this.idGuasto = idGuasto;
	}

	public String getNomeGuasto() {
		return nomeGuasto;
	}

	public void setNomeGuasto(String nomeGuasto) {
		this.nomeGuasto = nomeGuasto;
	}

	public String getTipoGuasto() {
		return tipoGuasto;
	}

	public void setTipoGuasto(String tipoGuasto) {
		this.tipoGuasto = tipoGuasto;
	}

	public void setPossiede(Set<Possiede> possiede) {
		this.possiede = possiede;
	}
	@Override
	public String toString() {
		return "Guasto [id_guasto=" + idGuasto + ", nome_guasto=" + nomeGuasto + ", tipo_guasto=" + tipoGuasto
				+ ", possiede=" + possiede + "]";
	}
}
