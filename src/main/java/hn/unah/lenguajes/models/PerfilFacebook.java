package hn.unah.lenguajes.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="perfiles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilFacebook {
	
	@Id
	private String usuario;
	
	private String contrasenia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="correo", referencedColumnName="correo")
	private Cliente cliente;
	
}
