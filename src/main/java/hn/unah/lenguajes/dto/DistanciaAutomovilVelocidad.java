package hn.unah.lenguajes.dto;

import hn.unah.lenguajes.models.Automovil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DistanciaAutomovilVelocidad {
	private double distanciaMinima;
	private Automovil automovil;
	private double velocidad;
	
}
