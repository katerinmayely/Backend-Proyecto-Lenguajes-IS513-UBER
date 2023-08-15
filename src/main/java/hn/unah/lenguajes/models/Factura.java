package hn.unah.lenguajes.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="factura")
public class Factura {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idfactura")
	private int idfactura;

	@Temporal(TemporalType.DATE)
	@Column(name="fechadeemision")
	private Date FechaDeEmision;
	 
	@Column(name="subtotal")
	private int subtotal;
	 
	@Column(name="impuesto")
	private int impuesto;
	 
	@Column(name="descuento")
	private int descuento;
	 
	@Column(name="totalpagar")
	private int totalPagar;
	 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idviaje", referencedColumnName="idviaje")
	private ViajeOrdenServicio viaje;
	  
}
