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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private double subtotal;
	 
	@Column(name="impuesto")
	private double impuesto;
	 
	@Column(name="descuento")
	private double descuento;
	 
	@Column(name="totalpagar")
	private double totalPagar;
	 
	
	@OneToOne(mappedBy="factura")
	@JsonIgnore
	private ViajeOrdenServicio viaje;
	  
}
