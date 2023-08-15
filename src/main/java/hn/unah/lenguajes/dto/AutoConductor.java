package hn.unah.lenguajes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutoConductor {
	int idConductor;
	String placa;
	String modelo;
	String marca;
	String color;
	String tipoCombustible;
	String coordenadasAuto;
	Boolean disponibilidad;
}
