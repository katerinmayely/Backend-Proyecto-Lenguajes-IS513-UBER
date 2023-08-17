package hn.unah.lenguajes.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="orden_servicio")
public class OrdenServicio {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idordenservicio")
    private int idOrdenServicio;
	  	 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idubicacioninicial", referencedColumnName="idubicacion")
    private Ubicacion ubicacionInicial;
	  
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idubicacionfinal", referencedColumnName="idubicacion")
    private Ubicacion ubicacionFinal;
	  
	@Column(name="tipopago")
	private String tipoPago;
	  
	@Column(name="status_orden")
	private int status_orden;
	  
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_y_hora_orden")
	private Date fecha_y_hora_orden;
	  
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idviaje", referencedColumnName="idviaje")
	private ViajeOrdenServicio viaje;
		
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="correocliente", referencedColumnName="correo")
	private Cliente cliente;
	  
}
