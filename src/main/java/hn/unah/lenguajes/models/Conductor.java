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
	  @Column(name="idconductor")
	  private int idconductor;
	
	  @Temporal(TemporalType.DATE)
	  @Column(name="fecha_ingreso")
	  private Date fecha_ingreso;
	  
	  private String nombre;
	  
	  private String apellido;
	  
	  private String correo;
	  
	  private String telefono;
	  
	  @Column(name="calificacion")
	  private double calificacion;
	  
	  @OneToOne(mappedBy = "conductor")
	  @JsonIgnore
	  private Automovil automovil;
	
	  @OneToMany(mappedBy="conductor")
	  private List<Calificacion> calificaciones;
	  
	  @OneToMany(mappedBy="conductor")
	  private List<ViajeOrdenServicio> viajes;	  
}
