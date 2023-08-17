package hn.unah.lenguajes.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ubicaciones")
public class Ubicacion {
	
	@Id
	@Column(name="idubicacion")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idubicacion;
	
	private double latitud;
	
	private double longitud;
	
	@OneToOne(mappedBy="ubicacionCliente")
	@JsonIgnore
	private Cliente cliente;
	
	@OneToOne(mappedBy="ubicacion")
	@JsonIgnore
	private Automovil automovil;
	
	@OneToOne(mappedBy="ubicacionInicial")
	@JsonIgnore
	private OrdenServicio partida;

	@OneToOne(mappedBy="ubicacionFinal")
	@JsonIgnore
	private OrdenServicio destino;
}
