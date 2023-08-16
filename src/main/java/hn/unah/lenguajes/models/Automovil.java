package hn.unah.lenguajes.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="automovil")
public class Automovil {
	
	@Id
    @Column(name="placa")
    private String placa;
	
	@Column(name="modelo")
  	private String modelo;
	
	@Column (name="marca")
	private String marca;
	
	@Column(name="color")
  	private String color;
	
	@Column(name="tipocombustible")
  	private String tipocombustible;
	
	@Column(name="disponibilidad")
  	private boolean disponibilidad;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idconductor", referencedColumnName="idconductor")
	private Conductor conductor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idubicacion", referencedColumnName="idubicacion")
	private Ubicacion ubicacion;
	
}
