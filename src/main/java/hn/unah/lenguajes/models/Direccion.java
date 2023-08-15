package hn.unah.lenguajes.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="direcciones")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iddireccion")
	private int iddireccion;
	 
	@Column(name="descripcion")
	private String descripcion;
	 
	@Column(name="municipio")
	private String municipio;
	 
	@Column(name="colonia")
	private String colonia;
	 
	@Column(name="departamento")
	private String departamento;
	 
	@Column(name="pais")
	private String pais;
	
	@OneToMany(mappedBy="direcciones")
	private List<OrdenServicio> orden_servicio;
	  
}
