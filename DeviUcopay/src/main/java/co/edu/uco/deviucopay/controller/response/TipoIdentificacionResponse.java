package co.edu.uco.deviucopay.controller.response;

import java.util.ArrayList;

import co.edu.uco.deviucopay.dto.TipoIdentificacionDTO;

public class TipoIdentificacionResponse extends Response<TipoIdentificacionDTO>{
	public TipoIdentificacionResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}
}
