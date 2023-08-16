package hn.unah.lenguajes.dto;

import hn.unah.lenguajes.models.Ubicacion;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientePersona {
	private String dni;
	private Ubicacion coordenada;
	private String tarjeta;
	
}
