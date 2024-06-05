package co.edu.uco.deviucopay.controller.response;

import java.util.ArrayList;

import co.edu.uco.deviucopay.dto.TipoInstitucionDTO;

public class TipoInstitucionResponse extends Response<TipoInstitucionDTO>{
	public TipoInstitucionResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}
}
