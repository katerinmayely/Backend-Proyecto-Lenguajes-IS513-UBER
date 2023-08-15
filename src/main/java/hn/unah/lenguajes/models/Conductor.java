package hn.unah.lenguajes.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="conductores")
public class Conductor {

	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name="idconductores")
	  private int idconductores;
	
	  @Temporal(TemporalType.DATE)
	  @Column(name="fecha_ingreso")
	  private Date fecha_ingreso;
	  
	  @Column(name="cargos")
	  private String cargos;
	  
	  @Column(name="salario")
	  private double salario;
	  
	  @Column(name="calificacion")
	  private double calificacion;
	  
	  @OneToOne(mappedBy = "conductores")
	  @JsonIgnore
	  private Automovil automovil;
	  
	  @OneToOne(mappedBy="conductores")
	  @JsonIgnore
	  private Persona persona;

	  @OneToMany(mappedBy="conductores")
		private List<Calificacion> calificaciones;
	  
	  @OneToMany(mappedBy="conductores")
	  private List<ViajeOrdenServicio> viaje;	  
}
