package hn.unah.lenguajes.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="persona")
public class Persona {

	@Id
	@Column(name="idpersona")
	private String idpersona;
	    
	@Column(name="nombre")
	private String nombre;
	  
	@Column(name="p_apellido")
	private String p_apellido;
	  
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fecha_nacimiento;
	  
	@Column(name="genero")
	private String genero;
	  
	@Column(name="correo")
	private String correo;
	  
	@Column(name="celular")
	private String celular;
	  
	@Column(name="direccion")
	private String direccion;
	  
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idcliente", referencedColumnName="idcliente")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idconductores", referencedColumnName="idconductores")
	private Conductor conductores;
	  
}
