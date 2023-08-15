package hn.unah.lenguajes.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ConductorPersona {
	private String dni;
	private Date fechaIngreso;
	private String cargo;
	private double salario;
	private double calificacion;
}
