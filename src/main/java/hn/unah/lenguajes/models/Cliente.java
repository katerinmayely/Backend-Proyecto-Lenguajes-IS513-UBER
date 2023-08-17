
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
@Table(name="clientes")
public class Cliente {
	
	@Id
    private String correo;
    
    @Column(name="tarjetavinculada")
    private String tarjetaVinculada;
    
    private String nombre;
    
    private String apellido;
    
    private String contrasenia;
    
    private String celular;
    
	@OneToMany(mappedBy="cliente")
	private List<Calificacion> calificaciones;
	
	@OneToMany(mappedBy="cliente")
	private List<OrdenServicio> orden_servicio;
	
	@OneToMany(mappedBy="cliente")
	private List<PerfilFacebook> perfiles;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idubicacion", referencedColumnName="idubicacion")
	private Ubicacion ubicacionCliente;
}
