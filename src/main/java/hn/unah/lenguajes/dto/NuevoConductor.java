package hn.unah.lenguajes.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NuevoConductor {
	private  int conDni;
	private  int licenciaValida;
	private int permisoCirculacion;
	private String cuentaBancaria;
	private  int telefonoValido;
	private String celular;
	private String correo;
	private String nombre;
	private String apellido;
	private int edad;
}
