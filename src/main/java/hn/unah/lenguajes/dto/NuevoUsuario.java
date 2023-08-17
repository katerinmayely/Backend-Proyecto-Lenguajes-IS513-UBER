package hn.unah.lenguajes.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NuevoUsuario {
	
	private String correo;
	private String nombre;
	private String apellido;
	private String contrasenia;
	private String celular;
	private String contraseniaValidacion;
	
}
