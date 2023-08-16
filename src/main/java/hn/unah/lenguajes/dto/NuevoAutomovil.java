package hn.unah.lenguajes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NuevoAutomovil {
	private int aniosAntiguedad;
	private int cuatroPuertas;
	private int dobleAirbag;
	private int aire;
	private int permiso;
	private String matricula;
	private String modelo;
	private String marca;
	private String color;
	private String tipoCombustible;
}
