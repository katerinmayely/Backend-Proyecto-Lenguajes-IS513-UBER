package hn.unah.lenguajes.dto;

import java.util.Date;

import hn.unah.lenguajes.models.Ubicacion;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SolicitudViaje {
	private String correoCliente;//idCliente
	private Ubicacion partida;
	private Ubicacion destino;
	private String tipoPago;
	private boolean status;
}
