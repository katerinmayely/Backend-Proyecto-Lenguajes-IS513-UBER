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
	  	  
	@Column(name="iddireccioninicial")
    private int idDireccionInicial;
	  
	@Column(name="iddireccionfinal")
	private int idDireccionFinal;
	  
	@Column(name="tipopago")
	private String tipoPago;
	  
	@Column(name="status_orden")
	private String status_orden;
	  
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_y_hora_orden")
	private Date fecha_y_hora_orden;
	  
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idviaje", referencedColumnName="idviaje")
	private ViajeOrdenServicio viaje;
		
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idcliente", referencedColumnName="idcliente")
	private Cliente cliente;
		
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iddireccion", referencedColumnName="iddireccion")
	private Direccion direcciones;
	  
}
