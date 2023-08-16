package hn.unah.lenguajes.models;

import java.util.Date;

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
@Table(name="viaje_orden_servicio")
public class ViajeOrdenServicio {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idviaje")
    private int idViaje;
	 
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_y_hora_viaje")
	private Date fecha_y_hora_viaje;
	 
	@OneToOne(mappedBy="viaje")
	@JsonIgnore
	private OrdenServicio orden_servicio;
		
	@OneToOne(mappedBy="viaje")
	@JsonIgnore
	private Factura factura;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idconductor", referencedColumnName="idconductor")
	private Conductor conductor;
 
}
