
package hn.unah.lenguajes.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="cliente")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idcliente")
    private int idcliente;
    
    @Column(name="tarjetavinculada")
    private String tarjetaVinculada;
    
	@OneToOne(mappedBy="cliente")
	@JsonIgnore
	private Persona persona;
    
	@OneToMany(mappedBy="cliente")
	private List<Calificacion> calificaciones;
	
	@OneToMany(mappedBy="cliente")
	private List<OrdenServicio> orden_servicio;

	@OneToOne(mappedBy="cliente")
	private Ubicacion ubicacion;
}
