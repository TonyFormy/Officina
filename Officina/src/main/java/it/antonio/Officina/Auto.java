package it.antonio.Officina;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Auto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idAuto;
private String targa;
private String marca;
private String modello;

public Auto(Long id_auto, String targa, String marca, String modello, Long idAuto) {
	super();
	this.idAuto = idAuto;
	this.targa = targa;
	this.marca = marca;
	this.modello = modello;
	
}

public Auto() {
	// TODO Auto-generated constructor stub
}


public Long getIdAuto() {
	return idAuto;
}

public void setIdAuto(Long idAuto) {
	this.idAuto = idAuto;
}

public String getTarga() {
	return targa;
}

public void setTarga(String targa) {
	this.targa = targa;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModello() {
	return modello;
}

public void setModello(String modello) {
	this.modello = modello;
}




@OneToMany(
		mappedBy="auto",
		fetch=FetchType.EAGER)
private Set<Possiede> possiede;

public Set<Possiede> getPossiede() {
	return possiede;
}

@Override
public String toString() {
	return "Auto [Id_auto=" + idAuto + ", Targa=" + targa + ", Marca=" + marca + ", Modello=" + modello + ", possiede="
			+ possiede + "]";
}







}
