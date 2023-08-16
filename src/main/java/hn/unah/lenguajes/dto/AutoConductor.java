package hn.unah.lenguajes.dto;

import hn.unah.lenguajes.models.Ubicacion;
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
	Ubicacion coordenadasAuto;
	Boolean disponibilidad;
}
